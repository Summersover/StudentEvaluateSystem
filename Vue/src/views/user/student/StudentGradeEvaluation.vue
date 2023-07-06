<template>
  <div>
    <div class="StudentGradeEvaluation">
      <h1>学生学年成绩</h1>
      <el-table :data="tableData" style="width: 100%">
        <el-table-column prop="username" label="学号"></el-table-column>
        <el-table-column prop="name" label="姓名"></el-table-column>
        <el-table-column prop="grade" label="成绩"></el-table-column>
        <el-table-column prop="gpa" label="GPA"></el-table-column>
      </el-table>
      <p class="error-message">如成绩登记有误请在7月9日上午10:00前联系学工反馈</p>
      <p class="error-message">电话：650562125</p>
      <p class="error-message">邮箱：xuegong@staff.dxu.edu</p>
    </div>
  </div>
</template>

<script>
import { getInfo } from "@/api/login";
import { getGpa } from "@/api/student";

export default {
  name: "update",
  data() {
    return {
      tableData: [],
      idSeed: 2,
      username: ""
    };
  },
  mounted() {
    getInfo().then((res) => {
      this.username = res.data.username;
    });
    getGpa().then((res) => {
      this.tableData = res.data.map((item) => ({
        username: item.username,
        name: item.name,
        grade: item.grade,
        gpa: item.gpa
      }));
      console.log(this.tableData);
    });
  }
};
</script>

<style scoped>
.StudentGradeEvaluation {
  padding: 20px;
}
.test {
  width: 150px !important;
}
</style>
