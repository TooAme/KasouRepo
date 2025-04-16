<template>
  <div>
    <h2 id="page-heading" data-cy="ImportHistoryDetailHeading">
      <span v-text="t$('importDbApp.importHistoryDetail.home.title')" id="import-history-detail-heading"></span>
      <div class="d-flex justify-content-end">
        <button class="btn btn-info mr-2" @click="handleSyncList" :disabled="isFetching">
          <font-awesome-icon icon="sync" :spin="isFetching"></font-awesome-icon>
          <span v-text="t$('importDbApp.importHistoryDetail.home.refreshListLabel')"></span>
        </button>
        <router-link :to="{ name: 'ImportHistoryDetailCreate' }" custom v-slot="{ navigate }">
          <button
            @click="navigate"
            id="jh-create-entity"
            data-cy="entityCreateButton"
            class="btn btn-primary jh-create-entity create-import-history-detail"
          >
            <font-awesome-icon icon="plus"></font-awesome-icon>
            <span v-text="t$('importDbApp.importHistoryDetail.home.createLabel')"></span>
          </button>
        </router-link>
      </div>
    </h2>
    <br />
    <div class="alert alert-warning" v-if="!isFetching && importHistoryDetails && importHistoryDetails.length === 0">
      <span v-text="t$('importDbApp.importHistoryDetail.home.notFound')"></span>
    </div>
    <div class="table-responsive" v-if="importHistoryDetails && importHistoryDetails.length > 0">
      <table class="table table-striped" aria-describedby="importHistoryDetails">
        <thead>
          <tr>
            <th scope="row" @click="changeOrder('id')">
              <span v-text="t$('global.field.id')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'id'"></jhi-sort-indicator>
            </th>
            <th scope="row" @click="changeOrder('uuid')">
              <span v-text="t$('importDbApp.importHistoryDetail.uuid')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'uuid'"></jhi-sort-indicator>
            </th>
            <th scope="row" @click="changeOrder('tcihdPid')">
              <span v-text="t$('importDbApp.importHistoryDetail.tcihdPid')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'tcihdPid'"></jhi-sort-indicator>
            </th>
            <th scope="row" @click="changeOrder('tcihdLine')">
              <span v-text="t$('importDbApp.importHistoryDetail.tcihdLine')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'tcihdLine'"></jhi-sort-indicator>
            </th>
            <th scope="row" @click="changeOrder('tcihdError')">
              <span v-text="t$('importDbApp.importHistoryDetail.tcihdError')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'tcihdError'"></jhi-sort-indicator>
            </th>
            <th scope="row" @click="changeOrder('createBy')">
              <span v-text="t$('importDbApp.importHistoryDetail.createBy')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'createBy'"></jhi-sort-indicator>
            </th>
            <th scope="row" @click="changeOrder('createTime')">
              <span v-text="t$('importDbApp.importHistoryDetail.createTime')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'createTime'"></jhi-sort-indicator>
            </th>
            <th scope="row" @click="changeOrder('updateBy')">
              <span v-text="t$('importDbApp.importHistoryDetail.updateBy')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'updateBy'"></jhi-sort-indicator>
            </th>
            <th scope="row" @click="changeOrder('updateTime')">
              <span v-text="t$('importDbApp.importHistoryDetail.updateTime')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'updateTime'"></jhi-sort-indicator>
            </th>
            <th scope="row" @click="changeOrder('delFlag')">
              <span v-text="t$('importDbApp.importHistoryDetail.delFlag')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'delFlag'"></jhi-sort-indicator>
            </th>
            <th scope="row" @click="changeOrder('remark')">
              <span v-text="t$('importDbApp.importHistoryDetail.remark')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'remark'"></jhi-sort-indicator>
            </th>
            <th scope="row"></th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="importHistoryDetail in importHistoryDetails" :key="importHistoryDetail.id" data-cy="entityTable">
            <td>
              <router-link :to="{ name: 'ImportHistoryDetailView', params: { importHistoryDetailId: importHistoryDetail.id } }">{{
                importHistoryDetail.id
              }}</router-link>
            </td>
            <td>{{ importHistoryDetail.uuid }}</td>
            <td>{{ importHistoryDetail.tcihdPid }}</td>
            <td>{{ importHistoryDetail.tcihdLine }}</td>
            <td>{{ importHistoryDetail.tcihdError }}</td>
            <td>{{ importHistoryDetail.createBy }}</td>
            <td>{{ formatDateShort(importHistoryDetail.createTime) || '' }}</td>
            <td>{{ importHistoryDetail.updateBy }}</td>
            <td>{{ formatDateShort(importHistoryDetail.updateTime) || '' }}</td>
            <td>{{ importHistoryDetail.delFlag }}</td>
            <td>{{ importHistoryDetail.remark }}</td>
            <td class="text-right">
              <div class="btn-group">
                <router-link
                  :to="{ name: 'ImportHistoryDetailView', params: { importHistoryDetailId: importHistoryDetail.id } }"
                  class="btn btn-info btn-sm details"
                  data-cy="entityDetailsButton"
                >
                  <font-awesome-icon icon="eye"></font-awesome-icon>
                  <span class="d-none d-md-inline" v-text="t$('entity.action.view')"></span>
                </router-link>
                <router-link
                  :to="{ name: 'ImportHistoryDetailEdit', params: { importHistoryDetailId: importHistoryDetail.id } }"
                  class="btn btn-primary btn-sm edit"
                  data-cy="entityEditButton"
                >
                  <font-awesome-icon icon="pencil-alt"></font-awesome-icon>
                  <span class="d-none d-md-inline" v-text="t$('entity.action.edit')"></span>
                </router-link>
                <b-button
                  @click="prepareRemove(importHistoryDetail)"
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
          id="importDbApp.importHistoryDetail.delete.question"
          data-cy="importHistoryDetailDeleteDialogHeading"
          v-text="t$('entity.delete.title')"
        ></span>
      </template>
      <div class="modal-body">
        <p id="jhi-delete-importHistoryDetail-heading" v-text="t$('importDbApp.importHistoryDetail.delete.question', { id: removeId })"></p>
      </div>
      <template #modal-footer>
        <div>
          <button type="button" class="btn btn-secondary" v-text="t$('entity.action.cancel')" @click="closeDialog()"></button>
          <button
            type="button"
            class="btn btn-primary"
            id="jhi-confirm-delete-importHistoryDetail"
            data-cy="entityConfirmDeleteButton"
            v-text="t$('entity.action.delete')"
            @click="removeImportHistoryDetail()"
          ></button>
        </div>
      </template>
    </b-modal>
    <div v-show="importHistoryDetails && importHistoryDetails.length > 0">
      <div class="row justify-content-center">
        <jhi-item-count :page="page" :total="queryCount" :itemsPerPage="itemsPerPage"></jhi-item-count>
      </div>
      <div class="row justify-content-center">
        <b-pagination size="md" :total-rows="totalItems" v-model="page" :per-page="itemsPerPage"></b-pagination>
      </div>
    </div>
  </div>
</template>

<script lang="ts" src="./import-history-detail.component.ts"></script>
