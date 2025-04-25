<template>
  <div class="row justify-content-center">
    <div class="col-8">
      <div v-if="importSetting">
        <h2 class="jh-entity-heading" data-cy="importSettingDetailsHeading">
          <span v-text="t$('importDbApp.importSetting.detail.title')"></span> {{ importSetting.id }}
        </h2>
        <dl class="row jh-entity-details">
          <dt>
            <span v-text="t$('importDbApp.importSetting.tcisCode')"></span>
          </dt>
          <dd>
            <span>{{ importSetting.tcisCode }}</span>
          </dd>
          <dt>
            <span v-text="t$('importDbApp.importSetting.tcisType')"></span>
          </dt>
          <dd>
            <span>{{ importSetting.tcisType }}</span>
          </dd>
          <dt>
            <span v-text="t$('importDbApp.importSetting.tcisIncol')"></span>
          </dt>
          <dd>
            <span>{{ importSetting.tcisIncol }}</span>
          </dd>
          <dt>
            <span v-text="t$('importDbApp.importSetting.tcisEditrule')"></span>
          </dt>
          <dd>
            <span>{{ importSetting.tcisEditrule }}</span>
          </dd>
        </dl>
        <button type="submit" @click.prevent="previousState()" class="btn btn-info" data-cy="entityDetailsBackButton">
          <font-awesome-icon icon="arrow-left"></font-awesome-icon>&nbsp;<span v-text="t$('entity.action.back')"></span>
        </button>
        <router-link
          v-if="importSetting.id"
          :to="{ name: 'ImportSettingEdit', params: { importSettingId: importSetting.id } }"
          custom
          v-slot="{ navigate }"
        >
          <button @click="navigate" class="btn btn-primary">
            <font-awesome-icon icon="pencil-alt"></font-awesome-icon>&nbsp;<span v-text="t$('entity.action.edit')"></span>
          </button>
        </router-link>
      </div>
    </div>
  </div>
</template>

<script lang="ts" src="./import-setting-details.component.ts"></script>
