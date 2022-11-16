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
          <h3>Gestor de grupos de clase</h3>
        </div>
        Ingrese aquí para agregar un grupo de clase
        <router-link to="/addGrupoClass">
        <button type="submit" class="btn btn-dark btn-lg btn-block">
        Agregar grupo de clase</button></router-link><br>
        
        <br>
        Listado de grupos de clase del ciclo
           
        <br>
        <div>
          <b-table striped hover id="pages-table" :items="items" :fields="fields">
            <template #cell(Editar)="row">
              <router-link to="/classEdit">
              <b-button class="mr-2">Editar/Ver
              </b-button></router-link>
            </template>
            <template #cell(Eliminar)="row">
              <b-button class="mr-2">Elminar
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
  name: 'addGrupoClass',
  props: {
    msg: String
  },
   components: {
    SidebarMenuAkahon,
  },
  methods: {
    search() {
      
    },
    update(data) {
      // I need to disable the button here
      this.output = data;
      data.item.name = "Dave";
      this.$refs["btn" + data.index].disabled = true      
    }
  },
  data() {
      return {
        items: [
          { ID: 40, Asignatura: '2353001', Docente: 'Clara Mabel', cupDis:'10', cupAsig:'22',cuposT:'32'},
          { ID: 40, Asignatura: '2353001', Docente: 'Clara Mabel', cupDis:'11', cupAsig:'21',cuposT:'32'},
          { ID: 40, Asignatura: '2353001', Docente: 'Clara Mabel', cupDis:'5', cupAsig:'27',cuposT:'32'},
          { ID: 40, Asignatura: '2353001', Docente: 'Clara Mabel', cupDis:'2', cupAsig:'30',cuposT:'32'}
        ],fields: [
          {
            key: "ID",
            label: "ID",
            sortable: true
          },
          { key: "Asignatura" },
          { key: "Docente" },
          { key: "cupDis", label:"Cupos disponibles" },
          { key: "cupAsig", label:"Cupos asignados" },
          { key: "cuposT", label:"Cupos totales" },
          { key: "Editar" },
          { key: "Eliminar" }
        ]
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
