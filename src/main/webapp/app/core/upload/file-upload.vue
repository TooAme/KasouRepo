<template>
  <div class="upload-container">
    <div class="upload-content">
      <h4>Excel</h4>
      <div class="file-list-container">
        <div class="file-list" v-if="selectedFiles.length > 0">
          <div v-for="(file, index) in selectedFiles" :key="index" class="file-item">
            <div class="file-item-name">{{ file.name }}</div>
            <button class="remove-btn" @click="removeFile(index)" title="削除">&times;</button>
          </div>
        </div>
        <div class="no-files" v-else>No File Selected</div>
      </div>

      <div class="upload-actions">
        <div class="button-group">
          <input type="file" ref="fileInput" @change="handleFileSelect" accept=".xlsx" style="display: none" multiple />
          <button class="action-button select-button" @click="triggerFileInput" title="Excelファイルを選択します">
            <i class="fas fa-file-upload"></i>
            <span>File Selection</span>
          </button>
          <button
            class="action-button upload-button"
            @click="uploadFiles"
            :disabled="isUploading || selectedFiles.length === 0"
            title="選択したファイルをアップロードします"
          >
            <i class="fas fa-cloud-upload-alt" v-if="!isUploading"></i>
            <i class="fas fa-spinner fa-spin" v-else></i>
            <span>{{ isUploading ? 'Importing...' : 'Import' }}</span>
          </button>
        </div>

        <div v-if="uploadStatus" :class="['upload-status', uploadStatus.type]">
          {{ uploadStatus.message }}
          <button v-if="uploadStatus.type === 'error'" class="close-btn" @click="uploadStatus = null">&times;</button>
        </div>
      </div>
    </div>
  </div>
</template>

<script lang="ts">
import { defineComponent } from 'vue';
import axios from 'axios';

interface UploadStatus {
  type: 'success' | 'error' | 'info';
  message: string;
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
  name: 'FileUpload',
  data() {
    return {
      selectedFiles: [] as File[],
      isUploading: false,
      uploadStatus: null as UploadStatus | null,
    };
  },
  methods: {
    triggerFileInput() {
      const fileInput = this.$refs.fileInput as HTMLInputElement;
      fileInput.click();
    },
    handleFileSelect(event: Event) {
      const fileInput = event.target as HTMLInputElement;
      if (fileInput.files?.length) {
        for (let i = 0; i < fileInput.files.length; i++) {
          const file = fileInput.files[i];
          if (this.validateFile(file)) {
            this.selectedFiles.push(file);
          }
        }
        // 清空 input，允许再次选择同一文件
        fileInput.value = '';
      }
    },
    validateFile(file: File): boolean {
      // 根据文件扩展名检查
      const fileExtension = file.name.split('.').pop()?.toLowerCase();
      if (fileExtension !== 'xlsx') {
        this.uploadStatus = {
          type: 'error',
          message: `ファイル "${file.name}" は有効なExcelファイルではありません。.xlsx と .xls のみサポートします`,
        };
        return false;
      }
      return true;
    },
    removeFile(index: number) {
      this.selectedFiles.splice(index, 1);
    },
    async uploadFiles() {
      if (this.selectedFiles.length === 0) return;

      this.isUploading = true;
      this.uploadStatus = {
        type: 'info',
        message: 'アップロード中...',
      };

      try {
        const successFiles: string[] = [];
        const failedFiles: string[] = [];

        // 逐个上传文件
        for (const file of this.selectedFiles) {
          try {
            await this.uploadSingleFile(file);
            successFiles.push(file.name);
          } catch (error) {
            failedFiles.push(file.name);
          }
        }

        // 根据上传结果设置状态信息
        if (failedFiles.length === 0) {
          this.uploadStatus = {
            type: 'success',
            message: `全部${successFiles.length}個のファイルがアップロードされました`,
          };
          this.selectedFiles = []; // 清空已选择文件列表
        } else if (successFiles.length === 0) {
          this.uploadStatus = {
            type: 'error',
            message: `全部${failedFiles.length}個のファイルがアップロードに失敗しました`,
          };
        } else {
          this.uploadStatus = {
            type: 'info',
            message: `${successFiles.length}個のファイルがアップロードされました，${failedFiles.length}個のファイルがアップロードに失敗しました`,
          };
          // 从选择文件列表中移除成功上传的文件
          this.selectedFiles = this.selectedFiles.filter(file => !successFiles.includes(file.name));
        }

        // 触发刷新事件，父组件可以监听
        this.$emit('refresh');
      } catch (error: any) {
        this.uploadStatus = {
          type: 'error',
          message: 'アップロード中にエラーが発生しました：' + (error.message || '未知のエラー'),
        };
      } finally {
        this.isUploading = false;
      }
    },
    async uploadSingleFile(file: File) {
      const formData = new FormData();
      formData.append('file', file);

      const response = await apiClient.post('/import/upload', formData, {
        headers: {
          'Content-Type': 'multipart/form-data',
        },
      });

      if (!response.data.success) {
        throw new Error(response.data.message || 'アップロードに失敗しました');
      }

      // 触发成功事件，父组件可以监听
      this.$emit('upload-success', response.data.data);

      return response.data;
    },
  },
});
</script>

