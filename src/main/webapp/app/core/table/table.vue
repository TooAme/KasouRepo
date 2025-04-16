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
        <tr v-for="(item, index) in paginatedItems" :key="index">
          <td v-for="column in columns" :key="column.field">
            {{ item[column.field] }}
          </td>
        </tr>
      </tbody>
    </table>

    <div class="pagination-container" v-if="totalPages > 1">
      <div class="pagination">
        <button class="page-button prev-button" @click="changePage(currentPage - 1)" :disabled="currentPage === 1" title="前のページ">
          <i class="fa fa-chevron-left"></i> Prev
        </button>

        <template v-if="totalPages <= maxVisibleButtons">
          <button
            v-for="page in totalPages"
            :key="page"
            class="page-button"
            :class="{ active: page === currentPage }"
            @click="changePage(page)"
          >
            {{ page }}
          </button>
        </template>

        <template v-else>
          <button
            v-for="page in visiblePageButtons"
            :key="page"
            class="page-button"
            :class="{ active: page === currentPage, ellipsis: page === '...' }"
            @click="page !== '...' && changePage(Number(page))"
            :disabled="page === '...'"
          >
            {{ page }}
          </button>
        </template>

        <button
          class="page-button next-button"
          @click="changePage(currentPage + 1)"
          :disabled="currentPage === totalPages"
          title="次のページ"
        >
          Next ><i class="fa fa-chevron-right"></i>
        </button>

        <div class="go-to-page">
          <span class="go-label">Go</span>
          <input type="text" class="page-input" v-model="goToPage" @keyup.enter="handleGoToPage" />
        </div>

        <button class="page-button select-button" @click="handleGoToPage">Select</button>
      </div>
    </div>
  </div>
</template>

<script lang="ts">
import { defineComponent } from 'vue';

interface Column {
  field: string;
  label: string;
}

interface TableItem {
  [key: string]: any;
}

export default defineComponent({
  name: 'TableComponent',
  props: {
    // 表格列配置
    columns: {
      type: Array as () => Column[],
      required: true,
      default: () => [],
    },
    // 表格数据
    items: {
      type: Array as () => TableItem[],
      required: true,
      default: () => [],
    },
    // 每页记录数
    pageSize: {
      type: Number,
      default: 10,
    },
    // 最大显示按钮数
    maxVisibleButtons: {
      type: Number,
      default: 5,
    },
  },
  data() {
    return {
      currentSort: {
        field: '',
        isAsc: true,
      },
      currentPage: 1,
      goToPage: '',
    };
  },
  computed: {
    sortedItems(): TableItem[] {
      if (!this.currentSort.field) {
        return this.items;
      }

      return [...this.items].sort((a: TableItem, b: TableItem) => {
        const aValue = a[this.currentSort.field];
        const bValue = b[this.currentSort.field];

        if (this.currentSort.isAsc) {
          return aValue > bValue ? 1 : -1;
        } else {
          return aValue < bValue ? 1 : -1;
        }
      });
    },
    totalPages(): number {
      return Math.max(1, Math.ceil(this.sortedItems.length / this.pageSize));
    },
    paginatedItems(): TableItem[] {
      const start = (this.currentPage - 1) * this.pageSize;
      const end = start + this.pageSize;
      return this.sortedItems.slice(start, end);
    },
    sortIconClass() {
      return {
        'fa-sort-up': this.currentSort.isAsc,
        'fa-sort-down': !this.currentSort.isAsc,
      };
    },
    visiblePageButtons(): (string | number)[] {
      const totalVisible = this.maxVisibleButtons;

      if (this.totalPages <= totalVisible) {
        return Array.from({ length: this.totalPages }, (_, i) => i + 1);
      }

      // 至少显示当前页、第一页、最后一页，和两个省略号按钮
      const buttons: (string | number)[] = [];

      // 总是显示第一页
      buttons.push(1);

      const leftSide = Math.floor(totalVisible / 2);
      const rightSide = totalVisible - leftSide - 1;

      // 计算左边界和右边界
      let start = Math.max(2, this.currentPage - leftSide);
      let end = Math.min(this.totalPages - 1, this.currentPage + rightSide);

      // 调整以适应边界情况
      if (start <= 2) {
        end = Math.min(this.totalPages - 1, totalVisible - 1);
      }

      if (end >= this.totalPages - 1) {
        start = Math.max(2, this.totalPages - totalVisible + 1);
      }

      // 添加左侧省略号
      if (start > 2) {
        buttons.push('...');
      }

      // 添加中间页码
      for (let i = start; i <= end; i++) {
        buttons.push(i);
      }

      // 添加右侧省略号
      if (end < this.totalPages - 1) {
        buttons.push('...');
      }

      // 总是显示最后一页
      if (this.totalPages > 1) {
        buttons.push(this.totalPages);
      }

      return buttons;
    },
  },
  watch: {
    // 当数据项改变时，重置到第一页
    items() {
      this.currentPage = 1;
      this.goToPage = '';
    },
    // 当排序改变时，重置到第一页
    'currentSort.field'() {
      this.currentPage = 1;
    },
    'currentSort.isAsc'() {
      this.currentPage = 1;
    },
    currentPage() {
      this.goToPage = '';
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
    changePage(page: number) {
      if (page >= 1 && page <= this.totalPages) {
        this.currentPage = page;
      }
    },
    handleGoToPage() {
      const page = parseInt(this.goToPage);
      if (!isNaN(page) && page >= 1 && page <= this.totalPages) {
        this.changePage(page);
      } else {
        this.goToPage = '';
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

.pagination-container {
  display: flex;
  justify-content: center;
  margin-top: 1rem;
}

.pagination {
  display: flex;
  align-items: center;
  gap: 5px;
}

.page-button {
  height: 36px;
  min-width: 36px;
  padding: 0 8px;
  border-radius: 2px;
  background: linear-gradient(to bottom, #f5f5f5 0%, #e6e6e6 100%);
  border: 1.5px solid #8d8d8d;
  box-shadow: 0 1px 2px rgba(0, 0, 0, 0.1);
  font-size: 14px;
  color: #000000;
  cursor: pointer;
  display: flex;
  align-items: center;
  justify-content: center;
}

.page-button:hover {
  background: linear-gradient(to bottom, #e9e9e9 0%, #d8d8d8 100%);
  border-color: #8d8d8d;
}

.page-button.active {
  background: #e0e0e0;
  border-color: #8d8d8d;
  box-shadow: inset 0 1px 3px rgba(0, 0, 0, 0.1);
  font-weight: bold;
}

.page-button:disabled {
  opacity: 0.5;
  cursor: not-allowed;
}

.page-button.ellipsis {
  background: transparent;
  border: none;
  box-shadow: none;
  cursor: default;
}

.prev-button,
.next-button {
  min-width: 70px;
  padding: 0 10px;
}

.prev-button i {
  margin-right: 4px;
}

.next-button i {
  margin-left: 4px;
}

.go-to-page {
  display: flex;
  align-items: center;
  margin-left: 8px;
}

.go-label {
  font-size: 14px;
  margin-right: 5px;
}

.page-input {
  width: 40px;
  height: 32px;
  border: 1px solid #ccc;
  border-radius: 2px;
  text-align: center;
  font-size: 14px;
}

.select-button {
  min-width: 70px;
}
</style>
