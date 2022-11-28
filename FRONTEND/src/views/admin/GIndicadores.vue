<template>
  <b-container>  
       <div>
          <sidebar-menu-akahon 
          />
        </div> 
    <b-row>
      <b-col>
        <div class="hello">
          <h3>Gestor de Indicadores de benchmarking</h3>
       </div>
       <br>
       <router-link to="/addInd">
          <button type="submit" class="btn btn-dark btn-lg btn-inline">
            <h2><b-icon-plus></b-icon-plus></h2>  
            Agregar indicador
        </button></router-link>
       <br><br>
        <div>
          <b-table striped hover id="pages-table" :items="items" :fields="fields2">
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
import admService from "@/service/adminServices";
import { BIcon, BIconArrowUp, BIconNewspaper,BIconPlus } from 'bootstrap-vue'

export default {
  data() {
    return {
      items: [
        {nombre: null,
          pregunta:null }
      ],
      fields2: [
          { key: "nombre",
            label: 'Indicador' ,
            sortable: true},
          { key: "pregunta" },
          { key: "Eliminar" }
      ]
    }      
  },
  components: {
    SidebarMenuAkahon,
    BIconPlus
  },
  created() {
    this.admService = new admService();
    this.getIndBench();
  },
  methods: {
    getIndBench() {
      this.admService.getAllIndicadores().then(data => {
        this.items = data.data;
        console.log("gj-----");
      });
      console.log("gj-----");
    },
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
