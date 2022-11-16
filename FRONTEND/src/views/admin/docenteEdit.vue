<template>
  <b-container>
    <div>
      <sidebar-menu-akahon />
    </div>
    <b-row>
      <b-col>
        <br><br>
        <h3>Diligencie el siguiente formulario con los datos del
          docente</h3>
        <br><br>
        <div>
          <b-form @submit="onSubmit" @reset="onReset" v-if="show">
            <b-container>
            <b-form-group id="input-group-1" label="Nombres y apellidos:" label-for="input-1">
              <b-form-input id="input-1" v-model="form.nombre" placeholder="Nombres y apellidos" required></b-form-input>
            </b-form-group>

            <b-form-group id="input-group-2" label="Vinculación:" label-for="input-2">
              <b-form-input id="input-2" v-model="form.vinculacion" placeholder="Vinculación" required>
              </b-form-input>
            </b-form-group>

            <b-form-group id="input-group-2" label="título profesional:" label-for="input-2">
              <b-form-input id="input-2" v-model="form.titulo" placeholder="título profesional" required>
              </b-form-input>
            </b-form-group>

            <b-form-group id="input-group-2" label="especialidad:" label-for="input-2">
              <b-form-input id="input-2" v-model="form.especialidad" placeholder="especialidad" required>
              </b-form-input>
            </b-form-group>

            <b-form-group id="input-group-2" label="Correo institucional:" label-for="input-2">
              <b-form-input id="input-2" v-model="form.correo" type="email" placeholder="Correo institucional" required>
              </b-form-input>
            </b-form-group>

            <b-form-group id="input-group-3" label="ID docente:" label-for="input-3">
              <b-form-input id="input-3" v-model="form.id" placeholder="ID docente" required></b-form-input>
            </b-form-group>

            <b-form-group id="input-group-4" label="Telefono:" label-for="input-4">
              <b-form-input id="input-4" v-model="form.telefono" placeholder="telefono" required></b-form-input>
            </b-form-group>

            <b-form-group id="input-group-5" label="Asignatura a la que pertenece:" label-for="input-5">
              <b-form-select id="input-5" v-model="form.asignatura" :options="asignatura" required></b-form-select>
            </b-form-group>

            <b-form-group id="input-group-2" label="oficina:" label-for="input-2">
              <b-form-input id="input-2" v-model="form.oficina" placeholder="oficina" required>
              </b-form-input>
            </b-form-group>

            <b-form-group id="input-group-2" label="dirección de residencia:" label-for="input-2">
              <b-form-input id="input-2" v-model="form.direcRes" placeholder="dirección de residencia"
                required></b-form-input>
            </b-form-group>

            <b-form-group id="input-group-2" label="Localidad/Municipio:" label-for="input-2">
              <b-form-select id="input-2" v-model="form.localidad" :options="localidad" required></b-form-select>
            </b-form-group>

            <b-form-group id="input-group-7" label="Sector económico de experiencia:" label-for="input-7">
              <b-form-select id="input-7" v-model="form.sectoEc" :options="sector" required></b-form-select>
            </b-form-group>

            <b-form-group id="input-group-5" label="Cuenta con experiencia en asesoría:" label-for="input-5">
              <b-form-select id="input-5" v-model="form.hisAse" :options="sino" required></b-form-select>
            </b-form-group>

            <b-form-group id="input-group-5" label="Medio de comunicación que prefiere:" label-for="input-5">
              <b-form-select id="input-5" v-model="form.contacto" :options="contacto" required></b-form-select>
            </b-form-group>


            <b-form-group id="input-group-6" label="Linea de acción:" label-for="input-6">
              <b-form-select id="input-5" v-model="form.lineaAc" :options="lineaAc" required></b-form-select>
            </b-form-group>

            <b-form-group id="input-group-7" label="Sector económico de preferencia:" label-for="input-7">
              <b-form-select id="input-7" v-model="form.secEco2" :options="sector" required></b-form-select>
            </b-form-group>

            <b-form-group id="input-group-4" label="Tipo de organizacion social:" label-for="input-4">
              <b-form-select id="input-5" v-model="form.tipoOS" :options="tipoOS" required></b-form-select>
            </b-form-group>

            <b-form-group id="input-group-6" label="horarios en que desea recibir notificaciones:" label-for="input-6">
              <b-form-select id="input-5" v-model="form.horarioNotif" :options="horario" required>
              </b-form-select>
            </b-form-group>

            <b-form-group id="input-group-6" label="horarios de atencion a estudiantes:" label-for="input-6">
              <b-form-select id="input-8" v-model="form.horarioAtencion" :options="horario" required>
              </b-form-select>
            </b-form-group>

            <b-form-group id="input-group-6" label="Tiene una limitacion a nivel social, psicológico o físico:"
              label-for="input-6">
              <b-form-select id="input-8" v-model="form.limitacion" :options="sino" required></b-form-select>
            </b-form-group>

            <b-form-group id="input-group-6" label="horarios de no disponibilidad:" label-for="input-6">
              <b-form-select id="input-8" v-model="form.nOdisponibilidad" :options="horario" required></b-form-select>
            </b-form-group>

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
import axios from 'axios';

