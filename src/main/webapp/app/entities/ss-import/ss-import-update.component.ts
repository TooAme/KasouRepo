import { type Ref, computed, defineComponent, inject, ref } from 'vue';
import { useI18n } from 'vue-i18n';
import { useRoute, useRouter } from 'vue-router';
import { useVuelidate } from '@vuelidate/core';

import SSImportService from './ss-import.service';
import { useDateFormat, useValidation } from '@/shared/composables';
import { useAlertService } from '@/shared/alert/alert.service';

import { type ISSImport, SSImport } from '@/shared/model/ss-import.model';

export default defineComponent({
  compatConfig: { MODE: 3 },
  name: 'SSImportUpdate',
  setup() {
    const sSImportService = inject('sSImportService', () => new SSImportService());
    const alertService = inject('alertService', () => useAlertService(), true);

    const sSImport: Ref<ISSImport> = ref(new SSImport());
    const isSaving = ref(false);
    const currentLanguage = inject('currentLanguage', () => computed(() => navigator.language ?? 'ja'), true);

    const route = useRoute();
    const router = useRouter();

    const previousState = () => router.go(-1);

    const retrieveSSImport = async sSImportId => {
      try {
        const res = await sSImportService().find(sSImportId);
        res.createTime = new Date(res.createTime);
        res.updateTime = new Date(res.updateTime);
        sSImport.value = res;
      } catch (error) {
        alertService.showHttpError(error.response);
      }
    };

    if (route.params?.sSImportId) {
      retrieveSSImport(route.params.sSImportId);
    }

    const { t: t$ } = useI18n();
    const validations = useValidation();
    const validationRules = {
      uuid: {
        required: validations.required(t$('entity.validation.required').toString()),
      },
      ssCreateBy: {},
      ssFilename: {},
      ssBCode: {},
      ssSubBCode: {},
      createBy: {},
      createTime: {},
      updateBy: {},
      updateTime: {},
      delFlag: {},
      remark: {},
    };
    const v$ = useVuelidate(validationRules, sSImport as any);
    v$.value.$validate();

    return {
      sSImportService,
      alertService,
      sSImport,
      previousState,
      isSaving,
      currentLanguage,
      v$,
      ...useDateFormat({ entityRef: sSImport }),
      t$,
    };
  },
  created(): void {},
  methods: {
    save(): void {
      this.isSaving = true;
      if (this.sSImport.id) {
        this.sSImportService()
          .update(this.sSImport)
          .then(param => {
            this.isSaving = false;
            this.previousState();
            this.alertService.showInfo(this.t$('importDbApp.sSImport.updated', { param: param.id }));
          })
          .catch(error => {
            this.isSaving = false;
            this.alertService.showHttpError(error.response);
          });
      } else {
        this.sSImportService()
          .create(this.sSImport)
          .then(param => {
            this.isSaving = false;
            this.previousState();
            this.alertService.showSuccess(this.t$('importDbApp.sSImport.created', { param: param.id }).toString());
          })
          .catch(error => {
            this.isSaving = false;
            this.alertService.showHttpError(error.response);
          });
      }
    },
  },
});
