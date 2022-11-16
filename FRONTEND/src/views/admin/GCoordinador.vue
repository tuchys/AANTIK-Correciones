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
          <h3>Gestor de coordinadores de asignatura</h3>
          <label-edit :text="text" id="labeledit1" v-on:text-updated="textUpdated" placeholder="Enter some text"></label-edit>
        </div>
        Ingrese aquí para agregar un coordinador de asignatura 
        <router-link to="/addCoord">
        <button type="submit" class="btn btn-dark btn-lg btn-block">
        Agregar coordinador</button></router-link><br>
        <br>
        Listado de coordinadores actuales 
        <br>
        <div>
          <b-table striped hover id="pages-table" :items="items" :fields="fields">
            <template #cell(Editar)="row">
              <router-link to="/coordEdit">
              <b-button class="mr-2">Editar/Ver
              </b-button></router-link>
            </template>
            <template #cell(Eliminar)="row">
              <b-button class="mr-2">Eliminar
              </b-button>
            </template>
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
import SidebarMenuAkahon from "@/components/SideBar.vue"

export default {
  name: 'Homecoordinador',
  props: {
    msg: String
  },
   components: {
    SidebarMenuAkahon,
  },
  data() {
      return {
        items: [
          { ID: 40, Nombres: 'Dickerson', Apellido: 'Macdonald', Asignatura: 'PSU' },
          { ID: 21, Nombres: 'Larsen', Apellido: 'Shaw', Asignatura: 'PSU' },
          { ID: 89, Nombres: 'Geneva', Apellido: 'Wilson', Asignatura: 'CDIO' },
          { ID: 38, Nombres: 'Jami', Apellido: 'Carney', Asignatura: 'CDIO'}
        ],
        fields: [
          {
            key: "ID",
            label: "ID",
            sortable: true
          },
          { key: "Nombres" },
          { key: "Apellido" },
          { key: "Asignatura" },
          { key: "Editar" },
          { key: "Eliminar" }
        ]
      }      
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
