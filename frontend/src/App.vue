<script setup>
import { RouterLink, RouterView } from 'vue-router'

const	priority = "high";
</script>

<template>
  <header>
    <div class="wrapper">
      <!--<nav> -->
        <RouterLink to="/"></RouterLink>
      <!--
        <RouterLink to="/add">Add Task</RouterLink>
         <RouterLink to="/edit">Edit Task</RouterLink> 
        <RouterLink :to="'/list/' + priority">Task List</RouterLink>
      </nav>-->
    </div>
  </header>
  <RouterView />
</template>

<style scoped>
  @font-face {
    font-family: "Inter";
    src: local("Inter"),
    url(../src/assets/fonts/Inter/Inter-Regular.ttf) format("truetype");
  }
</style>
