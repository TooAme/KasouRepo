<template>
  <div class="row justify-content-center">
    <div class="col-8">
      <div v-if="importHistoryDetail">
        <h2 class="jh-entity-heading" data-cy="importHistoryDetailDetailsHeading">
          <span v-text="t$('importDbApp.importHistoryDetail.detail.title')"></span> {{ importHistoryDetail.id }}
        </h2>
        <dl class="row jh-entity-details">
          <dt>
            <span v-text="t$('importDbApp.importHistoryDetail.uuid')"></span>
          </dt>
          <dd>
            <span>{{ importHistoryDetail.uuid }}</span>
          </dd>
          <dt>
            <span v-text="t$('importDbApp.importHistoryDetail.tcihdPid')"></span>
          </dt>
          <dd>
            <span>{{ importHistoryDetail.tcihdPid }}</span>
          </dd>
          <dt>
            <span v-text="t$('importDbApp.importHistoryDetail.tcihdLine')"></span>
          </dt>
          <dd>
            <span>{{ importHistoryDetail.tcihdLine }}</span>
          </dd>
          <dt>
            <span v-text="t$('importDbApp.importHistoryDetail.tcihdError')"></span>
          </dt>
          <dd>
            <span>{{ importHistoryDetail.tcihdError }}</span>
          </dd>
          <dt>
            <span v-text="t$('importDbApp.importHistoryDetail.createBy')"></span>
          </dt>
          <dd>
            <span>{{ importHistoryDetail.createBy }}</span>
          </dd>
          <dt>
            <span v-text="t$('importDbApp.importHistoryDetail.createTime')"></span>
          </dt>
          <dd>
            <span v-if="importHistoryDetail.createTime">{{ formatDateLong(importHistoryDetail.createTime) }}</span>
          </dd>
          <dt>
            <span v-text="t$('importDbApp.importHistoryDetail.updateBy')"></span>
          </dt>
          <dd>
            <span>{{ importHistoryDetail.updateBy }}</span>
          </dd>
          <dt>
            <span v-text="t$('importDbApp.importHistoryDetail.updateTime')"></span>
          </dt>
          <dd>
            <span v-if="importHistoryDetail.updateTime">{{ formatDateLong(importHistoryDetail.updateTime) }}</span>
          </dd>
          <dt>
            <span v-text="t$('importDbApp.importHistoryDetail.delFlag')"></span>
          </dt>
          <dd>
            <span>{{ importHistoryDetail.delFlag }}</span>
          </dd>
          <dt>
            <span v-text="t$('importDbApp.importHistoryDetail.remark')"></span>
          </dt>
          <dd>
            <span>{{ importHistoryDetail.remark }}</span>
          </dd>
        </dl>
        <button type="submit" @click.prevent="previousState()" class="btn btn-info" data-cy="entityDetailsBackButton">
          <font-awesome-icon icon="arrow-left"></font-awesome-icon>&nbsp;<span v-text="t$('entity.action.back')"></span>
        </button>
        <router-link
          v-if="importHistoryDetail.id"
          :to="{ name: 'ImportHistoryDetailEdit', params: { importHistoryDetailId: importHistoryDetail.id } }"
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

<script lang="ts" src="./import-history-detail-details.component.ts"></script>
