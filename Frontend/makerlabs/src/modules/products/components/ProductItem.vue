<script setup>
import { defineProps } from 'vue';
const props = defineProps({
    id: {
        type: Number,
        required: true,
    },
    
    name: {
        type: String,
        default: null
    }
})
</script>

<template> 

</template>

<style scoped>

</style>