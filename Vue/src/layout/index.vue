<template>
  <div>
    <div class="side-bar">
      <el-menu class="el-menu-vertical-demo" background-color="#545c64" text-color="#fff" active-text-color="#ffd04b" :default-openeds="['1', '2', '3']">
        <el-menu-item index="/">
          <i class="el-icon-house"></i>
          <span slot="title">首页</span>
        </el-menu-item>
        <el-submenu index="1" v-if="role === '学生'">
          <template slot="title">
            <i class="el-icon-user-solid"></i>
            <span slot="title">学生用户</span>
          </template>
          <router-link v-for="(menu, index) in menuList" :key="index" :to="menu.path">
            <el-menu-item :index="menu.path">
              <span slot="title">{{ menu.name }}</span>
            </el-menu-item>
          </router-link>
        </el-submenu>
        <el-submenu index="2" v-if="role === '评委老师'">
          <template slot="title">
            <i class="el-icon-s-check"></i>
            <span slot="title">评委用户</span>
          </template>
          <router-link v-for="(menu, index) in menuList" :key="index" :to="menu.path">
            <el-menu-item :index="menu.path">
              <span slot="title">{{ menu.name }}</span>
            </el-menu-item>
          </router-link>
        </el-submenu>
        <el-submenu index="3" v-if="role === '学工老师'">
          <template slot="title">
            <i class="el-icon-s-platform"></i>
            <span slot="title">学工用户</span>
          </template>
          <router-link v-for="(menu, index) in menuList" :key="index" :to="menu.path">
            <el-menu-item :index="menu.path">
              <span slot="title">{{ menu.name }}</span>
            </el-menu-item>
          </router-link>
        </el-submenu>
        <el-menu-item index="/logout" @click="logout">
          <i class="el-icon-switch-button"></i>
          <span slot="title">退出</span>
        </el-menu-item>
      </el-menu>


      <div class="main-content">
        <router-view/>
      </div>
    </div>
  </div>
</template>


<script>
import {removeToken} from '@/utils/auth'
import {getMenu} from '@/api/rbac_menu.js'
import {getRole} from '@/api/rbac_menu.js'
import SuccessPage from "@/views/HomeView.vue";
export default {
  name: "MyComponent",
  components: {SuccessPage},
  data() {
    return {
      role:'',
      menuList: [] // 菜单列表数据
    };
  },
  created() {
    getRole().then((res)=> {
      this.role = res.data;
      console.log(this.role);
    });

    getMenu().then((res)=> {
      this.menuList = res.data;
      console.log(this.menuList);
    });
  },
  methods: {
    logout() {
      this.$confirm('确定注销并退出系统吗？', '提示').then(() => {
        removeToken()
        this.$router.push({ path: '/login' })
      }).catch(() => {});
    },
  },
};
</script>

<style lang="scss" scoped>
.side-bar {
  display: flex;
  height: 100vh;
}

.main-content {
  flex: 1;
  padding: 20px;
}

.el-menu-vertical-demo{
  width:220px;
}

</style>