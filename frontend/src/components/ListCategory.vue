<script setup>
import StatusSelector from "../components/StatusSelector.vue"
import DetailsButton from "../components/DetailsButton.vue"


const props = defineProps({
  priority: {
    type:String,
  },
  tasks:{
    type: Object,
    
  },
  title:{
    type:String,
  }
})


</script>
<template>
  <main>
    <div class="rectangle-color" :class=priority>
      <div class="rectangle-category">
        <h2 class="categories-list"> {{title}}</h2>
        <DetailsButton :priority="priority"></DetailsButton>          
      </div>
        <div class="tasks-list scrollbar">
          <ul v-for="(task, index) in tasks" :key="index">
            <li v-if="task.priority ===priority" >
              <StatusSelector :id="task.id" :status="task.status"></StatusSelector>
              {{ task.title }}
            </li>
          </ul>
      </div>
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
.rectangle-color{
  margin-top:3.5rem;
  width: 20rem;
  border-radius:0.7rem;
}

.urgent{
  border:rgba(58, 47, 132, 1) solid 0.0625rem;
  background-color:rgba(58, 47, 132, 1);
}

.high{
  border:rgba(255, 158, 19, 1) solid 0.0625rem;
  background-color:rgba(255, 158, 19, 1);
}

.normal{
  border:rgba(50, 201, 83, 1) solid 0.0625rem;
  background-color:rgba(50, 201, 83, 1);
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
  font: normal 700 1.5rem "Inter";
  color:rgba(255, 255, 255, 1);
  line-height: normal;
  margin-right: 0.8rem;
}

.tasks-list{
  overflow-y: scroll;
  height: 40vh;
  padding-right:0.5rem;
}

ul {
  list-style: none;
  margin-top:0.9rem;
}

li{
  color: #FFF;
  font-family: normal 700 1.25rem "Inter";
}

/* total width */
.scrollbar::-webkit-scrollbar {
  width: 16px;
}

/* background of the scrollbar except button or resizer */
.scrollbar::-webkit-scrollbar-track {
  background-color: transparent; 
}

/* scrollbar itself */
.scrollbar::-webkit-scrollbar-thumb {
    background-color: rgba(186, 186, 192, 0.5); 
    border-radius: 16px;
    border: 5px solid transparent; 
}

/* Set button (top and bottom of the scrollbar) */
.scrollbar::-webkit-scrollbar-button {
  display: none;
}

</style>