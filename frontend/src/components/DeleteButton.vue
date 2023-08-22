<script setup></script>

<template>
        <button class="deleteButton">Delete Task</button>
</template>

<style scoped>
    .deleteButton {
        width: 12.8125rem;
        height: 3.75rem;
        border-radius: 0.625rem;
        background: #DC2626;
        flex-shrink: 0;
        border: none;
        color: #fff;
    }

    .deleteButton:hover {
        transition: all .2s ease-in-out;
        transform: scale(1.1);
    }
</style>