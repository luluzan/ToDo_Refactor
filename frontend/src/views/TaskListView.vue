<script setup>
import { RouterLink, RouterView, useRoute } from 'vue-router'
import TaskList from '../components/TaskList.vue'
import TaskListPriority from '../components/TaskListPriority.vue';

const	route = useRoute();
const	priority = route.params.priority;
const	modal = route.params.modal || false;

</script>

<template>
	<!-- <TaskList /> -->
	<TaskListPriority :priority="priority" :modal="modal"/>
</template>