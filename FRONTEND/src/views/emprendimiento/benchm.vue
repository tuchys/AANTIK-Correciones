<template>
    <b-container>  
         <div>
            <sidebar-menu-akahon 
            />
          </div> 
      <b-row>
        <b-col>
      <!---    <p>--> 
            <h3>Benchmarking</h3>
         <!--- </p>-->
          <br>
          valores obtenidos por su compañia
          <br>
          <div>
            <b-table striped hover :items="indicadores" :fields="fields1" @change="getFile($event)"></b-table>
          </div>
          <br>
          
          <DxChart
                id="chart"
                :data-source="indicadores"
                :ref="chartRefKey"
            >
                <DxSeries
                argument-field="nombre"
                value-field="puntaje"
                name="Benchmarking"
                type="bar"
                color="#2C5698"
                />
            </DxChart>
        </b-col>
      </b-row>
    </b-container>   
  </template>
  
  <script>
import SidebarMenuAkahon from "@/components/SideBarCoord.vue"
import LoginService from "@/service/LoginService";
import { DxChart, DxSeries } from "devextreme-vue/chart";
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
        DxChart,
        DxSeries,
    },
    data() {
      return{
          indicadores:[ {
          nombre: null,
          puntaje: null,
          descripcion: null
        } ],
        indicadores2:[ {
          nombre: "ind2",
          puntaje: 30,
          desc: null
        } ,{
          nombre: "ind3",
          puntaje: 33,
          desc: null
        } ,{
          nombre: "ind4",
          puntaje: 55,
          desc: null
        } ],
        fields1: [
            { key: "nombre", label:"Indicador" },
            { key: "puntaje" , label:"Puntaje"},
            { key: "descripcion", label:"Descripcion" }
          ],
        items2: [
            { ID: 40, Nombres: 'Dickerson', Apellido: 'Macdonald', Asignatura: '2353001', Clase: '4202', Requisitos: 'Satisfecho' },
            { ID: 21, Nombres: 'Larsen', Apellido: 'Shaw', Asignatura: '2353001', Clase: '4202', Requisitos: 'Pendiente' },
            { ID: 89, Nombres: 'Geneva', Apellido: 'Wilson', Asignatura: '2353001', Clase: '4206', Requisitos: 'Pendiente' },
            { ID: 38, Nombres: 'Jami', Apellido: 'Carney', Asignatura: '2353001', Clase: '4208', Requisitos: 'Satisfecho' }
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
      this.getAll();
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
  