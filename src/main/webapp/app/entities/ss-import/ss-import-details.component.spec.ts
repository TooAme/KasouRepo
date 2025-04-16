import { vitest } from 'vitest';
import { type MountingOptions, shallowMount } from '@vue/test-utils';
import sinon, { type SinonStubbedInstance } from 'sinon';
import { type RouteLocation } from 'vue-router';

import SSImportDetails from './ss-import-details.vue';
import SSImportService from './ss-import.service';
import AlertService from '@/shared/alert/alert.service';

type SSImportDetailsComponentType = InstanceType<typeof SSImportDetails>;

let route: Partial<RouteLocation>;
const routerGoMock = vitest.fn();

vitest.mock('vue-router', () => ({
  useRoute: () => route,
  useRouter: () => ({ go: routerGoMock }),
}));

const sSImportSample = { id: 123 };

describe('Component Tests', () => {
  let alertService: AlertService;

  afterEach(() => {
    vitest.resetAllMocks();
  });

  describe('SSImport Management Detail Component', () => {
    let sSImportServiceStub: SinonStubbedInstance<SSImportService>;
    let mountOptions: MountingOptions<SSImportDetailsComponentType>['global'];

    beforeEach(() => {
      route = {};
      sSImportServiceStub = sinon.createStubInstance<SSImportService>(SSImportService);

      alertService = new AlertService({
        i18n: { t: vitest.fn() } as any,
        bvToast: {
          toast: vitest.fn(),
        } as any,
      });

      mountOptions = {
        stubs: {
          'font-awesome-icon': true,
          'router-link': true,
        },
        provide: {
          alertService,
          sSImportService: () => sSImportServiceStub,
        },
      };
    });

    describe('Navigate to details', () => {
      it('Should call load all on init', async () => {
        // GIVEN
        sSImportServiceStub.find.resolves(sSImportSample);
        route = {
          params: {
            sSImportId: `${123}`,
          },
        };
        const wrapper = shallowMount(SSImportDetails, { global: mountOptions });
        const comp = wrapper.vm;
        // WHEN
        await comp.$nextTick();

        // THEN
        expect(comp.sSImport).toMatchObject(sSImportSample);
      });
    });

    describe('Previous state', () => {
      it('Should go previous state', async () => {
        sSImportServiceStub.find.resolves(sSImportSample);
        const wrapper = shallowMount(SSImportDetails, { global: mountOptions });
        const comp = wrapper.vm;
        await comp.$nextTick();

        comp.previousState();
        await comp.$nextTick();

        expect(routerGoMock).toHaveBeenCalledWith(-1);
      });
    });
  });
});
