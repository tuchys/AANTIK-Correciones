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
    <h3>Diligencie la siguiente información de la noticia</h3>
    <br><br>
    <div>
      <b-form @submit="onSubmit" @reset="onReset" v-if="show">

        <b-form-group id="input-group-1" label="Titulo:" label-for="input-1">     
          <b-form-input
            id="input-1"
            v-model="form.titulo"
            placeholder="Titulo"
            required
          ></b-form-input>
        </b-form-group>

        <b-form-group id="input-group-1" label="Noticia:" label-for="input-2"  >     
          <b-form-textarea
            id="input-2"
            v-model="form.noticiaa"
            placeholder="Noticia"
            required
            rows="3" 
            max-rows="10"
          ></b-form-textarea>
        </b-form-group>


        <b-form-group id="input-group-1" label="Fuente:" label-for="input-3">     
          <b-form-input
            id="input-3"
            v-model="form.fuente"
            placeholder="Fuente"
            required
          ></b-form-input>
        </b-form-group>
        <br>
        <b-button type="submit" variant="primary">Guardar</b-button>
        <b-button type="reset" variant="danger">Cancelar</b-button>
      </b-form>
      <br>
      <router-link to="/noticias">
        <button type="submit1" class="btn btn-dark btn-lg w-100">
        Ver otras noticias</button></router-link>
      <br>  <br>
      <router-link to="/studentHome">
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
          { key: "titulo" },
          { key: "noticiaa" },
          { key: "fuente" },
        ],

        form: {
          titulo: null,
          noticiaa: null,
          fuente: null,
   
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
        axios.post("http://localhost:8080/api/noticiaEs",{
          titulo: this.form.titulo,
          noticiaa: this.form.noticiaa,
          fuente: this.form.fuente,
          encargado: AuthService.getUser(),
          correo: AuthService.getCorreo(),
         
        });
        console.log(AuthService.getCorreo());
console.log(this.store.state.auth.user.username)
      },
      onReset(event) {
        event.preventDefault()
        // Reset our form values
        this.form.titulo = ''
        this.form.noticiaa = ''
        this.form.fuente = ''

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


