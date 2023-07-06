<template>
    <div class="add-user">
      <h1>个人学年总结评分</h1>
      <el-table
          :data="stuObjectArray"
          height="250"
          style="width: 100%"
          :border="true">
        <el-table-column
            label="序号"
            width="100">
          <template slot-scope="scope">
            {{ rowIndex(scope.$index) }}
          </template>
        </el-table-column>
  
        <el-table-column
            prop="username"
            label="学号">
        </el-table-column>
  
        <el-table-column
            prop="name"
            label="姓名"
            width="150">
        </el-table-column>
  
        <el-table-column
            prop="mark"
            label="个人学年总结得分">
        </el-table-column>
  
        <el-table-column
            prop="operation"
            label="操作">
          <template slot-scope="scope">
            <el-button type="text" size="small" @click="goToEvaluation(scope.row.username)">测评</el-button>
          </template>
        </el-table-column>
      </el-table>
    </div>
  </template>
  
  <script>
  // import {getStuList} from "@/api/judge";
  import {getStuList, getPerStatMarkList} from "@/api/judgePerStat";
  
  export default {
    data() {
      return {
        stuObjectArray: [],
        markObjectArray: [],
      }
    },
    mounted() {
      getStuList().then((res) => {
        this.stuObjectArray = res.data;
        console.log(this.stuObjectArray);
      });
      getPerStatMarkList().then((res) => {
        this.markObjectArray = res.data;
        console.log(this.stuObjectArray);
  
        // 遍历 stuObjectArray，将从评分总表获取的 markObjectArray 中的科研评分数据与每个学生对象进行匹配
        this.stuObjectArray.forEach((student) => {
          const markObj = this.markObjectArray.find((mark) => mark.username === student.username);
          if (markObj) {
            this.$set(student, 'mark', markObj.mark); // 将匹配到的分数赋值给学生对象的 score 属性
          } else {
            this.$set(student, 'mark', '未评分'); // 如果没有匹配到分数，则设置默认值为"未评分"
          }
        });
      });
    },
    methods: {
      goToEvaluation(username) {//跳转到评分详情页
        this.$router.push({
          path: '/user/judge/JPS/assess',
          query: {username: username},
        });
      },
    },
    computed: {
      rowIndex() {
        return (index) => index + 1;
      },
    },
  }
  </script>
  
  <style>
  .add-user {
    padding: 20px;
  }
  </style>