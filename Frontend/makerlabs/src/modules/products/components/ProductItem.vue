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
<div class="product-card">
    <figure>

    </figure>
    <div class="product-detail">
        <h5>{{ name }}</h5>
    </div>
</div>
</template>

<style scoped>
.product-card {
    display: grid;
    justify-content: center;
    grid-template-columns: 1fr 7fr;
    border: 2px solid #2d2a4c;
    height: 13rem;
}

.product-detail {
    display: flex;
    flex-direction: column;
    justify-content: flex-start;
    align-items: center;
}

.card-img {
    display: flex;
    justify-content: center;
    align-items: center;
    height: 13rem;
    width: 10rem;
    border-right: #2d2a4c solid 2px;
}

.card-img img {
    width: 100%;
    height: auto;
}

@supports (object-fit: cover) {
    .card-img img {
        height: 100%;
        object-fit: cover;
        object-position: center center;
    }
}
</style>