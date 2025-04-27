import { type Ref, defineComponent, inject, ref } from 'vue';
import { useI18n } from 'vue-i18n';
import { useRoute, useRouter } from 'vue-router';

import ImportSettingService from './import-setting.service';
import { type IImportSetting } from '@/shared/model/import-setting.model';
import { useAlertService } from '@/shared/alert/alert.service';

export default defineComponent({
  compatConfig: { MODE: 3 },
  name: 'ImportSettingDetails',
  setup() {
    const importSettingService = inject('importSettingService', () => new ImportSettingService());
    const alertService = inject('alertService', () => useAlertService(), true);

    const route = useRoute();
    const router = useRouter();

    const previousState = () => router.go(-1);
    const importSetting: Ref<IImportSetting> = ref({});

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

    return {
      alertService,
      importSetting,

      previousState,
      t$: useI18n().t,
    };
  },
});
