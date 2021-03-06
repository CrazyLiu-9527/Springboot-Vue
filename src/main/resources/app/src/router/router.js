import Vue from 'vue'
import VueRouter from 'vue-router'
import HelloWorld from "../views/HelloWorld";
import TestView from "../views/TestView";

Vue.use(VueRouter);

// 2. 定义路由
// 每个路由应该映射一个组件。 其中"component" 可以是
// 通过 Vue.extend() 创建的组件构造器，
// 或者，只是一个组件配置对象。
// 我们晚点再讨论嵌套路由。
const routes = [
    {path: '/hello', name: 'hello', component: HelloWorld},
    {path: '/test', name: 'test', component: TestView},
];

// 3. 创建 router 实例，然后传 `routes` 配置
// 你还可以传别的配置参数, 不过先这么简单着吧。
const router = new VueRouter({
    mode: 'history',
    base: '/',
    routes // (缩写) 相当于 routes: routes
});

// 4. 将router暴露出去，在main.js中引用
export default router;
