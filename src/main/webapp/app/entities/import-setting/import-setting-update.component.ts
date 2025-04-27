import { type Ref, computed, defineComponent, inject, ref } from 'vue';
import { useI18n } from 'vue-i18n';
import { useRoute, useRouter } from 'vue-router';
import { useVuelidate } from '@vuelidate/core';

import ImportSettingService from './import-setting.service';
import { useValidation } from '@/shared/composables';
import { useAlertService } from '@/shared/alert/alert.service';

import { type IImportSetting, ImportSetting } from '@/shared/model/import-setting.model';

export default defineComponent({
  compatConfig: { MODE: 3 },
  name: 'ImportSettingUpdate',
  setup() {
    const importSettingService = inject('importSettingService', () => new ImportSettingService());
    const alertService = inject('alertService', () => useAlertService(), true);

    const importSetting: Ref<IImportSetting> = ref(new ImportSetting());
    const isSaving = ref(false);
    const currentLanguage = inject('currentLanguage', () => computed(() => navigator.language ?? 'ja'), true);

    const route = useRoute();
    const router = useRouter();

    const previousState = () => router.go(-1);

    const retrieveImportSetting = async importSettingId => {
      try {
        const res = await importSettingService().find(importSettingId);
        importSetting.value = res;
      } catch (error) {
        alertService.showHttpError(error.response);
      }
    };

    if (route.params?.importSettingId) {
      retrieveImportSetting(route.params.importSettingId);
    }

    const { t: t$ } = useI18n();
    const validations = useValidation();
    const validationRules = {
      tcisCode: {},
      tcisType: {},
      tcisIncol: {},
      tcisEditrule: {},
    };
    const v$ = useVuelidate(validationRules, importSetting as any);
    v$.value.$validate();

    return {
      importSettingService,
      alertService,
      importSetting,
      previousState,
      isSaving,
      currentLanguage,
      v$,
      t$,
    };
  },
  created(): void {},
  methods: {
    save(): void {
      this.isSaving = true;
      if (this.importSetting.id) {
        this.importSettingService()
          .update(this.importSetting)
          .then(param => {
            this.isSaving = false;
            this.previousState();
            this.alertService.showInfo(this.t$('importDbApp.importSetting.updated', { param: param.id }));
          })
          .catch(error => {
            this.isSaving = false;
            this.alertService.showHttpError(error.response);
          });
      } else {
        this.importSettingService()
          .create(this.importSetting)
          .then(param => {
            this.isSaving = false;
            this.previousState();
            this.alertService.showSuccess(this.t$('importDbApp.importSetting.created', { param: param.id }).toString());
          })
          .catch(error => {
            this.isSaving = false;
            this.alertService.showHttpError(error.response);
          });
      }
    },
  },
});
