<template>
    <b-container>  
         <div>
            <sidebar-menu-akahon/>
          </div> 
      <b-row>
        <b-col>
          <div class="hello">
            <h3><b-icon-clock-history></b-icon-clock-history>
                Histórico de resultados de asignación</h3>
          </div>
          
          <br>
          RESULTADOS SUGERIDOS
          <br><br>
            
          <div>
            <b-table striped hover :items="users" :fields="fields1">
              
            </b-table>
  
          </div>
          <br>
          <br>
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
          fecha: null
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
          {key:"fecha"}
          
        ],
        show: true
      }
    },
    mounted() {
      axios.get("http://localhost:8080/api/histoAsignacion").then(
        (response) => {
          this.users= response.data;
          console.log(this.users)
        }
      );
    },
    methods: {
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
  