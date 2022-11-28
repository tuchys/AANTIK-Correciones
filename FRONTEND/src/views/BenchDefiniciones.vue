<template>
    <b-container fluid="xl">  
         <div>
            <sidebar-menu-akahon 
            />
          </div> 
      <b-row class="change_row">
        <b-col class="change_col">
          <div class="hello">
            <h3>Benchmarking definiciones</h3>
          </div>
          <div>
            <b-table class="table" striped Bordered hover id="pages-table" :items="this.user" :fields="fields" :key="id">
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
  import axios from 'axios'
  export default {
    name: 'Homecoordinador',
    props: {
      msg: String
    },
    data() {
        return {
          user: [],
          fields:[
            {
              key:"indicaid",
              label:"Indicador",
              thStyle: { width: "5%" }
            },
            {
              key:"descripcion",
              label:"Definición",
              thStyle: { width: "50%" }
            },
          ],
        }      
    },
     components: {
      SidebarMenuAkahon,
    },
    mounted(){
      axios.get("http://localhost:8080/api/benchmarking/indicadores").then((response)=>{
        console.log(response)
        this.user=response.data;
        console.log(this.user)
      })
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
  .table{
    width: 50rem;
  }
  .change_row{
    width: 100rem;
  }
  .change_col{
    width: 100rem;
  }
  </style>
  