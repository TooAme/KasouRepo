import { vitest } from 'vitest';
import { type MountingOptions, shallowMount } from '@vue/test-utils';
import sinon, { type SinonStubbedInstance } from 'sinon';
import { type RouteLocation } from 'vue-router';

import dayjs from 'dayjs';
import ImportHistoryUpdate from './import-history-update.vue';
import ImportHistoryService from './import-history.service';
import { DATE_TIME_LONG_FORMAT } from '@/shared/composables/date-format';
import AlertService from '@/shared/alert/alert.service';

type ImportHistoryUpdateComponentType = InstanceType<typeof ImportHistoryUpdate>;

let route: Partial<RouteLocation>;
const routerGoMock = vitest.fn();

vitest.mock('vue-router', () => ({
  useRoute: () => route,
  useRouter: () => ({ go: routerGoMock }),
}));

const importHistorySample = { id: 123 };

describe('Component Tests', () => {
  let mountOptions: MountingOptions<ImportHistoryUpdateComponentType>['global'];
  let alertService: AlertService;

  describe('ImportHistory Management Update Component', () => {
    let comp: ImportHistoryUpdateComponentType;
    let importHistoryServiceStub: SinonStubbedInstance<ImportHistoryService>;

    beforeEach(() => {
      route = {};
      importHistoryServiceStub = sinon.createStubInstance<ImportHistoryService>(ImportHistoryService);
      importHistoryServiceStub.retrieve.onFirstCall().resolves(Promise.resolve([]));

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
          importHistoryService: () => importHistoryServiceStub,
        },
      };
    });

    afterEach(() => {
      vitest.resetAllMocks();
    });

    describe('load', () => {
      beforeEach(() => {
        const wrapper = shallowMount(ImportHistoryUpdate, { global: mountOptions });
        comp = wrapper.vm;
      });
      it('Should convert date from string', () => {
        // GIVEN
        const date = new Date('2019-10-15T11:42:02Z');

        // WHEN
        const convertedDate = comp.convertDateTimeFromServer(date);

        // THEN
        expect(convertedDate).toEqual(dayjs(date).format(DATE_TIME_LONG_FORMAT));
      });

      it('Should not convert date if date is not present', () => {
        expect(comp.convertDateTimeFromServer(null)).toBeNull();
      });
    });

    describe('save', () => {
      it('Should call update service on save for existing entity', async () => {
        // GIVEN
        const wrapper = shallowMount(ImportHistoryUpdate, { global: mountOptions });
        comp = wrapper.vm;
        comp.importHistory = importHistorySample;
        importHistoryServiceStub.update.resolves(importHistorySample);

        // WHEN
        comp.save();
        await comp.$nextTick();

        // THEN
        expect(importHistoryServiceStub.update.calledWith(importHistorySample)).toBeTruthy();
        expect(comp.isSaving).toEqual(false);
      });

      it('Should call create service on save for new entity', async () => {
        // GIVEN
        const entity = {};
        importHistoryServiceStub.create.resolves(entity);
        const wrapper = shallowMount(ImportHistoryUpdate, { global: mountOptions });
        comp = wrapper.vm;
        comp.importHistory = entity;

        // WHEN
        comp.save();
        await comp.$nextTick();

        // THEN
        expect(importHistoryServiceStub.create.calledWith(entity)).toBeTruthy();
        expect(comp.isSaving).toEqual(false);
      });
    });

    describe('Before route enter', () => {
      it('Should retrieve data', async () => {
        // GIVEN
        importHistoryServiceStub.find.resolves(importHistorySample);
        importHistoryServiceStub.retrieve.resolves([importHistorySample]);

        // WHEN
        route = {
          params: {
            importHistoryId: `${importHistorySample.id}`,
          },
        };
        const wrapper = shallowMount(ImportHistoryUpdate, { global: mountOptions });
        comp = wrapper.vm;
        await comp.$nextTick();

        // THEN
        expect(comp.importHistory).toMatchObject(importHistorySample);
      });
    });

    describe('Previous state', () => {
      it('Should go previous state', async () => {
        importHistoryServiceStub.find.resolves(importHistorySample);
        const wrapper = shallowMount(ImportHistoryUpdate, { global: mountOptions });
        comp = wrapper.vm;
        await comp.$nextTick();

        comp.previousState();
        await comp.$nextTick();

        expect(routerGoMock).toHaveBeenCalledWith(-1);
      });
    });
  });
});
