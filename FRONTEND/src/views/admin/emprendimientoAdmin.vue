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
          <h3>Gestor de emprendimientos</h3>
        </div>
        Ingrese aquí para agregar emprendimientos de forma masiva
        por medio de un archivo excel
        <router-link to="/subirFile">
        <button type="submit" class="btn btn-dark btn-lg btn-block">
        Agregar emprendimientos</button></router-link><br>
        Ingrese aquí para agregar un emprendimiento individual
        <router-link to="/addemprendimientos">
        <button type="submit" class="btn btn-dark btn-lg btn-block">
        Agregar emprendimiento</button></router-link><br>
        <br>
        Listado de emprendimientos inscritos
           
        <br>
        <div>
          <b-table striped hover id="pages-table" :items="items" :fields="fields">
            <template #cell(EditarVer)="row">
              <router-link to="/empEdit">
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
          { ID: 40, Emprendimiento: 'Ruta Turismo Social', Organizacion: 'Fundacion Buena Semilla', Localidad: 'Candelaria', Interlocutor: 'Guadalupe Orjuela Ayala' },
          { ID: 47, Emprendimiento: 'Taller Tejidos', Organizacion: 'Fundacion Buena Semilla-', Localidad: 'Candelaria', Interlocutor: 'Guadalupe Orjuela Ayala' },
          { ID: 45, Emprendimiento: 'ClockChain', Organizacion: 'Fundación Vida en Acción', Localidad: 'Puente Aranda', Interlocutor: 'Elizabeth Maffiold' },
          { ID: 4, Emprendimiento: 'Importaciones Radida.cap', Organizacion: 'Fundación Vida en Acción', Localidad: 'Puente Aranda', Interlocutor: 'Paola Pantano' }
        ],
        fields: [
          {
            key: "ID",
            label: "ID",
            sortable: true
          },
          { key: "Emprendimiento" },
          { key: "Organizacion" },
          { key: "Localidad" },
          { key: "Interlocutor" },
          { key: "EditarVer" },
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
