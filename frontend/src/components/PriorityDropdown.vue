<script setup>
import { onUpdated, ref } from 'vue';

const priority = ref('')
let emit = defineEmits(['priority'])

onUpdated(() => {
  emit('priority', priority.value)
})

</script>

<template>
    <div class="dropdown">
        <select v-model="priority"
          class="select-dropdown"
        >
          
          <option value="normal">Normal</option>
          
          <option value="high">Alta Prioridad</option>

          <option value="urgent">Urgente</option>
          </select
        >
      </div>
</template>

<style scoped>
</style>
