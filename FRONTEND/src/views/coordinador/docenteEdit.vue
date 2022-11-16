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
    <h3>Diligencie el siguiente formulario con los datos del 
    docente</h3>
    <br><br>
    <div>
      <b-form @submit="onSubmit" @reset="onReset" v-if="show">
        <b-form-group id="input-group-1" label="Nombres y apellidos:" label-for="input-1">     
          <b-form-input
            id="input-1"
            v-model="form.name"
            placeholder="Nombres y apellidos"
            required
          ></b-form-input>
        </b-form-group>

        <b-form-group
          id="input-group-2"
          label="Vinculación:"
          label-for="input-2"
        >
          <b-form-input
            id="input-2"
            v-model="form.vinculacion"
            type="email"
            placeholder="Vinculación"
            required
          ></b-form-input>
        </b-form-group>

        <b-form-group
          id="input-group-2"
          label="título profesional:"
          label-for="input-2"
        >
          <b-form-input
            id="input-2"
            v-model="form.titulo"
            type="email"
            placeholder="título profesional"
            required
          ></b-form-input>
        </b-form-group>

        <b-form-group
          id="input-group-2"
          label="especialidad:"
          label-for="input-2"
        >
          <b-form-input
            id="input-2"
            v-model="form.especialidad"
            type="email"
            placeholder="especialidad"
            required
          ></b-form-input>
        </b-form-group>

        <b-form-group
          id="input-group-2"
          label="Correo institucional:"
          label-for="input-2"
        >
          <b-form-input
            id="input-2"
            v-model="form.email"
            type="email"
            placeholder="Correo institucional"
            required
          ></b-form-input>
        </b-form-group>

        <b-form-group id="input-group-3" label="ID docente:" label-for="input-3">     
          <b-form-input
            id="input-3"
            v-model="form.idEst"
            placeholder="ID docente"
            required
          ></b-form-input>
        </b-form-group>
        
        <b-form-group id="input-group-4" label="Telefono:" label-for="input-4">     
          <b-form-input
            id="input-4"
            v-model="form.telefono"
            placeholder="telefono"
            required
          ></b-form-input>
        </b-form-group>

        <b-form-group id="input-group-5" label="Asignatura a la que pertenece:" label-for="input-5">     
          <b-form-select
          id="input-5"
          v-model="form.asignatura"
          :options="asignatura"
          required
        ></b-form-select>
        </b-form-group>

        <b-form-group
          id="input-group-2"
          label="oficina:"
          label-for="input-2"
        >
          <b-form-input
            id="input-2"
            v-model="form.oficina"
            type="email"
            placeholder="oficina"
            required
          ></b-form-input>
        </b-form-group>

        <b-form-group
          id="input-group-2"
          label="dirección de residencia:"
          label-for="input-2"
        >
          <b-form-input
            id="input-2"
            v-model="form.direccion"
            type="email"
            placeholder="dirección de residencia"
            required
          ></b-form-input>
        </b-form-group>

        <b-form-group
          id="input-group-2"
          label="Localidad/Municipio:"
          label-for="input-2"
        >
          <b-form-input
            id="input-2"
            v-model="form.localidad"
            type="email"
            placeholder="Localidad/Municipio"
            required
          ></b-form-input>
        </b-form-group>

        <b-form-group id="input-group-7" label="Sector económico de experiencia:" label-for="input-7">     
          <b-form-input
            id="input-7"
            v-model="form.sector"
            placeholder="Sector económico"
            required
          ></b-form-input>
        </b-form-group>

        <b-form-group id="input-group-5" label="Cuenta con experiencia en asesoría:" label-for="input-5">     
          <b-form-select
          id="input-5"
          v-model="form.opcionExp"
          :options="opcionYN"
          required
        ></b-form-select>
        </b-form-group>

        <b-form-group id="input-group-5" label="Medio de comunicación que prefiere:" label-for="input-5">     
          <b-form-select
          id="input-5"
          v-model="form.comunicacion"
          :options="comunicacion"
          required
        ></b-form-select>
        </b-form-group>

        <b-button type="submit" variant="primary">Guardar</b-button>
        <b-button type="reset" variant="danger">Cancelar</b-button>
      </b-form>
      
    </div>
  </b-col>
      <b-col>
        
      </b-col>
    </b-row>
  </b-container>  
</template>

<script>
import SidebarMenuAkahon from "@/components/SideBarCoord.vue"

  export default {
    data() {
      return {
        form: {
          email: '',
          name: '',
          food: null,
          checked: []
        },
        asignatura: [{ text: 'Selecione una', value: null }, 'PSU', 'CDIO'],
        show: true,
        comunicacion: [{ text: 'Selecione una', value: null }, 'Whatsapp', 'Teams','Correo','Llamada'],
        
        show: true,
        opcionYN: [{ text: 'Selecione una', value: null }, 'Si', 'No'],
        show: true
      }
    },
    components: {
    SidebarMenuAkahon,
    },
    methods: {
      onSubmit(event) {
        event.preventDefault()
        alert(JSON.stringify(this.form))
      },
      onReset(event) {
        event.preventDefault()
        // Reset our form values
        this.form.email = ''
        this.form.name = ''
        this.form.food = null
        this.form.checked = []
        // Trick to reset/clear native browser form validation state
        this.show = false
        this.$nextTick(() => {
          this.show = true
        })
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
