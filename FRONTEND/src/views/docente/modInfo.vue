<template>
    <b-container>  
         <div>
            <sidebar-menu-akahon 
            />
          </div> 
      <b-row>
        <b-col>
          <div class="hello">
            <h3>Módulo de información</h3>
          </div>
          <br>
          <router-link to="/foro">
          <button type="submit" class="btn btn-dark btn-lg btn-inline">
            <h2><b-icon-chat-quote></b-icon-chat-quote></h2>  
            Espacio colaborativo
          </button></router-link>
          &nbsp
        <router-link to="/noticias">
        <button class="btn btn-dark btn-lg btn">
        <h2><b-icon-newspaper></b-icon-newspaper></h2>        
        Ver noticias
        </button></router-link>
          <br>
          <br>
          <br>
        <h4>Noticias subidas</h4>
          
        <br>
          <div>
            <b-table striped hover :items="noticias" :fields="fields1">
               
            </b-table>
          </div>
        </b-col>
        <b-col>
          
        </b-col>
      </b-row>
    </b-container>   
  </template>
  
  <script>
  import SidebarMenuAkahon from "@/components/SideBarDocente.vue"
  import { BIcon, BIconArrowUp, BIconNewspaper,BIconChatQuote } from 'bootstrap-vue'

  export default {
    name: 'modInfor',
    props: {
      msg: String
    },
    data() {
      return{
        fields1: [
            { key: "estudiante" },
            { key: "clase" },
            { key: "titulo" },
            { key: "fecha"}
          ],
        noticias: [
            { ID: 40, titulo: 'El iva en emprendimientos', estudiante:'pepito', fecha:'4/6/2022', clase:'3433'},
            { ID: 40, titulo: 'Petro es un hp', estudiante:'maria', fecha:'4/6/2022', clase:'r3434'},
            { ID: 40, titulo: 'Nueva reforma tributaria', estudiante:'alex', fecha:'4/6/2022',clase:'343'},
        ]
      };
    },
     components: {
      SidebarMenuAkahon,
      BIcon,
      BIconArrowUp,
      BIconNewspaper,
      BIconChatQuote
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
  button{
    display: inline-block;

  }
  a {
    color: #42b983;
  }
  </style>
  