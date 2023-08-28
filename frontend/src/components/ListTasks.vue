<script setup>
import ApiConnection from '../services/ApiConnection';
import ListCategory from "./ListCategory.vue";
import { Carousel, Slide, Pagination, Navigation } from 'vue3-carousel'
import 'vue3-carousel/dist/carousel.css'
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
    console.table(response.data);
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
      <ListCategory :priority="'urgent'" :tasks="tasks"></ListCategory>
      <ListCategory :priority="'high'" :tasks="tasks"></ListCategory>
      <ListCategory :priority="'normal'" :tasks="tasks"></ListCategory>
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
  background: rgba(220, 38, 38, 1);
}

h1{
  font: normal 700 1.5rem "Inter";
  color:rgba(255, 255, 255, 1);
}
.new-task{
  color: rgba(255, 0, 0, 1);
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
  width: auto;
}

.carousel__item {
  min-height: 200px;
  width: 100%;
  font-size: 20px;
  border-radius: 8px;
  display: flex;
  justify-content: center;
  align-items: center;
}

.carousel__slide {
  padding: 10px;
}

.carousel__prev,
.carousel__next {
  box-sizing: content-box;
  border: 5px solid white;
}

/*
.rectangle-color{
  margin-top:3.5rem;
  background-color: rgba(58, 47, 132, 1);
  width: 21.5rem;
  border:rgba(58, 47, 132, 1) solid 0.0625rem;
  border-radius:0.7rem;
}

.color-red{
  background-color:red;
  border-color:red;
}

.color-orange{
  background-color:orangered;
  border-color:orangered;
}

.color-green{
  background-color:green;
  border-color:green;
}

.rectangle-category{
  display: flex;
  flex-direction: row;
  justify-content: center;
  flex-wrap: wrap;
  align-items: center;
  border-bottom: rgba(245, 245, 245, 1) solid 0.0955rem;
  height: 4rem;
}

.categories-list{
  display:flex;
  flex-direction:row;
  flex-wrap:wrap;
  justify-content: center;
  padding:0.05rem;
  font: normal 700 0.8rem "Inter";
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
  font-family: normal 700 1.25rem "Inter";
  display:flex;
  flex-wrap:wrap;
  justify-content: center;
  padding-left:0;
  padding-right:0.25rem;
}
*/

</style>
