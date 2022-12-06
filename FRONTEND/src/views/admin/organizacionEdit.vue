<template>
  <b-container>
    <div>
      <sidebar-menu-akahon/>
    </div>
    <b-row>
      <b-col>
        <br>
        <br>
        <br>
        <h3>Modifique los valores del formulario con los datos a actualizar de la organización social</h3>
        <br>
    <h2>{{ idOS }}</h2><br>
        <div>
          <b-form @submit="onSubmit" @reset="onReset" v-if="show">

            <b-container>
              <b-col>
                <b-form-group id="input-group-1" label="Nombres de la organización social:" label-for="input-1">
                  <b-form-input id="input-1" v-model="form.nombreEmp" required></b-form-input>
                  <br>
                NIT de la organización social:
                  <b-form-input id="input-1" v-model="form.nitId" placeholder="NIT" required></b-form-input>
                </b-form-group>

                <b-form-group id="input-group-3" label="Fecha de constitución:" label-for="input-3">
                  <b-form-input id="input-3" v-model="form.fechaCons" placeholder="dd/mm/aaaa" required></b-form-input>
                </b-form-group>

                <b-form-group id="input-group-4" label="Dirección:" label-for="input-4">
                  <b-form-input id="input-4" v-model="form.direccion" placeholder="Dirección" required></b-form-input>
                </b-form-group>

                <b-form-group id="input-group-5" label="Localidad /Municipio:" label-for="input-5">
                  <b-form-select id="input-5" v-model="form.localidad" :selected="form.localidad" :options="localidad" required>
                    <option :selected="form.localidad">{{form.localidad}}</option>
                  </b-form-select>
                </b-form-group>
                <b-form-group id="input-group-4" label="Barrio:" label-for="input-4">
                  <b-form-input id="input-4" v-model="form.barrio" placeholder="Barrio" required></b-form-input>
                </b-form-group>

                <b-form-group id="input-group-4" label="Tema de asesoria:" label-for="input-4">
                  <b-form-input id="input-4" v-model="form.temaAsesorar" placeholder="Tema de asesoria" required>
                  </b-form-input>
                </b-form-group>

                <b-form-group id="input-group-4" label="Numero de estudiantes que necesita:" label-for="input-4">
                  <b-form-input id="input-4" v-model="form.cupos" placeholder="cupos" required></b-form-input>
                </b-form-group>

                <b-form-group id="input-group-4" label="Número de empleados:" label-for="input-4">
                  <b-form-input id="input-4" v-model="form.empleados" placeholder="Número de empleados" required>
                  </b-form-input>
                </b-form-group>

                <b-form-group id="input-group-6" label="Linea de acción:" label-for="input-6">
                  <b-form-select id="input-5" v-model="form.linAccion" :options="linAccion" required>
                    <option :selected="form.linAccion">{{form.linAccion}}</option>
                  </b-form-select>
                </b-form-group>


                <b-form-group id="input-group-4" label="Tipo de organizacion social:" label-for="input-4">
                  <b-form-select id="input-5" v-model="form.tipoOS" :options="tipoOS" required>
                    <option :selected="form.tipoOS">{{form.tipoOS}}</option>
                  </b-form-select>
                </b-form-group>

                <b-form-group id="input-group-4" label="Actividad económica:" label-for="input-4">
                  <b-form-input id="input-4" v-model="form.actividadEco" placeholder="Tipo" required></b-form-input>
                </b-form-group>

                <b-form-group id="input-group-4" label="Producto o servico que ofrece:" label-for="input-4">
                  <b-form-input id="input-4" v-model="form.prodServ" placeholder="producto o servicio" required>
                  </b-form-input>
                </b-form-group>


                <h4>DATOS DE INTERLOCUTOR DE LA ORGANIZACIÓN SOCIAL</h4>
                <b-form-group id="input-group-6" label="Nombre:" label-for="input-6">
                  <b-form-input id="input-6" v-model="form.nombreInterOS" placeholder="Nombre" required></b-form-input>
                </b-form-group>

                <b-form-group id="input-group-7" label="Teléfono:" label-for="input-7">
                  <b-form-input id="input-7" v-model="form.telefonoIOS" placeholder="Teléfono" required></b-form-input>
                </b-form-group>

                <b-form-group id="input-group-8" label="correo electrónico:" label-for="input-8">
                  <b-form-input id="input-8" v-model="form.correoIOS" placeholder="correo electrónico" required>
                  </b-form-input>
                </b-form-group>
                <h4>DATOS DE PERSONALIZACIÓN</h4>
                <b-form-group id="input-group-6" label="Requiere estudiante con algún tipo de experiencia:"
                  label-for="input-6">
                  <b-form-select id="input-5" v-model="form.experiencia" :options="sino" required>
                    <option :selected="form.experiencia">{{form.experiencia}}</option>
                  </b-form-select>
                </b-form-group>

                <b-form-group id="input-group-6" label="Requiere estudiantes con alto promedio:" label-for="input-6">
                  <b-form-select id="input-5" v-model="form.promedio" :options="sino" required>
                    <option :selected="form.promedio">{{form.promedio}}</option>
                  </b-form-select>
                </b-form-group>

                <b-form-group id="input-group-6" label="horarios en que desea recibir notificaciones:"
                  label-for="input-6">
                  <b-form-select id="input-5" v-model="form.horarioNotif" :options="horario" required>
                    <option :selected="form.horarioNotif">{{form.horarioNotif}}</option>
                  </b-form-select>
                </b-form-group>

                <b-form-group id="input-group-6" label="medio de contacto preferido:" label-for="input-6">
                  <b-form-select id="input-9" v-model="form.contacto" :options="contacto" required>
                    <option :selected="form.contacto">{{form.contacto}}</option>
                  </b-form-select>
                </b-form-group>

                <b-form-group id="input-group-6" label="seleccione la modalidad:" label-for="input-6">
                  <b-form-select id="input-8" v-model="form.modalidad" :options="modalidad" required>
                    <option :selected="form.modalidad">{{form.modalidad}}</option>
                  </b-form-select>
                </b-form-group>

                <b-form-group id="input-group-6" label="horarios de atencion a estudiantes:" label-for="input-6">
                  <b-form-select id="input-8" v-model="form.horarioAtencion" :options="horario" required>
                    <option :selected="form.horarioAtencion">{{form.horarioAtencion}}</option>
                  </b-form-select>
                </b-form-group>

                <b-form-group id="input-group-6" label="horarios de visita de estudiantes:" label-for="input-6">
                  <b-form-select id="input-8" v-model="form.disponibilidad" :options="horario" required>
                    <option :selected="form.disponibilidad">{{form.disponibilidad}}</option>
                  </b-form-select>
                </b-form-group>

                <b-form-group id="input-group-6" label="Restricciones de genero:" label-for="input-6">
                  <b-form-select id="input-8" v-model="form.genero" :options="genero" required>
                    <option :selected="form.genero">{{form.genero}}</option>
                  </b-form-select>
                </b-form-group>

                <b-form-group id="input-group-6" label="Acceso a personas con discapacidades:" label-for="input-6">
                  <b-form-select id="input-8" v-model="form.limitacion" :options="sino" required>
                    <option :selected="form.limitacion">{{form.limitacion}}</option>
                  </b-form-select>
                </b-form-group>

                <b-form-group id="input-group-6" label="Comunidad de la Organizacion:" label-for="input-6">
                  <b-form-select id="input-8" v-model="form.comunidad" :options="comunidad" required>
                    <option :selected="form.comunidad">{{form.comunidad}}</option>
                  </b-form-select>
                </b-form-group>

                <b-form-group id="input-group-6" label="Estudiante con transporte:" label-for="input-6">
                  <b-form-select id="input-8" v-model="form.transporte" :options="sino" required>
                    <option :selected="form.transporte">{{form.transporte}}</option>
                  </b-form-select>
                </b-form-group>


              </b-col>
              <b-button type="submit" variant="primary" @click="actualizar(form)">Actualizar</b-button>
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
import SidebarMenuAkahon from "@/components/SideBarAdmin.vue"
import admService from "@/service/adminServices";

