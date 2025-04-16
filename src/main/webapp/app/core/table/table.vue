<template>
  <div class="table-responsive">
    <table class="table table-striped">
      <thead>
        <tr>
          <th v-for="column in columns" :key="column.field" @click="sort(column.field)" class="hand">
            {{ column.label }}
            <span v-if="currentSort.field === column.field">
              <i class="fa" :class="sortIconClass"></i>
            </span>
          </th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="(item, index) in sortedItems" :key="index">
          <td v-for="column in columns" :key="column.field">
            {{ item[column.field] }}
          </td>
        </tr>
      </tbody>
    </table>
  </div>
</template>

<script lang="ts">
import { defineComponent } from 'vue';

export default defineComponent({
  name: 'TableComponent',
  props: {
    // 表格列配置
    columns: {
      type: Array,
      required: true,
      default: () => [],
    },
    // 表格数据
    items: {
      type: Array,
      required: true,
      default: () => [],
    },
  },
  data() {
    return {
      currentSort: {
        field: '',
        isAsc: true,
      },
    };
  },
  computed: {
    sortedItems() {
      if (!this.currentSort.field) {
        return this.items;
      }

      return [...this.items].sort((a, b) => {
        const aValue = a[this.currentSort.field];
        const bValue = b[this.currentSort.field];

        if (this.currentSort.isAsc) {
          return aValue > bValue ? 1 : -1;
        } else {
          return aValue < bValue ? 1 : -1;
        }
      });
    },
    sortIconClass() {
      return {
        'fa-sort-up': this.currentSort.isAsc,
        'fa-sort-down': !this.currentSort.isAsc,
      };
    },
  },
  methods: {
    sort(field: string) {
      if (this.currentSort.field === field) {
        this.currentSort.isAsc = !this.currentSort.isAsc;
      } else {
        this.currentSort.field = field;
        this.currentSort.isAsc = true;
      }
    },
  },
});
</script>

<style scoped>
.table-responsive {
  margin-bottom: 1rem;
}

.table {
  width: 100%;
  margin-bottom: 1rem;
  background-color: transparent;
}

.table th {
  padding: 0.75rem;
  vertical-align: top;
  border-top: 1px solid #dee2e6;
}

.table td {
  padding: 0.75rem;
  vertical-align: top;
  border-top: 1px solid #dee2e6;
}

.table-striped tbody tr:nth-of-type(odd) {
  background-color: rgba(0, 0, 0, 0.05);
}

.hand {
  cursor: pointer;
}
</style>
