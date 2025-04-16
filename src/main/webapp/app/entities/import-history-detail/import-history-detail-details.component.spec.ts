import { vitest } from 'vitest';
import { type MountingOptions, shallowMount } from '@vue/test-utils';
import sinon, { type SinonStubbedInstance } from 'sinon';
import { type RouteLocation } from 'vue-router';

import ImportHistoryDetailDetails from './import-history-detail-details.vue';
import ImportHistoryDetailService from './import-history-detail.service';
import AlertService from '@/shared/alert/alert.service';

type ImportHistoryDetailDetailsComponentType = InstanceType<typeof ImportHistoryDetailDetails>;

let route: Partial<RouteLocation>;
const routerGoMock = vitest.fn();

vitest.mock('vue-router', () => ({
  useRoute: () => route,
  useRouter: () => ({ go: routerGoMock }),
}));

const importHistoryDetailSample = { id: 123 };

describe('Component Tests', () => {
  let alertService: AlertService;

  afterEach(() => {
    vitest.resetAllMocks();
  });

  describe('ImportHistoryDetail Management Detail Component', () => {
    let importHistoryDetailServiceStub: SinonStubbedInstance<ImportHistoryDetailService>;
    let mountOptions: MountingOptions<ImportHistoryDetailDetailsComponentType>['global'];

    beforeEach(() => {
      route = {};
      importHistoryDetailServiceStub = sinon.createStubInstance<ImportHistoryDetailService>(ImportHistoryDetailService);

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
          importHistoryDetailService: () => importHistoryDetailServiceStub,
        },
      };
    });

    describe('Navigate to details', () => {
      it('Should call load all on init', async () => {
        // GIVEN
        importHistoryDetailServiceStub.find.resolves(importHistoryDetailSample);
        route = {
          params: {
            importHistoryDetailId: `${123}`,
          },
        };
        const wrapper = shallowMount(ImportHistoryDetailDetails, { global: mountOptions });
        const comp = wrapper.vm;
        // WHEN
        await comp.$nextTick();

        // THEN
        expect(comp.importHistoryDetail).toMatchObject(importHistoryDetailSample);
      });
    });

    describe('Previous state', () => {
      it('Should go previous state', async () => {
        importHistoryDetailServiceStub.find.resolves(importHistoryDetailSample);
        const wrapper = shallowMount(ImportHistoryDetailDetails, { global: mountOptions });
        const comp = wrapper.vm;
        await comp.$nextTick();

        comp.previousState();
        await comp.$nextTick();

        expect(routerGoMock).toHaveBeenCalledWith(-1);
      });
    });
  });
});
