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
	<main class="task-list-layout">
		<header>
			<p>The X goes here</p>
		</header>
		<section class = "list">
			<article class="title">
				<h2>{{ category }}</h2>
			</article>
			<section class="tasks">
				<article class="task" v-for="task in tasks.data" :key="task.id">
					<TaskSelection :task="task"/>
				</article>
			</section>
		</section>
		<article class="add-button">
			<AddButton :id="lastId"/>
		</article>
	</main>
</template>

<style scoped>
	.task-list-layout
	{
		display: flex;
		flex-direction: column;
		justify-content: space-around;
		height: 100vh;
	}

	.title
	{
		margin: 1rem 0;
	}

	.tasks
	{
		overflow-y: scroll;
		height: 60vh;
	}

	.add-button
	{
		display: flex;
		justify-content: center;
	}

</style>
