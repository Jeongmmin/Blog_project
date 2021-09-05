import Vue from 'vue'
import VueRouter from 'vue-router'
import List from '../views/List.vue'
import Insert from '../views/Insert.vue'
import Detail from '../views/Detail.vue'
import Main from '../views/Main.vue'
import Update from '../views/Update.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'Main',
    component: Main
  },
  {
    path: '/insert',
    name: 'Insert',
    component: Insert
  },
  {
    path: '/detail',
    name: 'Detail',
    component: Detail
  },
  {
    path: '/list',
    name: 'List',
    component: List
  },
  {
    path: '/update',
    name: 'Update',
    component: Update
  },
  
]

const router = new VueRouter({
  mode: 'history',
  routes
})

export default router
