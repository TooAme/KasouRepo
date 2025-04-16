<template>
  <div class="upload-container">
    <div
      class="upload-area"
      :class="{ 'drag-over': isDragOver }"
      @dragover.prevent="handleDragOver"
      @dragleave.prevent="handleDragLeave"
      @drop.prevent="handleDrop"
      @click="triggerFileInput"
    >
      <input type="file" ref="fileInput" @change="handleFileSelect" accept=".xlsx,.xls" style="display: none" />
      <div class="upload-content">
        <i class="fas fa-cloud-upload-alt upload-icon"></i>
        <p class="upload-text">
          拖拽文件到此处或点击上传
          <br />
          <span class="upload-hint">支持 .xlsx, .xls 格式</span>
        </p>
      </div>
    </div>

    <div v-if="uploadStatus" :class="['upload-status', uploadStatus.type]">
      {{ uploadStatus.message }}
      <button v-if="uploadStatus.type === 'error'" class="close-btn" @click="uploadStatus = null">&times;</button>
    </div>

    <div v-if="selectedFile" class="file-info">
      <span class="file-name">{{ selectedFile.name }}</span>
      <button class="upload-button" @click="uploadFile" :disabled="isUploading">
        <i class="fas fa-spinner fa-spin" v-if="isUploading"></i>
        {{ isUploading ? '上传中...' : '开始上传' }}
      </button>
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
      isDragOver: false,
      selectedFile: null as File | null,
      isUploading: false,
      uploadStatus: null as UploadStatus | null,
    };
  },
  methods: {
    handleDragOver(event: DragEvent) {
      this.isDragOver = true;
    },
    handleDragLeave(event: DragEvent) {
      this.isDragOver = false;
    },
    handleDrop(event: DragEvent) {
      this.isDragOver = false;
      if (event.dataTransfer?.files.length) {
        this.validateAndSetFile(event.dataTransfer.files[0]);
      }
    },
    triggerFileInput() {
      const fileInput = this.$refs.fileInput as HTMLInputElement;
      fileInput.click();
    },
    handleFileSelect(event: Event) {
      const fileInput = event.target as HTMLInputElement;
      if (fileInput.files?.length) {
        this.validateAndSetFile(fileInput.files[0]);
      }
    },
    validateAndSetFile(file: File) {
      // 根据文件扩展名检查
      const fileExtension = file.name.split('.').pop()?.toLowerCase();
      if (fileExtension !== 'xlsx' && fileExtension !== 'xls') {
        this.uploadStatus = {
          type: 'error',
          message: '只支持 Excel 文件格式 (.xlsx, .xls)',
        };
        return;
      }

      this.selectedFile = file;
      this.uploadStatus = null;
    },
    async uploadFile() {
      if (!this.selectedFile) return;

      this.isUploading = true;
      this.uploadStatus = {
        type: 'info',
        message: '正在上传...',
      };

      const formData = new FormData();
      formData.append('file', this.selectedFile);

      try {
        const response = await apiClient.post('/import/upload', formData, {
          headers: {
            'Content-Type': 'multipart/form-data',
          },
        });

        if (response.data.success) {
          this.uploadStatus = {
            type: 'success',
            message: response.data.message || '文件上传成功',
          };

          // 触发成功事件，父组件可以监听
          this.$emit('upload-success', response.data.data);

          // 清除已选文件
          this.selectedFile = null;

          // 刷新文件列表（如果父组件提供了这个方法）
          this.$emit('refresh');
        } else {
          throw new Error(response.data.message || '上传失败');
        }
      } catch (error: any) {
        this.uploadStatus = {
          type: 'error',
          message: error.response?.data?.message || error.message || '文件上传失败，请重试',
        };
      } finally {
        this.isUploading = false;
      }
    },
  },
});
</script>

<style scoped>
.upload-container {
  margin-bottom: 20px;
}

.upload-area {
  border: 2px dashed #dcdfe6;
  border-radius: 8px;
  padding: 20px;
  text-align: center;
  cursor: pointer;
  transition: all 0.3s;
}

.upload-area:hover {
  border-color: #409eff;
}

.drag-over {
  border-color: #409eff;
  background-color: rgba(64, 158, 255, 0.1);
}

.upload-content {
  display: flex;
  flex-direction: column;
  align-items: center;
  gap: 10px;
}

.upload-icon {
  font-size: 48px;
  color: #909399;
}

.upload-text {
  margin: 0;
  color: #606266;
}

.upload-hint {
  font-size: 12px;
  color: #909399;
}

.file-info {
  margin-top: 16px;
  padding: 12px;
  background-color: #f8f9fa;
  border-radius: 4px;
  display: flex;
  justify-content: space-between;
  align-items: center;
}

.file-name {
  color: #606266;
  font-size: 14px;
}

.upload-button {
  padding: 8px 16px;
  background-color: #409eff;
  color: white;
  border: none;
  border-radius: 4px;
  cursor: pointer;
  display: flex;
  align-items: center;
  gap: 8px;
}

.upload-button:disabled {
  background-color: #a0cfff;
  cursor: not-allowed;
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
