<template>
  <div class="row justify-content-center">
    <div class="col-8">
      <form name="editForm" novalidate @submit.prevent="save()">
        <h2
          id="importDbApp.sSImport.home.createOrEditLabel"
          data-cy="SSImportCreateUpdateHeading"
          v-text="t$('importDbApp.sSImport.home.createOrEditLabel')"
        ></h2>
        <div>
          <div class="form-group" v-if="sSImport.id">
            <label for="id" v-text="t$('global.field.id')"></label>
            <input type="text" class="form-control" id="id" name="id" v-model="sSImport.id" readonly />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('importDbApp.sSImport.uuid')" for="ss-import-uuid"></label>
            <input
              type="text"
              class="form-control"
              name="uuid"
              id="ss-import-uuid"
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
            <label class="form-control-label" v-text="t$('importDbApp.sSImport.ssCreateBy')" for="ss-import-ssCreateBy"></label>
            <input
              type="text"
              class="form-control"
              name="ssCreateBy"
              id="ss-import-ssCreateBy"
              data-cy="ssCreateBy"
              :class="{ valid: !v$.ssCreateBy.$invalid, invalid: v$.ssCreateBy.$invalid }"
              v-model="v$.ssCreateBy.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('importDbApp.sSImport.ssFilename')" for="ss-import-ssFilename"></label>
            <input
              type="text"
              class="form-control"
              name="ssFilename"
              id="ss-import-ssFilename"
              data-cy="ssFilename"
              :class="{ valid: !v$.ssFilename.$invalid, invalid: v$.ssFilename.$invalid }"
              v-model="v$.ssFilename.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('importDbApp.sSImport.ssBCode')" for="ss-import-ssBCode"></label>
            <input
              type="text"
              class="form-control"
              name="ssBCode"
              id="ss-import-ssBCode"
              data-cy="ssBCode"
              :class="{ valid: !v$.ssBCode.$invalid, invalid: v$.ssBCode.$invalid }"
              v-model="v$.ssBCode.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('importDbApp.sSImport.ssSubBCode')" for="ss-import-ssSubBCode"></label>
            <input
              type="text"
              class="form-control"
              name="ssSubBCode"
              id="ss-import-ssSubBCode"
              data-cy="ssSubBCode"
              :class="{ valid: !v$.ssSubBCode.$invalid, invalid: v$.ssSubBCode.$invalid }"
              v-model="v$.ssSubBCode.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('importDbApp.sSImport.createBy')" for="ss-import-createBy"></label>
            <input
              type="text"
              class="form-control"
              name="createBy"
              id="ss-import-createBy"
              data-cy="createBy"
              :class="{ valid: !v$.createBy.$invalid, invalid: v$.createBy.$invalid }"
              v-model="v$.createBy.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('importDbApp.sSImport.createTime')" for="ss-import-createTime"></label>
            <div class="d-flex">
              <input
                id="ss-import-createTime"
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
            <label class="form-control-label" v-text="t$('importDbApp.sSImport.updateBy')" for="ss-import-updateBy"></label>
            <input
              type="text"
              class="form-control"
              name="updateBy"
              id="ss-import-updateBy"
              data-cy="updateBy"
              :class="{ valid: !v$.updateBy.$invalid, invalid: v$.updateBy.$invalid }"
              v-model="v$.updateBy.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('importDbApp.sSImport.updateTime')" for="ss-import-updateTime"></label>
            <div class="d-flex">
              <input
                id="ss-import-updateTime"
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
          <div class="form-group">
            <label class="form-control-label" v-text="t$('importDbApp.sSImport.delFlag')" for="ss-import-delFlag"></label>
            <input
              type="checkbox"
              class="form-check"
              name="delFlag"
              id="ss-import-delFlag"
              data-cy="delFlag"
              :class="{ valid: !v$.delFlag.$invalid, invalid: v$.delFlag.$invalid }"
              v-model="v$.delFlag.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('importDbApp.sSImport.remark')" for="ss-import-remark"></label>
            <input
              type="text"
              class="form-control"
              name="remark"
              id="ss-import-remark"
              data-cy="remark"
              :class="{ valid: !v$.remark.$invalid, invalid: v$.remark.$invalid }"
              v-model="v$.remark.$model"
            />
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
<script lang="ts" src="./ss-import-update.component.ts"></script>
