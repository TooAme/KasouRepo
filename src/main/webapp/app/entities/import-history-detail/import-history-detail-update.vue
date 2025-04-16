<template>
  <div class="row justify-content-center">
    <div class="col-8">
      <form name="editForm" novalidate @submit.prevent="save()">
        <h2
          id="importDbApp.importHistoryDetail.home.createOrEditLabel"
          data-cy="ImportHistoryDetailCreateUpdateHeading"
          v-text="t$('importDbApp.importHistoryDetail.home.createOrEditLabel')"
        ></h2>
        <div>
          <div class="form-group" v-if="importHistoryDetail.id">
            <label for="id" v-text="t$('global.field.id')"></label>
            <input type="text" class="form-control" id="id" name="id" v-model="importHistoryDetail.id" readonly />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('importDbApp.importHistoryDetail.uuid')" for="import-history-detail-uuid"></label>
            <input
              type="text"
              class="form-control"
              name="uuid"
              id="import-history-detail-uuid"
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
            <label
              class="form-control-label"
              v-text="t$('importDbApp.importHistoryDetail.tcihdPid')"
              for="import-history-detail-tcihdPid"
            ></label>
            <input
              type="text"
              class="form-control"
              name="tcihdPid"
              id="import-history-detail-tcihdPid"
              data-cy="tcihdPid"
              :class="{ valid: !v$.tcihdPid.$invalid, invalid: v$.tcihdPid.$invalid }"
              v-model="v$.tcihdPid.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('importDbApp.importHistoryDetail.tcihdLine')"
              for="import-history-detail-tcihdLine"
            ></label>
            <input
              type="text"
              class="form-control"
              name="tcihdLine"
              id="import-history-detail-tcihdLine"
              data-cy="tcihdLine"
              :class="{ valid: !v$.tcihdLine.$invalid, invalid: v$.tcihdLine.$invalid }"
              v-model="v$.tcihdLine.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('importDbApp.importHistoryDetail.tcihdError')"
              for="import-history-detail-tcihdError"
            ></label>
            <input
              type="text"
              class="form-control"
              name="tcihdError"
              id="import-history-detail-tcihdError"
              data-cy="tcihdError"
              :class="{ valid: !v$.tcihdError.$invalid, invalid: v$.tcihdError.$invalid }"
              v-model="v$.tcihdError.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('importDbApp.importHistoryDetail.createBy')"
              for="import-history-detail-createBy"
            ></label>
            <input
              type="text"
              class="form-control"
              name="createBy"
              id="import-history-detail-createBy"
              data-cy="createBy"
              :class="{ valid: !v$.createBy.$invalid, invalid: v$.createBy.$invalid }"
              v-model="v$.createBy.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('importDbApp.importHistoryDetail.createTime')"
              for="import-history-detail-createTime"
            ></label>
            <div class="d-flex">
              <input
                id="import-history-detail-createTime"
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
            <label
              class="form-control-label"
              v-text="t$('importDbApp.importHistoryDetail.updateBy')"
              for="import-history-detail-updateBy"
            ></label>
            <input
              type="text"
              class="form-control"
              name="updateBy"
              id="import-history-detail-updateBy"
              data-cy="updateBy"
              :class="{ valid: !v$.updateBy.$invalid, invalid: v$.updateBy.$invalid }"
              v-model="v$.updateBy.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('importDbApp.importHistoryDetail.updateTime')"
              for="import-history-detail-updateTime"
            ></label>
            <div class="d-flex">
              <input
                id="import-history-detail-updateTime"
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
            <label
              class="form-control-label"
              v-text="t$('importDbApp.importHistoryDetail.delFlag')"
              for="import-history-detail-delFlag"
            ></label>
            <input
              type="checkbox"
              class="form-check"
              name="delFlag"
              id="import-history-detail-delFlag"
              data-cy="delFlag"
              :class="{ valid: !v$.delFlag.$invalid, invalid: v$.delFlag.$invalid }"
              v-model="v$.delFlag.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('importDbApp.importHistoryDetail.remark')"
              for="import-history-detail-remark"
            ></label>
            <input
              type="text"
              class="form-control"
              name="remark"
              id="import-history-detail-remark"
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
<script lang="ts" src="./import-history-detail-update.component.ts"></script>
