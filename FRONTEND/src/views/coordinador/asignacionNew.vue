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
            <template #cell(asignar)="row">
              <b-button class="mr-2">Asignar
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
        </button></router-link>&nbsp
        <router-link :to="{name: 'detalles', params: {fecha:'hola'}}">
          <b-button class="mr-2" @click="message('hola')">
            <h2><b-icon-clipboard-check></b-icon-clipboard-check></h2>  
            Ver detalles
        </b-button></router-link>
        
        <br><br>
      </b-col>
    </b-row>
  </b-container>   
</template>

<script>
import SidebarMenuAkahon from "@/components/SideBarCoord.vue"
import axios from "axios";
import detallesAs from "@/views/coordinador/detallesAsignacion.vue"
import {BIconClockHistory,BIconClipboardCheck } from 'bootstrap-vue'
export default {

   components: {
    SidebarMenuAkahon,
    BIconClockHistory,
    BIconClipboardCheck,
    detallesAs
  },
  name: 'estudiantesCord',
  data() {
    return {
      fechaP: '23/22/2222',
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
    handleInput(value, data) {},
    message(idrec){
      this.msg=idrec;
      console.log("inicial---",idrec);

    },
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
