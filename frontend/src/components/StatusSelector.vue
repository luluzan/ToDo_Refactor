<script setup>
import { onBeforeMount, ref } from "vue";
import GetTasks from "../services/ApiConnection"

	const	props = defineProps (
		{
			id:
			{
				type: Number,
			},
			status:
			{
				type: Boolean,
			}
		}
	)


	const	getTasks = new GetTasks();
	
	const	ftStatusChange = async() =>
	{
		const task = await getTasks.getTaskById(props.id);
		task.value.data.status = !task.value.data.status;
		await getTasks.updateTask(props.id, task.value.data);
	}

</script>

<template>
	<input v-if="props.status" type="checkbox" @change="ftStatusChange()" checked>
	<input v-else type="checkbox" @change="ftStatusChange()">
</template>