<template>
  <div>
    <h1>科研情况</h1>
    <el-table :data="tableData" :border="true">
      <el-table-column prop="rank" label="名次" width="300">
        <template slot-scope="{ row }">
          <el-input v-model="row.rank" :disabled="!row.editable"></el-input>
        </template>
      </el-table-column>
      <el-table-column prop="time" label="时间" width="160">
        <template slot-scope="{ row }">
          <el-date-picker v-model="row.time" type="date" :disabled="!row.editable" class="date-picker"></el-date-picker>
        </template>
      </el-table-column>

      <el-table-column prop="place" label="地点">
        <template slot-scope="{ row }">
          <el-input v-model="row.place" :disabled="!row.editable"></el-input>
        </template>
      </el-table-column>
      <el-table-column prop="prize" label="奖项">
        <template slot-scope="{ row }">
          <el-input v-model="row.prize" :disabled="!row.editable"></el-input>
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
import {getResSitu, updateResSituMark, sendStuNum} from "@/api/judgeResSitu";

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

  //注意sendStuNum和getResearchList不应该放在钩子函数中，应该放在导航守卫（路由守卫）中
  //否则每次进入页面加载的数据会停留在上一次，只有刷新后才能获得最新的数据
  beforeRouteEnter (to, from, next) {
    sendStuNum(to.query.username).then((res) => {
      console.log(to.query.username);
      getResSitu().then((res) => {
        next(vm => vm.tableData = res.data);
      });
    });
  },
  beforeRouteUpdate (to, from, next) {
    this.tableData = [];
    sendStuNum(to.query.username).then((res) => {
      console.log(to.query.username);
      getResSitu().then((res) => {
        this.tableData = res.data;
        next();
      });
    });
  },

  methods: {
    goBack() {
      this.$router.push('/judge/JRS'); // 跳转到 /judge/JRS 页面
    },

    handleSubmit() {
      this.$confirm('是否确认提交当前评分?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning',
        center: true
      }).then(() => {
        this.loading = true

        updateResSituMark(this.username, this.student.mark)
            .then(res =>{
              console.log(this.student.mark)
              if (res.code===200){
                console.log("success!")
                this.$message.success('提交成功，一秒后自动返回');
                setTimeout(() => {
                  this.$router.push('/judge/JRS'); // 跳转到 /judge/JRS 页面
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