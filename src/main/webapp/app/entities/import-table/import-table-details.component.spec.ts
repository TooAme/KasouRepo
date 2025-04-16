import { vitest } from 'vitest';
import { type MountingOptions, shallowMount } from '@vue/test-utils';
import sinon, { type SinonStubbedInstance } from 'sinon';
import { type RouteLocation } from 'vue-router';

import ImportTableDetails from './import-table-details.vue';
import ImportTableService from './import-table.service';
import AlertService from '@/shared/alert/alert.service';

type ImportTableDetailsComponentType = InstanceType<typeof ImportTableDetails>;

let route: Partial<RouteLocation>;
const routerGoMock = vitest.fn();

vitest.mock('vue-router', () => ({
  useRoute: () => route,
  useRouter: () => ({ go: routerGoMock }),
}));

const importTableSample = { id: 123 };

describe('Component Tests', () => {
  let alertService: AlertService;

  afterEach(() => {
    vitest.resetAllMocks();
  });

  describe('ImportTable Management Detail Component', () => {
    let importTableServiceStub: SinonStubbedInstance<ImportTableService>;
    let mountOptions: MountingOptions<ImportTableDetailsComponentType>['global'];

    beforeEach(() => {
      route = {};
      importTableServiceStub = sinon.createStubInstance<ImportTableService>(ImportTableService);

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
          importTableService: () => importTableServiceStub,
        },
      };
    });

    describe('Navigate to details', () => {
      it('Should call load all on init', async () => {
        // GIVEN
        importTableServiceStub.find.resolves(importTableSample);
        route = {
          params: {
            importTableId: `${123}`,
          },
        };
        const wrapper = shallowMount(ImportTableDetails, { global: mountOptions });
        const comp = wrapper.vm;
        // WHEN
        await comp.$nextTick();

        // THEN
        expect(comp.importTable).toMatchObject(importTableSample);
      });
    });

    describe('Previous state', () => {
      it('Should go previous state', async () => {
        importTableServiceStub.find.resolves(importTableSample);
        const wrapper = shallowMount(ImportTableDetails, { global: mountOptions });
        const comp = wrapper.vm;
        await comp.$nextTick();

        comp.previousState();
        await comp.$nextTick();

        expect(routerGoMock).toHaveBeenCalledWith(-1);
      });
    });
  });
});
