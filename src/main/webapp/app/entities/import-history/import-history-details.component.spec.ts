import { vitest } from 'vitest';
import { type MountingOptions, shallowMount } from '@vue/test-utils';
import sinon, { type SinonStubbedInstance } from 'sinon';
import { type RouteLocation } from 'vue-router';

import ImportHistoryDetails from './import-history-details.vue';
import ImportHistoryService from './import-history.service';
import AlertService from '@/shared/alert/alert.service';

type ImportHistoryDetailsComponentType = InstanceType<typeof ImportHistoryDetails>;

let route: Partial<RouteLocation>;
const routerGoMock = vitest.fn();

vitest.mock('vue-router', () => ({
  useRoute: () => route,
  useRouter: () => ({ go: routerGoMock }),
}));

const importHistorySample = { id: 123 };

describe('Component Tests', () => {
  let alertService: AlertService;

  afterEach(() => {
    vitest.resetAllMocks();
  });

  describe('ImportHistory Management Detail Component', () => {
    let importHistoryServiceStub: SinonStubbedInstance<ImportHistoryService>;
    let mountOptions: MountingOptions<ImportHistoryDetailsComponentType>['global'];

    beforeEach(() => {
      route = {};
      importHistoryServiceStub = sinon.createStubInstance<ImportHistoryService>(ImportHistoryService);

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
          importHistoryService: () => importHistoryServiceStub,
        },
      };
    });

    describe('Navigate to details', () => {
      it('Should call load all on init', async () => {
        // GIVEN
        importHistoryServiceStub.find.resolves(importHistorySample);
        route = {
          params: {
            importHistoryId: `${123}`,
          },
        };
        const wrapper = shallowMount(ImportHistoryDetails, { global: mountOptions });
        const comp = wrapper.vm;
        // WHEN
        await comp.$nextTick();

        // THEN
        expect(comp.importHistory).toMatchObject(importHistorySample);
      });
    });

    describe('Previous state', () => {
      it('Should go previous state', async () => {
        importHistoryServiceStub.find.resolves(importHistorySample);
        const wrapper = shallowMount(ImportHistoryDetails, { global: mountOptions });
        const comp = wrapper.vm;
        await comp.$nextTick();

        comp.previousState();
        await comp.$nextTick();

        expect(routerGoMock).toHaveBeenCalledWith(-1);
      });
    });
  });
});
