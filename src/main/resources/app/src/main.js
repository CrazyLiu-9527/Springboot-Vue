import Vue from 'vue';
import App from './App.vue';
// 引入iview
import iView from "view-design";
import 'view-design/dist/styles/iview.css';
// 引入路由
import router from "./router/router";
// 引入axios,其中vue-axios是将axios集成到Vue.js的小包装器，可以像插件一样进行安装
import VueAxios from "vue-axios";
import Axios from "axios";

Vue.config.productionTip = false;
Vue.use(iView);
Vue.use(VueAxios, Axios);

new Vue({
    router: router,
    render: h => h(App),
}).$mount('#app');

