import { defineComponent, provide } from 'vue';

import ImportHistoryService from './import-history/import-history.service';
import ImportHistoryDetailService from './import-history-detail/import-history-detail.service';
import ImportTableService from './import-table/import-table.service';
import SSImportService from './ss-import/ss-import.service';
import UserService from '@/entities/user/user.service';
import ImportSettingService from '@/entities/import-setting/import-setting.service.ts';
// jhipster-needle-add-entity-service-to-entities-component-import - JHipster will import entities services here

export default defineComponent({
  compatConfig: { MODE: 3 },
  name: 'Entities',
  setup() {
    provide('userService', () => new UserService());
    provide('importHistoryService', () => new ImportHistoryService());
    provide('importHistoryDetailService', () => new ImportHistoryDetailService());
    provide('importTableService', () => new ImportTableService());
    provide('sSImportService', () => new SSImportService());
    provide('importSettingService', () => new ImportSettingService());
    // jhipster-needle-add-entity-service-to-entities-component - JHipster will import entities services here
  },
});
