<template>
  <div class="home-container">
    <div class="header">
      <h2>导入记录</h2>
      <button class="refresh-btn" @click="fetchImportHistory" :disabled="loading">
        <i class="fas fa-sync-alt" :class="{ 'fa-spin': loading }"></i>
        刷新
      </button>
    </div>

    <file-upload @upload-success="handleUploadSuccess" @refresh="fetchImportHistory" />

    <div v-if="error" class="alert alert-danger">
      {{ error }}
      <button class="close-btn" @click="error = ''">&times;</button>
    </div>

    <div class="loading-overlay" v-if="loading">
      <div class="spinner"></div>
      加载中...
    </div>

    <table-component v-if="!loading" :columns="columns" :items="tableData" />

    <div v-if="!loading && tableData.length === 0" class="no-data">暂无数据</div>
  </div>
</template>

<script lang="ts">
import { defineComponent } from 'vue';
import TableComponent from '../table/table.vue';
import FileUpload from '../upload/file-upload.vue';
import axios from 'axios';

interface ImportHistory {
  tcihCode: string;
  tcihFilename: string;
  tcihImportTime: string;
  tcihStatus: string;
  createBy: string;
}

// 创建一个自定义的axios实例
const apiClient = axios.create({
  baseURL: '/api', // 设置基础URL
  timeout: 10000, // 设置超时时间
  headers: {
    'Content-Type': 'application/json',
  },
});

export default defineComponent({
  name: 'HomeView',
  components: {
    TableComponent,
    FileUpload,
  },
  data() {
    return {
      columns: [
        { field: 'code', label: 'Code' },
        { field: 'file', label: 'File' },
        { field: 'importTime', label: 'Import Time' },
        { field: 'status', label: 'Status' },
        { field: 'operate', label: 'Operate' },
        { field: 'user', label: 'User' },
      ],
      tableData: [] as Array<{
        code: string;
        file: string;
        importTime: string;
        status: string;
        operate: string;
        user: string;
      }>,
      loading: false,
      error: '',
    };
  },
  async created() {
    await this.fetchImportHistory();
  },
  methods: {
    formatDate(dateString: string): string {
      try {
        const date = new Date(dateString);
        return date.toLocaleString('zh-CN', {
          year: 'numeric',
          month: '2-digit',
          day: '2-digit',
          hour: '2-digit',
          minute: '2-digit',
          second: '2-digit',
        });
      } catch {
        return dateString;
      }
    },
    handleUploadSuccess(response: any) {
      // 上传成功后刷新列表
      this.fetchImportHistory();
    },
    async fetchImportHistory() {
      this.loading = true;
      this.error = '';

      try {
        const response = await apiClient.get<{ data: ImportHistory[] }>('/import-histories');

        // 检查响应数据的结构
        if (response.data && Array.isArray(response.data)) {
          this.tableData = response.data.map(item => ({
            code: item.tcihCode || '',
            file: item.tcihFilename || '',
            importTime: item.tcihImportTime ? this.formatDate(item.tcihImportTime) : '',
            status: item.tcihStatus === 'SUCCESS' ? 'Success' : 'Failure',
            operate: 'Detail',
            user: item.createBy || '',
          }));
        } else if (response.data && response.data.data && Array.isArray(response.data.data)) {
          // 处理嵌套在data字段中的数据
          this.tableData = response.data.data.map(item => ({
            code: item.tcihCode || '',
            file: item.tcihFilename || '',
            importTime: item.tcihImportTime ? this.formatDate(item.tcihImportTime) : '',
            status: item.tcihStatus === 'SUCCESS' ? 'Success' : 'Failure',
            operate: 'Detail',
            user: item.createBy || '',
          }));
        } else {
          throw new Error('Invalid data format');
        }
      } catch (error: any) {
        let errorMessage = '获取数据失败，请稍后重试';
        if (error.response) {
          // 服务器响应错误
          switch (error.response.status) {
            case 401:
              errorMessage = '未授权，请重新登录';
              break;
            case 403:
              errorMessage = '无权访问';
              break;
            case 404:
              errorMessage = '请求的资源不存在';
              break;
            case 500:
              errorMessage = '服务器错误，请稍后重试';
              break;
          }
        } else if (error.request) {
          // 请求发送失败
          errorMessage = '网络连接失败，请检查网络设置';
        }
        this.error = errorMessage;
        console.error('Failed to fetch import history:', error);
      } finally {
        this.loading = false;
      }
    },
  },
});
</script>

<style scoped>
.home-container {
  padding: 20px;
  position: relative;
  min-height: 200px;
}

.header {
  display: flex;
  justify-content: space-between;
  align-items: center;
  margin-bottom: 20px;
}

h2 {
  margin: 0;
  color: #2c3e50;
}

.refresh-btn {
  padding: 8px 16px;
  background-color: #4caf50;
  color: white;
  border: none;
  border-radius: 4px;
  cursor: pointer;
  display: flex;
  align-items: center;
  gap: 8px;
}

.refresh-btn:disabled {
  background-color: #cccccc;
  cursor: not-allowed;
}

.refresh-btn i {
  font-size: 14px;
}

.alert {
  padding: 12px;
  margin-bottom: 20px;
  border: 1px solid transparent;
  border-radius: 4px;
  display: flex;
  justify-content: space-between;
  align-items: center;
}

.alert-danger {
  color: #721c24;
  background-color: #f8d7da;
  border-color: #f5c6cb;
}

.close-btn {
  background: none;
  border: none;
  color: inherit;
  font-size: 20px;
  cursor: pointer;
  padding: 0 8px;
}

.loading-overlay {
  position: absolute;
  top: 0;
  left: 0;
  right: 0;
  bottom: 0;
  background: rgba(255, 255, 255, 0.8);
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  gap: 12px;
}

.spinner {
  width: 40px;
  height: 40px;
  border: 4px solid #f3f3f3;
  border-top: 4px solid #3498db;
  border-radius: 50%;
  animation: spin 1s linear infinite;
}

.no-data {
  text-align: center;
  padding: 40px;
  color: #666;
  font-size: 16px;
  background: #f9f9f9;
  border-radius: 4px;
}

@keyframes spin {
  0% {
    transform: rotate(0deg);
  }
  100% {
    transform: rotate(360deg);
  }
}
</style>
