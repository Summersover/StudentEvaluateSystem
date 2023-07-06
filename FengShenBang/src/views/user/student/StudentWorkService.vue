<template>
  <div>
      <div class="head" style="border-left: 4px solid #39a9ff;padding-left: 8px;line-height: initial;font-size: initial;text-align: left;">
        <h1>学生骨干岗位服务</h1>
      </div>
    <el-table :data="tableData" @cell-click="handleCellClick" :border = true>

      <el-table-column prop="start_time" label="起始时间" width="240">
        <template slot-scope="{ row }">
          <el-date-picker v-model="row.time" type="date" :disabled="!row.editable" class="date-picker" format="yyyy-MM-dd"></el-date-picker>
        </template>
      </el-table-column>

      <el-table-column prop="job" label="服务岗位名称" width="300">
        <template slot-scope="{ row }">
          <el-input v-model="row.job" :disabled="!row.editable"></el-input>
        </template>
      </el-table-column>

      <el-table-column prop="post" label="职务">
        <template slot-scope="{ row }">
          <el-input v-model="row.post" :disabled="!row.editable"></el-input>
        </template>
      </el-table-column>

      <el-table-column prop="level" label="考核级别">
        <template slot-scope="{ row }">
          <el-input v-model="row.level" :disabled="!row.editable"></el-input>
        </template>
      </el-table-column>

      <el-table-column label="操作">
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
      <el-button type="primary" size="small" @click="handleSubmit">提交</el-button>
    </div>
  </div>
</template>

<script>
import {getInfo} from "@/api/login";
import {getWorServ, updateWorServ, deleteWorServ} from "@/api/updateWorServ";

export default {
  name: "update",
  data() {
    return {
      tableData: [
        // {  description: '本科生科研训练项目', outcome: '论文一篇', level: 'SCI一作', start_time: '2022-10-01', end_time: '2023-10-01', editable: false },
        // {  description: 'xxx老师课题组科研项目', outcome: '专利一篇', level: '国家级', start_time: '2022-06-01',end_time: '2022-10-01', editable: false }
      ],
      idSeed: 2,
      username: ''
    }
  },
  mounted() {
  getInfo().then((res) => {
    this.username = res.data.username;
  });
  getWorServ().then((res) => {
    this.tableData = res.data;
    console.log(this.tableData);
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
      const newRow = { id: ++this.idSeed, job: '', post: '', level: '', editable: true, isNew: true }
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
              deleteWorServ([row], this.username) // 只删除正在编辑的行数据
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

        updateWorServ(editableRows, this.username)
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