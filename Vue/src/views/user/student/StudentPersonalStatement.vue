<!-- <template>
  <div>
    <div class="sps" >

      <el-form ref="form" :model="user" :rules="rules" label-width="1px">

        <div class="head" style="border-left: 4px solid #39a9ff;padding-left: 8px;line-height: initial;font-size: initial;text-align: left;">
          <h1>思想政治</h1>
        </div>
        <div class="left">
          <el-form-item v-for="(user,statementid) in userList" :key="statementid" prop="statement">
            时间
            <el-date-picker class="test3" value-format="d" format="yyyy-MM-dd" v-model="user.date" type="date" placeholder="选择年月日"></el-date-picker>
            地点
            <el-input class="test3" v-model="user.spot" placeholder="输入地点" prop="spot"></el-input>
            活动级别
            <el-input class="test3" v-model="user.level" placeholder="输入活动级别"></el-input>
            角色
            <el-input class="test3" v-model="user.role"  placeholder="输入角色"></el-input>
            活动名称
            <el-input class="test3" v-model="user.eventname"  placeholder="输入活动名称"></el-input>
          </el-form-item>
          <el-form-item>
            <el-button
              type="success"
              size="mini"
              icon="el-icon-plus"
              @click="addModule()"
              >添加条目
            </el-button>
            <el-button
              size="mini"
              icon="el-icon-delete"
              type="danger"
              @click="deleteModule()"
              >删除条目
            </el-button>
          </el-form-item>
        </div>

        <div class="head" style="border-left: 4px solid #39a9ff;padding-left: 8px;line-height: initial;font-size: initial;text-align: left;">
          <h1>行为规范</h1>
        </div>
        <div class="left">
          <el-form-item  prop="behaviour">
            <el-input v-model="user.behaviour" placeholder="注：不超过100字"></el-input>
          </el-form-item>
        </div>

        <div class="head" style="border-left: 4px solid #39a9ff;padding-left: 8px;line-height: initial;font-size: initial;text-align: left;">
          <h1>学习态度</h1>
        </div>
        <div class="left">
          <el-form-item  prop="study">
            <el-input v-model="user.study" placeholder="注：不超过100字"></el-input>
          </el-form-item>
        </div>

        <div class="head" style="border-left: 4px solid #39a9ff;padding-left: 8px;line-height: initial;font-size: initial;text-align: left;">
          <h1>身体健康</h1>
        </div>
        <div class="left">
          <el-form-item  prop="health">
            <el-input v-model="user.health" placeholder="注：不超过100字"></el-input>
          </el-form-item>
        </div>

        <div>
          <el-form-item>
            <el-button type="primary" @click="submitForm">提交</el-button>
          </el-form-item>
        </div>
      </el-form>
    </div>
  </div>

</template>

<script>

import { getInfo } from '@/api/login.js';
import { updateSPSinfo } from "@/api/login";
export default {

  name: "update",
  data() {
    return {
      userList:[],
      user: {
        username:"",
        statementid: "",
        date:"",
        spot:"",
        level:"",
        role:"",
        eventname:"",
        behaviour:"",
        study:"",
        health:""
      },

      rules: {
        spot: [{ required: true, message: "请输入地点", trigger: "blur" }],
        level: [{ required: true, message: "请输入活动级别", trigger: "blur" }],
        role: [{ required: true, message: "请输入角色", trigger: "blur" }],
        eventname: [{ required: true, message: "请输入活动名称", trigger: "blur" }],
        behaviour: [{ required: true, message: "请输入行为规范", trigger: "blur" }],
        study: [{ required: true, message: "请输入学习态度", trigger: "blur" }],
        health: [{ required: true, message: "请输入身体健康", trigger: "blur" }],
      },
    };
  },
  mounted() {
    getInfo().then((res) => {
      this.user.username = res.data.username;
    });
  },
  methods: {
    addModule() {
      this.user = {};
      this.userList.push(this.user);
    },
    deleteModule(user) {
      var index = this.userList.indexOf(user); //找到对应图标的下标
      this.userList.splice(this.userList.length - 1, 1);
    },
    submitForm() {
      this.$refs.form.validate(valid => {
        if (valid) {
          this.loading = true
          //发起网络请求登录，如果登录成功，跳转到主页面
          //操作与login api联系
          updateSPSinfo(this.user.username,this.user.date,this.user.spot, this.user.level,
              this.user.role,this.user.eventname,this.user.behaviour,this.user.study,this.user.health).then(res =>{
            console.log(res.data.accessToken)
            setToken(res.data.accessToken)
          }).catch(() => {
            // 上传，
            this.loading = true
          })
        }
      })
    },

  },
};
</script>

<style>
.update {
  padding: 20px;
}

.head{
  margin-left: 10px;
}

.test3{
  width: 150px !important;
}
.left{
  text-align: left;
  margin-left: 100px;
  margin-right: 50px;
}

.right{
  text-align: right;
  margin-right: 100px;
}
</style> -->

