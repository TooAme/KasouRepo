<template>
  <div>
    <h2 id="page-heading" data-cy="ImportHistoryHeading">
      <span v-text="t$('importDbApp.importHistory.home.title')" id="import-history-heading"></span>
      <div class="d-flex justify-content-end">
        <button class="btn btn-info mr-2" @click="handleSyncList" :disabled="isFetching">
          <font-awesome-icon icon="sync" :spin="isFetching"></font-awesome-icon>
          <span v-text="t$('importDbApp.importHistory.home.refreshListLabel')"></span>
        </button>
        <router-link :to="{ name: 'ImportHistoryCreate' }" custom v-slot="{ navigate }">
          <button
            @click="navigate"
            id="jh-create-entity"
            data-cy="entityCreateButton"
            class="btn btn-primary jh-create-entity create-import-history"
          >
            <font-awesome-icon icon="plus"></font-awesome-icon>
            <span v-text="t$('importDbApp.importHistory.home.createLabel')"></span>
          </button>
        </router-link>
      </div>
    </h2>
    <br />
    <div class="alert alert-warning" v-if="!isFetching && importHistories && importHistories.length === 0">
      <span v-text="t$('importDbApp.importHistory.home.notFound')"></span>
    </div>
    <div class="table-responsive" v-if="importHistories && importHistories.length > 0">
      <table class="table table-striped" aria-describedby="importHistories">
        <thead>
          <tr>
            <th scope="row" @click="changeOrder('id')">
              <span v-text="t$('global.field.id')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'id'"></jhi-sort-indicator>
            </th>
            <th scope="row" @click="changeOrder('uuid')">
              <span v-text="t$('importDbApp.importHistory.uuid')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'uuid'"></jhi-sort-indicator>
            </th>
            <th scope="row" @click="changeOrder('tcihCode')">
              <span v-text="t$('importDbApp.importHistory.tcihCode')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'tcihCode'"></jhi-sort-indicator>
            </th>
            <th scope="row" @click="changeOrder('tcihFilename')">
              <span v-text="t$('importDbApp.importHistory.tcihFilename')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'tcihFilename'"></jhi-sort-indicator>
            </th>
            <th scope="row" @click="changeOrder('tcihImporttime')">
              <span v-text="t$('importDbApp.importHistory.tcihImporttime')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'tcihImporttime'"></jhi-sort-indicator>
            </th>
            <th scope="row" @click="changeOrder('tcihStatus')">
              <span v-text="t$('importDbApp.importHistory.tcihStatus')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'tcihStatus'"></jhi-sort-indicator>
            </th>
            <th scope="row" @click="changeOrder('createBy')">
              <span v-text="t$('importDbApp.importHistory.createBy')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'createBy'"></jhi-sort-indicator>
            </th>
            <th scope="row" @click="changeOrder('createTime')">
              <span v-text="t$('importDbApp.importHistory.createTime')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'createTime'"></jhi-sort-indicator>
            </th>
            <th scope="row" @click="changeOrder('updateBy')">
              <span v-text="t$('importDbApp.importHistory.updateBy')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'updateBy'"></jhi-sort-indicator>
            </th>
            <th scope="row" @click="changeOrder('updateTime')">
              <span v-text="t$('importDbApp.importHistory.updateTime')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'updateTime'"></jhi-sort-indicator>
            </th>
            <th scope="row" @click="changeOrder('delFlag')">
              <span v-text="t$('importDbApp.importHistory.delFlag')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'delFlag'"></jhi-sort-indicator>
            </th>
            <th scope="row" @click="changeOrder('remark')">
              <span v-text="t$('importDbApp.importHistory.remark')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'remark'"></jhi-sort-indicator>
            </th>
            <th scope="row"></th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="importHistory in importHistories" :key="importHistory.id" data-cy="entityTable">
            <td>
              <router-link :to="{ name: 'ImportHistoryView', params: { importHistoryId: importHistory.id } }">{{
                importHistory.id
              }}</router-link>
            </td>
            <td>{{ importHistory.uuid }}</td>
            <td>{{ importHistory.tcihCode }}</td>
            <td>{{ importHistory.tcihFilename }}</td>
            <td>{{ formatDateShort(importHistory.tcihImporttime) || '' }}</td>
            <td>{{ importHistory.tcihStatus }}</td>
            <td>{{ importHistory.createBy }}</td>
            <td>{{ formatDateShort(importHistory.createTime) || '' }}</td>
            <td>{{ importHistory.updateBy }}</td>
            <td>{{ formatDateShort(importHistory.updateTime) || '' }}</td>
            <td>{{ importHistory.delFlag }}</td>
            <td>{{ importHistory.remark }}</td>
            <td class="text-right">
              <div class="btn-group">
                <router-link
                  :to="{ name: 'ImportHistoryView', params: { importHistoryId: importHistory.id } }"
                  class="btn btn-info btn-sm details"
                  data-cy="entityDetailsButton"
                >
                  <font-awesome-icon icon="eye"></font-awesome-icon>
                  <span class="d-none d-md-inline" v-text="t$('entity.action.view')"></span>
                </router-link>
                <router-link
                  :to="{ name: 'ImportHistoryEdit', params: { importHistoryId: importHistory.id } }"
                  class="btn btn-primary btn-sm edit"
                  data-cy="entityEditButton"
                >
                  <font-awesome-icon icon="pencil-alt"></font-awesome-icon>
                  <span class="d-none d-md-inline" v-text="t$('entity.action.edit')"></span>
                </router-link>
                <b-button
                  @click="prepareRemove(importHistory)"
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
      </table>
    </div>
    <b-modal ref="removeEntity" id="removeEntity">
      <template #modal-title>
        <span
          id="importDbApp.importHistory.delete.question"
          data-cy="importHistoryDeleteDialogHeading"
          v-text="t$('entity.delete.title')"
        ></span>
      </template>
      <div class="modal-body">
        <p id="jhi-delete-importHistory-heading" v-text="t$('importDbApp.importHistory.delete.question', { id: removeId })"></p>
      </div>
      <template #modal-footer>
        <div>
          <button type="button" class="btn btn-secondary" v-text="t$('entity.action.cancel')" @click="closeDialog()"></button>
          <button
            type="button"
            class="btn btn-primary"
            id="jhi-confirm-delete-importHistory"
            data-cy="entityConfirmDeleteButton"
            v-text="t$('entity.action.delete')"
            @click="removeImportHistory()"
          ></button>
        </div>
      </template>
    </b-modal>
    <div v-show="importHistories && importHistories.length > 0">
      <div class="row justify-content-center">
        <jhi-item-count :page="page" :total="queryCount" :itemsPerPage="itemsPerPage"></jhi-item-count>
      </div>
      <div class="row justify-content-center">
        <b-pagination size="md" :total-rows="totalItems" v-model="page" :per-page="itemsPerPage"></b-pagination>
      </div>
    </div>
  </div>
</template>

<script lang="ts" src="./import-history.component.ts"></script>
