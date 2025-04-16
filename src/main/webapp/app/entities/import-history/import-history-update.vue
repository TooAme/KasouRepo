<template>
  <div class="row justify-content-center">
    <div class="col-8">
      <form name="editForm" novalidate @submit.prevent="save()">
        <h2
          id="importDbApp.importHistory.home.createOrEditLabel"
          data-cy="ImportHistoryCreateUpdateHeading"
          v-text="t$('importDbApp.importHistory.home.createOrEditLabel')"
        ></h2>
        <div>
          <div class="form-group" v-if="importHistory.id">
            <label for="id" v-text="t$('global.field.id')"></label>
            <input type="text" class="form-control" id="id" name="id" v-model="importHistory.id" readonly />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('importDbApp.importHistory.uuid')" for="import-history-uuid"></label>
            <input
              type="text"
              class="form-control"
              name="uuid"
              id="import-history-uuid"
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
            <label class="form-control-label" v-text="t$('importDbApp.importHistory.tcihCode')" for="import-history-tcihCode"></label>
            <input
              type="text"
              class="form-control"
              name="tcihCode"
              id="import-history-tcihCode"
              data-cy="tcihCode"
              :class="{ valid: !v$.tcihCode.$invalid, invalid: v$.tcihCode.$invalid }"
              v-model="v$.tcihCode.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('importDbApp.importHistory.tcihFilename')"
              for="import-history-tcihFilename"
            ></label>
            <input
              type="text"
              class="form-control"
              name="tcihFilename"
              id="import-history-tcihFilename"
              data-cy="tcihFilename"
              :class="{ valid: !v$.tcihFilename.$invalid, invalid: v$.tcihFilename.$invalid }"
              v-model="v$.tcihFilename.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('importDbApp.importHistory.tcihImporttime')"
              for="import-history-tcihImporttime"
            ></label>
            <div class="d-flex">
              <input
                id="import-history-tcihImporttime"
                data-cy="tcihImporttime"
                type="datetime-local"
                class="form-control"
                name="tcihImporttime"
                :class="{ valid: !v$.tcihImporttime.$invalid, invalid: v$.tcihImporttime.$invalid }"
                :value="convertDateTimeFromServer(v$.tcihImporttime.$model)"
                @change="updateInstantField('tcihImporttime', $event)"
              />
            </div>
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('importDbApp.importHistory.tcihStatus')" for="import-history-tcihStatus"></label>
            <input
              type="checkbox"
              class="form-check"
              name="tcihStatus"
              id="import-history-tcihStatus"
              data-cy="tcihStatus"
              :class="{ valid: !v$.tcihStatus.$invalid, invalid: v$.tcihStatus.$invalid }"
              v-model="v$.tcihStatus.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('importDbApp.importHistory.createBy')" for="import-history-createBy"></label>
            <input
              type="text"
              class="form-control"
              name="createBy"
              id="import-history-createBy"
              data-cy="createBy"
              :class="{ valid: !v$.createBy.$invalid, invalid: v$.createBy.$invalid }"
              v-model="v$.createBy.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('importDbApp.importHistory.createTime')" for="import-history-createTime"></label>
            <div class="d-flex">
              <input
                id="import-history-createTime"
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
            <label class="form-control-label" v-text="t$('importDbApp.importHistory.updateBy')" for="import-history-updateBy"></label>
            <input
              type="text"
              class="form-control"
              name="updateBy"
              id="import-history-updateBy"
              data-cy="updateBy"
              :class="{ valid: !v$.updateBy.$invalid, invalid: v$.updateBy.$invalid }"
              v-model="v$.updateBy.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('importDbApp.importHistory.updateTime')" for="import-history-updateTime"></label>
            <div class="d-flex">
              <input
                id="import-history-updateTime"
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
            <label class="form-control-label" v-text="t$('importDbApp.importHistory.delFlag')" for="import-history-delFlag"></label>
            <input
              type="checkbox"
              class="form-check"
              name="delFlag"
              id="import-history-delFlag"
              data-cy="delFlag"
              :class="{ valid: !v$.delFlag.$invalid, invalid: v$.delFlag.$invalid }"
              v-model="v$.delFlag.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('importDbApp.importHistory.remark')" for="import-history-remark"></label>
            <input
              type="text"
              class="form-control"
              name="remark"
              id="import-history-remark"
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
<script lang="ts" src="./import-history-update.component.ts"></script>
