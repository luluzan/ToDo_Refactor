<script setup> //This component is to be used when dealing with categories
import { onBeforeMount, ref } from 'vue';

import GetTasks from '../services/ApiConnection'
import TaskSelection from './TaskSelection.vue'
import AddButton from './AddButton.vue'
import CloseButton from './CloseButton.vue';

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
}
)

</script>

<template>
	<main class="task-list-layout">
		<header class="task-list-header">
			<CloseButton path="/" />
		</header>
		<section class = "list">
			<article class="title">
				<h2>{{ category }}</h2>
			</article>
			<section v-if="tasks.data" class="tasks">
				<article class="task" v-for="task in tasks.data" :key="task.id">
					<TaskSelection :task="task"/>
				</article>
			</section>
			<section v-else>
				<h3>No tasks added to this list</h3>
			</section>
		</section>
		<article class="add-button">
			<AddButton />
		</article>
	</main>
</template>

<style scoped>

	.task-list-header
	{
		display: flex;
		justify-content: end;
	}
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
