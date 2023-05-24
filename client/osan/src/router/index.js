import Vue from 'vue'
import VueRouter from 'vue-router'

// 페이지 정보들

// 메인페이지
import Main from '../views/MainRoute.vue'
// 유저 회원가입 페이지

// 산책로
import Route from '../views/route/RouteMain.vue'
import RouteDetail from '../views/route/RouteDetail.vue'
import RouteCreate from '../views/route/RouteCreate.vue'

import RegistUser from '../views/UserRegist.vue'

// 경유지
import Spot from '../views/spot/SpotMain.vue'
import SpotDetail from '../views/spot/SpotDetail.vue'
import SpotCreate from '../views/spot/SpotCreate.vue'



Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'main',
    component: Main
  },
  {
    path: '/user',
    name: 'user',
    component: RegistUser
  },
  {
    path: '/route',
    name: 'routeMain',
    component: Route,
    children: [
      {
        path: 'detail/:routeId',
        name: 'RouteDetail',
        component: RouteDetail
      },
      {
        path: 'create',
        name: 'RouteCreate',
        component: RouteCreate
      }
    ]
  },
  {
    path: '/spot',
    name: 'spotMain',
    component: Spot,
    children: [
      {
        path: 'detail/:spotId',
        name: 'SpotDetail',
        component: SpotDetail
      },
      {
        path: 'create',
        name: 'SpotCreate',
        component: SpotCreate
      }
    ]
  },

]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