<template>
  <div>
      <div class="head" style="border-left: 4px solid #39a9ff;padding-left: 8px;line-height: initial;font-size: initial;text-align: left;">
        <h1>个人学年总结</h1>
      </div>
    <el-table :data="tableData" @cell-click="handleCellClick" :border = true>

      <el-table-column prop="start_time" label="时间" width="240">
        <template slot-scope="{ row }">
          <el-date-picker v-model="row.time" type="date" :disabled="!row.editable" class="date-picker" format="yyyy-MM-dd"></el-date-picker>
        </template>
      </el-table-column>

      <el-table-column prop="spot" label="地点">
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

      <el-table-column label="操作" width="200">
        <template slot-scope="{ row }">
          <div v-if="!row.editable">
            <el-button type="primary" size="mini" @click="handleEdit(row)">编辑</el-button>
            <el-button type="danger" size="mini" @click="handleDelete(row)">删除</el-button>
          </div>
          <div v-else>
            <el-button type="primary" size="mini" @click="handleSave(row)">保存</el-button>
            <el-button type="info" size="mini" @click="handleCancel(row)">删除</el-button>
          </div>
        </template>
      </el-table-column>
    </el-table>

    <div style="margin-top: 10px;">
      <el-button type="primary" icon="el-icon-plus" size="small" @click="handleAddRow">添加行</el-button>
    </div>

    <el-form :model="ruleForm" ref="ruleForm" label-width="100px" class="demo-ruleForm">
      <div class="head" style="border-left: 4px solid #39a9ff;padding-left: 8px;line-height: initial;font-size: initial;text-align: left;">
        <h1>行为规范</h1>
      </div>
      <el-form-item prop="behaviour">
        <el-input type="textarea" v-model="ruleForm.behaviour"></el-input>
      </el-form-item>
      <div class="head" style="border-left: 4px solid #39a9ff;padding-left: 8px;line-height: initial;font-size: initial;text-align: left;">
        <h1>学习态度</h1>
      </div>
      <el-form-item prop="study">
        <el-input type="textarea" v-model="ruleForm.study"></el-input>
      </el-form-item>
      <div class="head" style="border-left: 4px solid #39a9ff;padding-left: 8px;line-height: initial;font-size: initial;text-align: left;">
        <h1>身体健康</h1>
      </div>
      <el-form-item prop="health">
        <el-input type="textarea" v-model="ruleForm.health"></el-input>
      </el-form-item>
    </el-form>

    <div style="margin-top: 10px;">
      <el-button type="primary" size="small" @click="handleSubmit">提交</el-button>
    </div>
  </div>
</template>

<script>
import {getInfo} from "@/api/login";
import {getPerStat1, getPerStat2, updatePerStat, deletePerStat} from "@/api/updatePerStat";
import {deleteResSitu, updateResSitu} from "@/api/updateResSitu";

export default {
  name: "update",
  data() {
    return {
      tableData: [
        // {  description: '本科生科研训练项目', outcome: '论文一篇', level: 'SCI一作', start_time: '2022-10-01', end_time: '2023-10-01', editable: false },
        // {  description: 'xxx老师课题组科研项目', outcome: '专利一篇', level: '国家级', start_time: '2022-06-01',end_time: '2022-10-01', editable: false }
      ],
      ruleForm: {
        behaviour: '',
        study: '',
        health: ''
      },
      idSeed: 2,
      username: ''
    }
  },
  mounted() {
  getInfo().then((res) => {
    this.username = res.data.username;
  });
  getPerStat1().then((res) => {
    this.tableData = res.data;
    console.log(this.tableData);
  });
  //传回的是数组，还需要修改
  getPerStat2().then((res) => {
    this.behaviour = res.data.ruleForm.behaviour;
    this.study = res.data.ruleForm.study;
    this.health = res.data.ruleForm.health;
  });
},
  methods: {
    handleCellClick(row) {
      if (!row.editable) {
        this.$set(row, 'editable', true)
      }
    },
    handleEdit(row) {
      this.$set(row, 'editable', true)
    },
    handleSave(row) {
      this.$set(row, 'editable', false)
    },
    handleCancel(row) {
      this.$set(row, 'editable', false)
      if (row.isNew) {
        this.tableData.splice(this.tableData.indexOf(row), 1)
      }
    },
    handleAddRow() {
      const newRow = { id: ++this.idSeed, time: '', spot: '', level: '', role: '', eventname: '', editable: true, isNew: true }
      this.tableData.push(newRow)
    },
    handleDelete(row) {
      this.$confirm("确认删除该行数据?", "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning",
        center: true,
      })
          .then(() => {
            if (row.editable) {
              deletePerStat([row], this.username) // 只删除正在编辑的行数据
                  .then(() => {
                    console.log("删除成功！");
                    this.$message.success("删除成功！");
                    // 删除成功后再修改前端展示
                    this.tableData.splice(this.tableData.indexOf(row), 1);
                  })
                  .catch(() => {
                    console.log("删除失败！");
                    this.$message.error("删除失败！");
                  });
            } else {
              this.$message.warning("只能删除正在编辑的行数据！");
            }
          })
          .catch(() => {
            // 用户取消删除，无需进行任何操作
          });
    },
    handleSubmit() {
      this.$confirm('是否确认提交当前填写内容?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning',
        center: true
      }).then(() => {
        const editableRows = this.tableData.filter(row => row.editable);

        updatePerStat(editableRows, this.username)
            .then(res => {
              if (res.code === 200) {
                console.log("success!")
                this.$message.success('提交成功，1秒后刷新页面');
                setTimeout(() => {
                  location.reload();
                }, 1000); // 1秒后刷新页面
              } else {
                console.log("wrong")
                this.$message.error(res.message);
              }
            })
            .catch(() => {
              // 提交失败，显示错误提示
              this.$message.error('提交失败！');
            });
      }).catch(() => {
        this.$message({
          type: 'info',
          message: '已取消提交'
        });
      });
    }

  }
}
</script>

<style>
.update {
  padding: 20px;
}

.head{
  margin-left: 10px;
}

.test2{
  width: 100px !important;
}

.test3{
  width: 150px !important;
}

.left{
  text-align: left;
  margin-left: 100px;
  margin-right: 50px;
}

.right{
text-align: right;
margin-right: 100px;
}

</style>