import { vitest } from 'vitest';
import { type MountingOptions, shallowMount } from '@vue/test-utils';
import sinon, { type SinonStubbedInstance } from 'sinon';

import ImportSetting from './import-setting.vue';
import ImportSettingService from './import-setting.service';
import AlertService from '@/shared/alert/alert.service';

type ImportSettingComponentType = InstanceType<typeof ImportSetting>;

const bModalStub = {
  render: () => {},
  methods: {
    hide: () => {},
    show: () => {},
  },
};

describe('Component Tests', () => {
  let alertService: AlertService;

  describe('ImportSetting Management Component', () => {
    let importSettingServiceStub: SinonStubbedInstance<ImportSettingService>;
    let mountOptions: MountingOptions<ImportSettingComponentType>['global'];

    beforeEach(() => {
      importSettingServiceStub = sinon.createStubInstance<ImportSettingService>(ImportSettingService);
      importSettingServiceStub.retrieve.resolves({ headers: {} });

      alertService = new AlertService({
        i18n: { t: vitest.fn() } as any,
        bvToast: {
          toast: vitest.fn(),
        } as any,
      });

      mountOptions = {
        stubs: {
          jhiItemCount: true,
          bPagination: true,
          bModal: bModalStub as any,
          'font-awesome-icon': true,
          'b-badge': true,
          'jhi-sort-indicator': true,
          'b-button': true,
          'router-link': true,
        },
        directives: {
          'b-modal': {},
        },
        provide: {
          alertService,
          importSettingService: () => importSettingServiceStub,
        },
      };
    });

    describe('Mount', () => {
      it('Should call load all on init', async () => {
        // GIVEN
        importSettingServiceStub.retrieve.resolves({ headers: {}, data: [{ id: 123 }] });

        // WHEN
        const wrapper = shallowMount(ImportSetting, { global: mountOptions });
        const comp = wrapper.vm;
        await comp.$nextTick();

        // THEN
        expect(importSettingServiceStub.retrieve.calledOnce).toBeTruthy();
        expect(comp.importSettings[0]).toEqual(expect.objectContaining({ id: 123 }));
      });

      it('should calculate the sort attribute for an id', async () => {
        // WHEN
        const wrapper = shallowMount(ImportSetting, { global: mountOptions });
        const comp = wrapper.vm;
        await comp.$nextTick();

        // THEN
        expect(importSettingServiceStub.retrieve.lastCall.firstArg).toMatchObject({
          sort: ['id,asc'],
        });
      });
    });
    describe('Handles', () => {
      let comp: ImportSettingComponentType;

      beforeEach(async () => {
        const wrapper = shallowMount(ImportSetting, { global: mountOptions });
        comp = wrapper.vm;
        await comp.$nextTick();
        importSettingServiceStub.retrieve.reset();
        importSettingServiceStub.retrieve.resolves({ headers: {}, data: [] });
      });

      it('should load a page', async () => {
        // GIVEN
        importSettingServiceStub.retrieve.resolves({ headers: {}, data: [{ id: 123 }] });

        // WHEN
        comp.page = 2;
        await comp.$nextTick();

        // THEN
        expect(importSettingServiceStub.retrieve.called).toBeTruthy();
        expect(comp.importSettings[0]).toEqual(expect.objectContaining({ id: 123 }));
      });

      it('should re-initialize the page', async () => {
        // GIVEN
        comp.page = 2;
        await comp.$nextTick();
        importSettingServiceStub.retrieve.reset();
        importSettingServiceStub.retrieve.resolves({ headers: {}, data: [{ id: 123 }] });

        // WHEN
        comp.clear();
        await comp.$nextTick();

        // THEN
        expect(comp.page).toEqual(1);
        expect(importSettingServiceStub.retrieve.callCount).toEqual(1);
        expect(comp.importSettings[0]).toEqual(expect.objectContaining({ id: 123 }));
      });

      it('should calculate the sort attribute for a non-id attribute', async () => {
        // WHEN
        comp.propOrder = 'name';
        await comp.$nextTick();

        // THEN
        expect(importSettingServiceStub.retrieve.lastCall.firstArg).toMatchObject({
          sort: ['name,asc', 'id'],
        });
      });

      it('Should call delete service on confirmDelete', async () => {
        // GIVEN
        importSettingServiceStub.delete.resolves({});

        // WHEN
        comp.prepareRemove({ id: 123 });

        comp.removeImportSetting();
        await comp.$nextTick(); // clear components

        // THEN
        expect(importSettingServiceStub.delete.called).toBeTruthy();

        // THEN
        await comp.$nextTick(); // handle component clear watch
        expect(importSettingServiceStub.retrieve.callCount).toEqual(1);
      });
    });
  });
});
