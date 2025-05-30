import { vitest } from 'vitest';
import { type MountingOptions, shallowMount } from '@vue/test-utils';
import sinon, { type SinonStubbedInstance } from 'sinon';
import { type RouteLocation } from 'vue-router';

import dayjs from 'dayjs';
import SSImportUpdate from './ss-import-update.vue';
import SSImportService from './ss-import.service';
import { DATE_TIME_LONG_FORMAT } from '@/shared/composables/date-format';
import AlertService from '@/shared/alert/alert.service';

type SSImportUpdateComponentType = InstanceType<typeof SSImportUpdate>;

let route: Partial<RouteLocation>;
const routerGoMock = vitest.fn();

vitest.mock('vue-router', () => ({
  useRoute: () => route,
  useRouter: () => ({ go: routerGoMock }),
}));

const sSImportSample = { id: 123 };

describe('Component Tests', () => {
  let mountOptions: MountingOptions<SSImportUpdateComponentType>['global'];
  let alertService: AlertService;

  describe('SSImport Management Update Component', () => {
    let comp: SSImportUpdateComponentType;
    let sSImportServiceStub: SinonStubbedInstance<SSImportService>;

    beforeEach(() => {
      route = {};
      sSImportServiceStub = sinon.createStubInstance<SSImportService>(SSImportService);
      sSImportServiceStub.retrieve.onFirstCall().resolves(Promise.resolve([]));

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
          sSImportService: () => sSImportServiceStub,
        },
      };
    });

    afterEach(() => {
      vitest.resetAllMocks();
    });

    describe('load', () => {
      beforeEach(() => {
        const wrapper = shallowMount(SSImportUpdate, { global: mountOptions });
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
        const wrapper = shallowMount(SSImportUpdate, { global: mountOptions });
        comp = wrapper.vm;
        comp.sSImport = sSImportSample;
        sSImportServiceStub.update.resolves(sSImportSample);

        // WHEN
        comp.save();
        await comp.$nextTick();

        // THEN
        expect(sSImportServiceStub.update.calledWith(sSImportSample)).toBeTruthy();
        expect(comp.isSaving).toEqual(false);
      });

      it('Should call create service on save for new entity', async () => {
        // GIVEN
        const entity = {};
        sSImportServiceStub.create.resolves(entity);
        const wrapper = shallowMount(SSImportUpdate, { global: mountOptions });
        comp = wrapper.vm;
        comp.sSImport = entity;

        // WHEN
        comp.save();
        await comp.$nextTick();

        // THEN
        expect(sSImportServiceStub.create.calledWith(entity)).toBeTruthy();
        expect(comp.isSaving).toEqual(false);
      });
    });

    describe('Before route enter', () => {
      it('Should retrieve data', async () => {
        // GIVEN
        sSImportServiceStub.find.resolves(sSImportSample);
        sSImportServiceStub.retrieve.resolves([sSImportSample]);

        // WHEN
        route = {
          params: {
            sSImportId: `${sSImportSample.id}`,
          },
        };
        const wrapper = shallowMount(SSImportUpdate, { global: mountOptions });
        comp = wrapper.vm;
        await comp.$nextTick();

        // THEN
        expect(comp.sSImport).toMatchObject(sSImportSample);
      });
    });

    describe('Previous state', () => {
      it('Should go previous state', async () => {
        sSImportServiceStub.find.resolves(sSImportSample);
        const wrapper = shallowMount(SSImportUpdate, { global: mountOptions });
        comp = wrapper.vm;
        await comp.$nextTick();

        comp.previousState();
        await comp.$nextTick();

        expect(routerGoMock).toHaveBeenCalledWith(-1);
      });
    });
  });
});
