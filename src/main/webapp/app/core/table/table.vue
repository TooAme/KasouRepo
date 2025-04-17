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
            <template v-if="column.field === 'operate'">
              <div v-if="item.status === 'Failure'" class="operate-buttons">
                <button class="detail-button" @click="showErrorDetail(item)">Detail</button>
              </div>
              <span v-else></span>
            </template>
            <template v-else>
              {{ item[column.field] }}
            </template>
          </td>
        </tr>
      </tbody>
    </table>

    <!-- 错误详情对话框 -->
    <div v-if="showDetailModal" class="modal-overlay" @click="closeDetailModal">
      <div class="modal-content" @click.stop>
        <div class="modal-header">
          <!-- <h3>Error Details</h3> -->
          <button class="close-btn" @click="closeDetailModal">&times;</button>
        </div>
        <div class="modal-body">
          <div v-if="currentErrorDetails" class="table-responsive">
            <table class="table table-striped">
              <thead>
                <tr>
                  <th>Line</th>
                  <th>Error Detail</th>
                </tr>
              </thead>
              <tbody>
                <tr v-for="(line, index) in errorLines" :key="index" :class="{ 'highlight-row': index === 0 }">
                  <td>{{ line }}</td>
                  <td>{{ errorMessages[index] }}</td>
                </tr>
              </tbody>
            </table>
          </div>
          <div v-else class="no-errors">No error details available</div>
        </div>
      </div>
    </div>

    <div class="pagination-container" v-if="totalPages > 1">
      <div class="pagination">
        <button class="page-button prev-button" @click="changePage(currentPage - 1)" :disabled="currentPage === 1" title="前のページ">
          <i class="fa fa-chevron-left"></i>〈 Prev&nbsp;&nbsp;&nbsp;&nbsp;
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
          &nbsp;&nbsp;&nbsp;&nbsp;Next 〉<i class="fa fa-chevron-right"></i>
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
import axios from 'axios';

interface Column {
  field: string;
  label: string;
}

interface TableItem {
  [key: string]: any;
}

interface ImportHistoryDetail {
  tcihdLine: string;
  tcihdError: string;
}

const apiClient = axios.create({
  baseURL: '/api',
  timeout: 10000,
  headers: {
    'Content-Type': 'application/json',
  },
});

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
      showDetailModal: false,
      currentErrorDetails: null as ImportHistoryDetail | null,
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
    errorLines(): string[] {
      return this.currentErrorDetails?.tcihdLine ? this.currentErrorDetails.tcihdLine.split(',') : [];
    },
    errorMessages(): string[] {
      return this.currentErrorDetails?.tcihdError ? this.currentErrorDetails.tcihdError.split(',') : [];
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
    async showErrorDetail(item: TableItem) {
      try {
        const response = await apiClient.get<ImportHistoryDetail[]>('/import-history-details/by-pid/' + item.uuid);
        if (response.data && response.data.length > 0) {
          this.currentErrorDetails = response.data[0];
          this.showDetailModal = true;
        } else {
          this.currentErrorDetails = null;
          this.showDetailModal = true;
        }
      } catch (error) {
        console.error('Failed to fetch error details:', error);
        this.$emit('error', '获取错误详情失败');
      }
    },
    closeDetailModal() {
      this.showDetailModal = false;
      this.currentErrorDetails = null;
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
  border-collapse: separate;
  border-spacing: 0;
  border: 2px solid #4a4a4a; /* 深灰色外边框 */
  border-radius: 1px;
}

.table th {
  padding: 0.75rem;
  vertical-align: middle;
  text-align: center;
  font-weight: 400;
  font-size: 20px;
  background-color: #888884; /* 深灰色表头 */
  color: black;
  border-right: 1px solid #6a6a6a; /* 淡灰色内分割线 */
  border-bottom: 2px solid #333;
  border-top: none;
}

.table th:last-child {
  border-right: none; /* 移除最后一列的右边框 */
}

.table td {
  font-size: 20px;
  padding: 0.2rem 0.7rem;
  vertical-align: middle;
  /* text-align: center; */
  background-color: #f5f5f5; /* 淡灰色单元格 */
  border-right: 1px solid #6a6a6a; /* 淡灰色内分割线 */
  border-bottom: 1px solid #6a6a6a; /* 淡灰色内分割线 */
}

.table td:last-child {
  border-right: none; /* 移除最后一列的右边框 */
}

.table tr:last-child td {
  border-bottom: none; /* 移除最后一行的底部边框 */
}

/* .table-striped tbody tr:nth-of-type(odd) td {
  background-color: #e9e9e9; /* 条纹效果的更淡灰色 
} */

.table-striped tbody tr:hover td {
  background-color: #e0e0e0;
  transition: background-color 0.15s ease-in-out;
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

.detail-button {
  /* padding: 4px 12px; */
  /* background-color: #007bff; */
  color: rgb(65, 43, 209);
  border: none;
  background-color: rgba(255, 255, 255, 0);
  /* border-radius: 3px; */
  cursor: pointer;
  text-decoration: underline;
  font-size: 20px;
}

/* .detail-button:hover {
  color: rgb(75, 32, 192);
  background-color: #5a6268;
} */

.modal-overlay {
  position: fixed;
  top: 0;
  left: 0;
  right: 0;
  bottom: 0;
  background-color: rgba(0, 0, 0, 0.5);
  display: flex;
  justify-content: center;
  align-items: center;
  z-index: 1000;
}

.modal-content {
  background-color: white;
  border-radius: 8px;
  width: 95%;
  max-width: 1200px;
  max-height: 90vh;
  box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
  position: relative;
}

.modal-header {
  padding: 6px 1px;
  border-bottom: 1px solid #eee;
  display: flex;
  justify-content: flex-end;
  align-items: center;
  height: 30px;
}

/* .modal-header h3 {
  margin: 0;
  font-size: 18px;
  color: #333;
} */

.modal-body {
  padding: 24px;
  max-height: calc(80vh - 120px);
  overflow-y: auto;
}

.modal-body .table {
  margin-bottom: 0;
}

.modal-body .table th {
  background-color: #888884;
  color: black;
  font-size: 20px;
  font-weight: 400;
  padding: 12px;
  text-align: center;
}

.modal-body .table td {
  font-size: 18px;
  padding: 12px;
  padding-left: 23px;
  font-weight: 500;
  background-color: #f5f5f5;
}

/* .highlight-row td {
  background-color: #e6f3ff !important;
} */

.close-btn {
  background: none;
  border: none;
  font-size: 24px;
  color: #666;
  cursor: pointer;
  padding: 0 8px;
}

.close-btn:hover {
  color: #333;
}

.no-errors {
  text-align: center;
  color: #666;
  padding: 20px;
}
</style>
