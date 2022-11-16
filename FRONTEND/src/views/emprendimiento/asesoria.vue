<template>
  <b-container>  
       <div>
          <sidebar-menu-akahon 
            @search-input-emit="search"
          />
        </div> 
    <b-row>
      <b-col>
        <div class="hello">
          <h3>Asesoria</h3>
          <label-edit :text="text" id="labeledit1" v-on:text-updated="textUpdated" placeholder="Enter some text"></label-edit>
        </div>
        <br>
        Consulte su nivel de maduracion organizacional.      
        <button type="submit" class="btn btn-dark btn-lg btn-block">
          Ver nivel</button>
        <br>
        <br>
        Para conocer nuestras sugerencias de estrategias que te pueden generar crecimiento
        relacionadas con su sector económico, ingresa aquí.
        <button type="submit" class="btn btn-dark btn-lg btn-block">
        Benchmarking</button>
        <br>
        <br>
        Si quiere conocer las estrategias sugeridas para crecer en el nivel de maduración, ingresa aquí.
        <button type="submit" class="btn btn-dark btn-lg btn-block">
        Estrategias de maduración</button>
        <br>
      </b-col>
      <b-col>
        
      </b-col>
    </b-row>
  </b-container>   
</template>

<script>
import SidebarMenuAkahon from "@/components/SideBar.vue"

export default {
  name: 'Homecoordinador',
  props: {
    msg: String
  },
   components: {
    SidebarMenuAkahon,
  },
  methods: {
    search() {
      
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h3 {
  margin: 40px 0 0;
}
ul {
  list-style-type: none;
  padding: 0;
}
li {
  display: inline-block;
  margin: 0 10px;
}
a {
  color: #42b983;
}
</style>