<style scoped>
.upload-container {
  margin-bottom: 20px;
  width: 100%;
}

.upload-content {
  display: flex;
  gap: 20px;
}

.file-list-container {
  flex: 1;
  border: 2.5px solid #818181;
  border-radius: 6px;
  padding: 15px;
  background-color: #d3d5cb;
  min-height: 200px;
  max-height: 300px;
  overflow-y: auto;
}

h4 {
  margin-top: 0;
  margin-bottom: 15px;
  color: #333;
  font-size: 26px;
  padding-right: 12px;
  padding-left: 3px;
}

.file-list {
  display: flex;
  flex-direction: column;
  gap: 8px;
}

.file-item {
  display: flex;
  justify-content: space-between;
  align-items: center;
  padding: 8px 12px;
  background-color: white;
  border: 1px solid #e0e0e0;
  border-radius: 4px;
}

.file-item-name {
  white-space: nowrap;
  overflow: hidden;
  text-overflow: ellipsis;
  flex: 1;
}

.remove-btn {
  background: none;
  border: none;
  color: #ff4d4f;
  font-size: 18px;
  cursor: pointer;
  padding: 0 4px;
}

.no-files {
  display: flex;
  justify-content: center;
  align-items: center;
  height: 150px;
  color: #999;
  font-style: italic;
}

.upload-actions {
  flex: 1;
  display: flex;
  flex-direction: column;
  gap: 20px;
}

.button-group {
  display: flex;
  gap: 10px;
}

.action-button {
  display: flex;
  align-items: center;
  justify-content: center;
  gap: 1.5px;
  padding: 5px 10px;
  border-radius: 3px;
  background: linear-gradient(to bottom, #fafafa 10%, rgb(223, 223, 223) 100%);
  border: 1.5px solid #808080;
  box-shadow: 0 1px 2px rgba(0, 0, 0, 0.1);
  font-size: 18px;
  font-weight: normal;
  color: #000000;
  cursor: pointer;
  height: 70px;
  width: 160px;
}

.action-button:hover {
  background: linear-gradient(to bottom, #f0f0f0 0%, #e0e0e0 100%);
}

.action-button:active {
  background: linear-gradient(to bottom, #e0e0e0 0%, #e9e9e9 100%);
  box-shadow: inset 0 1px 2px rgba(0, 0, 0, 0.1);
}

.action-button:disabled {
  opacity: 0.6;
  cursor: not-allowed;
}

.action-button i {
  font-size: 17px;
}

.select-button {
  min-width: 120px;
}

.upload-button {
  min-width: 100px;
}

.upload-status {
  margin-top: 12px;
  padding: 12px;
  border-radius: 4px;
  display: flex;
  justify-content: space-between;
  align-items: center;
}

.upload-status.success {
  background-color: #f0f9eb;
  color: #67c23a;
  border: 1px solid #e1f3d8;
}

.upload-status.error {
  background-color: #fef0f0;
  color: #f56c6c;
  border: 1px solid #fde2e2;
}

.upload-status.info {
  background-color: #f4f4f5;
  color: #909399;
  border: 1px solid #e9e9eb;
}

.close-btn {
  background: none;
  border: none;
  color: inherit;
  font-size: 18px;
  cursor: pointer;
  padding: 0 4px;
}
</style>
