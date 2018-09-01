import Vue from 'vue'
import Router from 'vue-router'
import Home from './views/Home.vue'

Vue.use(Router)

export default new Router({
  mode: 'history',
  base: process.env.BASE_URL,
  routes: [
    {
      path: '/home',
      name: 'home',
      component: Home
    },
    {
      path: '/about',
      name: 'about',
      // route level code-splitting
      // this generates a separate chunk (about.[hash].js) for this route
      // which is lazy-loaded when the route is visited.
      component: () => import(/* webpackChunkName: "about" */ './views/About.vue')
    },
    {
      path: '/test',
      name: 'test',
      component: () => import('./views/Test.vue')
    },
    {
      path: '/',
      name: 'index',
      component: () => import('./views/Index.vue')
    },
    {
      path: '/login',
      name: 'login',
      component: () => import('./views/user/Login.vue')
    },
    {
      path: '/register',
      name: 'register',
      component: () => import('./views/user/Register.vue')
    },
    {
      path: '/resetPassword',
      name: 'reset',
      component: () => import('./views/user/ResetPassword.vue')
    },
    {
      path: '/retrievePassword',
      name: 'retrieve',
      component: () => import('./views/user/RetrievePassword.vue')
    }
  ]
})
