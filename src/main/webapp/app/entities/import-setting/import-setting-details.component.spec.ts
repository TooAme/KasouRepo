import { vitest } from 'vitest';
import { type MountingOptions, shallowMount } from '@vue/test-utils';
import sinon, { type SinonStubbedInstance } from 'sinon';
import { type RouteLocation } from 'vue-router';

import ImportSettingDetails from './import-setting-details.vue';
import ImportSettingService from './import-setting.service';
import AlertService from '@/shared/alert/alert.service';

type ImportSettingDetailsComponentType = InstanceType<typeof ImportSettingDetails>;

let route: Partial<RouteLocation>;
const routerGoMock = vitest.fn();

vitest.mock('vue-router', () => ({
  useRoute: () => route,
  useRouter: () => ({ go: routerGoMock }),
}));

const importSettingSample = { id: 123 };

describe('Component Tests', () => {
  let alertService: AlertService;

  afterEach(() => {
    vitest.resetAllMocks();
  });

  describe('ImportSetting Management Detail Component', () => {
    let importSettingServiceStub: SinonStubbedInstance<ImportSettingService>;
    let mountOptions: MountingOptions<ImportSettingDetailsComponentType>['global'];

    beforeEach(() => {
      route = {};
      importSettingServiceStub = sinon.createStubInstance<ImportSettingService>(ImportSettingService);

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
          importSettingService: () => importSettingServiceStub,
        },
      };
    });

    describe('Navigate to details', () => {
      it('Should call load all on init', async () => {
        // GIVEN
        importSettingServiceStub.find.resolves(importSettingSample);
        route = {
          params: {
            importSettingId: `${123}`,
          },
        };
        const wrapper = shallowMount(ImportSettingDetails, { global: mountOptions });
        const comp = wrapper.vm;
        // WHEN
        await comp.$nextTick();

        // THEN
        expect(comp.importSetting).toMatchObject(importSettingSample);
      });
    });

    describe('Previous state', () => {
      it('Should go previous state', async () => {
        importSettingServiceStub.find.resolves(importSettingSample);
        const wrapper = shallowMount(ImportSettingDetails, { global: mountOptions });
        const comp = wrapper.vm;
        await comp.$nextTick();

        comp.previousState();
        await comp.$nextTick();

        expect(routerGoMock).toHaveBeenCalledWith(-1);
      });
    });
  });
});
