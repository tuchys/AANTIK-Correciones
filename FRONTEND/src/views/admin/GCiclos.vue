<template>
    <b-container>  
         <div>
            <sidebar-menu-akahon 
            />
          </div> 
      <b-row>
        <b-col>
          <div class="hello">
            <h3>Gestor de ciclos lectivos</h3>
         </div>
         <br>
         Cada vez que se active un ciclo, los demás se desactivan
         <br><br>
         <b-form @submit="onSubmit">     

        <b-form-group id="input-group-1" label="Si desea agregar un nuevo ciclo ingrese el nombre del ciclo:" label-for="input-1">     
          <b-form-input
            id="input-1"
            v-model="form.nombre"
            placeholder="Nombre del ciclo"
            required
          ></b-form-input>
        </b-form-group>

        <b-button type="submit" variant="primary">Agregar <b-icon-plus></b-icon-plus></b-button>
      </b-form>

         <br><br>
          <div>
            <b-table striped hover id="pages-table" :items="items" :fields="fields2">
              <template #cell(Eliminar)="row">
                <b-button @click="deleteCiclo(row.item.id)" class="mr-2">Eliminar
                </b-button>
              </template>

              <template #cell(Activar)="row">
                <b-button @click="activaCiclo(row.item.id)" class="mr-2">Activar
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
  import { BIconPlus } from 'bootstrap-vue'
  
  export default {
    data() {
      return {
        items: [
          {id:null,nombre: null,
            estado:null }
        ],
        fields2: [
            { key: "nombre",
              label: 'Ciclo' ,
              sortable: true},
            { key: "estado" },            
            { key: "Activar" },
            { key: "Eliminar" }
        ],
        form: {
            nombre: ''
        },
      }      
    },
    components: {
      SidebarMenuAkahon,
      BIconPlus
    },
    created() {
      this.admService = new admService();
      this.getCiclos();
    },
    methods: {
      getCiclos() {
        this.admService.getAllCiclos().then(data => {
          this.items = data.data;
          console.log("gj-----");
        });
        console.log("gj-----");
      },   
      onSubmit(event) {
            event.preventDefault()
            //alert(JSON.stringify(this.form))
            this.admService.saveCiclo(this.form).
            then(function(response) {
                alert("Ciclo agregado");//console.log(response.data);
            }).catch(function(error) {
                alert(error);//console.log(error);
            });            
        window.location.reload();
      },
      deleteCiclo(idCiclo){
        window.location.reload();
        this.admService.borraCiclo(idCiclo);
      },
      activaCiclo(idCiclo){
        window.location.reload();
        this.admService.activaCiclo(idCiclo);
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
  