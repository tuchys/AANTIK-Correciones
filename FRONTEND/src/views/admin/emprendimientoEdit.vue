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
    <h3>Diligencie el siguiente formulario con los datos del emprendimiento</h3>
    <br><br>
    <div>
      <b-form @submit="onSubmit" @reset="onReset" v-if="show">
        
  <b-container>  
    <b-col> 
      <b-form-group id="input-group-1" label="Nombres del emprendimiento:" label-for="input-1">     
          <b-form-input
            id="input-1"
            v-model="form.emprendimiento"
            placeholder="Nombre"
            required
          ></b-form-input>
        </b-form-group>

        <b-form-group id="input-group-1" label="Nombres de la organización social:" label-for="input-1">     
          <b-form-input
            id="input-1"
            v-model="form.organizacion3"
            placeholder="Organización"
            required
          ></b-form-input>
        </b-form-group>

        <b-form-group
          id="input-group-2"
          label="Correo Interlocutor:"
          label-for="input-2"
        >
          <b-form-input
            id="input-2"
            v-model="form.email"
            type="email"
            placeholder="Correo Interlocutor"
            required
          ></b-form-input>
        </b-form-group>
      </b-col> 
        <b-col> 
        <b-form-group id="input-group-3" label="Fecha de constitución:" label-for="input-3">     
          <b-form-input
            id="input-3"
            v-model="form.idEst"
            placeholder="dd/mm/aaaa"
            required
          ></b-form-input>
        </b-form-group>
        
        <b-form-group id="input-group-4" label="Dirección:" label-for="input-4">     
          <b-form-input
            id="input-4"
            v-model="form.cedula"
            placeholder="Dirección"
            required
          ></b-form-input>
        </b-form-group>

        <b-form-group id="input-group-5" label="Localidad /Municipio:" label-for="input-5">     
          <b-form-select
          id="input-5"
          v-model="form.asignatura"
          :options="asignatura"
          required
        ></b-form-select>
        </b-form-group>
        <h4>DATOS DE INTERLOCUTOR DE LA ORGANIZACIÓN SOCIAL</h4> 
        <b-form-group id="input-group-6" label="Nombre:" label-for="input-6">     
          <b-form-input
            id="input-6"
            v-model="form.fechaTaller"
            placeholder="Nombre"
            required
          ></b-form-input>
        </b-form-group>

        <b-form-group id="input-group-7" label="Teléfono:" label-for="input-7">     
          <b-form-input
            id="input-7"
            v-model="form.telefono"
            placeholder="Teléfono"
            required
          ></b-form-input>
        </b-form-group>

        <b-form-group id="input-group-8" label="correo electrónico:" label-for="input-8">     
          <b-form-input
            id="input-8"
            v-model="form.telefono"
            placeholder="correo electrónico"
            required
          ></b-form-input>
        </b-form-group>        
        <h4>DATOS DE PERSONALIZACIÓN</h4> 
        <b-form-group id="input-group-6" label="Requiere estudiante con algún tipo de experiencia:" label-for="input-6">     
          <b-form-select
          id="input-5"
          v-model="form.opciones"
          :options="opciones"
          required
        ></b-form-select>
        </b-form-group>

        <b-form-group id="input-group-6" label="Requiere estudiantes con alto promedio:" label-for="input-6">     
          <b-form-select
          id="input-5"
          v-model="form.opciones"
          :options="opciones"
          required
        ></b-form-select>
        </b-form-group>

        <b-form-group id="input-group-6" label="horarios en que desea recibir notificaciones:" label-for="input-6">     
          <b-form-select
          id="input-5"
          v-model="form.opciones"
          :options="opcionesH"
          required
        ></b-form-select>
        </b-form-group>
      </b-col> 
        <b-button type="submit" variant="primary">Guardar</b-button>
        <b-button type="reset" variant="danger">Cancelar</b-button>
        
      </b-container>  
      </b-form>
      
    </div>
  </b-col>
      <b-col>
      
      </b-col>
    </b-row>
  </b-container>  
</template>

<script>
import SidebarMenuAkahon from "@/components/SideBar.vue"

  export default {
    data() {
      return {
        form: {
          email: '',
          name: '',
          food: null,
          checked: []
        },
        asignatura: [{ text: 'Selecione una', value: null }, 'Chapinero', 'Usme'],
        show: true,
        opciones: [{ text: 'Selecione una', value: null }, 'Si', 'No'],
        show: true,
        opcionesH: [{ text: 'Selecione una', value: null }, 'Entre semana AM', 'Entre semana PM'],
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