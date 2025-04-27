import { vitest } from 'vitest';
import { type MountingOptions, shallowMount } from '@vue/test-utils';
import sinon, { type SinonStubbedInstance } from 'sinon';
import { type RouteLocation } from 'vue-router';

import ImportSettingUpdate from './import-setting-update.vue';
import ImportSettingService from './import-setting.service';
import AlertService from '@/shared/alert/alert.service';

type ImportSettingUpdateComponentType = InstanceType<typeof ImportSettingUpdate>;

let route: Partial<RouteLocation>;
const routerGoMock = vitest.fn();

vitest.mock('vue-router', () => ({
  useRoute: () => route,
  useRouter: () => ({ go: routerGoMock }),
}));

const importSettingSample = { id: 123 };

describe('Component Tests', () => {
  let mountOptions: MountingOptions<ImportSettingUpdateComponentType>['global'];
  let alertService: AlertService;

  describe('ImportSetting Management Update Component', () => {
    let comp: ImportSettingUpdateComponentType;
    let importSettingServiceStub: SinonStubbedInstance<ImportSettingService>;

    beforeEach(() => {
      route = {};
      importSettingServiceStub = sinon.createStubInstance<ImportSettingService>(ImportSettingService);
      importSettingServiceStub.retrieve.onFirstCall().resolves(Promise.resolve([]));

      alertService = new AlertService({
        i18n: { t: vitest.fn() } as any,
        bvToast: {
          toast: vitest.fn(),
        } as any,
      });

      mountOptions = {
        stubs: {
          'font-awesome-icon': true,
          'b-input-group': true,
          'b-input-group-prepend': true,
          'b-form-datepicker': true,
          'b-form-input': true,
        },
        provide: {
          alertService,
          importSettingService: () => importSettingServiceStub,
        },
      };
    });

    afterEach(() => {
      vitest.resetAllMocks();
    });

    describe('save', () => {
      it('Should call update service on save for existing entity', async () => {
        // GIVEN
        const wrapper = shallowMount(ImportSettingUpdate, { global: mountOptions });
        comp = wrapper.vm;
        comp.importSetting = importSettingSample;
        importSettingServiceStub.update.resolves(importSettingSample);

        // WHEN
        comp.save();
        await comp.$nextTick();

        // THEN
        expect(importSettingServiceStub.update.calledWith(importSettingSample)).toBeTruthy();
        expect(comp.isSaving).toEqual(false);
      });

      it('Should call create service on save for new entity', async () => {
        // GIVEN
        const entity = {};
        importSettingServiceStub.create.resolves(entity);
        const wrapper = shallowMount(ImportSettingUpdate, { global: mountOptions });
        comp = wrapper.vm;
        comp.importSetting = entity;

        // WHEN
        comp.save();
        await comp.$nextTick();

        // THEN
        expect(importSettingServiceStub.create.calledWith(entity)).toBeTruthy();
        expect(comp.isSaving).toEqual(false);
      });
    });

    describe('Before route enter', () => {
      it('Should retrieve data', async () => {
        // GIVEN
        importSettingServiceStub.find.resolves(importSettingSample);
        importSettingServiceStub.retrieve.resolves([importSettingSample]);

        // WHEN
        route = {
          params: {
            importSettingId: `${importSettingSample.id}`,
          },
        };
        const wrapper = shallowMount(ImportSettingUpdate, { global: mountOptions });
        comp = wrapper.vm;
        await comp.$nextTick();

        // THEN
        expect(comp.importSetting).toMatchObject(importSettingSample);
      });
    });

    describe('Previous state', () => {
      it('Should go previous state', async () => {
        importSettingServiceStub.find.resolves(importSettingSample);
        const wrapper = shallowMount(ImportSettingUpdate, { global: mountOptions });
        comp = wrapper.vm;
        await comp.$nextTick();

        comp.previousState();
        await comp.$nextTick();

        expect(routerGoMock).toHaveBeenCalledWith(-1);
      });
    });
  });
});
