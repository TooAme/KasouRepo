<template>
  <div class="row justify-content-center">
    <div class="col-8">
      <div v-if="importHistory">
        <h2 class="jh-entity-heading" data-cy="importHistoryDetailsHeading">
          <span v-text="t$('importDbApp.importHistory.detail.title')"></span> {{ importHistory.id }}
        </h2>
        <dl class="row jh-entity-details">
          <dt>
            <span v-text="t$('importDbApp.importHistory.uuid')"></span>
          </dt>
          <dd>
            <span>{{ importHistory.uuid }}</span>
          </dd>
          <dt>
            <span v-text="t$('importDbApp.importHistory.tcihCode')"></span>
          </dt>
          <dd>
            <span>{{ importHistory.tcihCode }}</span>
          </dd>
          <dt>
            <span v-text="t$('importDbApp.importHistory.tcihFilename')"></span>
          </dt>
          <dd>
            <span>{{ importHistory.tcihFilename }}</span>
          </dd>
          <dt>
            <span v-text="t$('importDbApp.importHistory.tcihImporttime')"></span>
          </dt>
          <dd>
            <span v-if="importHistory.tcihImporttime">{{ formatDateLong(importHistory.tcihImporttime) }}</span>
          </dd>
          <dt>
            <span v-text="t$('importDbApp.importHistory.tcihStatus')"></span>
          </dt>
          <dd>
            <span>{{ importHistory.tcihStatus }}</span>
          </dd>
          <dt>
            <span v-text="t$('importDbApp.importHistory.createBy')"></span>
          </dt>
          <dd>
            <span>{{ importHistory.createBy }}</span>
          </dd>
          <dt>
            <span v-text="t$('importDbApp.importHistory.createTime')"></span>
          </dt>
          <dd>
            <span v-if="importHistory.createTime">{{ formatDateLong(importHistory.createTime) }}</span>
          </dd>
          <dt>
            <span v-text="t$('importDbApp.importHistory.updateBy')"></span>
          </dt>
          <dd>
            <span>{{ importHistory.updateBy }}</span>
          </dd>
          <dt>
            <span v-text="t$('importDbApp.importHistory.updateTime')"></span>
          </dt>
          <dd>
            <span v-if="importHistory.updateTime">{{ formatDateLong(importHistory.updateTime) }}</span>
          </dd>
          <dt>
            <span v-text="t$('importDbApp.importHistory.delFlag')"></span>
          </dt>
          <dd>
            <span>{{ importHistory.delFlag }}</span>
          </dd>
          <dt>
            <span v-text="t$('importDbApp.importHistory.remark')"></span>
          </dt>
          <dd>
            <span>{{ importHistory.remark }}</span>
          </dd>
        </dl>
        <button type="submit" @click.prevent="previousState()" class="btn btn-info" data-cy="entityDetailsBackButton">
          <font-awesome-icon icon="arrow-left"></font-awesome-icon>&nbsp;<span v-text="t$('entity.action.back')"></span>
        </button>
        <router-link
          v-if="importHistory.id"
          :to="{ name: 'ImportHistoryEdit', params: { importHistoryId: importHistory.id } }"
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

<script lang="ts" src="./import-history-details.component.ts"></script>
