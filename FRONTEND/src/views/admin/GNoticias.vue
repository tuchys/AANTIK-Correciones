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
          <h3>Gestor de noticias</h3>
          <label-edit :text="text" id="labeledit1" v-on:text-updated="textUpdated" placeholder="Enter some text"></label-edit>
        </div>
        <div>
          <b-table striped hover id="pages-table" :items="items" :fields="fields">
            <template #cell(Editar)="row">
              <router-link to="/notiEdit">
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
import SidebarMenuAkahon from "@/components/SideBarAdmin.vue"

export default {
  name: 'Homecoordinador',
  props: {
    msg: String
  },
  data() {
      return {
        items: [
          { ID: 40, Titulo: 'Nuevo impuesto a..', Fecha: '10/10/22', Autor: 'Pepito' },
          { ID: 40, Titulo: 'Apoyo a emprendimientos en col..',  Fecha: '10/10/22', Autor: 'Juanito' },
          { ID: 40, Titulo: 'notica', Fecha: '01/10/22', Autor: 'Camilo' }
        ],
        fields: [
          {
            key: "ID",
            label: "ID",
            sortable: true
          },
          { key: "Titulo" },
          { key: "Fecha" },
          { key: "Autor" },
          { key: "Editar" },
          { key: "Eliminar" }
        ]
      }      
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
