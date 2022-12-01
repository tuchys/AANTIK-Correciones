<template>
  <b-container>  
       <div>
          <sidebar-menu-akahon/>
        </div> 
    <b-row>
      <b-col>
        <div class="hello">
          <h3>Nuevo resultado de asignación</h3>
        </div>
        
        <br>
        RESULTADOS 
        <br><br>
        Listado de sugerencias
          
        <br>
        <div>
          <b-table striped hover :items="users" :fields="fields1">
            <template #cell(asignar)="data">                            
              <b-button class="mr-2" @click="asignarSTU(data.item)">Asignar
              </b-button>
            </template>
          </b-table>

        </div>
        <br>
        <br>
        <router-link to="/histoAsig">
          <button type="submit" class="btn btn-dark btn-lg btn-inline">
            <h2><b-icon-clock-history></b-icon-clock-history></h2>  
            Ver historial
        </button></router-link>
      </b-col>
    </b-row>
  </b-container>   
</template>

<script>
import SidebarMenuAkahon from "@/components/SideBarCoord.vue"
import axios from "axios";
import {BIconClockHistory } from 'bootstrap-vue'
export default {

   components: {
    SidebarMenuAkahon,
    BIconClockHistory
  },
  name: 'estudiantesCord',
  data() {
    return {
      users: [{
        nombre: null,
        correo: null,
        emprendimiento: null,
        id1: null,
      }] ,
      fields1: [
        {
          key: "nombre",
        },
        {
          key: "correo",
        },
        {
          key: "emprendimiento",
        },
        {
          key: "asignar",
        },
        
      ],
      form: {
          estado: '',
        },
      estado: [{ text: 'Selecione una', value: null }, 'Pendiente', 'Satisfecho'],
      show: true
    }
  },
  mounted() {
    axios.get("http://localhost:8080/api/asignacionNueva").then(
      (response) => {
        this.users= response.data;
        console.log(this.users)
      }
    );
  },
  methods: {
    asignarSTU: function (cosa) {
      //window.location.reload();
      console.log(cosa)
      console.log(cosa.correo)
      axios.post("http://localhost:8080/api/asignarSTU", {
        nombre: cosa.nombre,
        correo: cosa.correo,
        emprendimiento: cosa.emprendimiento,
        fecha: cosa.fecha
        
        }).catch((error) => {
        if (error.response) {
          console.log(error.response.data); // => the response payload 
        }
      });
        console.log(cosa.nombre)
      },
    handleInput(value, data) {},
  },
};

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
