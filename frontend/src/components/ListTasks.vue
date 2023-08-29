<script setup>
import ApiConnection from '../services/ApiConnection';
import ListCategory from "./ListCategory.vue";
import { ref, onBeforeMount } from 'vue';
import AddButton from './AddButton.vue';

const tasks = ref([]);
const getTasks = new ApiConnection();

function getAllTasks() {
  getTasks.getAllTasks()
  .then(response => {
    tasks.value = response.data;
    tasks.value.sort(((a, b) => {
      const orderPriority = {urgent: 1, high: 2, normal: 3};
      const orderByPriority = orderPriority[a.priority] - orderPriority[b.priority];
      const orderByDate = new Date(a.dueDate).getDate() - new Date(b.dueDate).getDate();
      return (orderByPriority === 0 ? orderByDate : orderByPriority);
    }));
  })
  .catch(e => {
    console.log(e);
  });
}

onBeforeMount(() => {
  getAllTasks();
})

</script>

<template>

  <main class="main-container">
  
    <header>
      <h1>To do List</h1>
    </header>
  
    <div class="categories">  
      <p class="categories-title">My To do´s</p>
      <div class="ico-addTask">
        <AddButton></AddButton>
      </div>
      <span class="new-task">Add new task</span>
    </div>
   <div class="rectangles-categories">
      <ListCategory :priority="'urgent'" :title="'Urgent'" :tasks="tasks"></ListCategory>
      <ListCategory :priority="'high'" :title="'High'" :tasks="tasks"></ListCategory>
      <ListCategory :priority="'normal'" :title="'Normal'" :tasks="tasks"></ListCategory>
    </div>
   
  </main>
  
</template>

<style scoped>

@font-face 
{
  font-family: "Inter";
  src: local("Inter"),
  url(../src/assets/fonts/Inter/Inter-Regular.ttf) format("truetype");
}
  
.main-container{
  background: #F5F5F5;
  min-height: 58.25rem;
}

header{
  display:flex;
  justify-content: center;
  align-items: center;
  height: 6.25rem;
  background: rgba(221, 75, 57, 1);
}

h1{
  font: normal 700 1.5rem "Inter";
  color:rgba(255, 255, 255, 1);
}
.new-task{
  color: rgba(0, 0, 0, 1);
  font: capitalize 400 1rem normal "Inter";
  margin-top: 1rem;
}
.categories{
  display:flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  margin-top: 5rem;
}

.categories-title{
  font: normal 700 1.875rem "Inter";
  color: rgba(0, 0, 0, 1);
  margin-bottom: 1.985rem;
}

.ico-addTask{
  width: 1.8125rem;
  height: 1.8125rem;
  flex-shrink: 0;
  width: 3.8125rem;
  height: 3.5rem;
}

.rectangles-categories{
  display:flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  width: 100%;
}

</style>
