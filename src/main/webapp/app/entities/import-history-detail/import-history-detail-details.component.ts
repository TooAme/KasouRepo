import { type Ref, defineComponent, inject, ref } from 'vue';
import { useI18n } from 'vue-i18n';
import { useRoute, useRouter } from 'vue-router';

import ImportHistoryDetailService from './import-history-detail.service';
import { useDateFormat } from '@/shared/composables';
import { type IImportHistoryDetail } from '@/shared/model/import-history-detail.model';
import { useAlertService } from '@/shared/alert/alert.service';

export default defineComponent({
  compatConfig: { MODE: 3 },
  name: 'ImportHistoryDetailDetails',
  setup() {
    const dateFormat = useDateFormat();
    const importHistoryDetailService = inject('importHistoryDetailService', () => new ImportHistoryDetailService());
    const alertService = inject('alertService', () => useAlertService(), true);

    const route = useRoute();
    const router = useRouter();

    const previousState = () => router.go(-1);
    const importHistoryDetail: Ref<IImportHistoryDetail> = ref({});

    const retrieveImportHistoryDetail = async importHistoryDetailId => {
      try {
        const res = await importHistoryDetailService().find(importHistoryDetailId);
        importHistoryDetail.value = res;
      } catch (error) {
        alertService.showHttpError(error.response);
      }
    };

    if (route.params?.importHistoryDetailId) {
      retrieveImportHistoryDetail(route.params.importHistoryDetailId);
    }

    return {
      ...dateFormat,
      alertService,
      importHistoryDetail,

      previousState,
      t$: useI18n().t,
    };
  },
});
