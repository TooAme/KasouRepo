import { type Ref, computed, defineComponent, inject, ref } from 'vue';
import { useI18n } from 'vue-i18n';
import { useRoute, useRouter } from 'vue-router';
import { useVuelidate } from '@vuelidate/core';

import ImportHistoryDetailService from './import-history-detail.service';
import { useDateFormat, useValidation } from '@/shared/composables';
import { useAlertService } from '@/shared/alert/alert.service';

import { type IImportHistoryDetail, ImportHistoryDetail } from '@/shared/model/import-history-detail.model';

export default defineComponent({
  compatConfig: { MODE: 3 },
  name: 'ImportHistoryDetailUpdate',
  setup() {
    const importHistoryDetailService = inject('importHistoryDetailService', () => new ImportHistoryDetailService());
    const alertService = inject('alertService', () => useAlertService(), true);

    const importHistoryDetail: Ref<IImportHistoryDetail> = ref(new ImportHistoryDetail());
    const isSaving = ref(false);
    const currentLanguage = inject('currentLanguage', () => computed(() => navigator.language ?? 'ja'), true);

    const route = useRoute();
    const router = useRouter();

    const previousState = () => router.go(-1);

    const retrieveImportHistoryDetail = async importHistoryDetailId => {
      try {
        const res = await importHistoryDetailService().find(importHistoryDetailId);
        res.createTime = new Date(res.createTime);
        res.updateTime = new Date(res.updateTime);
        importHistoryDetail.value = res;
      } catch (error) {
        alertService.showHttpError(error.response);
      }
    };

    if (route.params?.importHistoryDetailId) {
      retrieveImportHistoryDetail(route.params.importHistoryDetailId);
    }

    const { t: t$ } = useI18n();
    const validations = useValidation();
    const validationRules = {
      uuid: {
        required: validations.required(t$('entity.validation.required').toString()),
      },
      tcihdPid: {},
      tcihdLine: {},
      tcihdError: {},
      createBy: {},
      createTime: {},
      updateBy: {},
      updateTime: {},
      delFlag: {},
      remark: {},
    };
    const v$ = useVuelidate(validationRules, importHistoryDetail as any);
    v$.value.$validate();

    return {
      importHistoryDetailService,
      alertService,
      importHistoryDetail,
      previousState,
      isSaving,
      currentLanguage,
      v$,
      ...useDateFormat({ entityRef: importHistoryDetail }),
      t$,
    };
  },
  created(): void {},
  methods: {
    save(): void {
      this.isSaving = true;
      if (this.importHistoryDetail.id) {
        this.importHistoryDetailService()
          .update(this.importHistoryDetail)
          .then(param => {
            this.isSaving = false;
            this.previousState();
            this.alertService.showInfo(this.t$('importDbApp.importHistoryDetail.updated', { param: param.id }));
          })
          .catch(error => {
            this.isSaving = false;
            this.alertService.showHttpError(error.response);
          });
      } else {
        this.importHistoryDetailService()
          .create(this.importHistoryDetail)
          .then(param => {
            this.isSaving = false;
            this.previousState();
            this.alertService.showSuccess(this.t$('importDbApp.importHistoryDetail.created', { param: param.id }).toString());
          })
          .catch(error => {
            this.isSaving = false;
            this.alertService.showHttpError(error.response);
          });
      }
    },
  },
});
