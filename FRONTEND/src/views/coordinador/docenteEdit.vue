<template>
  <b-container>  
      <div>
        <sidebar-menu-akahon 
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
            v-model="nombre"
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
            v-model="vinculacion"
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
            v-model="titulo"
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
            v-model="especialidad"
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
            v-model="correo"
            type="email"
            placeholder="Correo institucional"
            required
          ></b-form-input>
        </b-form-group>

        <b-form-group id="input-group-3" label="ID docente:" label-for="input-3">     
          <b-form-input
            id="input-3"
            v-model="id"
            placeholder="ID docente"
            required
          ></b-form-input>
        </b-form-group>
        
        <b-form-group id="input-group-4" label="Telefono:" label-for="input-4">     
          <b-form-input
            id="input-4"
            v-model="telefono"
            placeholder="telefono"
            required
          ></b-form-input>
        </b-form-group>

        <b-form-group id="input-group-5" label="Asignatura a la que pertenece:" label-for="input-5">     
          <b-form-select
          id="input-5"
          v-model="asignatura"
          :options="asignaturas"
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
            v-model="oficina"
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
            v-model="direcRes"
            placeholder="dirección de residencia"
            required
          ></b-form-input>
        </b-form-group>

        <b-form-group id="input-group-2" label="Localidad/Municipio:" label-for="input-2">
              <b-form-select id="input-2" v-model="localidad" :options="localidades" required></b-form-select>
            </b-form-group>

        <b-form-group id="input-group-7" label="Sector económico de experiencia:" label-for="input-7">     
          <b-form-input
            id="input-7"
            v-model="sectoEc"
            placeholder="Sector económico"
            required
          ></b-form-input>
        </b-form-group>

        <b-form-group id="input-group-5" label="Cuenta con experiencia en asesoría:" label-for="input-5">     
          <b-form-select
          id="input-5"
          v-model="expe"
          :options="opcionYN"
          required
        ></b-form-select>
        </b-form-group>

        <b-form-group id="input-group-5" label="Medio de comunicación que prefiere:" label-for="input-5">     
          <b-form-select
          id="input-5"
          v-model="contacto"
          :options="comunicacion"
          required
        ></b-form-select>
        </b-form-group>

        <b-button type="submit" variant="primary">Guardar</b-button>
        <b-button type="reset" variant="danger">Cancelar</b-button>
      </b-form>
      <div class="s" margin-top>
          <div v-if="message" class="alert alert-primary" role="alert">{{message}} </div>
        </div>
    </div>
  </b-col>
      <b-col>
        
      </b-col>
    </b-row>
  </b-container>  
</template>

<script>
import SidebarMenuAkahon from "@/components/SideBarCoord.vue"
import axios from 'axios'
  export default {
    data() {
      return {
        message:'',
        nombre: '',
        id:"",////
        vinculacion: '',
        titulo: '',
        especialidad: '',
        telefono: '',
        correo: '',
        oficina: '',
        expe:"",////
        direcRes: '',
        localidad: '',
        sectoEc: '',
        tipoOS: "",
        asignatura: [],
        asignaturas: [{ text: 'Selecione una', value: null }, 'PSU', 'CDIO'],
        contacto: [],
        comunicacion: [{ text: 'Selecione una', value: null }, 'Whatsapp', 'Teams','Correo','Llamada'],
        show: true,
        opcionYN: [{ text: 'Selecione una', value: null }, 'Si', 'No'],
        localidades: [{ text: 'Selecione una', value: null }, 'Usaquén', 'Chapinero', 'Santa Fe', 'San Cristóbal', 'Usme', 'Tunjuelito', 'Bosa', 'Kennedy', 'Fontibón', 'Engativá', 'Suba', 'Barrios Unidos', 'Teusaquillo', '	Los Mártires', 'Antonio Nariño', 'Puente Aranda', 'La Candelaria', 'Rafael Uribe Uribe', 'Ciudad Bolívar', 'Sumapaz'],
        show: true
      }
    },
    components: {
    SidebarMenuAkahon,
    },
    methods: {
      onSubmit() {
        axios.post("http://localhost:8080/aut/EditTeacher",{//
          nombre:this.nombre,
          vinculacion:this.vinculacion,
          titulo:this.titulo,
          especialidad:this.especialidad,
          telefono:this.telefono,
          correo:this.correo,
          oficina:this.oficina,
          direcRes:this.direcRes,
          localidad:this.localidad,
          sectoEc:this.sectoEc,
          tipoOS:this.tipoOS,
          asignatura:this.asignatura,
          contacto:this.contacto,
        }).then((response)=>{
          this.message=response.data.message;
          this.nombre="",
          this.vinculacion="",
          this.titulo="",
          this.especialidad="",
          this.telefono="",
          this.correo="",
          this.oficina="",
          this.direcRes="",
          this.localidad="",
          this.sectoEc="",
          this.tipoOS="",
          this.asignatura="",
          this.contacto=""
        })
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
