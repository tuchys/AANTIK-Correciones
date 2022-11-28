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
    estudiante</h3>
    <br><br>
    <div>
      <b-form @submit="onSubmit" @reset="onReset" >
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

        <b-form-group id="input-group-3" label="ID estudiantil:" label-for="input-3">     
          <b-form-input
            id="input-3"
            v-model="idEstudiantil"
            placeholder="ID estudiantil"
            required
          ></b-form-input>
        </b-form-group>
        
        <b-form-group id="input-group-4" label="Cédula:" label-for="input-4">     
          <b-form-input
            id="input-4"
            v-model="documento"
            placeholder="Cédula"
            required
          ></b-form-input>
        </b-form-group>

        <b-form-group id="input-group-5" label="Asignatura a inscribir:" label-for="input-5">     
          <b-form-select
          id="input-5"
          v-model="asignatura"
          :options="asignaturaa"
          required
        ></b-form-select>
        </b-form-group>

        <b-form-group id="input-group-6" label="Fecha en que asistió a charla sentido de mi práctica:" label-for="input-6">     
          <b-form-input
            id="input-6"
            v-model="fechaSP"
            placeholder="dd/mm/aaaa"
            required
          ></b-form-input>
        </b-form-group>

        <b-form-group id="input-group-7" label="Teléfono:" label-for="input-7">     
          <b-form-input
            id="input-7"
            v-model="telefono"
            placeholder="Teléfono"
            required
          ></b-form-input>
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
          message:"",
          correo: "",
          documento:"",
          nombre: "",
          idEstudiantil:"",
          telefono: "",
          fechaSP:"",
          asignatura:[],
        asignaturaa: [{ text: 'Selecione una', value: null }, 'PSU', 'CDIO'],
      }
    },
    components: {
    SidebarMenuAkahon,
    },
    methods: {
      onSubmit() {
        console.log(this.asig)
      
        axios.post("http://localhost:8080/aut/agregEst",{
          correo:this.correo,
          documento:this.documento,
          nombre:this.nombre,
          idEstudiantil:this.idEstudiantil,
          telefono:this.telefono,
          fechaSP:this.fechaSP,
          asignatura:this.asignatura
        }).then((response)=>{
          this.message=response.data.message;
          this.correo="",
          this.documento="",
          this.nombre="",
          this.idEstudiantil="",
          this.telefono="",
          this.fechaSP="",
          this.asignatura=""
        })
        


      },
      onReset(event) {
        event.preventDefault()
        // Reset our form values
        this.correo="",
          this.documento="",
          this.nombre="",
          this.idEstudiantil="",
          this.telefono="",
          this.fechaSP="",
          this.asignatura=""
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
s{
  margin-top: 5px;
}
.alert{
  margin-top: 10px;
}
</style>
