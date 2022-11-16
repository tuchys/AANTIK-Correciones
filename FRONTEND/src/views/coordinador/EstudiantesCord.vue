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
          <h3>Gestor de estudiantes</h3>
        </div>
        Ingrese aquí para agregar estudiantes preinscritos de forma masiva
        por medio de un archivo .csv
        <router-link to="/subirFile">
        <button type="submit" class="btn btn-dark btn-lg btn-block">
        Agregar estudiantes preinscritos</button></router-link><br>
        Ingrese aquí para agregar un estudiante individual
        <router-link to="/agregarStd">
        <button type="submit" class="btn btn-dark btn-lg btn-block">
        Agregar estudiante</button></router-link><br>
        <br>

        Listado de estudiantes preinscritos
        <br>
        <div>
          <b-table striped hover :items="items2" :fields="fields2">
            <template #cell(Editar)="row">
              <router-link to="/CpreEdit">
              <b-button class="mr-2">Editar
              </b-button></router-link>
            </template>
            <template #cell(Eliminar)="row">
              <b-button class="mr-2">Eliminar
              </b-button>
            </template>
          </b-table>
        </div>
        Listado de estudiantes inscritos
           
           <br>
           <div>
             <b-table striped hover id="pages-table" :items="items" :fields="fields">
               <template #cell(Editar)="row">
                <router-link to="/CstuEdit">
                 <b-button class="mr-2">Editar
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
import SidebarMenuAkahon from "@/components/SideBarCoord.vue"

export default {
  name: 'estudiantesCord',
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
          { ID: 40, Nombres: 'Dickerson', Apellido: 'Macdonald', Asignatura: '2353001', Clase: '4202', Emprendimiento: 'emprendimiento 2' },
          { ID: 21, Nombres: 'Larsen', Apellido: 'Shaw', Asignatura: '2353001', Clase: '4202' },
          { ID: 89, Nombres: 'Geneva', Apellido: 'Wilson', Asignatura: '2353001', Clase: '4206', Emprendimiento: 'emprendimiento 2' },
          { ID: 38, Nombres: 'Jami', Apellido: 'Carney', Asignatura: '2353001', Clase: '4208', Emprendimiento: 'emprendimiento 1',isActive: true }
        ],
        items2: [
          { ID: 40, Nombres: 'Dickerson', Apellido: 'Macdonald', Asignatura: '2353001', Requisitos: 'Satisfecho' },
          { ID: 21, Nombres: 'Larsen', Apellido: 'Shaw', Asignatura: '2353001', Requisitos: 'Pendiente' },
          { ID: 89, Nombres: 'Geneva', Apellido: 'Wilson', Asignatura: '2353001', Requisitos: 'Pendiente' },
          { ID: 38, Nombres: 'Jami', Apellido: 'Carney', Asignatura: '2353001', Requisitos: 'Satisfecho' }
        ],fields: [
          {
            key: "ID",
            label: "ID",
            sortable: true
          },
          { key: "Nombres" },
          { key: "Apellido" },
          { key: "Asignatura" },
          { key: "Clase" },
          { key: "Emprendimiento" },
          { key: "Editar" },
          { key: "Eliminar" }
        ],fields2: [
          {
            key: "ID",
            label: "ID",
            sortable: true
          },
          { key: "Nombres" },
          { key: "Apellido" },
          { key: "Asignatura" },
          { key: "Requisitos" },
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
