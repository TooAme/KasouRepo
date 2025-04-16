<template>
  <div class="row justify-content-center">
    <div class="col-8">
      <form name="editForm" novalidate @submit.prevent="save()">
        <h2
          id="importDbApp.importTable.home.createOrEditLabel"
          data-cy="ImportTableCreateUpdateHeading"
          v-text="t$('importDbApp.importTable.home.createOrEditLabel')"
        ></h2>
        <div>
          <div class="form-group" v-if="importTable.id">
            <label for="id" v-text="t$('global.field.id')"></label>
            <input type="text" class="form-control" id="id" name="id" v-model="importTable.id" readonly />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('importDbApp.importTable.uuid')" for="import-table-uuid"></label>
            <input
              type="text"
              class="form-control"
              name="uuid"
              id="import-table-uuid"
              data-cy="uuid"
              :class="{ valid: !v$.uuid.$invalid, invalid: v$.uuid.$invalid }"
              v-model="v$.uuid.$model"
              required
            />
            <div v-if="v$.uuid.$anyDirty && v$.uuid.$invalid">
              <small class="form-text text-danger" v-for="error of v$.uuid.$errors" :key="error.$uid">{{ error.$message }}</small>
            </div>
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('importDbApp.importTable.partNumber')" for="import-table-partNumber"></label>
            <input
              type="text"
              class="form-control"
              name="partNumber"
              id="import-table-partNumber"
              data-cy="partNumber"
              :class="{ valid: !v$.partNumber.$invalid, invalid: v$.partNumber.$invalid }"
              v-model="v$.partNumber.$model"
              required
            />
            <div v-if="v$.partNumber.$anyDirty && v$.partNumber.$invalid">
              <small class="form-text text-danger" v-for="error of v$.partNumber.$errors" :key="error.$uid">{{ error.$message }}</small>
            </div>
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('importDbApp.importTable.partType')" for="import-table-partType"></label>
            <input
              type="text"
              class="form-control"
              name="partType"
              id="import-table-partType"
              data-cy="partType"
              :class="{ valid: !v$.partType.$invalid, invalid: v$.partType.$invalid }"
              v-model="v$.partType.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('importDbApp.importTable.value')" for="import-table-value"></label>
            <input
              type="text"
              class="form-control"
              name="value"
              id="import-table-value"
              data-cy="value"
              :class="{ valid: !v$.value.$invalid, invalid: v$.value.$invalid }"
              v-model="v$.value.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('importDbApp.importTable.schematicPart')" for="import-table-schematicPart"></label>
            <input
              type="text"
              class="form-control"
              name="schematicPart"
              id="import-table-schematicPart"
              data-cy="schematicPart"
              :class="{ valid: !v$.schematicPart.$invalid, invalid: v$.schematicPart.$invalid }"
              v-model="v$.schematicPart.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('importDbApp.importTable.ratingVoltage')" for="import-table-ratingVoltage"></label>
            <input
              type="text"
              class="form-control"
              name="ratingVoltage"
              id="import-table-ratingVoltage"
              data-cy="ratingVoltage"
              :class="{ valid: !v$.ratingVoltage.$invalid, invalid: v$.ratingVoltage.$invalid }"
              v-model="v$.ratingVoltage.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('importDbApp.importTable.ratingElectricity')"
              for="import-table-ratingElectricity"
            ></label>
            <input
              type="text"
              class="form-control"
              name="ratingElectricity"
              id="import-table-ratingElectricity"
              data-cy="ratingElectricity"
              :class="{ valid: !v$.ratingElectricity.$invalid, invalid: v$.ratingElectricity.$invalid }"
              v-model="v$.ratingElectricity.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('importDbApp.importTable.characteristics')"
              for="import-table-characteristics"
            ></label>
            <input
              type="text"
              class="form-control"
              name="characteristics"
              id="import-table-characteristics"
              data-cy="characteristics"
              :class="{ valid: !v$.characteristics.$invalid, invalid: v$.characteristics.$invalid }"
              v-model="v$.characteristics.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('importDbApp.importTable.tolerance')" for="import-table-tolerance"></label>
            <input
              type="text"
              class="form-control"
              name="tolerance"
              id="import-table-tolerance"
              data-cy="tolerance"
              :class="{ valid: !v$.tolerance.$invalid, invalid: v$.tolerance.$invalid }"
              v-model="v$.tolerance.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('importDbApp.importTable.manufacture')" for="import-table-manufacture"></label>
            <input
              type="text"
              class="form-control"
              name="manufacture"
              id="import-table-manufacture"
              data-cy="manufacture"
              :class="{ valid: !v$.manufacture.$invalid, invalid: v$.manufacture.$invalid }"
              v-model="v$.manufacture.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('importDbApp.importTable.bCode')" for="import-table-bCode"></label>
            <input
              type="text"
              class="form-control"
              name="bCode"
              id="import-table-bCode"
              data-cy="bCode"
              :class="{ valid: !v$.bCode.$invalid, invalid: v$.bCode.$invalid }"
              v-model="v$.bCode.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('importDbApp.importTable.partsName')" for="import-table-partsName"></label>
            <input
              type="text"
              class="form-control"
              name="partsName"
              id="import-table-partsName"
              data-cy="partsName"
              :class="{ valid: !v$.partsName.$invalid, invalid: v$.partsName.$invalid }"
              v-model="v$.partsName.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('importDbApp.importTable.itemRegistrationClassification')"
              for="import-table-itemRegistrationClassification"
            ></label>
            <input
              type="number"
              class="form-control"
              name="itemRegistrationClassification"
              id="import-table-itemRegistrationClassification"
              data-cy="itemRegistrationClassification"
              :class="{ valid: !v$.itemRegistrationClassification.$invalid, invalid: v$.itemRegistrationClassification.$invalid }"
              v-model.number="v$.itemRegistrationClassification.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('importDbApp.importTable.spiceModel')" for="import-table-spiceModel"></label>
            <input
              type="text"
              class="form-control"
              name="spiceModel"
              id="import-table-spiceModel"
              data-cy="spiceModel"
              :class="{ valid: !v$.spiceModel.$invalid, invalid: v$.spiceModel.$invalid }"
              v-model="v$.spiceModel.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('importDbApp.importTable.pcbFootPrint')" for="import-table-pcbFootPrint"></label>
            <input
              type="text"
              class="form-control"
              name="pcbFootPrint"
              id="import-table-pcbFootPrint"
              data-cy="pcbFootPrint"
              :class="{ valid: !v$.pcbFootPrint.$invalid, invalid: v$.pcbFootPrint.$invalid }"
              v-model="v$.pcbFootPrint.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('importDbApp.importTable.delFlag')" for="import-table-delFlag"></label>
            <input
              type="checkbox"
              class="form-check"
              name="delFlag"
              id="import-table-delFlag"
              data-cy="delFlag"
              :class="{ valid: !v$.delFlag.$invalid, invalid: v$.delFlag.$invalid }"
              v-model="v$.delFlag.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('importDbApp.importTable.remark')" for="import-table-remark"></label>
            <input
              type="text"
              class="form-control"
              name="remark"
              id="import-table-remark"
              data-cy="remark"
              :class="{ valid: !v$.remark.$invalid, invalid: v$.remark.$invalid }"
              v-model="v$.remark.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('importDbApp.importTable.createBy')" for="import-table-createBy"></label>
            <input
              type="text"
              class="form-control"
              name="createBy"
              id="import-table-createBy"
              data-cy="createBy"
              :class="{ valid: !v$.createBy.$invalid, invalid: v$.createBy.$invalid }"
              v-model="v$.createBy.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('importDbApp.importTable.createTime')" for="import-table-createTime"></label>
            <div class="d-flex">
              <input
                id="import-table-createTime"
                data-cy="createTime"
                type="datetime-local"
                class="form-control"
                name="createTime"
                :class="{ valid: !v$.createTime.$invalid, invalid: v$.createTime.$invalid }"
                :value="convertDateTimeFromServer(v$.createTime.$model)"
                @change="updateInstantField('createTime', $event)"
              />
            </div>
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('importDbApp.importTable.updateBy')" for="import-table-updateBy"></label>
            <input
              type="text"
              class="form-control"
              name="updateBy"
              id="import-table-updateBy"
              data-cy="updateBy"
              :class="{ valid: !v$.updateBy.$invalid, invalid: v$.updateBy.$invalid }"
              v-model="v$.updateBy.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('importDbApp.importTable.updateTime')" for="import-table-updateTime"></label>
            <div class="d-flex">
              <input
                id="import-table-updateTime"
                data-cy="updateTime"
                type="datetime-local"
                class="form-control"
                name="updateTime"
                :class="{ valid: !v$.updateTime.$invalid, invalid: v$.updateTime.$invalid }"
                :value="convertDateTimeFromServer(v$.updateTime.$model)"
                @change="updateInstantField('updateTime', $event)"
              />
            </div>
          </div>
        </div>
        <div>
          <button type="button" id="cancel-save" data-cy="entityCreateCancelButton" class="btn btn-secondary" @click="previousState()">
            <font-awesome-icon icon="ban"></font-awesome-icon>&nbsp;<span v-text="t$('entity.action.cancel')"></span>
          </button>
          <button
            type="submit"
            id="save-entity"
            data-cy="entityCreateSaveButton"
            :disabled="v$.$invalid || isSaving"
            class="btn btn-primary"
          >
            <font-awesome-icon icon="save"></font-awesome-icon>&nbsp;<span v-text="t$('entity.action.save')"></span>
          </button>
        </div>
      </form>
    </div>
  </div>
</template>
<script lang="ts" src="./import-table-update.component.ts"></script>
