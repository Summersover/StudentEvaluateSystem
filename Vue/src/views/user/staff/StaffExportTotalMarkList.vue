<template>
  <div class="JudgeAssessed">
    <h1>评测结果汇总</h1>
    <el-button size="small" type="primary" @click="exportToExcel">导出到Excel</el-button>
    <el-table
        :data="tableData"
        height="500"
        border
        style="width: 100%">
      <el-table-column
          prop="username"
          label="学号"
          width="320"
          align="center">
      </el-table-column>
      <el-table-column
          prop="name"
          label="姓名"
          width="160"
          align="center">
      </el-table-column>
      <el-table-column
          prop="psmark"
          label="个人学年总结"
          align="center">
      </el-table-column>
      <el-table-column
          prop="vsmark"
          label="志愿服务"
          align="center">
      </el-table-column>
      <el-table-column
          prop="gpmark"
          label="学生成绩"
          align="center">
      </el-table-column>
      <el-table-column
          prop="rsmark"
          label="科研情况"
          align="center">
      </el-table-column>
      <el-table-column
          prop="wsmark"
          label="学生服务"
          align="center">
      </el-table-column>
      <el-table-column
          prop="spmark"
          label="社会实践"
          align="center">
      </el-table-column>
      <el-table-column
          prop="totmark"
          label="总评分"
          align="center">
      </el-table-column>
    </el-table>
  </div>
</template>
<!--<script>-->
<!--import { fetchTotalMark } from "@/api/totalMark";-->


<script>
import { getTotalMarkList } from '@/api/totalMark'
import { saveAs } from 'file-saver';
import XLSX from 'xlsx';
import { Message } from 'element-ui';




export default {
  data() {
    return {
      tableData: []
    }
  },
  mounted() {
    getTotalMarkList().then((res) => {
      this.tableData = res.data;
      console.log(this.tableData);
    });
  },

  computed: {
    rowIndex() {
      return (index) => index + 1;
    },
  },

  methods: {
    exportToExcel() {

      Message.info('文件下载已开始，请稍候...');

      let wb = XLSX.utils.book_new();
      wb.Props = {
        Title: "评测结果汇总",
        Subject: "评测结果",
        Author: "Admin",
        CreatedDate: new Date()
      };
      wb.SheetNames.push("评测结果");

      let ws_data = [['学号', '姓名', '个人学年总结', '志愿服务', '学生成绩', '科研情况', '学生服务', '社会实践', '总评分']];

      this.tableData.forEach((row) => {
        ws_data.push([row.username, row.name, row.psmark, row.vsmark, row.gpmark, row.rsmark, row.wsmark, row.spmark, row.totmark]);
      });

      let ws = XLSX.utils.aoa_to_sheet(ws_data);
      wb.Sheets["评测结果"] = ws;
      let wbout = XLSX.write(wb, {bookType:'xlsx',  type: 'binary'});

      function s2ab(s) {
        let buf = new ArrayBuffer(s.length);
        let view = new Uint8Array(buf);
        for (let i=0; i<s.length; i++) view[i] = s.charCodeAt(i) & 0xFF;
        return buf;
      }

      saveAs(new Blob([s2ab(wbout)],{type:"application/octet-stream"}), '评测结果汇总.xlsx');
    },
  },

}
</script>

<style>


.admin-score-overview {
  padding: 20px;
}
</style>