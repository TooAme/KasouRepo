import { vitest } from 'vitest';
import { type MountingOptions, shallowMount } from '@vue/test-utils';
import sinon, { type SinonStubbedInstance } from 'sinon';
import { type RouteLocation } from 'vue-router';

import dayjs from 'dayjs';
import ImportHistoryDetailUpdate from './import-history-detail-update.vue';
import ImportHistoryDetailService from './import-history-detail.service';
import { DATE_TIME_LONG_FORMAT } from '@/shared/composables/date-format';
import AlertService from '@/shared/alert/alert.service';

type ImportHistoryDetailUpdateComponentType = InstanceType<typeof ImportHistoryDetailUpdate>;

let route: Partial<RouteLocation>;
const routerGoMock = vitest.fn();

vitest.mock('vue-router', () => ({
  useRoute: () => route,
  useRouter: () => ({ go: routerGoMock }),
}));

const importHistoryDetailSample = { id: 123 };

describe('Component Tests', () => {
  let mountOptions: MountingOptions<ImportHistoryDetailUpdateComponentType>['global'];
  let alertService: AlertService;

  describe('ImportHistoryDetail Management Update Component', () => {
    let comp: ImportHistoryDetailUpdateComponentType;
    let importHistoryDetailServiceStub: SinonStubbedInstance<ImportHistoryDetailService>;

    beforeEach(() => {
      route = {};
      importHistoryDetailServiceStub = sinon.createStubInstance<ImportHistoryDetailService>(ImportHistoryDetailService);
      importHistoryDetailServiceStub.retrieve.onFirstCall().resolves(Promise.resolve([]));

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
          importHistoryDetailService: () => importHistoryDetailServiceStub,
        },
      };
    });

    afterEach(() => {
      vitest.resetAllMocks();
    });

    describe('load', () => {
      beforeEach(() => {
        const wrapper = shallowMount(ImportHistoryDetailUpdate, { global: mountOptions });
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
        const wrapper = shallowMount(ImportHistoryDetailUpdate, { global: mountOptions });
        comp = wrapper.vm;
        comp.importHistoryDetail = importHistoryDetailSample;
        importHistoryDetailServiceStub.update.resolves(importHistoryDetailSample);

        // WHEN
        comp.save();
        await comp.$nextTick();

        // THEN
        expect(importHistoryDetailServiceStub.update.calledWith(importHistoryDetailSample)).toBeTruthy();
        expect(comp.isSaving).toEqual(false);
      });

      it('Should call create service on save for new entity', async () => {
        // GIVEN
        const entity = {};
        importHistoryDetailServiceStub.create.resolves(entity);
        const wrapper = shallowMount(ImportHistoryDetailUpdate, { global: mountOptions });
        comp = wrapper.vm;
        comp.importHistoryDetail = entity;

        // WHEN
        comp.save();
        await comp.$nextTick();

        // THEN
        expect(importHistoryDetailServiceStub.create.calledWith(entity)).toBeTruthy();
        expect(comp.isSaving).toEqual(false);
      });
    });

    describe('Before route enter', () => {
      it('Should retrieve data', async () => {
        // GIVEN
        importHistoryDetailServiceStub.find.resolves(importHistoryDetailSample);
        importHistoryDetailServiceStub.retrieve.resolves([importHistoryDetailSample]);

        // WHEN
        route = {
          params: {
            importHistoryDetailId: `${importHistoryDetailSample.id}`,
          },
        };
        const wrapper = shallowMount(ImportHistoryDetailUpdate, { global: mountOptions });
        comp = wrapper.vm;
        await comp.$nextTick();

        // THEN
        expect(comp.importHistoryDetail).toMatchObject(importHistoryDetailSample);
      });
    });

    describe('Previous state', () => {
      it('Should go previous state', async () => {
        importHistoryDetailServiceStub.find.resolves(importHistoryDetailSample);
        const wrapper = shallowMount(ImportHistoryDetailUpdate, { global: mountOptions });
        comp = wrapper.vm;
        await comp.$nextTick();

        comp.previousState();
        await comp.$nextTick();

        expect(routerGoMock).toHaveBeenCalledWith(-1);
      });
    });
  });
});
