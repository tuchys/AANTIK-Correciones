<template>
  <b-container>
    <div>
      <sidebar-menu-akahon />
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
                <b-form-group id="input-group-1" label="Nombres del emprendimiento:" label-for="input-122">
                  <b-form-input id="input-122" v-model="form.nombreEmp" placeholder="Nombre" required></b-form-input>
                </b-form-group>

                <b-form-group id="input-group-2" label="Nit del emprendimiento:" label-for="input-2">
                  <b-form-input id="input-2" v-model="form.nitId"  placeholder="NIT"
                    required></b-form-input>
                </b-form-group>

                <b-form-group id="input-group-1" label="Nombres de la organización social:" label-for="input-1">
                  <b-form-input id="input-1" v-model="form.orgSocial" placeholder="Organización" required>
                  </b-form-input>
                </b-form-group>

                <b-form-group id="input-group-2" label="Nombre del Interlocutor:" label-for="input-2">
                  <b-form-input id="input-2" v-model="form.interlocutorEmp" placeholder="Nombre Interlocutor"
                    required></b-form-input>
                </b-form-group>

                <b-form-group id="input-group-2" label="Correo Interlocutor:" label-for="input-2">
                  <b-form-input id="input-2" v-model="form.correoIE" type="email" placeholder="Correo Interlocutor"
                    required></b-form-input>
                </b-form-group>

                <b-form-group id="input-group-7" label="Teléfono:" label-for="input-7">
                  <b-form-input id="input-7" v-model="form.telefonoIE" placeholder="Teléfono" required></b-form-input>
                </b-form-group>
              </b-col>
              <b-col>
                <b-form-group id="input-group-3" label="Fecha de constitución:" label-for="input-3">
                  <b-form-input id="input-3" v-model="form.fechaCons" placeholder="dd/mm/aaaa" required></b-form-input>
                </b-form-group>

                <b-form-group id="input-group-4" label="Dirección:" label-for="input-4">
                  <b-form-input id="input-4" v-model="form.direccion" placeholder="Dirección" required></b-form-input>
                </b-form-group>

                <b-form-group id="input-group-5" label="Localidad /Municipio:" label-for="input-5">
                  <b-form-select id="input-5" v-model="form.localidad" :options="localidad" required></b-form-select>
                </b-form-group>

                <b-form-group id="input-group-4" label="Barrio:" label-for="input-4">
                  <b-form-input id="input-4" v-model="form.barrio" placeholder="barrio" required></b-form-input>
                </b-form-group>

                <b-form-group id="input-group-4" label="Productos y servicios:" label-for="input-4">
                  <b-form-input id="input-4" v-model="form.prodServ" placeholder="productos y servicios" required></b-form-input>
                </b-form-group>

                <b-form-group id="input-group-4" label="Cuantos estudiantes recibe:" label-for="input-4">
                  <b-form-input id="input-4" v-model="form.cupos" placeholder="cupos" required></b-form-input>
                </b-form-group>

                <b-form-group id="input-group-4" label="Numero de empleados:" label-for="input-4">
                  <b-form-input id="input-4" v-model="form.empleados" placeholder="Numero de empleados" required></b-form-input>
                </b-form-group>

                <b-form-group id="input-group-4" label="Comunidad del emprendimiento:" label-for="input-4">
                  <b-form-select id="input-4" v-model="form.comunidad" :options="comunidad" required></b-form-select>
                </b-form-group>

                <b-form-group id="input-group-4" label="Linea de acción:" label-for="input-4">
                  <b-form-select id="input-4" v-model="form.linAccion" :options="linAccion" required></b-form-select>
                </b-form-group>

                <b-form-group id="input-group-4" label="Tema de asesoria:" label-for="input-4">
                    <b-form-select id="input-4" v-model="form.temaAsesorar" :options="temas" required></b-form-select>
                </b-form-group>

                <b-form-group id="input-group-4" label="Actividad económica:" label-for="input-4">
                  <b-form-input id="input-4" v-model="form.actividadEco" placeholder="Actividad" required></b-form-input>
                </b-form-group>

                <h4>DATOS DE INTERLOCUTOR DE LA ORGANIZACIÓN SOCIAL</h4>
                <b-form-group id="input-group-6" label="Nombre:" label-for="input-6">
                  <b-form-input id="input-6" v-model="form.nombreInterOS" placeholder="Nombre" required></b-form-input>
                </b-form-group>

                <b-form-group id="input-group-77" label="Teléfono:" label-for="input-77">
                  <b-form-input id="input-77" v-model="form.telefonoIOS" placeholder="Teléfono" required></b-form-input>
                </b-form-group>

                <b-form-group id="input-group-8" label="correo electrónico:" label-for="input-8">
                  <b-form-input id="input-8" v-model="form.correoIOS" placeholder="correo electrónico" required>
                  </b-form-input>
                </b-form-group>
                <h4>DATOS DE PERSONALIZACIÓN</h4>
                <b-form-group id="input-group-6" label="Requiere estudiante con algún tipo de experiencia:"
                  label-for="input-6">
                  <b-form-select id="input-5" v-model="form.experiencia" :options="sino" required></b-form-select>
                </b-form-group>

                <b-form-group id="input-group-6" label="Requiere estudiantes con alto promedio:" label-for="input-6">
                  <b-form-select id="input-5" v-model="form.promedio" :options="sino" required></b-form-select>
                </b-form-group>

                <b-form-group id="input-group-6" label="horarios en que desea recibir notificaciones:"
                  label-for="input-6">
                  <b-form-select id="input-5" v-model="form.horarioNotif" :options="horario" required></b-form-select>
                </b-form-group>

                <b-form-group id="input-group-6" label="horarios de atención a estudiantes:"
                  label-for="input-6">
                  <b-form-select id="input-5" v-model="form.horarioAtencion" :options="horario" required></b-form-select>
                </b-form-group>

                
                <b-form-group id="input-group-6" label="horarios de disponibildiad:"
                  label-for="input-6">
                  <b-form-select id="input-5" v-model="form.disponibilidad" :options="horario" required></b-form-select>
                </b-form-group>

                <b-form-group id="input-group-6" label="Medio de contacto:"
                  label-for="input-6">
                  <b-form-select id="input-5" v-model="form.contacto" :options="contacto" required></b-form-select>
                </b-form-group>

                <b-form-group id="input-group-6" label="modalidad de contacto:"
                  label-for="input-6">
                  <b-form-select id="input-5" v-model="form.modalidad" :options="modalidad" required></b-form-select>
                </b-form-group>

                <b-form-group id="input-group-6" label="preferencia o restriccion de genero:"
                  label-for="input-6">
                  <b-form-select id="input-5" v-model="form.genero" :options="genero" required></b-form-select>
                </b-form-group>

                
                <b-form-group id="input-group-6" label="Acceso para personas con dificultades:"
                  label-for="input-6">
                  <b-form-select id="input-5" v-model="form.limitacion" :options="sino" required></b-form-select>
                </b-form-group>


                <b-form-group id="input-group-6" label="Es de preferencia asistir con transporte:"
                  label-for="input-6">
                  <b-form-select id="input-5" v-model="form.transporte" :options="sino" required></b-form-select>
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
import axios from 'axios';

