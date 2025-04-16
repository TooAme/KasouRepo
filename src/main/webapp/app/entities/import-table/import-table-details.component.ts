import { type Ref, defineComponent, inject, ref } from 'vue';
import { useI18n } from 'vue-i18n';
import { useRoute, useRouter } from 'vue-router';

import ImportTableService from './import-table.service';
import { useDateFormat } from '@/shared/composables';
import { type IImportTable } from '@/shared/model/import-table.model';
import { useAlertService } from '@/shared/alert/alert.service';

export default defineComponent({
  compatConfig: { MODE: 3 },
  name: 'ImportTableDetails',
  setup() {
    const dateFormat = useDateFormat();
    const importTableService = inject('importTableService', () => new ImportTableService());
    const alertService = inject('alertService', () => useAlertService(), true);

    const route = useRoute();
    const router = useRouter();

    const previousState = () => router.go(-1);
    const importTable: Ref<IImportTable> = ref({});

    const retrieveImportTable = async importTableId => {
      try {
        const res = await importTableService().find(importTableId);
        importTable.value = res;
      } catch (error) {
        alertService.showHttpError(error.response);
      }
    };

    if (route.params?.importTableId) {
      retrieveImportTable(route.params.importTableId);
    }

    return {
      ...dateFormat,
      alertService,
      importTable,

      previousState,
      t$: useI18n().t,
    };
  },
});