export default {
  data() {
    return {
      fields: [
        { key: "nombre" },
        { key: "vinculacion" },
        { key: "titulo" },
        { key: "especialidad" },
        { key: "asignatura" },
        { key: "telefono" },
        { key: "correo" },
        { key: "oficina" },
        { key: "direcRed" },
        { key: "localidad" },
        { key: "sectoEc" },
        { key: "hisAse" },
        { key: "contacto" },
        { key: "lineaAC" },
        { key: "secEco2" },
        { key: "tipoOS" },
        { key: "horarioNotif" },
        { key: "horarioAtencion" },
        { key: "nOdisponibilidad" },
        { key: "limitacion" },
      ],
      form: {
        nombre: '',
        vinculacion: '',
        titulo: '',
        especialidad: '',
        asignatura: '',
        telefono: '',
        correo: '',
        oficina: '',
        direcRes: '',
        localidad: '',
        sectoEc: '',
        hisAse: '',
        contacto: '',
        lineaAc: '',
        secEco2: '',
        tipoOS: '',
        horarioNotif: '',
        horarioAtencion: '',
        nOdisponibilidad: '',
        limitacion: '',

      
    },

    show: true,

      vinculacion: [{ text: 'Selecione una', value: null }, 'Planta', 'Catedra', 'Otro'],
      
      asignatura: [{ text: 'Selecione una', value: null }, 'PSU', 'CDIO'],

      localidad: [{ text: 'Selecione una', value: null }, 'Usaquén', 'Chapinero', 'Santa Fe', 'San Cristóbal', 'Usme', 'Tunjuelito', 'Bosa', 'Kennedy', 'Fontibón', 'Engativá', 'Suba', 'Barrios Unidos', 'Teusaquillo', '	Los Mártires', 'Antonio Nariño', 'Puente Aranda', 'La Candelaria', 'Rafael Uribe Uribe', 'Ciudad Bolívar', 'Sumapaz'],

      sino: [{ text: 'Selecione una', value: null }, 'Si', 'No'],

      sector: [{ text: 'Selecione una', value: null }, 'Manufactura - alimentos', 'Manufactura - confecciones', 'Servicios' , 'Manufactura - artículos decorativos'],

      lineaAc: [{ text: 'Selecione una', value: null }, 'Asesoría técnica', 'Capacitacion', 'Ambas'],

      contacto: [{ text: 'Selecione una', value: null }, 'Whatsapp', 'Correo', 'Llamada', 'Conferencias virtuales'],

      tipoOS: [{ text: 'Selecione una', value: null }, 'Fundación', 'Cooperativa', 'Colegio', 'Fondo de empleados', 'Asociacion', 'Corporacion', 'Hospital', 'Otro'],
      
      horario: [{ text: 'Selecione una', value: null }, 'Entre semana AM', 'Entre semana PM', 'Entre semana 24h', 'Fines de semana AM', 'Fines de semana PM', 'Fines de semana 24h'],

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
      
      console.log(this.form.nombre)
      if (this.form.limitacion == 'Si') {
        this.form.limitacion = true;
      } else
        this.form.limitacion = false;


      axios.post("http://localhost:8080/editDoc", {
        id: this.$route.params.id,
        nombre: this.form.nombre,
        vinculacion: this.form.vinculacion,
        titulo: this.form.titulo,
        especialidad: this.form.especialidad,
        asignatura: this.form.asignatura,
        telefono: this.form.telefono,
        correo: this.form.correo,
        oficina: this.form.oficina,
        direcRes: this.form.direcRes,
        localidad: this.form.localidad,
        sectoEc: this.form.sectoEc,
        hisAse: this.form.hisAse,
        contacto: this.form.contacto,
        lineaAc: this.form.lineaAc,
        secEco2: this.form.secEco2,
        tipoOS: this.form.tipoOS,
        horarioNotif: this.form.horarioNotif,
        horarioAtencion: this.form.horarioAtencion,
        nOdisponibilidad: this.form.nOdisponibiliada,
        limitacion: this.form.limitacion,

      });

    },
  onReset(event) {
    event.preventDefault()
    // Reset our form values
        this.form.nombre = ''
        this.form.vinculacion = null
        this.form.titulo = ''
        this.form.especialidad = ''
        this.form.asignatura = null
        this.form.telefono = ''
        this.form.correo = ''
        this.form.oficina = ''
        this.form.direcRes = ''
        this.form.localidad = null
        this.form.sectoEc = null
        this.form.hisAse = null
        this.form.contacto = ''
        this.form.lineaAc = null
        this.form.secEco2 = null
        this.form.tipoOS = null
        this.form.horarioNotif = null
        this.form.horarioAtencion = null
        this.form.nOdisponibiliada = null
        this.form.limitacion = null
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
