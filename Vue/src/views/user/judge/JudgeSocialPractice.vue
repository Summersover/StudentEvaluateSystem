<template>
  <div>
    <h1>社会实践</h1>
    <el-table :data="tableData" :border="true">
      <el-table-column prop="initiator" label="发起单位" width="300">
        <template slot-scope="{ row }">
          <el-input v-model="row.initiator" :disabled="!row.editable"></el-input>
        </template>
      </el-table-column>
      <el-table-column prop="spot" label="地点" width="160">
        <template slot-scope="{ row }">
          <el-input v-model="row.spot" :disabled="!row.editable"></el-input>
        </template>
      </el-table-column>

      <el-table-column prop="days" label="天数">
        <template slot-scope="{ row }">
          <el-input v-model="row.days" :disabled="!row.editable"></el-input>
        </template>
      </el-table-column>
      <el-table-column prop="size" label="团队人数">
        <template slot-scope="{ row }">
          <el-input v-model="row.size" :disabled="!row.editable"></el-input>
        </template>
      </el-table-column>

      <el-table-column prop="post" label="团队职务">
        <template slot-scope="{ row }">
          <el-input v-model="row.post" :disabled="!row.editable"></el-input>
        </template>
      </el-table-column>
      <el-table-column prop="online" label="是否线上">
        <template slot-scope="{ row }">
          <el-input v-model="row.online" :disabled="!row.editable"></el-input>
        </template>
      </el-table-column>

      <el-table-column prop="award" label="是否获得奖励">
        <template slot-scope="{ row }">
          <el-input v-model="row.award" :disabled="!row.editable"></el-input>
        </template>
      </el-table-column>
      <el-table-column prop="awardname" label="奖励名称">
        <template slot-scope="{ row }">
          <el-input v-model="row.awardname" :disabled="!row.editable"></el-input>
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
import {getSocPrac, updateSocPracMark, sendStuNum} from "@/api/judgeSocPrac";

export default {
  data() {
    return {
      tableData: [],
      idSeed: 2,
      student: {
        // name: '',
        // stuID: '',
        mark: ''
      },
      username: this.$route.query.username
    }
  },

  beforeRouteEnter (to, from, next) {
    sendStuNum(to.query.username).then((res) => {
      console.log(to.query.username);
      getSocPrac().then((res) => {
        next(vm => vm.tableData = res.data);
      });
    });
  },
  beforeRouteUpdate (to, from, next) {
    this.tableData = [];
    sendStuNum(to.query.username).then((res) => {
      console.log(to.query.username);
      getSocPrac().then((res) => {
        this.tableData = res.data;
        next();
      });
    });
  },

  methods: {
    goBack() {
      this.$router.push('/judge/JSP'); // 跳转到上一个 页面
    },

    handleSubmit() {
      this.$confirm('是否确认提交当前评分?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning',
        center: true
      }).then(() => {
        this.loading = true

        updateSocPracMark(this.username, this.student.mark)
            .then(res =>{
              console.log(this.student.mark)
              if (res.code===200){
                console.log("success!")
                this.$message.success('提交成功，一秒后自动返回');
                setTimeout(() => {
                  this.$router.push('/judge/JSP'); // 跳转到上一个 页面
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