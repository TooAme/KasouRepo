import { type Ref, computed, defineComponent, inject, ref } from 'vue';
import { useI18n } from 'vue-i18n';
import { useRoute, useRouter } from 'vue-router';
import { useVuelidate } from '@vuelidate/core';

import ImportTableService from './import-table.service';
import { useDateFormat, useValidation } from '@/shared/composables';
import { useAlertService } from '@/shared/alert/alert.service';

import { type IImportTable, ImportTable } from '@/shared/model/import-table.model';

export default defineComponent({
  compatConfig: { MODE: 3 },
  name: 'ImportTableUpdate',
  setup() {
    const importTableService = inject('importTableService', () => new ImportTableService());
    const alertService = inject('alertService', () => useAlertService(), true);

    const importTable: Ref<IImportTable> = ref(new ImportTable());
    const isSaving = ref(false);
    const currentLanguage = inject('currentLanguage', () => computed(() => navigator.language ?? 'ja'), true);

    const route = useRoute();
    const router = useRouter();

    const previousState = () => router.go(-1);

    const retrieveImportTable = async importTableId => {
      try {
        const res = await importTableService().find(importTableId);
        res.createTime = new Date(res.createTime);
        res.updateTime = new Date(res.updateTime);
        importTable.value = res;
      } catch (error) {
        alertService.showHttpError(error.response);
      }
    };

    if (route.params?.importTableId) {
      retrieveImportTable(route.params.importTableId);
    }

    const { t: t$ } = useI18n();
    const validations = useValidation();
    const validationRules = {
      uuid: {
        required: validations.required(t$('entity.validation.required').toString()),
      },
      partNumber: {
        required: validations.required(t$('entity.validation.required').toString()),
      },
      partType: {},
      value: {},
      schematicPart: {},
      ratingVoltage: {},
      ratingElectricity: {},
      characteristics: {},
      tolerance: {},
      manufacture: {},
      bCode: {},
      partsName: {},
      itemRegistrationClassification: {},
      spiceModel: {},
      pcbFootPrint: {},
      delFlag: {},
      remark: {},
      createBy: {},
      createTime: {},
      updateBy: {},
      updateTime: {},
    };
    const v$ = useVuelidate(validationRules, importTable as any);
    v$.value.$validate();

    return {
      importTableService,
      alertService,
      importTable,
      previousState,
      isSaving,
      currentLanguage,
      v$,
      ...useDateFormat({ entityRef: importTable }),
      t$,
    };
  },
  created(): void {},
  methods: {
    save(): void {
      this.isSaving = true;
      if (this.importTable.id) {
        this.importTableService()
          .update(this.importTable)
          .then(param => {
            this.isSaving = false;
            this.previousState();
            this.alertService.showInfo(this.t$('importDbApp.importTable.updated', { param: param.id }));
          })
          .catch(error => {
            this.isSaving = false;
            this.alertService.showHttpError(error.response);
          });
      } else {
        this.importTableService()
          .create(this.importTable)
          .then(param => {
            this.isSaving = false;
            this.previousState();
            this.alertService.showSuccess(this.t$('importDbApp.importTable.created', { param: param.id }).toString());
          })
          .catch(error => {
            this.isSaving = false;
            this.alertService.showHttpError(error.response);
          });
      }
    },
  },
});
