<template>
  <div className="success-page">
    <el-container>
      <el-main>
        <div className="content">
          <h1>Login Successful!</h1>
          <p>Welcome, {{ username1 }}!</p>
        </div>
      </el-main>
    </el-container>
  </div>
</template>

<script>
import {getInfo} from "@/api/login";

export default {
  name: "SuccessPage",
  data() {
    return {
      username1: "",
    };
  },
  mounted() {
    getInfo().then((res) => {
      this.username1 = res.data.username;
    });
  },
};
</script>

<style scoped>
.success-page {
  height: 100%;
}

.content {
  margin: 20px;
  padding: 20px;
  background-color: #ffffff;
  border-radius: 4px;
  box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.1);
}
</style>