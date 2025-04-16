<template>
  <div class="row justify-content-center">
    <div class="col-8">
      <div v-if="sSImport">
        <h2 class="jh-entity-heading" data-cy="sSImportDetailsHeading">
          <span v-text="t$('importDbApp.sSImport.detail.title')"></span> {{ sSImport.id }}
        </h2>
        <dl class="row jh-entity-details">
          <dt>
            <span v-text="t$('importDbApp.sSImport.uuid')"></span>
          </dt>
          <dd>
            <span>{{ sSImport.uuid }}</span>
          </dd>
          <dt>
            <span v-text="t$('importDbApp.sSImport.ssCreateBy')"></span>
          </dt>
          <dd>
            <span>{{ sSImport.ssCreateBy }}</span>
          </dd>
          <dt>
            <span v-text="t$('importDbApp.sSImport.ssFilename')"></span>
          </dt>
          <dd>
            <span>{{ sSImport.ssFilename }}</span>
          </dd>
          <dt>
            <span v-text="t$('importDbApp.sSImport.ssBCode')"></span>
          </dt>
          <dd>
            <span>{{ sSImport.ssBCode }}</span>
          </dd>
          <dt>
            <span v-text="t$('importDbApp.sSImport.ssSubBCode')"></span>
          </dt>
          <dd>
            <span>{{ sSImport.ssSubBCode }}</span>
          </dd>
          <dt>
            <span v-text="t$('importDbApp.sSImport.createBy')"></span>
          </dt>
          <dd>
            <span>{{ sSImport.createBy }}</span>
          </dd>
          <dt>
            <span v-text="t$('importDbApp.sSImport.createTime')"></span>
          </dt>
          <dd>
            <span v-if="sSImport.createTime">{{ formatDateLong(sSImport.createTime) }}</span>
          </dd>
          <dt>
            <span v-text="t$('importDbApp.sSImport.updateBy')"></span>
          </dt>
          <dd>
            <span>{{ sSImport.updateBy }}</span>
          </dd>
          <dt>
            <span v-text="t$('importDbApp.sSImport.updateTime')"></span>
          </dt>
          <dd>
            <span v-if="sSImport.updateTime">{{ formatDateLong(sSImport.updateTime) }}</span>
          </dd>
          <dt>
            <span v-text="t$('importDbApp.sSImport.delFlag')"></span>
          </dt>
          <dd>
            <span>{{ sSImport.delFlag }}</span>
          </dd>
          <dt>
            <span v-text="t$('importDbApp.sSImport.remark')"></span>
          </dt>
          <dd>
            <span>{{ sSImport.remark }}</span>
          </dd>
        </dl>
        <button type="submit" @click.prevent="previousState()" class="btn btn-info" data-cy="entityDetailsBackButton">
          <font-awesome-icon icon="arrow-left"></font-awesome-icon>&nbsp;<span v-text="t$('entity.action.back')"></span>
        </button>
        <router-link v-if="sSImport.id" :to="{ name: 'SSImportEdit', params: { sSImportId: sSImport.id } }" custom v-slot="{ navigate }">
          <button @click="navigate" class="btn btn-primary">
            <font-awesome-icon icon="pencil-alt"></font-awesome-icon>&nbsp;<span v-text="t$('entity.action.edit')"></span>
          </button>
        </router-link>
      </div>
    </div>
  </div>
</template>

<script lang="ts" src="./ss-import-details.component.ts"></script>
