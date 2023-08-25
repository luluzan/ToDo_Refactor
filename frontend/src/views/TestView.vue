<script setup>
import { useRoute } from 'vue-router';

const	route = useRoute();
const	id = route.params.id;

console.log(route.params.id);
</script>

<template>
	<h1>Hola</h1>
	<h2>{{ id }}</h2>
</template>