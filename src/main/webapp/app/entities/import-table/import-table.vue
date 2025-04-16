<template>
  <div>
    <h2 id="page-heading" data-cy="ImportTableHeading">
      <span v-text="t$('importDbApp.importTable.home.title')" id="import-table-heading"></span>
      <div class="d-flex justify-content-end">
        <button class="btn btn-info mr-2" @click="handleSyncList" :disabled="isFetching">
          <font-awesome-icon icon="sync" :spin="isFetching"></font-awesome-icon>
          <span v-text="t$('importDbApp.importTable.home.refreshListLabel')"></span>
        </button>
        <router-link :to="{ name: 'ImportTableCreate' }" custom v-slot="{ navigate }">
          <button
            @click="navigate"
            id="jh-create-entity"
            data-cy="entityCreateButton"
            class="btn btn-primary jh-create-entity create-import-table"
          >
            <font-awesome-icon icon="plus"></font-awesome-icon>
            <span v-text="t$('importDbApp.importTable.home.createLabel')"></span>
          </button>
        </router-link>
      </div>
    </h2>
    <br />
    <div class="alert alert-warning" v-if="!isFetching && importTables && importTables.length === 0">
      <span v-text="t$('importDbApp.importTable.home.notFound')"></span>
    </div>
    <div class="table-responsive" v-if="importTables && importTables.length > 0">
      <table class="table table-striped" aria-describedby="importTables">
        <thead>
          <tr>
            <th scope="row" @click="changeOrder('id')">
              <span v-text="t$('global.field.id')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'id'"></jhi-sort-indicator>
            </th>
            <th scope="row" @click="changeOrder('uuid')">
              <span v-text="t$('importDbApp.importTable.uuid')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'uuid'"></jhi-sort-indicator>
            </th>
            <th scope="row" @click="changeOrder('partNumber')">
              <span v-text="t$('importDbApp.importTable.partNumber')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'partNumber'"></jhi-sort-indicator>
            </th>
            <th scope="row" @click="changeOrder('partType')">
              <span v-text="t$('importDbApp.importTable.partType')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'partType'"></jhi-sort-indicator>
            </th>
            <th scope="row" @click="changeOrder('value')">
              <span v-text="t$('importDbApp.importTable.value')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'value'"></jhi-sort-indicator>
            </th>
            <th scope="row" @click="changeOrder('schematicPart')">
              <span v-text="t$('importDbApp.importTable.schematicPart')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'schematicPart'"></jhi-sort-indicator>
            </th>
            <th scope="row" @click="changeOrder('ratingVoltage')">
              <span v-text="t$('importDbApp.importTable.ratingVoltage')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'ratingVoltage'"></jhi-sort-indicator>
            </th>
            <th scope="row" @click="changeOrder('ratingElectricity')">
              <span v-text="t$('importDbApp.importTable.ratingElectricity')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'ratingElectricity'"></jhi-sort-indicator>
            </th>
            <th scope="row" @click="changeOrder('characteristics')">
              <span v-text="t$('importDbApp.importTable.characteristics')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'characteristics'"></jhi-sort-indicator>
            </th>
            <th scope="row" @click="changeOrder('tolerance')">
              <span v-text="t$('importDbApp.importTable.tolerance')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'tolerance'"></jhi-sort-indicator>
            </th>
            <th scope="row" @click="changeOrder('manufacture')">
              <span v-text="t$('importDbApp.importTable.manufacture')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'manufacture'"></jhi-sort-indicator>
            </th>
            <th scope="row" @click="changeOrder('bCode')">
              <span v-text="t$('importDbApp.importTable.bCode')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'bCode'"></jhi-sort-indicator>
            </th>
            <th scope="row" @click="changeOrder('partsName')">
              <span v-text="t$('importDbApp.importTable.partsName')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'partsName'"></jhi-sort-indicator>
            </th>
            <th scope="row" @click="changeOrder('itemRegistrationClassification')">
              <span v-text="t$('importDbApp.importTable.itemRegistrationClassification')"></span>
              <jhi-sort-indicator
                :current-order="propOrder"
                :reverse="reverse"
                :field-name="'itemRegistrationClassification'"
              ></jhi-sort-indicator>
            </th>
            <th scope="row" @click="changeOrder('spiceModel')">
              <span v-text="t$('importDbApp.importTable.spiceModel')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'spiceModel'"></jhi-sort-indicator>
            </th>
            <th scope="row" @click="changeOrder('pcbFootPrint')">
              <span v-text="t$('importDbApp.importTable.pcbFootPrint')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'pcbFootPrint'"></jhi-sort-indicator>
            </th>
            <th scope="row" @click="changeOrder('delFlag')">
              <span v-text="t$('importDbApp.importTable.delFlag')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'delFlag'"></jhi-sort-indicator>
            </th>
            <th scope="row" @click="changeOrder('remark')">
              <span v-text="t$('importDbApp.importTable.remark')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'remark'"></jhi-sort-indicator>
            </th>
            <th scope="row" @click="changeOrder('createBy')">
              <span v-text="t$('importDbApp.importTable.createBy')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'createBy'"></jhi-sort-indicator>
            </th>
            <th scope="row" @click="changeOrder('createTime')">
              <span v-text="t$('importDbApp.importTable.createTime')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'createTime'"></jhi-sort-indicator>
            </th>
            <th scope="row" @click="changeOrder('updateBy')">
              <span v-text="t$('importDbApp.importTable.updateBy')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'updateBy'"></jhi-sort-indicator>
            </th>
            <th scope="row" @click="changeOrder('updateTime')">
              <span v-text="t$('importDbApp.importTable.updateTime')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'updateTime'"></jhi-sort-indicator>
            </th>
            <th scope="row"></th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="importTable in importTables" :key="importTable.id" data-cy="entityTable">
            <td>
              <router-link :to="{ name: 'ImportTableView', params: { importTableId: importTable.id } }">{{ importTable.id }}</router-link>
            </td>
            <td>{{ importTable.uuid }}</td>
            <td>{{ importTable.partNumber }}</td>
            <td>{{ importTable.partType }}</td>
            <td>{{ importTable.value }}</td>
            <td>{{ importTable.schematicPart }}</td>
            <td>{{ importTable.ratingVoltage }}</td>
            <td>{{ importTable.ratingElectricity }}</td>
            <td>{{ importTable.characteristics }}</td>
            <td>{{ importTable.tolerance }}</td>
            <td>{{ importTable.manufacture }}</td>
            <td>{{ importTable.bCode }}</td>
            <td>{{ importTable.partsName }}</td>
            <td>{{ importTable.itemRegistrationClassification }}</td>
            <td>{{ importTable.spiceModel }}</td>
            <td>{{ importTable.pcbFootPrint }}</td>
            <td>{{ importTable.delFlag }}</td>
            <td>{{ importTable.remark }}</td>
            <td>{{ importTable.createBy }}</td>
            <td>{{ formatDateShort(importTable.createTime) || '' }}</td>
            <td>{{ importTable.updateBy }}</td>
            <td>{{ formatDateShort(importTable.updateTime) || '' }}</td>
            <td class="text-right">
              <div class="btn-group">
                <router-link
                  :to="{ name: 'ImportTableView', params: { importTableId: importTable.id } }"
                  class="btn btn-info btn-sm details"
                  data-cy="entityDetailsButton"
                >
                  <font-awesome-icon icon="eye"></font-awesome-icon>
                  <span class="d-none d-md-inline" v-text="t$('entity.action.view')"></span>
                </router-link>
                <router-link
                  :to="{ name: 'ImportTableEdit', params: { importTableId: importTable.id } }"
                  class="btn btn-primary btn-sm edit"
                  data-cy="entityEditButton"
                >
                  <font-awesome-icon icon="pencil-alt"></font-awesome-icon>
                  <span class="d-none d-md-inline" v-text="t$('entity.action.edit')"></span>
                </router-link>
                <b-button
                  @click="prepareRemove(importTable)"
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
          id="importDbApp.importTable.delete.question"
          data-cy="importTableDeleteDialogHeading"
          v-text="t$('entity.delete.title')"
        ></span>
      </template>
      <div class="modal-body">
        <p id="jhi-delete-importTable-heading" v-text="t$('importDbApp.importTable.delete.question', { id: removeId })"></p>
      </div>
      <template #modal-footer>
        <div>
          <button type="button" class="btn btn-secondary" v-text="t$('entity.action.cancel')" @click="closeDialog()"></button>
          <button
            type="button"
            class="btn btn-primary"
            id="jhi-confirm-delete-importTable"
            data-cy="entityConfirmDeleteButton"
            v-text="t$('entity.action.delete')"
            @click="removeImportTable()"
          ></button>
        </div>
      </template>
    </b-modal>
    <div v-show="importTables && importTables.length > 0">
      <div class="row justify-content-center">
        <jhi-item-count :page="page" :total="queryCount" :itemsPerPage="itemsPerPage"></jhi-item-count>
      </div>
      <div class="row justify-content-center">
        <b-pagination size="md" :total-rows="totalItems" v-model="page" :per-page="itemsPerPage"></b-pagination>
      </div>
    </div>
  </div>
</template>

<script lang="ts" src="./import-table.component.ts"></script>
