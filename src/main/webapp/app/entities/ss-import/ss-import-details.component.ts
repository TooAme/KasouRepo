import { type Ref, defineComponent, inject, ref } from 'vue';
import { useI18n } from 'vue-i18n';
import { useRoute, useRouter } from 'vue-router';

import SSImportService from './ss-import.service';
import { useDateFormat } from '@/shared/composables';
import { type ISSImport } from '@/shared/model/ss-import.model';
import { useAlertService } from '@/shared/alert/alert.service';

export default defineComponent({
  compatConfig: { MODE: 3 },
  name: 'SSImportDetails',
  setup() {
    const dateFormat = useDateFormat();
    const sSImportService = inject('sSImportService', () => new SSImportService());
    const alertService = inject('alertService', () => useAlertService(), true);

    const route = useRoute();
    const router = useRouter();

    const previousState = () => router.go(-1);
    const sSImport: Ref<ISSImport> = ref({});

    const retrieveSSImport = async sSImportId => {
      try {
        const res = await sSImportService().find(sSImportId);
        sSImport.value = res;
      } catch (error) {
        alertService.showHttpError(error.response);
      }
    };

    if (route.params?.sSImportId) {
      retrieveSSImport(route.params.sSImportId);
    }

    return {
      ...dateFormat,
      alertService,
      sSImport,

      previousState,
      t$: useI18n().t,
    };
  },
});
