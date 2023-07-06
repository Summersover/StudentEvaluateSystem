import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
import xlsx from 'xlsx'
import './permission'
import axios from 'axios';

Vue.config.productionTip = false
axios.defaults.withCredentials = true

Vue.use(ElementUI);
Vue.use(xlsx);

new Vue({
  router,
  store,
  el: '#app',
  render: h => h(App)
}).$mount('#app')