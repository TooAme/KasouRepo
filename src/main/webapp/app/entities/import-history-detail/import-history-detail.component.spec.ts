import { vitest } from 'vitest';
import { type MountingOptions, shallowMount } from '@vue/test-utils';
import sinon, { type SinonStubbedInstance } from 'sinon';

import ImportHistoryDetail from './import-history-detail.vue';
import ImportHistoryDetailService from './import-history-detail.service';
import AlertService from '@/shared/alert/alert.service';

type ImportHistoryDetailComponentType = InstanceType<typeof ImportHistoryDetail>;

const bModalStub = {
  render: () => {},
  methods: {
    hide: () => {},
    show: () => {},
  },
};

describe('Component Tests', () => {
  let alertService: AlertService;

  describe('ImportHistoryDetail Management Component', () => {
    let importHistoryDetailServiceStub: SinonStubbedInstance<ImportHistoryDetailService>;
    let mountOptions: MountingOptions<ImportHistoryDetailComponentType>['global'];

    beforeEach(() => {
      importHistoryDetailServiceStub = sinon.createStubInstance<ImportHistoryDetailService>(ImportHistoryDetailService);
      importHistoryDetailServiceStub.retrieve.resolves({ headers: {} });

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
          importHistoryDetailService: () => importHistoryDetailServiceStub,
        },
      };
    });

    describe('Mount', () => {
      it('Should call load all on init', async () => {
        // GIVEN
        importHistoryDetailServiceStub.retrieve.resolves({ headers: {}, data: [{ id: 123 }] });

        // WHEN
        const wrapper = shallowMount(ImportHistoryDetail, { global: mountOptions });
        const comp = wrapper.vm;
        await comp.$nextTick();

        // THEN
        expect(importHistoryDetailServiceStub.retrieve.calledOnce).toBeTruthy();
        expect(comp.importHistoryDetails[0]).toEqual(expect.objectContaining({ id: 123 }));
      });

      it('should calculate the sort attribute for an id', async () => {
        // WHEN
        const wrapper = shallowMount(ImportHistoryDetail, { global: mountOptions });
        const comp = wrapper.vm;
        await comp.$nextTick();

        // THEN
        expect(importHistoryDetailServiceStub.retrieve.lastCall.firstArg).toMatchObject({
          sort: ['id,asc'],
        });
      });
    });
    describe('Handles', () => {
      let comp: ImportHistoryDetailComponentType;

      beforeEach(async () => {
        const wrapper = shallowMount(ImportHistoryDetail, { global: mountOptions });
        comp = wrapper.vm;
        await comp.$nextTick();
        importHistoryDetailServiceStub.retrieve.reset();
        importHistoryDetailServiceStub.retrieve.resolves({ headers: {}, data: [] });
      });

      it('should load a page', async () => {
        // GIVEN
        importHistoryDetailServiceStub.retrieve.resolves({ headers: {}, data: [{ id: 123 }] });

        // WHEN
        comp.page = 2;
        await comp.$nextTick();

        // THEN
        expect(importHistoryDetailServiceStub.retrieve.called).toBeTruthy();
        expect(comp.importHistoryDetails[0]).toEqual(expect.objectContaining({ id: 123 }));
      });

      it('should not load a page if the page is the same as the previous page', () => {
        // WHEN
        comp.page = 1;

        // THEN
        expect(importHistoryDetailServiceStub.retrieve.called).toBeFalsy();
      });

      it('should re-initialize the page', async () => {
        // GIVEN
        comp.page = 2;
        await comp.$nextTick();
        importHistoryDetailServiceStub.retrieve.reset();
        importHistoryDetailServiceStub.retrieve.resolves({ headers: {}, data: [{ id: 123 }] });

        // WHEN
        comp.clear();
        await comp.$nextTick();

        // THEN
        expect(comp.page).toEqual(1);
        expect(importHistoryDetailServiceStub.retrieve.callCount).toEqual(1);
        expect(comp.importHistoryDetails[0]).toEqual(expect.objectContaining({ id: 123 }));
      });

      it('should calculate the sort attribute for a non-id attribute', async () => {
        // WHEN
        comp.propOrder = 'name';
        await comp.$nextTick();

        // THEN
        expect(importHistoryDetailServiceStub.retrieve.lastCall.firstArg).toMatchObject({
          sort: ['name,asc', 'id'],
        });
      });

      it('Should call delete service on confirmDelete', async () => {
        // GIVEN
        importHistoryDetailServiceStub.delete.resolves({});

        // WHEN
        comp.prepareRemove({ id: 123 });

        comp.removeImportHistoryDetail();
        await comp.$nextTick(); // clear components

        // THEN
        expect(importHistoryDetailServiceStub.delete.called).toBeTruthy();

        // THEN
        await comp.$nextTick(); // handle component clear watch
        expect(importHistoryDetailServiceStub.retrieve.callCount).toEqual(1);
      });
    });
  });
});
