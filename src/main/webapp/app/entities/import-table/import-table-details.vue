<template>
  <div class="row justify-content-center">
    <div class="col-8">
      <div v-if="importTable">
        <h2 class="jh-entity-heading" data-cy="importTableDetailsHeading">
          <span v-text="t$('importDbApp.importTable.detail.title')"></span> {{ importTable.id }}
        </h2>
        <dl class="row jh-entity-details">
          <dt>
            <span v-text="t$('importDbApp.importTable.uuid')"></span>
          </dt>
          <dd>
            <span>{{ importTable.uuid }}</span>
          </dd>
          <dt>
            <span v-text="t$('importDbApp.importTable.partNumber')"></span>
          </dt>
          <dd>
            <span>{{ importTable.partNumber }}</span>
          </dd>
          <dt>
            <span v-text="t$('importDbApp.importTable.partType')"></span>
          </dt>
          <dd>
            <span>{{ importTable.partType }}</span>
          </dd>
          <dt>
            <span v-text="t$('importDbApp.importTable.value')"></span>
          </dt>
          <dd>
            <span>{{ importTable.value }}</span>
          </dd>
          <dt>
            <span v-text="t$('importDbApp.importTable.schematicPart')"></span>
          </dt>
          <dd>
            <span>{{ importTable.schematicPart }}</span>
          </dd>
          <dt>
            <span v-text="t$('importDbApp.importTable.ratingVoltage')"></span>
          </dt>
          <dd>
            <span>{{ importTable.ratingVoltage }}</span>
          </dd>
          <dt>
            <span v-text="t$('importDbApp.importTable.ratingElectricity')"></span>
          </dt>
          <dd>
            <span>{{ importTable.ratingElectricity }}</span>
          </dd>
          <dt>
            <span v-text="t$('importDbApp.importTable.characteristics')"></span>
          </dt>
          <dd>
            <span>{{ importTable.characteristics }}</span>
          </dd>
          <dt>
            <span v-text="t$('importDbApp.importTable.tolerance')"></span>
          </dt>
          <dd>
            <span>{{ importTable.tolerance }}</span>
          </dd>
          <dt>
            <span v-text="t$('importDbApp.importTable.manufacture')"></span>
          </dt>
          <dd>
            <span>{{ importTable.manufacture }}</span>
          </dd>
          <dt>
            <span v-text="t$('importDbApp.importTable.bCode')"></span>
          </dt>
          <dd>
            <span>{{ importTable.bCode }}</span>
          </dd>
          <dt>
            <span v-text="t$('importDbApp.importTable.partsName')"></span>
          </dt>
          <dd>
            <span>{{ importTable.partsName }}</span>
          </dd>
          <dt>
            <span v-text="t$('importDbApp.importTable.itemRegistrationClassification')"></span>
          </dt>
          <dd>
            <span>{{ importTable.itemRegistrationClassification }}</span>
          </dd>
          <dt>
            <span v-text="t$('importDbApp.importTable.spiceModel')"></span>
          </dt>
          <dd>
            <span>{{ importTable.spiceModel }}</span>
          </dd>
          <dt>
            <span v-text="t$('importDbApp.importTable.pcbFootPrint')"></span>
          </dt>
          <dd>
            <span>{{ importTable.pcbFootPrint }}</span>
          </dd>
          <dt>
            <span v-text="t$('importDbApp.importTable.delFlag')"></span>
          </dt>
          <dd>
            <span>{{ importTable.delFlag }}</span>
          </dd>
          <dt>
            <span v-text="t$('importDbApp.importTable.remark')"></span>
          </dt>
          <dd>
            <span>{{ importTable.remark }}</span>
          </dd>
          <dt>
            <span v-text="t$('importDbApp.importTable.createBy')"></span>
          </dt>
          <dd>
            <span>{{ importTable.createBy }}</span>
          </dd>
          <dt>
            <span v-text="t$('importDbApp.importTable.createTime')"></span>
          </dt>
          <dd>
            <span v-if="importTable.createTime">{{ formatDateLong(importTable.createTime) }}</span>
          </dd>
          <dt>
            <span v-text="t$('importDbApp.importTable.updateBy')"></span>
          </dt>
          <dd>
            <span>{{ importTable.updateBy }}</span>
          </dd>
          <dt>
            <span v-text="t$('importDbApp.importTable.updateTime')"></span>
          </dt>
          <dd>
            <span v-if="importTable.updateTime">{{ formatDateLong(importTable.updateTime) }}</span>
          </dd>
        </dl>
        <button type="submit" @click.prevent="previousState()" class="btn btn-info" data-cy="entityDetailsBackButton">
          <font-awesome-icon icon="arrow-left"></font-awesome-icon>&nbsp;<span v-text="t$('entity.action.back')"></span>
        </button>
        <router-link
          v-if="importTable.id"
          :to="{ name: 'ImportTableEdit', params: { importTableId: importTable.id } }"
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

<script lang="ts" src="./import-table-details.component.ts"></script>
