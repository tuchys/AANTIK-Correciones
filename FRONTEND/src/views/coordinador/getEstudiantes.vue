<template>
  <b-container>  
       <div>
          <sidebar-menu-akahon 
          />
        </div> 
    <b-row>
      <b-col>
        <p>
          <h3>Gestor de estudiantes</h3>
        </p>
        <router-link to="/subirFile">
        <button type="submit" class="btn btn-dark btn-lg btn-block">
        Agregar estudiante preinscrito</button></router-link><br>
        <button type="submit" class="btn btn-dark btn-lg btn-block">
        Agregar estudiante</button>
        <button type="submit" class="btn btn-dark btn-lg btn-block">
        Eliminar estudiante</button>
        <button type="submit" class="btn btn-dark btn-lg btn-block">
        Modificar estudiante</button>
        <br>
        Listado de estudiantes inscritos
        <br>
        <div>
          <b-table striped hover :items="estudiante" :fields="fields" @change="getFile($event)"></b-table>
        </div>
        <br>
        Listado de estudiantes preinscritos
        <br>
        <div>
          <b-table striped hover :items="items2"></b-table>
        </div>  
      </b-col>
      <b-col>
      
      </b-col>
    </b-row>
  </b-container>   
</template>

<script>
import SidebarMenuAkahon from "@/components/SideBarCoord.vue"
import LoginService from "@/service/LoginService";

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
      datos:{
        estudiante:[ {
        nombre: null,
        correo: null,
        telefono: null
      } ],
      prueba: null,
      
    } ,

      fields: [
          { key: "nombre" },
          { key: "correo" },
          { key: "telefono", label:"celular" }
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
   /* async save() {
      var data = {
        nombre: this.estudiante.nombre,
        correo: this.estudiante.correo,
        telefono: this.estudiante.telefono
      };*/
      getAll() {
      this.loginService.getAll().then(data => {
        this.datos = data.data;
        console.log("gj-----");
        console.log("gj-----",data.data.String);
        console.log("typeof-----",typeof data.data);
        console.log("key-----",typeof data.headers);
        console.log("DATOS-----",this.datos);
      });
      console.log("gj-----");
      console.log(this.estudiante.nombre);
      },
      /*try {
        //let self = this;
        await this.loginService.save()
        .then(function(response) {
          console.log(response.data); // DISPLAYS THE DATA I WANT
         // user = response.data; // THROWS TYPE ERROR: Cannot set property 'thoughtWallet' of undefined at eval
        //  self.$router.push({name:'about' })
        }).catch(function(error) {
          console.log(error);
        });

        //.then(response => this.$router.push("/about"))
        //.catch(error => this.$router.push("/login"));
      } catch (error) {
        console.log(error);
      }
    },*/
      print() {
        console.log("Esto es un método"+this.estudiante.correo);
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
