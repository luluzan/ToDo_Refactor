<script setup>
import DeleteButton from "../components/DeleteButton.vue";
import PriorityDropdown from '../components/PriorityDropdown.vue'
import CompleteButton from '../components/CompleteButton.vue'
import Calendar from "./Calendar.vue";

const titleAdd = "Add Task";
const titleEdit = "Edit Task";

const props = defineProps({
  title: {
    type: String,
  },
});
</script>

<template>
  <main class="mainContainer">
    <div id="top">
      <h2>{{ titleAdd }}</h2>

      <svg
        class="closeButton"
        xmlns="http://www.w3.org/2000/svg"
        width="15"
        height="15"
        viewBox="0 0 15 15"
        fill="none"
      >
        <path
          d="M10.3432 7.5L14.6075 3.23565C15.1308 2.71236 15.1308 1.86392 14.6075 1.3402L13.6598 0.392472C13.1365 -0.130824 12.2881 -0.130824 11.7643 0.392472L7.5 4.65682L3.23565 0.392472C2.71236 -0.130824 1.86392 -0.130824 1.3402 0.392472L0.392472 1.3402C-0.130824 1.86349 -0.130824 2.71193 0.392472 3.23565L4.65682 7.5L0.392472 11.7643C-0.130824 12.2876 -0.130824 13.1361 0.392472 13.6598L1.3402 14.6075C1.86349 15.1308 2.71236 15.1308 3.23565 14.6075L7.5 10.3432L11.7643 14.6075C12.2876 15.1308 13.1365 15.1308 13.6598 14.6075L14.6075 13.6598C15.1308 13.1365 15.1308 12.2881 14.6075 11.7643L10.3432 7.5Z"
          fill="white"
        />
      </svg>

      <h3>Task</h3>
      <input type="text" placeholder="This field is required" />

      <h3>Description (Optional)</h3>
      <input type="text" placeholder="Enter Description" />
      <div>
        <CompleteButton fill="#FF9E13"/>
      </div>
    </div>

    <div id="bottom">
      <svg
        xmlns="http://www.w3.org/2000/svg"
        width="20"
        height="23"
        viewBox="0 0 20 23"
        fill="none"
      >
        <path
          d="M17.8571 2.85714H15.7143V0.535714C15.7143 0.241071 15.4732 0 15.1786 0H13.3929C13.0982 0 12.8571 0.241071 12.8571 0.535714V2.85714H7.14286V0.535714C7.14286 0.241071 6.90179 0 6.60714 0H4.82143C4.52679 0 4.28571 0.241071 4.28571 0.535714V2.85714H2.14286C0.959821 2.85714 0 3.81696 0 5V20.7143C0 21.8973 0.959821 22.8571 2.14286 22.8571H17.8571C19.0402 22.8571 20 21.8973 20 20.7143V5C20 3.81696 19.0402 2.85714 17.8571 2.85714ZM17.5893 20.7143H2.41071C2.26339 20.7143 2.14286 20.5938 2.14286 20.4464V7.14286H17.8571V20.4464C17.8571 20.5938 17.7366 20.7143 17.5893 20.7143Z"
          fill="black"
        />
      </svg>

      <h3>Due Date</h3>
      <Calendar />
      <p>This field is required</p>

      <svg
        xmlns="http://www.w3.org/2000/svg"
        width="5"
        height="16"
        viewBox="0 0 5 16"
        fill="none"
      >
        <path
          d="M5 13.5C5 14.8785 3.8785 16 2.5 16C1.1215 16 0 14.8785 0 13.5C0 12.1215 1.1215 11 2.5 11C3.8785 11 5 12.1215 5 13.5ZM0.289375 0.787469L0.714375 9.28747C0.734344 9.68663 1.06378 10 1.46344 10H3.53656C3.93622 10 4.26566 9.68663 4.28562 9.28747L4.71063 0.787469C4.73203 0.359062 4.3905 0 3.96156 0H1.03844C0.6095 0 0.267969 0.359062 0.289375 0.787469Z"
          fill="black"
        />
      </svg>

      <h3>Priority</h3>
      

      <PriorityDropdown />

      <DeleteButton />
    </div>
  </main>
</template>

<style scoped>
.mainContainer {
  width: 26.875rem;
  height: 58.25rem;
  overflow: hidden;
  background: #f5f5f5;
}

#top {
  width: 26.875rem;
  height: 20.5625rem;
  background: #dd4b39;
  flex-shrink: 0;
}

.closeButton {
  width: 0.9375rem;
  height: 0.9375rem;
  flex-shrink: 0;
}
</style>
