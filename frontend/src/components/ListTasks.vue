<script setup>
import StatusSelector from "../components/StatusSelector.vue"
import ApiConnection from '../services/ApiConnection';
import DetailsButton from "./DetailsButton.vue";
import ListCategory from "./ListCategory.vue";
import { Carousel, Slide, Pagination, Navigation } from 'vue3-carousel'
import 'vue3-carousel/dist/carousel.css'
import { ref, onBeforeMount } from 'vue';

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

let emit = defineEmits(['sendPriority']);

function EmitPriority(priority){ 
    emit('sendPriority', priority);
}

</script>

<template>

  <main class="main-container">
  
    <header>
      <h1>To do List</h1>
    </header>
  
    <div class="categories">  
      <p class="categories-title">My To do´s</p>
      <div class="ico-addTask">
        <svg width="61" height="56" viewBox="0 0 61 56" fill="none" xmlns="http://www.w3.org/2000/svg">
        <rect width="61" height="56" rx="5" fill="#DF373B"/>
          <path d="M43.8571 24.7857H34.2143V15.1429C34.2143 13.9596 33.2547 13 32.0714 13H29.9286C28.7453 13 27.7857 13.9596 27.7857 15.1429V24.7857H18.1429C16.9596 24.7857 16 25.7453 16 26.9286V29.0714C16 30.2547 16.9596 31.2143 18.1429 31.2143H27.7857V40.8571C27.7857 42.0404 28.7453 43 29.9286 43H32.0714C33.2547 43 34.2143 42.0404 34.2143 40.8571V31.2143H43.8571C45.0404 31.2143 46 30.2547 46 29.0714V26.9286C46 25.7453 45.0404 24.7857 43.8571 24.7857Z" fill="white"/>
        </svg>
      </div>
    </div>

    <div class="rectangles-categories">
    </div>
      <Carousel>
        <Slide v-for="slide in 3" :key="slide">
          <div class="carousel__item">
            <div class="rectangle-color color-red">
              <div class="rectangle-category">
                <h2 class="categories-list">Muy Urgente</h2>
                <DetailsButton path="/"  @click="EmitPriority('veryhigh')"></DetailsButton>
              </div>
              <div class="tasks-list">
                <ul v-for="(task, index) in tasks">
                  <li v-if="task.priority ==='veryhigh'" :key="index">
                    <!--<StatusSelector></StatusSelector>-->
                    {{ task.title }} - {{ task.priority }} - {{ task.dueDate }}
                  </li>
                </ul>
              </div>
            </div>  
          </div>
          <div class="carousel__item">
            <div class="rectangle-color color-orange">
              <div class="rectangle-category">
                <h2 class="categories-list">Urgente</h2>
                <DetailsButton path="/"  @click="EmitPriority('high')"></DetailsButton>
              </div>
              <div class="tasks-list">
                <ul v-for="(task, index) in tasks">
                  <li v-if="task.priority ==='high'" :key="index">
                  {{ task.title }} - {{ task.priority }} - {{ task.dueDate }}
                  </li>
                </ul>
              </div>
            </div>
          </div>
          <div class="carousel__item">
            <div class="rectangle-color color-green">
            <div class="rectangle-category">
              <h2 class="categories-list">Normal</h2>
              <DetailsButton path="/" @click="EmitPriority('normal')"></DetailsButton>
            </div>
            <div class="tasks-list">
              <ul v-for="(task, index) in tasks">
                <li v-if="task.priority ==='normal'" :key="index">
                <!--<StatusSelector ></StatusSelector>-->
                {{ task.title }} - {{ task.priority }} - {{ task.dueDate }}
                </li>
              </ul>
            </div>
          </div>
          </div>
        </Slide>

        <template #addons>
          <Navigation />
          <Pagination />
        </template>

      </Carousel>

  </main>
  
</template>

<style scoped>
.main-container{
  background: #F5F5F5;
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

.categories{
  display:flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  margin-top: 8.3125rem;
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
.rectangle-color{
  margin-top:3.5rem;
  background-color: rgba(58, 47, 132, 1);
  width: 21.5rem;
  height: 35.375rem;
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
.rectangles-categories{
  display:flex;
  flex-direction: column;
  justify-content: left;
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

</style>
