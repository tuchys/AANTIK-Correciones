<template>
    <b-container>  
         <div>
            <sidebar-menu-akahon 
            />
          </div> 
      <b-row>
        <b-col>
      <!---    <p>--> 
            <h3>Informes cargados por estudiantes</h3>
         <!--- </p>-->
          <br>
          <h4>Clase 1111</h4>          
          <br>
          <div>
            <b-table striped hover :items="items2" :fields="fields1">
                <template #cell(url)="row">
                    <li v-for='item3 in row.item.documentos'>                        
                    <a v-on:click.prevent="print2()" href="/">
                    {{item3}}</a>
                    </li>
                </template>
            </b-table>
          </div>
          <br>

        </b-col>
      </b-row>
    </b-container>   
  </template>
  
  <script>
import SidebarMenuAkahon from "@/components/SideBarDocente.vue"
import LoginService from "@/service/LoginService";
import AuthService from "@/service/auth.service"
import 'devextreme/dist/css/dx.common.css';
import 'devextreme/dist/css/dx.light.compact.css';
  
  export default {
    //name: 'estudiantesCord2',
    props: {
      msg: String
    },
     components: {
        SidebarMenuAkahon,
    },
    data() {
      return{
        fields1: [
            { key: "nombre", label:"Estudiante" },
            { key: "url" , label:"Documentos"}
          ],
        items2: [
            { ID: 40, nombre: 'pepito', documentos:['informes/infoinicial.docx','informes/infofinal.docx']},
            { ID: 40, nombre: 'pepita', documentos:['informes/infoinicial.docx','informes/infofinal.docx']},
            { ID: 40, nombre: 'maria', documentos:['informes/infoinicial.docx','informes/infofinal.docx']}
        ]
      };
    },
    items: [
      {
        label: "Refrescar",
        icon: "pi pi-fw pi-refresh",
        command: () => {
          this.getAll();
        }
      }
    ],
    loginService: null,
    created() {
      this.loginService = new LoginService();
     // this.getAll();
      this.print();
    },
    methods: {
      getAll() {
          try{
            this.loginService.getAllBenc()
            .then(function(response) {
              data => {
              this.indicadores = data.data;
              console.log("gj-----");
             /* console.log("gj-----",data.data.String);
              console.log("typeof-----",typeof data.data);
              console.log("key-----",typeof data.headers);
              console.log("DATOS-----",this.datos);*/
          }
        });
            console.log("gj-----");
            console.log(this.indicadores.nombre);
        } catch (error) {
        console.log('error');
        console.log(error);
        } 
      },
      print() {
        console.log("Esto es un método");
      },
      print2() {
        console.log("PRUEBA DE LINK FUNCION");
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
    display: block;
    margin: 0 10px;
  }
  a {
    color: #42b983;
    display: block;
  }
  </style>
  