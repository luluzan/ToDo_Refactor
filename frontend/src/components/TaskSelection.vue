<script setup>
import StatusSelector from './StatusSelector.vue'
import EditButton from './EditButton.vue'

defineProps (
	{
		task:
		{
			type: Object,
		}
	}
)

</script>

<template>
	<main class="task-container">
		<section class="status-selector">
			<StatusSelector :id="task.id" :status="task.status"/>
		</section>
		<section class="task-info">
			<h3 v-if="task.status" class="done">{{ task.title }}</h3>
			<h3 v-else>{{ task.title }}</h3>
			<p v-if="task.description">{{ task.description }}</p>
			<p>{{ task.dueDate }}</p>
			<p>{{ task.priority }}</p>
		</section>
		<section class="task-edit">
			<EditButton :id="task.id"/>
		</section>
	</main>
</template>

<style scoped>
	.task-container
	{
		display: flex;
    	align-items: center;
		justify-content: space-around;
    	background-color: white;
    	height: 7rem;
		border-radius: 0.8rem;
		margin: 1rem 0;
	}

	.status-selector, .task-edit
	{
		width: 15%;
	}
	.task-info
	{
		width: 60%;
    	height: 70%;
    	overflow-y: scroll;
	}

	.status-selector
	{
		display: flex;
		justify-content: center;
	}

	.done
	{
		text-decoration: line-through;
	}

</style>