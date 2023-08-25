<script setup>
import { onBeforeMount, ref } from 'vue';
import { RouterLink, RouterView } from 'vue-router'
import GetTasks from '../services/ApiConnection'
import TaskSelection from './TaskSelection.vue'
import AddButton from './AddButton.vue'

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
const	lastId = ref();

onBeforeMount( async() => 
{
	tasks.value = await getTasks.getAllTasks();
	lastId.value = tasks.value.data.length + 1;
	console.log(lastId.value);
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
	<article class="add-button">
		<AddButton :id="lastId"/>
	</article>
</template>

<style scoped>
	
	.add-button
	{
		display: flex;
		justify-content: center;
	}
	
</style>
