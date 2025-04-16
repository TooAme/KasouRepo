import { type Ref, computed, defineComponent, inject, ref } from 'vue';
import { useI18n } from 'vue-i18n';
import { useRoute, useRouter } from 'vue-router';
import { useVuelidate } from '@vuelidate/core';

import ImportHistoryService from './import-history.service';
import { useDateFormat, useValidation } from '@/shared/composables';
import { useAlertService } from '@/shared/alert/alert.service';

import { type IImportHistory, ImportHistory } from '@/shared/model/import-history.model';

export default defineComponent({
  compatConfig: { MODE: 3 },
  name: 'ImportHistoryUpdate',
  setup() {
    const importHistoryService = inject('importHistoryService', () => new ImportHistoryService());
    const alertService = inject('alertService', () => useAlertService(), true);

    const importHistory: Ref<IImportHistory> = ref(new ImportHistory());
    const isSaving = ref(false);
    const currentLanguage = inject('currentLanguage', () => computed(() => navigator.language ?? 'ja'), true);

    const route = useRoute();
    const router = useRouter();

    const previousState = () => router.go(-1);

    const retrieveImportHistory = async importHistoryId => {
      try {
        const res = await importHistoryService().find(importHistoryId);
        res.tcihImporttime = new Date(res.tcihImporttime);
        res.createTime = new Date(res.createTime);
        res.updateTime = new Date(res.updateTime);
        importHistory.value = res;
      } catch (error) {
        alertService.showHttpError(error.response);
      }
    };

    if (route.params?.importHistoryId) {
      retrieveImportHistory(route.params.importHistoryId);
    }

    const { t: t$ } = useI18n();
    const validations = useValidation();
    const validationRules = {
      uuid: {
        required: validations.required(t$('entity.validation.required').toString()),
      },
      tcihCode: {},
      tcihFilename: {},
      tcihImporttime: {},
      tcihStatus: {},
      createBy: {},
      createTime: {},
      updateBy: {},
      updateTime: {},
      delFlag: {},
      remark: {},
    };
    const v$ = useVuelidate(validationRules, importHistory as any);
    v$.value.$validate();

    return {
      importHistoryService,
      alertService,
      importHistory,
      previousState,
      isSaving,
      currentLanguage,
      v$,
      ...useDateFormat({ entityRef: importHistory }),
      t$,
    };
  },
  created(): void {},
  methods: {
    save(): void {
      this.isSaving = true;
      if (this.importHistory.id) {
        this.importHistoryService()
          .update(this.importHistory)
          .then(param => {
            this.isSaving = false;
            this.previousState();
            this.alertService.showInfo(this.t$('importDbApp.importHistory.updated', { param: param.id }));
          })
          .catch(error => {
            this.isSaving = false;
            this.alertService.showHttpError(error.response);
          });
      } else {
        this.importHistoryService()
          .create(this.importHistory)
          .then(param => {
            this.isSaving = false;
            this.previousState();
            this.alertService.showSuccess(this.t$('importDbApp.importHistory.created', { param: param.id }).toString());
          })
          .catch(error => {
            this.isSaving = false;
            this.alertService.showHttpError(error.response);
          });
      }
    },
  },
});
