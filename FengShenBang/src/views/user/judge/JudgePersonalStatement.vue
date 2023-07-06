<template>
  <div>
    <h1>个人学年总结</h1>
    <el-table :data="tableData" :border="true">
      <el-table-column prop="time" label="时间" width="160">
        <template slot-scope="{ row }">
          <el-date-picker v-model="row.time" type="date" :disabled="!row.editable" class="date-picker"></el-date-picker>
        </template>
      </el-table-column>
      <el-table-column prop="spot" label="地点" width="300">
        <template slot-scope="{ row }">
          <el-input v-model="row.spot" :disabled="!row.editable"></el-input>
        </template>
      </el-table-column>

      <el-table-column prop="level" label="活动级别">
        <template slot-scope="{ row }">
          <el-input v-model="row.level" :disabled="!row.editable"></el-input>
        </template>
      </el-table-column>
      <el-table-column prop="role" label="角色">
        <template slot-scope="{ row }">
          <el-input v-model="row.role" :disabled="!row.editable"></el-input>
        </template>
      </el-table-column>
      <el-table-column prop="eventname" label="活动名称">
        <template slot-scope="{ row }">
          <el-input v-model="row.eventname" :disabled="!row.editable"></el-input>
        </template>
      </el-table-column>
    </el-table>

    <br><br>
    <div> 评分：
      <el-input
          v-model="student.mark"
          :style="{width: '65px'}"
      ></el-input>
    </div>
    <br>

    <div style="margin-top: 10px;">
      <el-button type="default" size="small" @click="goBack">返回</el-button> <!-- 返回按钮 -->
      <el-button type="primary" size="small" @click="handleSubmit">提交</el-button>
    </div>
  </div>
</template>

<script>
import {getPerStat1, getPerStat2, updatePerStatMark, sendStuNum} from "@/api/judgePerStat";

export default {
  data() {
    return {
      tableData: [],
      ruleForm: {
        behaviour: '',
        study: '',
        health: ''
      },
      idSeed: 2,
      student: {
        // name: '',
        // stuID: '',
        mark: ''
      },
      username: this.$route.query.username,
      editable: true
    }
  },

  beforeRouteEnter (to, from, next) {
    sendStuNum(to.query.username).then((res) => {
      console.log(to.query.username);
      getPerStat1().then((res) => {
        next(vm => vm.tableData = res.data);
      });
      getPerStat2().then((res) => {
        this.behaviour = res.data.ruleForm.behaviour;
        this.study = res.data.ruleForm.study;
        this.health = res.data.ruleForm.health;
      });
    });
  },
  beforeRouteUpdate (to, from, next) {
    this.tableData = [];
    sendStuNum(to.query.username).then((res) => {
      console.log(to.query.username);
      getPerStat1().then((res) => {
        this.tableData = res.data;
        next();
      });
      getPerStat2().then((res) => {
        this.behaviour = res.data.ruleForm.behaviour;
        this.study = res.data.ruleForm.study;
        this.health = res.data.ruleForm.health;
      });
    });
  },

  methods: {
    goBack() {
      this.$router.push('/judge/JPS'); // 跳转到上一个 页面
    },

    handleSubmit() {
      this.$confirm('是否确认提交当前评分?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning',
        center: true
      }).then(() => {
        this.loading = true

        updatePerStatMark(this.username, this.student.mark)
            .then(res =>{
              console.log(this.student.mark)
              if (res.code===200){
                console.log("success!")
                this.$message.success('提交成功，一秒后自动返回');
                setTimeout(() => {
                  this.$router.push('/judge/JPS'); // 跳转到上一个 页面
                }, 1000); //
              }else{
                console.log("wrong")
                this.$message.error(res.data)
                this.loading = false
              }
            }).catch(() => {
          this.$message.error('错误')
          this.loading = false
        });
      }).catch(() => {
        this.$message({
          type: 'info',
          message: '已取消提交'
        });
      });

    },
  }
}
</script>


<style>
.research {
  padding: 20px;
}

.date-picker .el-input__inner {
  width: 140px;
}
</style>