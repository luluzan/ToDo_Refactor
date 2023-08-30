<script setup>
import { RouterLink, RouterView } from 'vue-router'

</script>

<template>
  <header>
    <div class="wrapper">
        <RouterLink to="/"></RouterLink>
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
