<template>
  <div class="home-container">
    <file-upload @upload-success="handleUploadSuccess" @refresh="fetchImportHistory" />

    <h2>—— File Import Result List ————————————————————————————————————————————————————————————————————————————</h2>
    <div class="header">
      <button class="refresh-button" @click="fetchImportHistory" :disabled="loading" title="リフレッシュ">
        <i class="fas fa-sync-alt" :class="{ 'fa-spin': loading }"></i>
        <span>Refresh</span>
      </button>
    </div>
    <div v-if="error" class="alert alert-danger">
      {{ error }}
      <button class="close-btn" @click="error = ''">&times;</button>
    </div>

    <div class="loading-overlay" v-if="loading">
      <div class="spinner"></div>
      loading...
    </div>

    <table-component v-if="!loading" :columns="columns" :items="tableData" @error="handleError" />

    <div v-if="!loading && tableData.length === 0" class="no-data">no data</div>
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
  tcihImporttime: string;
  tcihStatus: boolean;
  createBy: string;
  uuid: string;
}

const apiClient = axios.create({
  baseURL: '/api',
  timeout: 100000,
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
        uuid: string;
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
      this.fetchImportHistory();
    },
    handleError(message: string) {
      this.error = message;
    },
    async fetchImportHistory() {
      this.loading = true;
      this.error = '';

      try {
        const response = await apiClient.get<{ data: ImportHistory[] }>('/import-histories', {
          params: {
            page: 0,
            size: 1000, // 设置较大的页面大小以获取所有数据
            sort: 'tcihImporttime,asc', // 按导入时间降序排序
          },
        });

        if (response.data && Array.isArray(response.data)) {
          this.tableData = response.data.map(item => ({
            code: item.tcihCode || '',
            file: item.tcihFilename || '',
            importTime: item.tcihImporttime ? this.formatDate(item.tcihImporttime) : '',
            status: item.tcihStatus === true ? 'Success' : 'Failure',
            operate: item.tcihStatus === true ? '' : 'detail',
            user: item.createBy || '',
            uuid: item.uuid || '',
          }));
        } else if (response.data && response.data.data && Array.isArray(response.data.data)) {
          this.tableData = response.data.data.map(item => ({
            code: item.tcihCode || '',
            file: item.tcihFilename || '',
            importTime: item.tcihImporttime ? this.formatDate(item.tcihImporttime) : '',
            status: item.tcihStatus === true ? 'Success' : 'Failure',
            operate: item.tcihStatus === true ? '' : 'detail',
            user: item.createBy || '',
            uuid: item.uuid || '',
          }));
        } else {
          throw new Error('Invalid data format');
        }
      } catch (error: any) {
        let errorMessage = 'データの取得に失敗した場合は、後で再試行をお願いします。';
        if (error.response) {
          switch (error.response.status) {
            case 401:
              errorMessage = '未許可です,再登録してください';
              break;
            case 403:
              errorMessage = 'アクセスする権利はありません';
              break;
            case 404:
              errorMessage = '要求リソースは存在しません';
              break;
            case 500:
              errorMessage = 'サーバーが間違っています。あとでリトライしてください。';
              break;
          }
        } else if (error.request) {
          errorMessage = 'ネットワーク接続に失敗しました。ネットワークの設定を確認してください。';
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
  font-size: 1.25vw;
  color: #2c3e50;
  font-weight: 100;
  padding-right: -10px;
  align-content: center;
  align-self: center;
  white-space: nowrap;
  overflow: hidden;
  text-overflow: initial;
}

.refresh-button {
  display: flex;
  align-items: center;
  justify-content: center;
  gap: 1px;
  padding: 5px 10px;
  border-radius: 3px;
  background: linear-gradient(to bottom, #fafafa 10%, rgb(223, 223, 223) 100%);
  border: 1px solid #808080;
  box-shadow: 0 1px 2px rgba(0, 0, 0, 0.1);
  font-size: 16px;
  font-weight: normal;
  color: #000000;
  cursor: pointer;
  height: 40px;
  min-width: 80px;
  margin-top: 10px;
  margin-right: 10px;
  margin-left: auto;
}

.refresh-button:hover {
  background: linear-gradient(to bottom, #f0f0f0 0%, #e0e0e0 100%);
}

.refresh-button:active {
  background: linear-gradient(to bottom, #e0e0e0 0%, #e9e9e9 100%);
  box-shadow: inset 0 1px 2px rgba(0, 0, 0, 0.1);
}

.refresh-button:disabled {
  opacity: 0.6;
  cursor: not-allowed;
}

.refresh-button i {
  font-size: 17px;
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
