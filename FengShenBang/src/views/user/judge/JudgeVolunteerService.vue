<template>
  <div class =  "uploadBox">
    <div class =  "uploadButtom">
      <h1>学生志愿情况导入</h1>
      <el-upload
        class="upload-demo"
        :action="apiUrl"
        :on-success="handleSuccess"
        :before-upload="beforeUpload"
        :on-exceed="handleExceed"
        :file-list="fileList"
        @change="uploadFile"

      >
        <el-button size="small" type="primary">点击上传志愿时长</el-button>
        <div slot="tip" class="el-upload__tip">请上传学生志愿时长文件，包括学生学号，姓名，服务时长以及对应的评分</div>
        <div slot="tip" class="el-upload__tip">只能上传Excel文件，且不超过500kb</div>
      </el-upload>
    </div>

    <div class="tableBox" v-show="show">
      <!-- <h3>
        <i class="el-icon-info">
          以下是将上传的数据，请您检查无误后，点击“采集数据提交”按钮上传至服务器</i
        >
      </h3> -->
      <el-table :data="tableData" border style="width: 100%" >
        <el-table-column
          prop="username"
          label="学号"
          min-width="25%"
        ></el-table-column>
        <el-table-column
          prop="name"
          label="姓名"
          min-width="25%"
        ></el-table-column>
        <el-table-column
          prop="time"
          label="服务时长"
          min-width="25%"
        ></el-table-column>
        <el-table-column
          prop="vsmark"
          label="评分"
          min-width="25%"
        ></el-table-column>
      </el-table>
    </div>
  </div>
</template>

<script>
import { uploadStudentVolSer, getStudentVolSerData } from '@/api/judge'

export default {
  data() {
    return {
      apiUrl: '', // 通过 beforeUpload 方法设置 apiUrl
      fileList: [],
      tableData: [],
      height: document.documentElement.clientHeight - 130,
      show: true,
      handle: null // 初始化 handle 属性
    };

  },

  mounted() {
    this.fetchStudentVolSerData();
  },

  methods: {

    fetchStudentVolSerData() {
      getStudentVolSerData().then((res) => {
        this.tableData = res.data;
        console.log(this.tableData);
      });
    },

    handleSuccess(response, file) {
      console.log(response);
      this.$message.success('文件上传成功，1秒后刷新页面');
      setTimeout(() => {
        location.reload()
      }, 1000) // 1秒后刷新页面
    },
    beforeUpload(file) {
      const isExcel =
          file.type === 'application/vnd.ms-excel' ||
          file.type === 'application/vnd.openxmlformats-officedocument.spreadsheetml.sheet';
      const isLt500KB = file.size / 1024 < 500;
      if (!isExcel) {
        this.$message.error('只能上传Excel文件');
      }
      if (!isLt500KB) {
        this.$message.error('文件大小不能超过500KB');
      }
      if (isExcel && isLt500KB) {
        this.apiUrl = '/admin-api/studentVolSer/upload'; // 设置 apiUrl
        this.uploadFile(file); // 调用上传文件方法
      }
      return false; // 阻止自动上传
    },
    handleExceed(files, fileList) {
      this.$message.warning('只能上传一个文件');
    },
    uploadFile(file) {
      uploadStudentVolSer(file)
          .then(response => {
            this.handleSuccess(response, file);
          })
          .catch(error => {
            console.error(error);
            this.$message.error('文件上传失败');
          });
    }
  }
};
</script>


<style lang="less" scoped>
  .homeBox {
    position: fixed;
    top: 10px;
    right: 20px;
    z-index: 9999;
    font-size: 40px;
  }

  .buttonBox {
    padding: 15px;
    display: flex;
    width: 100%;
    justify-content: center;
    & .el-button {
      margin-right: 20px !important;
    }
  }

  .tableBox {
    padding: 0 15px;
    h3 {
      font-size: 18px;
      color: #f56c6c;
      padding-bottom: 15px;
    }
  }
</style>