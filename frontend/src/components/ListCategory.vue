<script setup>
import StatusSelector from "../components/StatusSelector.vue"
import DetailsButton from "../components/DetailsButton.vue"

const props = defineProps({
  priority: {
    type:String,
  },
  tasks:{
    type: Object,
    
  }
})

console.log(props.tasks);

</script>
<template>
  <main>
    <div class="rectangle-color" :class=props.priority>
      <div class="rectangle-category">
        <h2 class="categories-list"> {{props.priority}}</h2>
        <DetailsButton :priority="props.priority"></DetailsButton>          
      </div>
      <div class="tasks-list">
        <ul v-for="(task, index) in props.tasks">
          <li v-if="task.priority ==='props.priority'" :key="index">
            <StatusSelector :id="task.id" :status="task.status"></StatusSelector>/>
            {{ task.title }} - {{ task.priority }} - {{ task.dueDate }}
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
  background-color: rgba(58, 47, 132, 1);
  width: 120%;
  border-radius:0.7rem;
}

.urgent{
  border:red solid 0.0625rem;
  background-color:red;
}

.high{
  border:yellow solid 0.0625rem;
  background-color:yellow;
}

.normal{
  border:green solid 0.0625rem;
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