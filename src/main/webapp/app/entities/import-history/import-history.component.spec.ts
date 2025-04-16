import { vitest } from 'vitest';
import { type MountingOptions, shallowMount } from '@vue/test-utils';
import sinon, { type SinonStubbedInstance } from 'sinon';

import ImportHistory from './import-history.vue';
import ImportHistoryService from './import-history.service';
import AlertService from '@/shared/alert/alert.service';

type ImportHistoryComponentType = InstanceType<typeof ImportHistory>;

const bModalStub = {
  render: () => {},
  methods: {
    hide: () => {},
    show: () => {},
  },
};

describe('Component Tests', () => {
  let alertService: AlertService;

  describe('ImportHistory Management Component', () => {
    let importHistoryServiceStub: SinonStubbedInstance<ImportHistoryService>;
    let mountOptions: MountingOptions<ImportHistoryComponentType>['global'];

    beforeEach(() => {
      importHistoryServiceStub = sinon.createStubInstance<ImportHistoryService>(ImportHistoryService);
      importHistoryServiceStub.retrieve.resolves({ headers: {} });

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
          importHistoryService: () => importHistoryServiceStub,
        },
      };
    });

    describe('Mount', () => {
      it('Should call load all on init', async () => {
        // GIVEN
        importHistoryServiceStub.retrieve.resolves({ headers: {}, data: [{ id: 123 }] });

        // WHEN
        const wrapper = shallowMount(ImportHistory, { global: mountOptions });
        const comp = wrapper.vm;
        await comp.$nextTick();

        // THEN
        expect(importHistoryServiceStub.retrieve.calledOnce).toBeTruthy();
        expect(comp.importHistories[0]).toEqual(expect.objectContaining({ id: 123 }));
      });

      it('should calculate the sort attribute for an id', async () => {
        // WHEN
        const wrapper = shallowMount(ImportHistory, { global: mountOptions });
        const comp = wrapper.vm;
        await comp.$nextTick();

        // THEN
        expect(importHistoryServiceStub.retrieve.lastCall.firstArg).toMatchObject({
          sort: ['id,asc'],
        });
      });
    });
    describe('Handles', () => {
      let comp: ImportHistoryComponentType;

      beforeEach(async () => {
        const wrapper = shallowMount(ImportHistory, { global: mountOptions });
        comp = wrapper.vm;
        await comp.$nextTick();
        importHistoryServiceStub.retrieve.reset();
        importHistoryServiceStub.retrieve.resolves({ headers: {}, data: [] });
      });

      it('should load a page', async () => {
        // GIVEN
        importHistoryServiceStub.retrieve.resolves({ headers: {}, data: [{ id: 123 }] });

        // WHEN
        comp.page = 2;
        await comp.$nextTick();

        // THEN
        expect(importHistoryServiceStub.retrieve.called).toBeTruthy();
        expect(comp.importHistories[0]).toEqual(expect.objectContaining({ id: 123 }));
      });

      it('should not load a page if the page is the same as the previous page', () => {
        // WHEN
        comp.page = 1;

        // THEN
        expect(importHistoryServiceStub.retrieve.called).toBeFalsy();
      });

      it('should re-initialize the page', async () => {
        // GIVEN
        comp.page = 2;
        await comp.$nextTick();
        importHistoryServiceStub.retrieve.reset();
        importHistoryServiceStub.retrieve.resolves({ headers: {}, data: [{ id: 123 }] });

        // WHEN
        comp.clear();
        await comp.$nextTick();

        // THEN
        expect(comp.page).toEqual(1);
        expect(importHistoryServiceStub.retrieve.callCount).toEqual(1);
        expect(comp.importHistories[0]).toEqual(expect.objectContaining({ id: 123 }));
      });

      it('should calculate the sort attribute for a non-id attribute', async () => {
        // WHEN
        comp.propOrder = 'name';
        await comp.$nextTick();

        // THEN
        expect(importHistoryServiceStub.retrieve.lastCall.firstArg).toMatchObject({
          sort: ['name,asc', 'id'],
        });
      });

      it('Should call delete service on confirmDelete', async () => {
        // GIVEN
        importHistoryServiceStub.delete.resolves({});

        // WHEN
        comp.prepareRemove({ id: 123 });

        comp.removeImportHistory();
        await comp.$nextTick(); // clear components

        // THEN
        expect(importHistoryServiceStub.delete.called).toBeTruthy();

        // THEN
        await comp.$nextTick(); // handle component clear watch
        expect(importHistoryServiceStub.retrieve.callCount).toEqual(1);
      });
    });
  });
});
