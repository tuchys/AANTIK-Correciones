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
          <h3>Gestor de docentes</h3>
        </div>
        Ingrese aquí para agregar docentes de forma masiva
        por medio de un archivo excel
        <router-link to="/CargaMasivaDoc">
        <button type="submit" class="btn btn-dark btn-lg btn-block">
        Agregar docentes </button></router-link><br>
        Ingrese aquí para agregar un docente individual
        <router-link to="/addDocentes">
        <button type="submit" class="btn btn-dark btn-lg btn-block">
        Agregar docente</button></router-link><br>
        <br>
        
        Listado de docentes actuales 
           
        <br>
        <div>
          <b-table striped hover id="pages-table" :items="items" :fields="fields">
           <!-- <template #cell(Editar)="row">
              <router-link to="/CdocEdit">
              <b-button class="mr-2">Editar/Ver
              </b-button></router-link>
            </template>
            <template #cell(Eliminar)="row">
              <b-button class="mr-2">Eliminar
              </b-button>
            </template>-->
          </b-table>
        </div>
        <br>
        
              </b-col>
              <b-col>
              
              </b-col>
            </b-row>
          </b-container>   
        </template>

<script>
import SidebarMenuAkahon from "@/components/SideBarCoord.vue"
import axios from 'axios'
export default {
  name: 'docentesCord',
  props: {
    msg: String
  },
   components: {
    SidebarMenuAkahon,
  },
  methods: {
    update(data) {
      // I need to disable the button here
      this.output = data;
      data.item.name = "Dave";
      this.$refs["btn" + data.index].disabled = true      
    }
  },
  data() {
      return {
        items: [],
        fields: [
          {
            key: "id",
            label: "ID",
            sortable: true
          },
          { key: "nombre" },
          { key: "correo" },
          { key: "asignatura" },
          { key: "vinculacion", label:"Vinculación" }
        ]
      }      
  },
  mounted(){
    axios.get("http://localhost:8080/getDoc").then((response)=>{
     console.log(response)
      this.items=response.data;
      
    });
},
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
