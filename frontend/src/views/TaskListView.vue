<script setup>
import { useRoute } from 'vue-router'
import TaskListPriority from '../components/TaskListPriority.vue';

const	route = useRoute();
const	priority = route.params.priority;
const	modal = (route.params.modal === "true") || false;
const	action = route.params.action || "";

</script>

<template>
	<TaskListPriority :priority="priority" :modal="modal" :action="action"/>
</template>