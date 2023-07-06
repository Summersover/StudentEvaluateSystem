import Vue from 'vue'
import VueRouter from 'vue-router'
import LoginView from "@/views/LoginView.vue";

import Layout from "@/layout";
import index from "@/layout/index.vue";
import {getMenu} from '@/api/rbac_menu.js'
import {EventBus} from '@/api/listen.js'
import {getAccessToken} from '@/utils/auth.js'
import layout from "@/layout/index.vue";


Vue.use(VueRouter)

const routes = [//初始静态路由
  {
    path: '/',
    component: Layout, // 修改为 Layout 组件
    children: [
      {
        path: '',
        component: () => import( '../views/HomeView.vue'),
        name: 'home'
      }
    ]
  },

  {
    path: '/login',
    name: 'login',
    component:  LoginView
  },
  {
    path: '/user/judge/JRS/assess',//科研评分详情页
    name: 'JRSAssess',
    component: () => import('../views/user/judge/JudgeResearchSituation.vue')
  },
  {
    path: '/user/judge/JWS/assess',
    name: 'JWSAssess',
    component: () => import('../views/user/judge/JudgeWorkService.vue')
  },
  {
    path: '/user/judge/JSP/assess',
    name: 'JSPAssess',
    component: () => import('../views/user/judge/JudgeSocialPractice.vue')
  },
  {
    path: '/user/judge/JPS/assess',
    name: 'JPSAssess',
    component: () => import('../views/user/judge/JudgePersonalStatement.vue')
  },

]

let routerPush = VueRouter.prototype.push;
VueRouter.prototype.push = function push(location) {
  return routerPush.call(this, location).catch(err => err)
}

const  router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
});

async function fetchMenu() {
  getMenu().then((res) => {
    const menuList = res.data;
    console.log('menuList',menuList);

    menuList.forEach(menu => {

      const route = {
        path: menu.path,
        name: menu.name,
        component: Layout,
        children:[{
          path: '',
          component: () => import(`@/views/user/${menu.component}.vue`),
      }]
      };
      router.addRoute(route);
    });
  }).catch((error) => {
    console.error(error);
  });
}
if(getAccessToken()){
  fetchMenu();
}
// 监听事件
EventBus.$on('login-success', fetchMenu);
export default router
