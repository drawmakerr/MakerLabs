<template>
  <v-app>
<NavBar />
<v-container fluid>
  <v-card
        color="red"
        height="180px"
        tile
        flat
        class="d-flex align-center justify-center mt-12"
        dark
      >
        <v-row>
          <v-col cols="12" sm="12">
            <v-item-group mandatory class="mt-n1">
              <v-container>
                <v-row justify="center" class="space">
                  <v-col
                    cols="12"
                    xs="12"
                    sm="4"
                    md="2"
                    v-for="(cetegory, i) in categories"
                    :key="i"
                  >
                    <v-item v-slot="{ active, toggle }">
                      <v-card
                        :color="active ? '#D5F0DB' : 'white'"
                        :class="active ? 'borderme' : 'borderout'"
                        class="d-flex align-center rounded-lg mx-2"
                        dark
                        height="170"
                        @click="toggle"
                        flat
                      >
                        <v-row>
                          <v-col cols="12" sm="12">
                            <v-list-item three-line class="text-center">
                              <v-list-item-content>
                                <div align="center" justify="center">
                                  <v-img
                                    :src="cetegory.img"
                                    max-height="80"
                                    max-width="80"
                                    contain
                                  ></v-img>
                                </div>
                                <v-list-item-subtitle
                                  :class="
                                    active ? 'green--text' : 'black--text'
                                  "
                                  class="caption mt-4"
                                  >{{ cetegory.title }}</v-list-item-subtitle
                                >
                              </v-list-item-content>
                            </v-list-item>
                          </v-col>
                        </v-row>
                      </v-card>
                    </v-item>
                  </v-col>
                </v-row>
              </v-container>
            </v-item-group>
          </v-col>
        </v-row>
      </v-card>
      <v-toolbar color="transparent" dark class="mt-3">
        <v-btn variant="text">Choose Category
          <v-icon right class="ml-2 mt-n1">fas fa-caret-right</v-icon>
        </v-btn>
        <v-divider vertical></v-divider>
        <v-btn variant="text">Color
          <v-icon right class="ml-2 mt-n1">fas fa-caret-right</v-icon>
        </v-btn>
        <v-divider vertical></v-divider>
        <v-btn variant="text">Choose Design
          <v-icon right class="ml-2 mt-n1">fas fa-caret-right</v-icon>
        </v-btn>
        <v-divider vertical></v-divider>
       <span class="text-caption mx-2">Price till 0€</span>
       <v-slider v-model="slider2" label="track-color" class="mt-5"></v-slider>
       <span class="text-caption mx-2">5000€</span>
      </v-toolbar>
      <v-divider class=mt-2></v-divider>
      <v-toolbar color="transparent">
        <v-spacer></v-spacer>
        <v-btn variant="text" color="grey">Sort by :</v-btn>
        <v-btn variant="text" color="">Name</v-btn>
        <v-btn variant="text" color="grey">Popularity</v-btn>
        <v-btn variant="text" color="grey">Price</v-btn>
      </v-toolbar>
      <v-row>
          <v-col cols="12" sm="3" v-for="(design,i) in designs" :key="i" >
              <v-card height="300" align="center" flat outlined tile>
                <v-img :src="design.image" width="200" height="200" contain></v-img>
                <v-card-text class="mt-n1">
                  <strong>{{design.title}}</strong>
                </v-card-text>
                <v-card-text class="mt-n4">
                  <strong>{{design.price}}</strong>
                </v-card-text>
              </v-card>
          </v-col>
      </v-row>
      <v-divider></v-divider>
      <v-toolbar color="transparent">
        <v-toolbar-title class="text-caption">Show more</v-toolbar-title>
        <v-spacer></v-spacer>
        <v-icon color="grey" left class="mr-4 mt-n1">fas fa-long-arrow-alt-left</v-icon>
        <span class="text-caption">3</span>
        <v-icon color="grey" left class="ml-4 mt-n1 mr-2">fas fa-long-arrow-alt-right</v-icon>
      </v-toolbar>
</v-container>
<FooterView />
  </v-app>
  
</template>

<script>
import { defineComponent } from 'vue';

// Components
import NavBar from '@/components/NavBar.vue';
import FooterView from '@/components/FooterView.vue';

export default defineComponent({
  name: 'HomeView',
setup(){
  return {
    design: true,
    other: false,
    slider2: 50,
    categories: [
    { img: "fi1.png", title: "Fiction" },
        { img: "an1.png", title: "Anime" },
        { img: "my1.png", title: "Mythologic" },
        { img: "cl1.png", title: "Classic" },
        { img: "sk1.png", title: "Sketch" },
        { img: "r1.png", title: "Realistic" },
    ],
    designs:[
    {
          class: "pa-0",
          image: "genji1.png",
          title: "Genji Cyberninja",
          price: "145.00€",
        },
        {
          class: "pa-0",
          image: "robot1.png",
          title: "Thor Mecha",
          price: "85.00€",
        },
        {
          class: "pa-0",
          image: "foxghost1.png",
          title: "Ghost Foxy Girl",
          price: "110€",
        },
        {
          class: "pa-0",
          image: "alien1.png",
          title: "Alien Bug",
          price: "50€",
        },
        {
          class: "pa-0",
          image: "alien2.png",
          title: "Sharky Alien",
          price: "60€",
        }
    ]
  }
}, 
  components: {
    NavBar,
    FooterView
},
});
</script>
<style scoped>
  .v-container{
    width: 100%;
    padding: 16px 0px !important;
    margin-right: auto;
    margin-left: auto;
  }
  .v-card.borderme {
    border: 2px solid black !important;
  }
  .v-card.borderout {
    border: 1px solid #d5f0db !important;
  }
</style>