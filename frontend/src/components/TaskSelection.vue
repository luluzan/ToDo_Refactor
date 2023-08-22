<script setup>
import StatusSelector from './StatusSelector.vue'

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
			<StatusSelector :id="task.id"/>
		</section>
		<section class="task-info">
			<h3>{{ task.title }}</h3>
			<p v-if="task.description">{{ task.description }}</p>
			<p>{{ task.dueDate }}</p>
			<p>{{ task.priority }}</p>
		</section>
		<section class="task-edit">
			<button>B</button>
		</section>
	</main>
</template>

<style scoped>
	.task-container
	{
		display: flex;
	}

	.task-selector, .task-edit
	{
		width: 10%;
	}
	.task-info
	{
		width: 80%;
	}
</style>