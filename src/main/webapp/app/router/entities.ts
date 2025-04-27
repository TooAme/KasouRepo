import { Authority } from '@/shared/security/authority';
const Entities = () => import('@/entities/entities.vue');

const ImportHistory = () => import('@/entities/import-history/import-history.vue');
const ImportHistoryUpdate = () => import('@/entities/import-history/import-history-update.vue');
const ImportHistoryDetails = () => import('@/entities/import-history/import-history-details.vue');

const ImportHistoryDetail = () => import('@/entities/import-history-detail/import-history-detail.vue');
const ImportHistoryDetailUpdate = () => import('@/entities/import-history-detail/import-history-detail-update.vue');
const ImportHistoryDetailDetails = () => import('@/entities/import-history-detail/import-history-detail-details.vue');

const ImportTable = () => import('@/entities/import-table/import-table.vue');
const ImportTableUpdate = () => import('@/entities/import-table/import-table-update.vue');
const ImportTableDetails = () => import('@/entities/import-table/import-table-details.vue');

const SSImport = () => import('@/entities/ss-import/ss-import.vue');
const SSImportUpdate = () => import('@/entities/ss-import/ss-import-update.vue');
const SSImportDetails = () => import('@/entities/ss-import/ss-import-details.vue');

const ImportSetting = () => import('@/entities/import-setting/import-setting.vue');
const ImportSettingUpdate = () => import('@/entities/import-setting/import-setting-update.vue');
const ImportSettingDetails = () => import('@/entities/import-setting/import-setting-details.vue');

// jhipster-needle-add-entity-to-router-import - JHipster will import entities to the router here

export default {
  path: '/',
  component: Entities,
  children: [
    {
      path: 'import-history',
      name: 'ImportHistory',
      component: ImportHistory,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'import-history/new',
      name: 'ImportHistoryCreate',
      component: ImportHistoryUpdate,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'import-history/:importHistoryId/edit',
      name: 'ImportHistoryEdit',
      component: ImportHistoryUpdate,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'import-history/:importHistoryId/view',
      name: 'ImportHistoryView',
      component: ImportHistoryDetails,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'import-history-detail',
      name: 'ImportHistoryDetail',
      component: ImportHistoryDetail,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'import-history-detail/new',
      name: 'ImportHistoryDetailCreate',
      component: ImportHistoryDetailUpdate,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'import-history-detail/:importHistoryDetailId/edit',
      name: 'ImportHistoryDetailEdit',
      component: ImportHistoryDetailUpdate,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'import-history-detail/:importHistoryDetailId/view',
      name: 'ImportHistoryDetailView',
      component: ImportHistoryDetailDetails,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'import-table',
      name: 'ImportTable',
      component: ImportTable,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'import-table/new',
      name: 'ImportTableCreate',
      component: ImportTableUpdate,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'import-table/:importTableId/edit',
      name: 'ImportTableEdit',
      component: ImportTableUpdate,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'import-table/:importTableId/view',
      name: 'ImportTableView',
      component: ImportTableDetails,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'ss-import',
      name: 'SSImport',
      component: SSImport,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'ss-import/new',
      name: 'SSImportCreate',
      component: SSImportUpdate,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'ss-import/:sSImportId/edit',
      name: 'SSImportEdit',
      component: SSImportUpdate,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'ss-import/:sSImportId/view',
      name: 'SSImportView',
      component: SSImportDetails,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'import-setting',
      name: 'ImportSetting',
      component: ImportSetting,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'import-setting/new',
      name: 'ImportSettingCreate',
      component: ImportSettingUpdate,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'import-setting/:importSettingId/edit',
      name: 'ImportSettingEdit',
      component: ImportSettingUpdate,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'import-setting/:importSettingId/view',
      name: 'ImportSettingView',
      component: ImportSettingDetails,
      meta: { authorities: [Authority.USER] },
    },
    // jhipster-needle-add-entity-to-router - JHipster will add entities to the router here
  ],
};
