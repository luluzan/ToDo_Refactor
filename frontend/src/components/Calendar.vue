<script setup>
import { ref, onUpdated } from "vue";
import VueDatePicker from "@vuepic/vue-datepicker";
import "@vuepic/vue-datepicker/dist/main.css";

const date = ref();
let emit = defineEmits(['date'])

onUpdated(() => {
  emit('date', date.value)
})
  

</script>

<template>
  <VueDatePicker v-model="date" modelType="yyyy-MM-dd"></VueDatePicker>
</template>

