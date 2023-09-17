<script setup>
import { useProductStore } from '@/modules/products/store/productStore'
import { onBeforeMount, ref } from 'vue';

const productStore = useProductStore()

onBeforeMount(() => {
    getProducts()
})

const loading = ref(true)

const getProducts = async () => {
   await productStore.fetchProducts()
   loading.value = false
}
</script>

<template>
<div class="content">
    <div v-if="loading" class="lds-dual-ring"></div>
    <div class="content__products" v-else>
        <h1>Patata</h1>
    </div>
</div>
</template>

<style scoped>
.content {
    display: flex;
    flex-direction: column;
    align-items: center;
    padding: 5vh 0;
    overflow-y: auto;
}

.content__products {
    width: 90%;
}

.loading {
    display: flex;
    justify-content: center;
    align-content: center;
    width: 100%;
    height: 100%;
}
</style>