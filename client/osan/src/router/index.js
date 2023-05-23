import Vue from 'vue'
import VueRouter from 'vue-router'
import HomeView from '../views/HomeView.vue'

// // 페이지 정보들

// // 메인페이지
// import Main from '../views/MainRoute.vue'
// // 유저 회원가입 페이지
// import Regist from '../views/UserRgist.vue'

// // 산책로
// import Route from '../views/route/RouteMain.vue'
// import RouteDetail from '../views/route/RouteDetail.vue'
// import RouteCreate from '../views/route/RouteCreate.vue'

// // 경유지
// import Spot from '../views/spot/SpotMain.vue'
// import SpotDetail from '../views/spot/SpotDetail.vue'
// import SpotCreate from '../views/spot/SpotCreate.vue'



Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'home',
    component: HomeView
  },
  {
    path: '/about',
    name: 'about',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ '../views/AboutView.vue')
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
