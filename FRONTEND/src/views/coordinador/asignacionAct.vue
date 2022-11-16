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
          <h3>Resultado de asignación</h3>
        </div>
        Seleccione aquí para correr el algoritmo de sugerencia de asignaciones
        <router-link to="/asignacionNueva">
        <button type="submit" class="btn btn-dark btn-lg btn-block">
        Sugerir asignaciones</button></router-link><br>
        <br>
        RESULTADOS DEL CICLO # 
        <br><br>
        Estudiantes sin asignar: 2<br>
        Cupos disponibles en emprendimientos: 5
        <br><br>
        Listado de estudiantes asignados
           
        <br>
        <div>
          <b-table striped hover id="pages-table" :items="items" :fields="fields">
            <template #cell(Editar)="row">
              <b-button class="mr-2">Editar
              </b-button>
            </template>
            <template #cell(Eliminar)="row">
              <b-button class="mr-2">Elminar
              </b-button>
            </template>
          </b-table>
        </div>
        <br>
        Listado de estudiantes no asignados
        <br>
        <div>
          <b-table striped hover :items="items2" :fields="fields2">
            <template #cell(Editar)="row">
              <b-button class="mr-2">Editar
              </b-button>
            </template>
            <template #cell(Eliminar)="row">
              <b-button class="mr-2">Elminar
              </b-button>
            </template>
          </b-table>
        </div>
        <br>
        Listado de emprendimientos sin asignar
           
        <br> 
        <div>
          <b-table striped hover :items="items3" :fields="fields3">
            <template #cell(Editar)="row">
              <b-button class="mr-2">Editar
              </b-button>
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
          { ID: 40, Nombres: 'Dickerson', Clase:'2230' , Emprendimiento: 'emprendimiento 2' },
          { ID: 40, Nombres: 'Dickerson', Clase:'2230' , Emprendimiento: 'emprendimiento 2' },
          { ID: 40, Nombres: 'Dickerson', Clase:'2230' , Emprendimiento: 'emprendimiento 2' }
        ],
        items2: [
          { ID: 40, Nombres: 'Dickerson', Clase:'2230', Requisitos:'si'},
          { ID: 40, Nombres: 'Dickerson', Clase:'2230', Requisitos:'si'},
          { ID: 40, Nombres: 'Dickerson', Clase:'2230', Requisitos:'No'}
        ],items3: [
          { ID: 40, Emprendimiento: 'Dickerson', Cuposd:'3', cuposT:'1'},
          { ID: 40, Emprendimiento: 'Dickerson', Cuposd:'3', cuposT:'1'},
          { ID: 40, Emprendimiento: 'Dickerson', Cuposd:'3', cuposT:'1'}
        ],fields: [
          {
            key: "ID",
            label: "ID",
            sortable: true
          },
          { key: "Nombres" },
          { key: "Clase" },
          { key: "Emprendimiento" }
        ],fields2: [
          {
            key: "ID",
            label: "ID",
            sortable: true
          },
          { key: "Nombres" },
          { key: "Clase" },
          { key: "Requisitos" }
        ],fields3: [
          {
            key: "ID",
            label: "ID",
            sortable: true
          },
          { key: "Emprendimiento" },
          { key: "Cuposd", label:"Cupos disponibles" },
          { key: "cuposT", label:"Cupos totales"  }
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
