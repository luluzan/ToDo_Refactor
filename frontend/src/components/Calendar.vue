<script>
import { ref } from "vue";
import VueDatePicker from "@vuepic/vue-datepicker";
import "@vuepic/vue-datepicker/dist/main.css";

export default {
  components: { VueDatePicker },
  setup() {
    const date = ref();

    return {
      date,
    };
  },
};
</script>

<template>
  <VueDatePicker v-model="date"></VueDatePicker>
</template>

