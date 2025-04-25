<template>
  <div class="row justify-content-center">
    <div class="col-8">
      <form name="editForm" novalidate @submit.prevent="save()">
        <h2
          id="importDbApp.importSetting.home.createOrEditLabel"
          data-cy="ImportSettingCreateUpdateHeading"
          v-text="t$('importDbApp.importSetting.home.createOrEditLabel')"
        ></h2>
        <div>
          <div class="form-group" v-if="importSetting.id">
            <label for="id" v-text="t$('global.field.id')"></label>
            <input type="text" class="form-control" id="id" name="id" v-model="importSetting.id" readonly />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('importDbApp.importSetting.tcisCode')" for="import-setting-tcisCode"></label>
            <input
              type="text"
              class="form-control"
              name="tcisCode"
              id="import-setting-tcisCode"
              data-cy="tcisCode"
              :class="{ valid: !v$.tcisCode.$invalid, invalid: v$.tcisCode.$invalid }"
              v-model="v$.tcisCode.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('importDbApp.importSetting.tcisType')" for="import-setting-tcisType"></label>
            <input
              type="text"
              class="form-control"
              name="tcisType"
              id="import-setting-tcisType"
              data-cy="tcisType"
              :class="{ valid: !v$.tcisType.$invalid, invalid: v$.tcisType.$invalid }"
              v-model="v$.tcisType.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('importDbApp.importSetting.tcisIncol')" for="import-setting-tcisIncol"></label>
            <input
              type="text"
              class="form-control"
              name="tcisIncol"
              id="import-setting-tcisIncol"
              data-cy="tcisIncol"
              :class="{ valid: !v$.tcisIncol.$invalid, invalid: v$.tcisIncol.$invalid }"
              v-model="v$.tcisIncol.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('importDbApp.importSetting.tcisEditrule')"
              for="import-setting-tcisEditrule"
            ></label>
            <input
              type="text"
              class="form-control"
              name="tcisEditrule"
              id="import-setting-tcisEditrule"
              data-cy="tcisEditrule"
              :class="{ valid: !v$.tcisEditrule.$invalid, invalid: v$.tcisEditrule.$invalid }"
              v-model="v$.tcisEditrule.$model"
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
<script lang="ts" src="./import-setting-update.component.ts"></script>
