<template>
  <div>
    <b-dropdown-item to="/import-history">
      <font-awesome-icon icon="asterisk" />
      <span v-text="t$('global.menu.entities.importHistory')"></span>
    </b-dropdown-item>
    <b-dropdown-item to="/import-history-detail">
      <font-awesome-icon icon="asterisk" />
      <span v-text="t$('global.menu.entities.importHistoryDetail')"></span>
    </b-dropdown-item>
    <b-dropdown-item to="/import-table">
      <font-awesome-icon icon="asterisk" />
      <span v-text="t$('global.menu.entities.importTable')"></span>
    </b-dropdown-item>
    <b-dropdown-item to="/ss-import">
      <font-awesome-icon icon="asterisk" />
      <span v-text="t$('global.menu.entities.ssImport')"></span>
    </b-dropdown-item>
    <b-dropdown-item to="/import-setting">
      <font-awesome-icon icon="asterisk" />
      <span v-text="t$('global.menu.entities.importSetting')"></span>
    </b-dropdown-item>
    <!-- jhipster-needle-add-entity-to-menu - JHipster will add entities to the menu here -->
  </div>
</template>

<script lang="ts" src="./entities-menu.component.ts"></script>
