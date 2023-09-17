import { createRouter, createWebHistory } from 'vue-router'
import ProductsView from "@/modules/products/views/ProductsView.vue";
import Sidebar from "@/modules/global/components/Sidebar.vue";

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
     path: '/',
      name: 'Products',
      components: {
        aside: Sidebar,
        default: ProductsView
    }
  }
  ]
})

export default router
