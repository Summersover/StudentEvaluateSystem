<template>
  <div>
    <h1>学生信息导入</h1>
    <el-upload
        class="upload-demo"
        :action="apiUrl"
        :on-success="handleSuccess"
        :before-upload="beforeUpload"
        :on-exceed="handleExceed"
        :file-list="fileList"
    >
      <el-button size="small" type="primary">点击上传名单</el-button>
      <div slot="tip" class="el-upload__tip">请上传学生名单文件，包括学生学号和姓名</div>
      <div slot="tip" class="el-upload__tip">只能上传Excel文件，且不超过500kb</div>
    </el-upload>
    <el-table :data="studentData" height="500" border style="width: 100%">
      <el-table-column prop="username" label="学号" min-width="50%" align="center"></el-table-column>
      <el-table-column prop="name" label="姓名" min-width="50%" align="center"></el-table-column>
    </el-table>
  </div>
  
  
</template>

<script>
import { uploadStudentInfo, getStudentInfo} from '@/api/judge'

export default {
  data() {
    return {
      apiUrl: '', // 通过 beforeUpload 方法设置 apiUrl
      fileList: [],
      tableData: [],
      studentData: []  // 新增属性，用于存储后端返回的学生数据
    };
  },
  mounted() {
    this.fetchStudentData(); // 当组件加载完成后，自动执行获取学生信息的方法
  },
  methods: {
    handleSuccess(response, file) {
      console.log(response);
      this.$message.success('文件上传成功，一秒后自动刷新');
      setTimeout(() => {
        this.$router.go(0);
      }, 1000); //
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
        this.apiUrl = '/admin-api/studentInfo/upload'; // 设置 apiUrl
        this.uploadFile(file); // 调用上传文件方法
      }
      return false; // 阻止自动上传
    },
    handleExceed(files, fileList) {
      this.$message.warning('只能上传一个文件');
    },
    uploadFile(file) {
      uploadStudentInfo(file)
          .then(response => {
            this.handleSuccess(response, file);
          })
          .catch(error => {
            console.error(error);
            this.$message.error('文件上传失败');
          });
    },
    fetchStudentData() {
      getStudentInfo()
        .then(response => {
          this.studentData = response.data;
        })
        .catch(error => {
          console.error(error);
          this.$message.error('获取学生信息失败');
        });
    },
    
    
  }
};
</script>




<!--    <el-table :data="tableData" height="500" border style="width: 100%">-->
<!--      <el-table-column prop="studentId" label="学号" width="320" align="center"></el-table-column>-->
<!--      <el-table-column prop="name" label="姓名" width="160" align="center"></el-table-column>-->
<!--      <el-table-column prop="situation" label="未完成项目" align="center">-->
<!--        <template #default="scope">-->
<!--          <el-tag type="info" v-if="scope.row.mark.mark1 < 0">个人学年总结</el-tag>-->
<!--          <el-tag type="info" v-if="scope.row.mark.mark2 < 0">志愿服务</el-tag>-->
<!--          <el-tag type="info" v-if="scope.row.mark.mark3 < 0">学生成绩</el-tag>-->
<!--          <el-tag type="info" v-if="scope.row.mark.mark4 < 0">科研情况</el-tag>-->
<!--          <el-tag type="info" v-if="scope.row.mark.mark5 < 0">学生服务</el-tag>-->
<!--          <el-tag type="info" v-if="scope.row.mark.mark6 < 0">社会实践</el-tag>-->
<!--        </template>-->
<!--      </el-table-column>-->
<!--    </el-table>-->
