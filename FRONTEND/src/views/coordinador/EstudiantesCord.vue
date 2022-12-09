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

          
         <b-table striped hover :items="users.preins" :fields="fields1">
            <template #cell(Editar)="row">
              <b-button class="mr-2"  @click="editarSt(row.item.id)">Editar
              </b-button>
            </template>
            <template #cell(Eliminar)="row">
              <b-button class="mr-2">Eliminar
              </b-button>
            </template>
          </b-table>
        </div>
        Listado de estudiantes inscritos

           <br>
           <div>
             <b-table striped hover id="pages-table" :items="users.ins" :fields="fields2">
               <template #cell(Editar)="row">
                <b-button class="mr-2"  @click="editarSt(row.item.id)">Editar
                 </b-button>
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
    return{
      users:{
        preins: [{
          nombre: null,
          datoCambiante: null,
          tallerSp: null,
        }],
        ins: [{
          id: null,
          nombre: null,
          datoCambiante: null
        }],
      },

      fields1: [
        { key: "id" },
        { key: "nombre" },
        { key: "datoCambiante", label:"Asignatura" },
        { key: "Editar" },
        { key: "Eliminar" }
      ],
      fields2: [
        { key: "id" },
        { key: "nombre" },
        { key: "datoCambiante", label:"Asignación" },
        { key: "Editar" },
        { key: "Eliminar" }
      ],
    }
  },
  mounted() {
    axios.get("http://localhost:8080/gesStu").then(
      (response) => {
        this.users= response.data;
        console.log(this.users)
      }
    );
  },
  methods: {
      editarSt(idSt){
        console.log("id---------",idSt);
        //self.$router.push({name:'preEdit' })
      },
      editarPre(idSt){
        console.log("id---------",idSt);
        //self.$router.push({name:'preEdit' })
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