export default {
  props: {
    idOS: String
  },
  data() {
    return {
      form: {
        nombreEmp: 'hj',
        nitId: 'hhh',
        fechaCons: '12/5/2',
        direccion: '',
        localidad: '',
        barrio: '',
        nombreInterOS: '',
        telefonoIOS: '',
        correoIOS: '',
        temaAsesorar: '',
        cupos: '',
        empleados: '',
        linAccion: '',
        tipoOS: '',
        actividadEco: '',
        prodServ: '',
        contacto: '',
        experiencia: '',
        promedio: '',
        horarioNotif: '',
        modalidad: '',
        diponibilidad: '',
        horarioAtencion: '',
        genero: '',
        limitacion: '',
        comunidad: '',
        transporte: '',
      },
      localidad: [{ text: 'Selecione una', value: null }, 'Usaquén', 'Chapinero', 'Santa Fe', 'San Cristóbal', 'Usme', 'Tunjuelito', 'Bosa', 'Kennedy', 'Fontibón', 'Engativá', 'Suba', 'Barrios Unidos', 'Teusaquillo', '	Los Mártires', 'Antonio Nariño', 'Puente Aranda', 'La Candelaria', 'Rafael Uribe Uribe', 'Ciudad Bolívar', 'Sumapaz'],
      sino: [{ text: 'Selecione una', value: null }, 'Si', 'No'],
      linAccion: [{ text: 'Selecione una', value: null }, 'Acesoria tecnica', 'Capacitacion', 'Ambas'],
      tipoOS: [{ text: 'Selecione una', value: null }, 'Fundación', 'Cooperativa', 'Colegio', 'Fondo de empleados', 'Asociacion', 'Corporacion', 'Hospital', 'Otro'],
      contacto: [{ text: 'Selecione una', value: null }, 'Whatsapp', 'Correo', 'Llamada', 'Conferencias virtuales'],
      horario: [{ text: 'Selecione una', value: null }, 'Entre semana AM', 'Entre semana PM', 'Entre semana 24h', 'Fines de semana AM', 'Fines de semana PM', 'Fines de semana 24h'],
      horario2: [{ text: 'Selecione una', value: null }, 'Entre semana AM', 'Entre semana PM', 'Entre semana 24h', 'Fines de semana AM', 'Fines de semana PM', 'Fines de semana 24h'],
      modalidad: [{ text: 'Selecione una', value: null }, 'Mixta', 'Presencial', 'Virtual'],
      genero: [{ text: 'Selecione una', value: null }, 'Indiferente', 'Masculino', 'Femenino'],
      comunidad: [{ text: 'Selecione una', value: null }, 'Niños 0-3', 'Jovenes 18-30', 'Adultos 30-60', 'Ancianos 60+'],
      show: true,
    }
  },
  components: {
    SidebarMenuAkahon,
  }, 
  created() {
        this.admService = new admService();
        this.getOS(this.idOS);
  },
  methods: {
    getOS(idorgs) {
            console.log("gj-----",idorgs);
        this.admService.getOS(idorgs).then(data => {
          this.form = data.data;
          if (this.form.experiencia == true) {
            this.form.experiencia = 'Si';
          } else
            this.form.experiencia = 'No';
          if (this.form.promedio == true) {
            this.form.promedio = 'Si';
          } else
            this.form.promedio = 'No';

          if (this.form.genero == 'M') {
            this.form.genero = 'Masculino';
          } else if (this.form.genero == 'F') {
            this.form.genero = "Femenino";
          } else
            this.form.genero = "Indiferente";

          if (this.form.limitacion == true) {
            this.form.limitacion = 'Si';
          } else
            this.form.limitacion = 'No';

          if (this.form.transporte == true) {
            this.form.transporte = 'Si';
          } else
            this.form.transporte = 'No';

          if (this.form.modalidad == 'V') {
            this.form.modalidad = "Virtual";
          } else if (this.form.modalidad == 'P') {
            this.form.modalidad = "Presencial";
          } else
            this.form.modalidad = "Mixta";
          console.log("gj-----");
          console.log("key-----",typeof data.headers);
        });        
    },
    actualizar(formR){
      console.log(formR.nitId);
    },
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
        this.form.modalidad = "V";
      } else if (this.form.modalidad == 'Presencial') {
        this.form.modalidad = "P";
      } else
        this.form.modalidad = "M";

      this.admService.getActulizacion(this.form,this.idOS).
      then(function(response) {
          console.log(response.data);
      }).catch(function(error) {
          console.log(error);
      });
    },


    onReset(event) {
      event.preventDefault()
      // Reset our form values
      this.form.nombreEmp = ''
      this.form.nitId = ''
      this.form.fechaCons = ''
      this.form.direccion = ''
      this.form.localidad = null
      this.form.barrio = ''
      this.form.nombreInterOS = ''
      this.form.telefonoIOS = ''
      this.form.correoIOS = ''
      this.form.temaAsesorar = ''
      this.form.cupos = ''
      this.form.empleados = ''
      this.form.linAccion = null
      this.form.tipoSO = null
      this.form.actividadEco = ''
      this.form.prodServ = ''
      this.form.contacto = null
      this.form.experiencia = null
      this.form.promedio = null
      this.form.horarioNotif = null
      this.form.modalidad = null
      this.form.disponibilidad = null
      this.form.horarioAtencion = null
      this.form.genero = null
      this.form.limitacion = null
      this.form.comunidad = null
      this.form.transporte = null
      this.form.checked = []
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