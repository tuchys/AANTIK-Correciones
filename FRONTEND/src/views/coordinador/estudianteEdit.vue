<template>
  <b-container>  
      <div>
        <sidebar-menu-akahon 
          @search-input-emit="search"
        />
      </div> 
  <b-row>
    <b-col>
    <br><br>
    <h3>Actualice los datos del estudiante</h3>
    <br><br>
    <div>
      <b-form @submit="onSubmit" @reset="onReset" v-if="show">

        <b-table striped hover :items="estudiante" :fields="fields" @change="getFile($event)"></b-table>


        <b-form-group id="input-group-4" label="Asigne un emprendimenito al estudiante" label-for="input-1">     
          <b-form-select
            id="input-1"
            v-model="form.emprendimiento"
            :options="emprendimiento"
            required
          ></b-form-select>
        </b-form-group>
        

        <b-button type="submit" variant="primary">Guardar</b-button>
        <b-button type="reset" variant="danger">Cancelar</b-button>
      </b-form>
      <br>
      <router-link to="/gesStu">
        <button type="submit" class="btn btn-dark btn-lg btn-block">
        Volver</button></router-link>
    </div>
  </b-col>
      <b-col>
        
      </b-col>
    </b-row>
  </b-container>  
</template>

<script>
import axios from 'axios';
import SidebarMenuAkahon from "@/components/SideBarCoord.vue"
import LoginService from "@/service/LoginService";

  export default {
    data() {
      return {
        estudiante: {
        nombre: null,
        correo: null,
      } ,
      fields: [
          { key: "nombre" },
          { key: "correo" },
        ],

        form: {
          estado: '',

        },

        emprendimiento: [{ text: 'Selecione una', value: null }, 'America', 'Rosita'],
        show: true
      }
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
  },
    components: {
    SidebarMenuAkahon,
    },
    methods: {
      onSubmit() {
        axios.post("http://localhost:8080/datosPre",{
          telefono: this.form.telefono,
          municipio: this.form.municipio,
          localidad: this.form.localidad,
          barrio: this.form.barrio,
          direccion: this.form.direccion,
          limitacion: this.form.limitacion,
          localidadrest: this.form.localidadrest,
          notif: this.form.notif,
        });

      },
      onReset(event) {
        event.preventDefault()
        // Reset our form values
        this.form.telefono = ''
        this.form.municipio = ''
        this.form.localidad = null
        this.form.barrio = ''
        this.form.direccion = ''
        this.form.limitacion = null
        this.form.localidadrest = null
        this.form.notif = null
        // Trick to reset/clear native browser form validation state
        this.show = false
        this.$nextTick(() => {
          this.show = true
        })
      },
      getAll() {
      this.loginService.getAll().then(data => {
        this.estudiante = data.data;
      });
      },
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


