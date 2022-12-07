<template>
  <b-container>  
       <div>
          <sidebar-menu-akahon 
          />
        </div> 
    <b-row>
      <b-col>
        <div class="hello">
          <h3>Gestor de estudiantes</h3>
        </div>
        Ingrese aquí para agregar estudiantes preinscritos de forma masiva
        por medio de un archivo .xlsx (excel)
        <router-link to="/subirFile">
        <button type="submit" class="btn btn-dark btn-lg btn-block">
        Agregar estudiantes preinscritos</button></router-link><br>

        Ingrese aquí para agregar un estudiante preinscrito de forma individual
        <router-link to="/agregarStd">
        <button type="submit" class="btn btn-dark btn-lg btn-block">
        Agregar estudiante preinscrito</button></router-link><br>
        <br>

        Ingrese aquí para agregar un estudiante inscrito de forma individual
        <router-link to="/agregarStdInsc">
        <button type="submit" class="btn btn-dark btn-lg btn-block">
        Agregar estudiante inscrito</button></router-link><br>
        <br>

        Listado de estudiantes preinscritos
        <br>
        <div>
         <b-table striped hover :items="this.preinsc" :fields="fieldPre">
            <!--<template #cell(Editar)="row">
              <router-link to="/CpreEdit">
              <b-button class="mr-2">Editar
              </b-button></router-link>
            </template>-->
            <template #cell(Eliminar)="row">
              <b-button size="sm" @click="Eliminate(row.item.id)" class="mr-2"> Eliminar
              </b-button>
            </template>
          </b-table>
        </div>
        Listado de estudiantes inscritos
           
           <br>
           <div>
             <b-table striped hover id="pages-table" :items="this.student" :fields="fieldStu" >
               <template #cell(Editar)="row">
                <router-link to="/CstuEdit">
                 <b-button class="mr-2">Editar
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
import SidebarMenuAkahon from "@/components/SideBarCoord.vue"
import axios from 'axios'
export default {
  name: 'estudiantesCord',
  props: {
    msg: String
  },
   components: {
    SidebarMenuAkahon,
  },

  data() {
      return {
        student: [],
        preinsc:[],
        fieldPre:[
          {
            key:"id",
            label:"Id",
            thStyle: { width: "5%" }
          },
          {
            key:"nombre",
            label:"Nombre",
            thStyle: { width: "5%" }
          },
          {
            key:"correo",
            label:"Correo",
            thStyle: { width: "5%" }
          },
          {
            key:"asignatura",
            label:"Asignatura",
            thStyle: { width: "5%" }
          },
          {
            key:"Editar",
          },
          {
            key:"Eliminar",
          },
        ],
        fieldStu:[
          {
            key:"id",
            label:"Id",
            thStyle: { width: "5%" }
          },
          {
            key:"nombre",
            label:"Nombre",
            thStyle: { width: "5%" }
          },
          {
            key:"correo",
            label:"Correo",
            thStyle: { width: "5%" }
          },
          {
            key:"asignatura",
            label:"Asignatura",
            thStyle: { width: "5%" }
          },
          {
            key:"Editar",
          },
          {
            key:"Eliminar",
          },
        ]
      }      
  },
  mounted(){
    axios.get("http://localhost:8080/aut/getStudent").then((response)=>{
     // console.log(response)
      this.student=response.data;
      console.log(this.student)
    }),
  
  axios.get("http://localhost:8080/aut/getPreinsc").then((response)=>{
     // console.log(response)
      this.preinsc=response.data;
      console.log(this.student)
    })
  },
    methods: {
    Eliminate(id){
      console.log(id)
       axios.post("http://localhost:8080/aut/deletePreinsc", { 
        id:id,
    }).then((response) => {
      this.preinsc=response.data;
    })
    }
  },
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
