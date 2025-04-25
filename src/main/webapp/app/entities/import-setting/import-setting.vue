<template>
  <div>
    <h2 id="page-heading" data-cy="ImportSettingHeading">
      <span v-text="t$('importDbApp.importSetting.home.title')" id="import-setting-heading"></span>
      <div class="d-flex justify-content-end">
        <button class="btn btn-info mr-2" @click="handleSyncList" :disabled="isFetching">
          <font-awesome-icon icon="sync" :spin="isFetching"></font-awesome-icon>
          <span v-text="t$('importDbApp.importSetting.home.refreshListLabel')"></span>
        </button>
        <router-link :to="{ name: 'ImportSettingCreate' }" custom v-slot="{ navigate }">
          <button
            @click="navigate"
            id="jh-create-entity"
            data-cy="entityCreateButton"
            class="btn btn-primary jh-create-entity create-import-setting"
          >
            <font-awesome-icon icon="plus"></font-awesome-icon>
            <span v-text="t$('importDbApp.importSetting.home.createLabel')"></span>
          </button>
        </router-link>
      </div>
    </h2>
    <br />
    <div class="alert alert-warning" v-if="!isFetching && importSettings && importSettings.length === 0">
      <span v-text="t$('importDbApp.importSetting.home.notFound')"></span>
    </div>
    <div class="table-responsive" v-if="importSettings && importSettings.length > 0">
      <table class="table table-striped" aria-describedby="importSettings">
        <thead>
          <tr>
            <th scope="row" @click="changeOrder('id')">
              <span v-text="t$('global.field.id')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'id'"></jhi-sort-indicator>
            </th>
            <th scope="row" @click="changeOrder('tcisCode')">
              <span v-text="t$('importDbApp.importSetting.tcisCode')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'tcisCode'"></jhi-sort-indicator>
            </th>
            <th scope="row" @click="changeOrder('tcisType')">
              <span v-text="t$('importDbApp.importSetting.tcisType')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'tcisType'"></jhi-sort-indicator>
            </th>
            <th scope="row" @click="changeOrder('tcisIncol')">
              <span v-text="t$('importDbApp.importSetting.tcisIncol')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'tcisIncol'"></jhi-sort-indicator>
            </th>
            <th scope="row" @click="changeOrder('tcisEditrule')">
              <span v-text="t$('importDbApp.importSetting.tcisEditrule')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'tcisEditrule'"></jhi-sort-indicator>
            </th>
            <th scope="row"></th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="importSetting in importSettings" :key="importSetting.id" data-cy="entityTable">
            <td>
              <router-link :to="{ name: 'ImportSettingView', params: { importSettingId: importSetting.id } }">{{
                importSetting.id
              }}</router-link>
            </td>
            <td>{{ importSetting.tcisCode }}</td>
            <td>{{ importSetting.tcisType }}</td>
            <td>{{ importSetting.tcisIncol }}</td>
            <td>{{ importSetting.tcisEditrule }}</td>
            <td class="text-right">
              <div class="btn-group">
                <router-link
                  :to="{ name: 'ImportSettingView', params: { importSettingId: importSetting.id } }"
                  class="btn btn-info btn-sm details"
                  data-cy="entityDetailsButton"
                >
                  <font-awesome-icon icon="eye"></font-awesome-icon>
                  <span class="d-none d-md-inline" v-text="t$('entity.action.view')"></span>
                </router-link>
                <router-link
                  :to="{ name: 'ImportSettingEdit', params: { importSettingId: importSetting.id } }"
                  class="btn btn-primary btn-sm edit"
                  data-cy="entityEditButton"
                >
                  <font-awesome-icon icon="pencil-alt"></font-awesome-icon>
                  <span class="d-none d-md-inline" v-text="t$('entity.action.edit')"></span>
                </router-link>
                <b-button
                  @click="prepareRemove(importSetting)"
                  variant="danger"
                  class="btn btn-sm"
                  data-cy="entityDeleteButton"
                  v-b-modal.removeEntity
                >
                  <font-awesome-icon icon="times"></font-awesome-icon>
                  <span class="d-none d-md-inline" v-text="t$('entity.action.delete')"></span>
                </b-button>
              </div>
            </td>
          </tr>
        </tbody>
        <span ref="infiniteScrollEl"></span>
      </table>
    </div>
    <b-modal ref="removeEntity" id="removeEntity">
      <template #modal-title>
        <span
          id="importDbApp.importSetting.delete.question"
          data-cy="importSettingDeleteDialogHeading"
          v-text="t$('entity.delete.title')"
        ></span>
      </template>
      <div class="modal-body">
        <p id="jhi-delete-importSetting-heading" v-text="t$('importDbApp.importSetting.delete.question', { id: removeId })"></p>
      </div>
      <template #modal-footer>
        <div>
          <button type="button" class="btn btn-secondary" v-text="t$('entity.action.cancel')" @click="closeDialog()"></button>
          <button
            type="button"
            class="btn btn-primary"
            id="jhi-confirm-delete-importSetting"
            data-cy="entityConfirmDeleteButton"
            v-text="t$('entity.action.delete')"
            @click="removeImportSetting()"
          ></button>
        </div>
      </template>
    </b-modal>
  </div>
</template>

<script lang="ts" src="./import-setting.component.ts"></script>
