<script setup>
const props = defineProps({
    fill: {
        type: String
    }
})
</script>

<template>
    <svg
          xmlns="http://www.w3.org/2000/svg"
          width="80"
          height="80"
          viewBox="0 0 80 80"
          fill="none"
          class="complete-btn"
        >
          <circle cx="40" cy="40" r="40" :fill="fill" />
          <path
            d="M53.8352 18.8437L17.6204 39.7366C16.2062 40.5492 16.3859 42.5181 17.7923 43.112L26.0979 46.5967L48.5456 26.8133C48.9753 26.4305 49.5848 27.0165 49.2175 27.4618L30.3952 50.394V56.6837C30.3952 58.5277 32.622 59.2543 33.7159 57.9182L38.6774 51.8785L48.4128 55.9571C49.5223 56.4259 50.788 55.7305 50.9912 54.5351L56.6168 20.7814C56.8824 19.2031 55.1869 18.0624 53.8352 18.8437Z"
            fill="white"
          />
        </svg>
</template>

<style scoped>
.complete-btn {
  cursor: pointer;
}

@media (min-width: 368px) {
  .complete-btn {
    margin: -40px 0 0 75%;
  }
}

@media (min-width: 568px) {
  .complete-btn {
    margin: -40px 0 0 80%;
  }
}

@media (min-width: 768px) {
    .complete-btn {
      margin: -40px 0 0 85%;
    }
  }

@media (min-width: 1024px) {
  .complete-btn {
    margin: -40px 0 0 90%;
  }
}
</style>