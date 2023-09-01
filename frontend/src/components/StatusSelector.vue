<script setup>
import ApiConnection from "../services/ApiConnection"

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


	const	emit = defineEmits(['response']);
	
	const	ftStatusChange = async() =>
	{
		const task = await ApiConnection.getTaskById(props.id);
		task.data.status = !task.data.status;
		await ApiConnection.updateTask(props.id, task.data);
		emit('response', task.data.status);
	}

</script>

<template>
	<input v-if="props.status" type="checkbox" @change="ftStatusChange()" checked>
	<input v-else type="checkbox" @change="ftStatusChange()">
</template>