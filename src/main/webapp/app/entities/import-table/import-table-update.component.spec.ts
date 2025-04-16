import { vitest } from 'vitest';
import { type MountingOptions, shallowMount } from '@vue/test-utils';
import sinon, { type SinonStubbedInstance } from 'sinon';
import { type RouteLocation } from 'vue-router';

import dayjs from 'dayjs';
import ImportTableUpdate from './import-table-update.vue';
import ImportTableService from './import-table.service';
import { DATE_TIME_LONG_FORMAT } from '@/shared/composables/date-format';
import AlertService from '@/shared/alert/alert.service';

type ImportTableUpdateComponentType = InstanceType<typeof ImportTableUpdate>;

let route: Partial<RouteLocation>;
const routerGoMock = vitest.fn();

vitest.mock('vue-router', () => ({
  useRoute: () => route,
  useRouter: () => ({ go: routerGoMock }),
}));

const importTableSample = { id: 123 };

describe('Component Tests', () => {
  let mountOptions: MountingOptions<ImportTableUpdateComponentType>['global'];
  let alertService: AlertService;

  describe('ImportTable Management Update Component', () => {
    let comp: ImportTableUpdateComponentType;
    let importTableServiceStub: SinonStubbedInstance<ImportTableService>;

    beforeEach(() => {
      route = {};
      importTableServiceStub = sinon.createStubInstance<ImportTableService>(ImportTableService);
      importTableServiceStub.retrieve.onFirstCall().resolves(Promise.resolve([]));

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
          importTableService: () => importTableServiceStub,
        },
      };
    });

    afterEach(() => {
      vitest.resetAllMocks();
    });

    describe('load', () => {
      beforeEach(() => {
        const wrapper = shallowMount(ImportTableUpdate, { global: mountOptions });
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
        const wrapper = shallowMount(ImportTableUpdate, { global: mountOptions });
        comp = wrapper.vm;
        comp.importTable = importTableSample;
        importTableServiceStub.update.resolves(importTableSample);

        // WHEN
        comp.save();
        await comp.$nextTick();

        // THEN
        expect(importTableServiceStub.update.calledWith(importTableSample)).toBeTruthy();
        expect(comp.isSaving).toEqual(false);
      });

      it('Should call create service on save for new entity', async () => {
        // GIVEN
        const entity = {};
        importTableServiceStub.create.resolves(entity);
        const wrapper = shallowMount(ImportTableUpdate, { global: mountOptions });
        comp = wrapper.vm;
        comp.importTable = entity;

        // WHEN
        comp.save();
        await comp.$nextTick();

        // THEN
        expect(importTableServiceStub.create.calledWith(entity)).toBeTruthy();
        expect(comp.isSaving).toEqual(false);
      });
    });

    describe('Before route enter', () => {
      it('Should retrieve data', async () => {
        // GIVEN
        importTableServiceStub.find.resolves(importTableSample);
        importTableServiceStub.retrieve.resolves([importTableSample]);

        // WHEN
        route = {
          params: {
            importTableId: `${importTableSample.id}`,
          },
        };
        const wrapper = shallowMount(ImportTableUpdate, { global: mountOptions });
        comp = wrapper.vm;
        await comp.$nextTick();

        // THEN
        expect(comp.importTable).toMatchObject(importTableSample);
      });
    });

    describe('Previous state', () => {
      it('Should go previous state', async () => {
        importTableServiceStub.find.resolves(importTableSample);
        const wrapper = shallowMount(ImportTableUpdate, { global: mountOptions });
        comp = wrapper.vm;
        await comp.$nextTick();

        comp.previousState();
        await comp.$nextTick();

        expect(routerGoMock).toHaveBeenCalledWith(-1);
      });
    });
  });
});
