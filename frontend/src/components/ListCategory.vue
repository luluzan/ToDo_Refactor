<script setup>
import StatusSelector from "../components/StatusSelector.vue"
import ApiConnection from '../services/ApiConnection';
import DetailsButton from '../components/DetailsButton.vue';
import { ref, onBeforeMount, computed } from 'vue';

const tasks = ref([]);

function getTasks() {
    ApiConnection.getAllTasks()
        .then(response => {
          tasks.value = response.data;
          tasks.value.sort(((a, b) => {
            const orderPriority = {veryhigh: 1, high: 2, normal: 3};
            const orderByPriority = orderPriority[a.priority] - orderPriority[b.priority];
            const orderByDate = new Date(a.dueDate).getDate() - new Date(b.dueDate).getDate();
            return (orderByPriority === 0 ? orderByDate : orderByPriority);
          }));
          console.table(response.data);
        })
        .catch(e => {
            console.log(e);
        });
}

onBeforeMount(() => {
  getTasks();
})


let emit = defineEmits(['sendId']);

function EmitId(id){ 
    emit('sendId', id);
}

const props = defineProps({
  fill: {
    type: String
  },
  priority: {
    type:String
  }
})

let fillClass = computed(() => {
  return props.fill;
});

let priorityClass = computed(() => {
  return props.priority;
});

</script>
<template>
  <main>
    <div class="rectangle-color" :class="fillClass">
      <div class="rectangle-category">
        <h2 class="categories-list"> priorityClass</h2>
        <DetailsButton path="/"></DetailsButton>          
      </div>
      <div class="tasks-list">
        <ul v-for="(task, index) in tasks">
          <li v-if="task.priority ==='priorityClass'" :key="index" @click="EmitId(task.id)">
          <!--<StatusSelector ></StatusSelector>-->
          {{ task.title }} - {{ task.priority }} - {{ task.dueDate }}
          </li>
        </ul>
      </div>
    </div>
  </main>
</template>
<style scoped>

.rectangle-color{
  margin-top:3.5rem;
  background-color: rgba(58, 47, 132, 1);
  width: 70%;
  height: 35.375rem;
  border:rgba(58, 47, 132, 1) solid 0.0625rem;
  border-radius:0.7rem;
}

.veryhigh{
  background-color:red;
}

.high{
  background-color:yellow;
}

.normal{
  background-color:green;
}

.rectangle-category{
  display: flex;
  flex-direction: row;
  justify-content: center;
  align-items: center;
  border-bottom: rgba(245, 245, 245, 1) solid 0.0955rem;
  height: 3rem;
}

.categories-list{
  flex-shrink: 0;
  font: normal 700 1.5rem Inter;
  color:rgba(255, 255, 255, 1);
  line-height: normal;
  margin-right: 0.8rem;
}

ul {
  list-style: none;
  margin-top:0.9rem;
}

li{
  color: #FFF;
  font-family: normal 700 1.25rem Inter;
}

</style>