import Vue from "vue";
//配置路由
import VueRouter from "vue-router";
Vue.use(VueRouter);
//1.创建组件
import Index from "@/views/index";
import Home from "@/views/home";
import Login from "@/views/login";
import NotFound from "@/views/404";
import UpdatePassword from "@/views/update-password";
import pay from "@/views/pay";
import register from "@/views/register";
import center from "@/views/center";
import forum from "@/views/modules/forum/list";
import news from "@/views/modules/news/list";
import yonghu from "@/views/modules/yonghu/list";
import yiqingshangbao from "@/views/modules/yiqingshangbao/list";
import churuxinxi from "@/views/modules/churuxinxi/list";
import config from "@/views/modules/config/list";
import jiankangxinxi from "@/views/modules/jiankangxinxi/list";
import admin from '@/views/modules/admin/list'
import area from '@/views/modules/area/list'
import materials from '@/views/modules/materials/list'
import goods from '@/views/modules/goods/list'
import foreign from '@/views/modules//foreign/list'

//2.配置路由   注意：名字
const routes = [
  {
    path: "/index",
    name: "首页",
    component: Index,
    children: [
      {
        // 这里不设置值，是把main作为默认页面
        path: "/",
        name: "首页",
        component: Home,
        meta: { icon: "", title: "center" },
      },
      {
        path: "/updatePassword",
        name: "修改密码",
        component: UpdatePassword,
        meta: { icon: "", title: "updatePassword" },
      },
      {
        path: "/pay",
        name: "支付",
        component: pay,
        meta: { icon: "", title: "pay" },
      },
      {
        path: "/center",
        name: "个人信息",
        component: center,
        meta: { icon: "", title: "center" },
      },
      {
        path: "/forum",
        name: "社区交流",
        component: forum,
      },
      {
        path: "/news",
        name: "公告信息",
        component: news,
      },
      {
        path: "/yonghu",
        name: "用户",
        component: yonghu,
      },
      {
        path: "/yiqingshangbao",
        name: "疫情上报",
        component: yiqingshangbao,
      },
      {
        path: "/churuxinxi",
        name: "出入信息",
        component: churuxinxi,
      },
      {
        path: "/config",
        name: "轮播图管理",
        component: config,
      },
      {
        path: "/jiankangxinxi",
        name: "健康信息",
        component: jiankangxinxi,
      },{
        path: '/admin',
        name: '管理员管理',
        component: admin
      },{
        path: "/area",
        name: '区域管理',
        component: area
      },{
        path: '/materials',
        name: '物资管理',
        component: materials
      },{
        path: '/goods',
        name: '商品管理',
        component: goods
      },{
        path: '/foreign',
        name: '人员报备',
        component: foreign
      }
    ],
  },
  {
    path: "/login",
    name: "login",
    component: Login,
    meta: { icon: "", title: "login" },
  },
  {
    path: "/register",
    name: "register",
    component: register,
    meta: { icon: "", title: "register" },
  },
  {
    path: "/",
    name: "首页",
    redirect: "/index",
  } /*默认跳转路由*/,
  {
    path: "*",
    component: NotFound,
  },
];

const originalPush = VueRouter.prototype.push
   VueRouter.prototype.push = function push(location) {
   return originalPush.call(this, location).catch(err => err)
}


//3.实例化VueRouter  注意：名字
const router = new VueRouter({
  mode: "hash",
  /*hash模式改为history*/
  routes, // （缩写）相当于 routes: routes
});

export default router;
