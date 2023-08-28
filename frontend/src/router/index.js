import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'
import AddView from '../views/AddView.vue'
import EditView from '../views/EditView.vue'
import TaskListView from '../views/TaskListView.vue'


const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'home',
      component: HomeView
    },
    {
      path: '/add',
      name: 'AddTask',
      component: AddView
    },
    {
      path: '/edit',
      name: 'EditTask',
      component: EditView
    },
	{
		path: '/list/:priority',
		name: 'TaskList',
		component: TaskListView
	}
  ]
})

export default router
