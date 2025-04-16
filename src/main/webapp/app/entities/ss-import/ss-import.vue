<template>
  <div>
    <h2 id="page-heading" data-cy="SSImportHeading">
      <span v-text="t$('importDbApp.sSImport.home.title')" id="ss-import-heading"></span>
      <div class="d-flex justify-content-end">
        <button class="btn btn-info mr-2" @click="handleSyncList" :disabled="isFetching">
          <font-awesome-icon icon="sync" :spin="isFetching"></font-awesome-icon>
          <span v-text="t$('importDbApp.sSImport.home.refreshListLabel')"></span>
        </button>
        <router-link :to="{ name: 'SSImportCreate' }" custom v-slot="{ navigate }">
          <button
            @click="navigate"
            id="jh-create-entity"
            data-cy="entityCreateButton"
            class="btn btn-primary jh-create-entity create-ss-import"
          >
            <font-awesome-icon icon="plus"></font-awesome-icon>
            <span v-text="t$('importDbApp.sSImport.home.createLabel')"></span>
          </button>
        </router-link>
      </div>
    </h2>
    <br />
    <div class="alert alert-warning" v-if="!isFetching && sSImports && sSImports.length === 0">
      <span v-text="t$('importDbApp.sSImport.home.notFound')"></span>
    </div>
    <div class="table-responsive" v-if="sSImports && sSImports.length > 0">
      <table class="table table-striped" aria-describedby="sSImports">
        <thead>
          <tr>
            <th scope="row" @click="changeOrder('id')">
              <span v-text="t$('global.field.id')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'id'"></jhi-sort-indicator>
            </th>
            <th scope="row" @click="changeOrder('uuid')">
              <span v-text="t$('importDbApp.sSImport.uuid')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'uuid'"></jhi-sort-indicator>
            </th>
            <th scope="row" @click="changeOrder('ssCreateBy')">
              <span v-text="t$('importDbApp.sSImport.ssCreateBy')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'ssCreateBy'"></jhi-sort-indicator>
            </th>
            <th scope="row" @click="changeOrder('ssFilename')">
              <span v-text="t$('importDbApp.sSImport.ssFilename')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'ssFilename'"></jhi-sort-indicator>
            </th>
            <th scope="row" @click="changeOrder('ssBCode')">
              <span v-text="t$('importDbApp.sSImport.ssBCode')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'ssBCode'"></jhi-sort-indicator>
            </th>
            <th scope="row" @click="changeOrder('ssSubBCode')">
              <span v-text="t$('importDbApp.sSImport.ssSubBCode')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'ssSubBCode'"></jhi-sort-indicator>
            </th>
            <th scope="row" @click="changeOrder('createBy')">
              <span v-text="t$('importDbApp.sSImport.createBy')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'createBy'"></jhi-sort-indicator>
            </th>
            <th scope="row" @click="changeOrder('createTime')">
              <span v-text="t$('importDbApp.sSImport.createTime')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'createTime'"></jhi-sort-indicator>
            </th>
            <th scope="row" @click="changeOrder('updateBy')">
              <span v-text="t$('importDbApp.sSImport.updateBy')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'updateBy'"></jhi-sort-indicator>
            </th>
            <th scope="row" @click="changeOrder('updateTime')">
              <span v-text="t$('importDbApp.sSImport.updateTime')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'updateTime'"></jhi-sort-indicator>
            </th>
            <th scope="row" @click="changeOrder('delFlag')">
              <span v-text="t$('importDbApp.sSImport.delFlag')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'delFlag'"></jhi-sort-indicator>
            </th>
            <th scope="row" @click="changeOrder('remark')">
              <span v-text="t$('importDbApp.sSImport.remark')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'remark'"></jhi-sort-indicator>
            </th>
            <th scope="row"></th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="sSImport in sSImports" :key="sSImport.id" data-cy="entityTable">
            <td>
              <router-link :to="{ name: 'SSImportView', params: { sSImportId: sSImport.id } }">{{ sSImport.id }}</router-link>
            </td>
            <td>{{ sSImport.uuid }}</td>
            <td>{{ sSImport.ssCreateBy }}</td>
            <td>{{ sSImport.ssFilename }}</td>
            <td>{{ sSImport.ssBCode }}</td>
            <td>{{ sSImport.ssSubBCode }}</td>
            <td>{{ sSImport.createBy }}</td>
            <td>{{ formatDateShort(sSImport.createTime) || '' }}</td>
            <td>{{ sSImport.updateBy }}</td>
            <td>{{ formatDateShort(sSImport.updateTime) || '' }}</td>
            <td>{{ sSImport.delFlag }}</td>
            <td>{{ sSImport.remark }}</td>
            <td class="text-right">
              <div class="btn-group">
                <router-link
                  :to="{ name: 'SSImportView', params: { sSImportId: sSImport.id } }"
                  class="btn btn-info btn-sm details"
                  data-cy="entityDetailsButton"
                >
                  <font-awesome-icon icon="eye"></font-awesome-icon>
                  <span class="d-none d-md-inline" v-text="t$('entity.action.view')"></span>
                </router-link>
                <router-link
                  :to="{ name: 'SSImportEdit', params: { sSImportId: sSImport.id } }"
                  class="btn btn-primary btn-sm edit"
                  data-cy="entityEditButton"
                >
                  <font-awesome-icon icon="pencil-alt"></font-awesome-icon>
                  <span class="d-none d-md-inline" v-text="t$('entity.action.edit')"></span>
                </router-link>
                <b-button
                  @click="prepareRemove(sSImport)"
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
        <span id="importDbApp.sSImport.delete.question" data-cy="sSImportDeleteDialogHeading" v-text="t$('entity.delete.title')"></span>
      </template>
      <div class="modal-body">
        <p id="jhi-delete-sSImport-heading" v-text="t$('importDbApp.sSImport.delete.question', { id: removeId })"></p>
      </div>
      <template #modal-footer>
        <div>
          <button type="button" class="btn btn-secondary" v-text="t$('entity.action.cancel')" @click="closeDialog()"></button>
          <button
            type="button"
            class="btn btn-primary"
            id="jhi-confirm-delete-sSImport"
            data-cy="entityConfirmDeleteButton"
            v-text="t$('entity.action.delete')"
            @click="removeSSImport()"
          ></button>
        </div>
      </template>
    </b-modal>
    <div v-show="sSImports && sSImports.length > 0">
      <div class="row justify-content-center">
        <jhi-item-count :page="page" :total="queryCount" :itemsPerPage="itemsPerPage"></jhi-item-count>
      </div>
      <div class="row justify-content-center">
        <b-pagination size="md" :total-rows="totalItems" v-model="page" :per-page="itemsPerPage"></b-pagination>
      </div>
    </div>
  </div>
</template>

<script lang="ts" src="./ss-import.component.ts"></script>
