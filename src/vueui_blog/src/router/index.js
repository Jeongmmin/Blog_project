import Vue from 'vue'
import VueRouter from 'vue-router'
import List from '../views/List.vue'
import Insert from '../views/Insert.vue'
import Detail from '../views/Detail.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'List',
    component: List
  },
  {
    path: '/insert',
    name: 'Insert',
    component: Insert
  },
  {
    path: '/Detail',
    name: 'Detail',
    component: Detail
  }
]

const router = new VueRouter({
  routes
})

export default router
