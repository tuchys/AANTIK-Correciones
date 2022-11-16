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
    <h3>Diligencie la siguiente información</h3>
    <br><br>
    <div>
      <b-form @submit="onSubmit" @reset="onReset" v-if="show">

        <b-form-group id="input-group-1" label="Pregunta o petición:" label-for="input-1"  >     
          <b-form-textarea
            id="input-2"
            v-model="form.pregunta"
            placeholder="Pregunta o petición"
            required
            rows="2" 
            max-rows="5"
          ></b-form-textarea>
        </b-form-group>

        <br>
        <b-button type="submit" variant="primary">Guardar</b-button>
        <b-button type="reset" variant="danger">Cancelar</b-button>
      </b-form>
      <br>
      <router-link to="/foro">
        <button type="submit1" class="btn btn-dark btn-lg w-100">
       Espacio Colaborativo</button></router-link>
      <br>  <br>
      <router-link to="/homeEmp">
        <button type="submit1" class="btn btn-dark btn-lg w-100">
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
import SidebarMenuAkahon from "@/components/SideBar.vue"
import AuthService from "@/service/auth.service"

  export default {
    data() {
      return {
      fields: [
          { key: "pregunta" },
          { key: "responsable" },
        ],

        form: {
          pregunta: null,
          responsable: null,
   
        },
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
    components: {
    SidebarMenuAkahon,
    },
    methods: {
      onSubmit() {
        axios.post("http://localhost:8080/foroEmp",{
          pregunta: this.form.pregunta,
          responsable: AuthService.getUser(),

         
        });
        console.log(AuthService.getCorreo());
console.log(this.store.state.auth.user.username)
      },
      onReset(event) {
        event.preventDefault()
        // Reset our form values
        this.form.pregunta = ''


        // Trick to reset/clear native browser form validation state
        this.show = false
        this.$nextTick(() => {
          this.show = true
        })
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


