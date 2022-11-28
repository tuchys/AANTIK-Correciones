<template>
    <b-container>  
         <div>
            <sidebar-menu-akahon 
            />
          </div> 
      <b-row>
        <b-col>
          <div class="hello">
            <h3>Agregar indicador de benchmarking</h3>
         </div>
         <br>
        
        <b-form @submit="onSubmit" @reset="onReset" >       
        <b-form-group id="input-group-5" label="Nombre de indicador:" label-for="input-5">     
          <b-form-select
          id="input-5"
          v-model="form.nombre"
          :options="asignatura"
          required
        ></b-form-select>
        </b-form-group>

        <b-form-group id="input-group-1" label="Pregunta:" label-for="input-1">     
          <b-form-input
            id="input-1"
            v-model="form.pregunta"
            placeholder="Nombres y apellidos"
            required
          ></b-form-input>
        </b-form-group>

        <b-button type="submit" variant="primary">Agregar</b-button>
      </b-form>

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

  export default {
    data() {
      return {
        form: {
            pregunta: '',
            nombre: ''
        },
      }      
    },
    components: {
      SidebarMenuAkahon,
    },
    created() {
      this.admService = new admService();
    },
    methods: {      
        onSubmit(event) {
            event.preventDefault()
            alert(JSON.stringify(this.form))
        },
        onReset(event) {
            event.preventDefault()
            // Reset our form values
            this.form.nombre = ''
            this.form.pregunta = ''
            // Trick to reset/clear native browser form validation state
    
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
  