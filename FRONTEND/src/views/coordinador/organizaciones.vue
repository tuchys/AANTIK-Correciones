<template>
  <b-container>  
       <div>
          <sidebar-menu-akahon 
            @search-input-emit="search"
          />
        </div> 


        <div class="hello">
          <h3>Gestor de organizaciones sociales</h3>
        </div>
        Ingrese aquí para agregar organizaciones sociales de forma masiva
        por medio de un archivo .csv
        <router-link to="/subirFileOrgSoc">
        <button type="submit" class="btn btn-dark btn-lg btn-block">
        Agregar organizaciones sociales</button></router-link><br>
        Ingrese aquí para agregar una organizacion social de forma individual
        <router-link to="/agregarOrgSoc">
        <button type="submit" class="btn btn-dark btn-lg btn-block">
        Agregar organizacion social</button></router-link><br>
        <br>



            
    <b-row>
      <b-col>
        Listado de organizaciones sociales inscritas
           
        <br>
        <div>
          <b-table striped hover id="pages-table" :items="items" :fields="fields">
            <template #cell(Editar)="row">
              <router-link to="/CorgEdit">
              <b-button class="mr-2">Ver y Editar
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
          { ID: 40, Nombre: 'America Solidaria', email: 'lideresolidariosas@americasolidaria.org',
          tipoOrg: 'Fundación', actEco: 'Servicios', emprendimientos: '2',interlocutor: 'interlo1',
          serProd: 'Talleres, Contactos Ecosistema Emprendimiento-Apoyo financiero' },
          { ID: 21, Nombre: 'Fundacion Buena Semilla', email: 'lu.orjuela@hotmail.com',
          tipoOrg: 'Fundación', actEco: 'Manufactura - confecciones', emprendimientos: '1',interlocutor: 'interlo2',
          serProd: 'Tejidos+Carpinteria+servicios turismo+Servicio Comedor Comunitario'  },
        ],
        fields: [
          {
            key: "ID",
            label: "ID",
            sortable: true
          },
          { key: "Nombre" },
          { key: "interlocutor",
          label:"Interlocutor" },
          { key: "tipoOrg",
          label: "tipo de organización" },
          { key: "actEco",
          label: "Emprendimientos" },
          { key: "serProd",
          label: "Servicio o producto" },
          { key: "Editar" },
          { key: "Eliminar" }
        ],
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