export default {
  data() {
    return {
      fields: [
        { key: "nombreEmp" },
        { key: "direccion" },
        { key: "prodServ" },
        { key: "linAccion" },
        { key: "nitId" },
        { key: "fechaCons" },
        { key: "orgSocial" },
        { key: "localidad" },
        { key: "barrio" },
        { key: "temaAsesorar" },
        { key: "interlocutorEmp" },
        { key: "telefonoIE" },
        { key: "correoIE" },
        { key: "nombreInterOS" },
        { key: "telefonoIOS" },
        { key: "correoIOS" },
        { key: "cupos" },
        { key: "empleados" },
        { key: "actividadEco" },
        { key: "contacto" },
        { key: "experiencia" },
        { key: "promedio" },
        { key: "horarioNotif" },
        { key: "modalidad" },
        { key: "disponibilidad" },
        { key: "horarioAtencion" },
        { key: "genero" },
        { key: "limitacion" },
        { key: "comunidad" },
        { key: "transporte" },
      ],
      form: {
        nombreEmp: '',
        direccion: '',
        prodServ: '',
        linAccion: '',
        nitId: '',
        fechaCons: '',
        orgSocial: '',
        localidad: '',
        barrio: '',
        temaAsesorar: '',
        interlocutorEmp: '',
        telefonoIE: '',
        correoIE: '',
        nombreInterOS: '',
        telefonoIOS: '',
        correoIOS: '',
        cupos: '',
        empleados: '',
        actividadEco: '',
        contacto: '',
        experiencia: '',
        promedio: '',
        horarioNotif: '',
        modalidad: '',
        disponibilidad: '',
        horarioAtencion: '',
        genero: '',
        limitacion: '',
        comunidad: '',
        transporte: '',
      },
      show: true,

      localidad: [{ text: 'Selecione una', value: null }, 'Usaquén', 'Chapinero', 'Santa Fe', 'San Cristóbal', 'Usme', 'Tunjuelito', 'Bosa', 'Kennedy', 'Fontibón', 'Engativá', 'Suba', 'Barrios Unidos', 'Teusaquillo', '	Los Mártires', 'Antonio Nariño', 'Puente Aranda', 'La Candelaria', 'Rafael Uribe Uribe', 'Ciudad Bolívar', 'Sumapaz'],

      sino: [{ text: 'Selecione una', value: null }, 'Si', 'No'],

      linAccion: [{ text: 'Selecione una', value: null }, 'Acesoria tecnica', 'Capacitacion', 'Ambas'],

      contacto: [{ text: 'Selecione una', value: null }, 'Whatsapp', 'Correo', 'Llamada', 'Conferencias virtuales'],

      horario: [{ text: 'Selecione una', value: null }, 'Entre semana AM', 'Entre semana PM', 'Entre semana 24h', 'Fines de semana AM', 'Fines de semana PM', 'Fines de semana 24h'],

      modalidad: [{ text: 'Selecione una', value: null }, 'Mixta', 'Presencial', 'Virtual'],

      genero: [{ text: 'Selecione una', value: null }, 'Indiferente', 'Masculino', 'Femenino'],

      comunidad: [{ text: 'Selecione una', value: null }, 'Niños 0-3', 'Jovenes 18-30', 'Adiltos 30-60', 'Ancianos 60+'],
      
      temas: [{ text: 'Selecione una', value: null }, 'Calidad', 'Seguridad industrial', 'Marketing', 'Recursos humanos', 'Gestión', 'Finanzas', 'Administración', 'Análisis de datos', 'Producción', 'Procesos', 'Sistemas de información'],

      show: true,
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

      if (this.form.experiencia == 'Si') {
        this.form.experiencia = true;
      } else
        this.form.experiencia = false;

      if (this.form.promedio == 'Si') {
        this.form.promedio = true;
      } else
        this.form.promedio = false;

      if (this.form.genero == 'Masculino') {
        this.form.genero = "M";
      } else if (this.form.genero == 'Femenino') {
        this.form.genero = "F";
      } else
        this.form.genero = "I";

      if (this.form.limitacion == 'Si') {
        this.form.limitacion = true;
      } else
        this.form.limitacion = false;

      if (this.form.transporte == 'Si') {
        this.form.transporte = true;
      } else
        this.form.transporte = false;

      if (this.form.modalidad == 'Virtual') {
        this.form.modalidad = "v";
      } else if (this.form.modalidad == 'Presencial') {
        this.form.modalidad = "p";
      } else
        this.form.modalidad = "m";

        console.log(this.form)

      axios.post("http://localhost:8080/addemprendimientos", {
        nombreEmp: this.form.nombreEmp,
        direccion: this.form.direccion,
        prodServ: this.form.prodServ,
        linAccion: this.form.linAccion,
        nitId: this.form.nitId,
        fechaCons: this.form.fechaCons,
        orgSocial: this.form.orgSocial,
        localidad: this.form.localidad,
        barrio: this.form.barrio,
        temaAsesorar: this.form.temaAsesorar,
        interlocutorEmp: this.form.interlocutorEmp,
        telefonoIE: this.form.telefonoIE,
        correoIE: this.form.correoIE,
        nombreInterOS: this.form.nombreInterOS,
        telefonoIOS: this.form.telefonoIOS,
        correoIOS: this.form.correoIOS,
        cupos: this.form.cupos,
        empleados: this.form.empleados,
        actividadEco: this.form.actividadEco,
        contacto: this.form.contacto,
        experiencia: this.form.experiencia,
        promedio: this.form.promedio,
        horarioNotif: this.form.horarioNotif,
        modalidad: this.form.modalidad,
        disponibilidad: this.form.disponibilidad,
        horarioAtencion: this.form.horarioAtencion,
        genero: this.form.genero,
        limitacion: this.form.limitacion,
        comunidad: this.form.comunidad,
        transporte: this.form.transporte,
        

      }).catch((error) => {
    if( error.response ){
        console.log(error.response.data); // => the response payload 
    }
    window.location.reload();
});

    },


    onReset(event) {
      event.preventDefault()
      // Reset our form values

      this.nombreEmp = ''
      this.direccion = ''
      this.prodServ = ''
      this.linAccion = null
      this.nitId = ''
      this.fechaCons = ''
      this.orgSocial = ''
      this.localidad = null
      this.barrio = ''
      this.temaAsesorar = ''
      this.interlocutorEmp = ''
      this.telefonoIE = ''
      this.correoIE = ''
      this.nombreInterOS = ''
      this.telefonoIOS = ''
      this.correoIOS = ''
      this.cupos = ''
      this.empleados = ''
      this.actividadEco = null
      this.contacto = null
      this.experiencia = null
      this.promedio = null
      this.horarioNotif = null
      this.modalidad = null
      this.disponibilidad = null
      this.horarioAtencion = null
      this.genero = null
      this.limitacion = null
      this.comunidad = null
      this.transporte = null
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