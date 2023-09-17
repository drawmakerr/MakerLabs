import {defineStore} from "pinia";
export const useProductStore = defineStore('products', {
    state: () => ({ 
        products: [],
    }),
    getters: {

    },
    actions: {
     async fetchProducts() {
        await fetch('http://localhost:8080/products/list')
        .then(res => res.json())
        .then(data => {
            this.products = data
        })
      },
    },
  })