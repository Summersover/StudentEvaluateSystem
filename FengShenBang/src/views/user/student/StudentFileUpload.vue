<template>
    <div class="upload-card">
      <h2>证明材料上传</h2>
      <input type="file" ref="fileInput" @change="handleFileChange">
      <button class="upload-btn" @click="uploadFile">上传</button>
    </div>
</template>

<script>
import { uploadFile, } from '@/api/student'

export default {
  methods: {
    handleFileChange(event) {
      this.selectedFile = event.target.files[0];
    },
    handleSuccess(response, file) {
      console.log(response);
      this.$message.success('文件上传成功');
    },
    uploadFile() {
      if (!this.selectedFile) {
        this.$message.error('请选择要上传的文件');
        return;
      }

      const allowedTypes = ['image/jpeg', 'image/png'];
      const maxSize = 2 * 1024 * 1024; // 2MB

      if (!allowedTypes.includes(this.selectedFile.type)) {
        this.$message.error('只能上传 JPG/PNG 格式的图片');
        return;
      }

      if (this.selectedFile.size > maxSize) {
        this.$message.error('上传图片大小不能超过 2MB');
        return;
      }

      uploadFile(this.selectedFile)
          .then(response => {
            this.handleSuccess(response, this.selectedFile);
          })
          .catch(error => {
            console.error(error);
            this.$message.error('文件上传失败');
          });
    }
  },
  data() {
    return {
      selectedFile: null
    };
  }
};
</script>

<style scoped>
.upload-card {
  width: 60%;
  padding: 20px;
  border: 1px solid #39a9ff;  /* 浅蓝色边框 */
  background-color: #f5faff;  /* 浅蓝色背景 */
  border-radius: 4px;
  margin: 20px auto;
}

.upload-card h2 {
  font-size: 18px;
  margin-bottom: 10px;
}

.upload-btn {
  margin-top: 10px;
  background-color: #39a9ff;
  color: white;
  border: none;
  padding: 10px;
  border-radius: 4px;
  cursor: pointer;
}
</style>
