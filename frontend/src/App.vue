<script setup>
import { RouterLink, RouterView } from 'vue-router'
import TaskListView from './views/TaskListView.vue'
</script>

<template>
  <header>
    <div class="wrapper">
      <nav>
        <RouterLink to="/">Home</RouterLink>
        <RouterLink to="/add">Add Task</RouterLink> 
        <RouterLink to="/edit">Edit Task</RouterLink>
      </nav>
    </div>
  </header>
  <RouterView />
  <TaskListView />
</template>

<style scoped>
</style>