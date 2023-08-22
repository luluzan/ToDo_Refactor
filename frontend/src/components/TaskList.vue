<script setup>
import { onBeforeMount, ref } from 'vue';
import { RouterLink, RouterView } from 'vue-router'
import GetTasks from '../services/ApiConnection'
import TaskSelection from './TaskSelection.vue'

defineProps
(
	{
		category:
		{
			type: String,
			default: "My To Do's"
		}
	}
)

const	tasks = ref({});
const	getTasks = new GetTasks();

onBeforeMount( async() => 
{
	tasks.value = await getTasks.getAllTasks();
	console.log(tasks.value.data[0].id);
}
)

</script>

<template>
	<header>
		<h2>{{ category }}</h2>
	</header>
	<article class="task" v-for="task in tasks.data" :key="task.id">
		<TaskSelection :task="task"/>
	</article>
	<main>

	</main>
</template>

<style scoped>

</style>
