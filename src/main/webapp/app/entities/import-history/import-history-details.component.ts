import { type Ref, defineComponent, inject, ref } from 'vue';
import { useI18n } from 'vue-i18n';
import { useRoute, useRouter } from 'vue-router';

import ImportHistoryService from './import-history.service';
import { useDateFormat } from '@/shared/composables';
import { type IImportHistory } from '@/shared/model/import-history.model';
import { useAlertService } from '@/shared/alert/alert.service';

export default defineComponent({
  compatConfig: { MODE: 3 },
  name: 'ImportHistoryDetails',
  setup() {
    const dateFormat = useDateFormat();
    const importHistoryService = inject('importHistoryService', () => new ImportHistoryService());
    const alertService = inject('alertService', () => useAlertService(), true);

    const route = useRoute();
    const router = useRouter();

    const previousState = () => router.go(-1);
    const importHistory: Ref<IImportHistory> = ref({});

    const retrieveImportHistory = async importHistoryId => {
      try {
        const res = await importHistoryService().find(importHistoryId);
        importHistory.value = res;
      } catch (error) {
        alertService.showHttpError(error.response);
      }
    };

    if (route.params?.importHistoryId) {
      retrieveImportHistory(route.params.importHistoryId);
    }

    return {
      ...dateFormat,
      alertService,
      importHistory,

      previousState,
      t$: useI18n().t,
    };
  },
});
