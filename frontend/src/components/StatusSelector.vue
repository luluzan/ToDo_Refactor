<script setup>
import GetTasks from "../services/ApiConnection"

	const	props = defineProps (
		{
			id:
			{
				type: Number,
			}
		}
	)

	const	getTasks = new GetTasks();	
	const	ftStatusChange = async() =>
	{
		const	task = await getTasks.getTaskById(props.id);

		//console.log(task.data.status);
		task.data.status = !task.data.status;
		await getTasks.updateTask(props.id, task.data);
	}

</script>

<template>
	<input type="checkbox" @change="ftStatusChange()">
</template>