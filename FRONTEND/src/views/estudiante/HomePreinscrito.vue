<template>
  <b-container>  
       <div>
          <sidebar-menu-akahon 
            @search-input-emit="search"
          />
        </div> 
    <b-row>
      <b-col>
        <br>
        <div class="hello">
          <h3>Se encuentra preinscrito en el ciclo '2022-03'</h3>
          <label-edit :text="text" id="labeledit1" v-on:text-updated="textUpdated" placeholder="Enter some text"></label-edit>
        </div><br>
        Es importante que verifique sus datos y los actualice
        <router-link to="/datosPre">
        <button type="submit" class="btn btn-dark btn-lg btn-block">
        Actualizar datos</button></router-link>
        <br>
        
        La asignación de emprendimientos se realizará por medio de la personalización 
        para esto debe llenar el formulario que se encuentra aquí
        <router-link to="/encuesta">
        <button type="submit" class="btn btn-dark btn-lg btn-block">
          Formato de personalización</button></router-link>
          <br>

        Verifique el cumplimiento de sus requisitos, en caso de haber algún error 
        comuniquese con el/la coordinador/a de la asignatura.
        <router-link to="/reqEs">
        <button type="submit" class="btn btn-dark btn-lg btn-block">
        Consultar requisitos</button></router-link>
      </b-col>
      <b-col>
        
      </b-col>
    </b-row>
  </b-container>   
</template>

<script>
import SidebarMenuAkahon from "@/components/SideBarPreIns.vue"

export default {
  name: 'preinscHome',
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
