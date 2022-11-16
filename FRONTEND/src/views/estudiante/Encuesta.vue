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
    <h3>Diligencie el siguiente formulario de personalización para encontrar el emprendimiento más apropiado</h3>
    <br><br>
    <div>
      <b-form @submit="onSubmit" @reset="onReset" v-if="show">
        
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

        <b-form-group id="input-group-5" label="Asignatura a inscribir:" label-for="input-5">     
          <b-form-select
          id="input-5"
          v-model="form.asignatura"
          :options="asignatura"
          required
        ></b-form-select>
        </b-form-group>

        <b-form-group id="input-group-5" label="Genero:" label-for="input-6">     
          <b-form-select
          id="input-6"
          v-model="form.genero"
          :options="genero"
          required
        ></b-form-select>
        </b-form-group>

        <b-form-group id="input-group-6" label="Fecha en que asistió a charla sentido de mi práctica:" label-for="input-7">     
          <b-form-input
            id="input-7"
            v-model="form.fechaTaller"
            placeholder="dd/mm/aaaa"
            required
          ></b-form-input>
        </b-form-group>

        <b-form-group id="input-group-7" label="Teléfono:" label-for="input-8">     
          <b-form-input
            id="input-8"
            v-model="form.telefono"
            placeholder="Teléfono"
            required
          ></b-form-input>
        </b-form-group>

        <b-form-group id="input-group-5" label="Municipio:" label-for="input-9">     
          <b-form-select
          id="input-9"
          v-model="form.municipio"
          :options="municipio"
          required
        ></b-form-select>
        </b-form-group>

        <b-form-group id="input-group-5" label="Localidad:" label-for="input-10">     
          <b-form-select
          id="input-10"
          v-model="form.localidad"
          :options="localidad"
        ></b-form-select>
        </b-form-group>

        <b-form-group id="input-group-4" label="Barrio:" label-for="input-11">     
          <b-form-input
            id="input-11"
            v-model="form.barrio"
            placeholder="Barrio"
            required
          ></b-form-input>
        </b-form-group>

        <b-form-group id="input-group-4" label="Dirección:" label-for="input-12">     
          <b-form-input
            id="input-12"
            v-model="form.direccion"
            placeholder="Direción"
            required
          ></b-form-input>
        </b-form-group>

        <b-form-group id="input-group-4" label="¿Realiza actualmente alguna actividad extracurricular? (trabajo, entrenamiento, etc.)
:" label-for="input-13">     
          <b-form-select
            id="input-13"
            v-model="form.actividad"
            :options="actividad"
            required
          ></b-form-select>
        </b-form-group>

        <b-form-group id="input-group-4" label="¿Cuáles?:" label-for="input-14">     
          <b-form-input
            id="input-14"
            v-model="form.cualesactiv"
            placeholder="¿Cuáles?"
            required
          ></b-form-input>
        </b-form-group>

        <b-form-group id="input-group-4" label="¿Cuenta con experiencia de más de un año en las siguientes actividades?" label-for="input-15">     
          <b-form-select
            id="input-15"
            v-model="form.experiencia"
            :options="experiencia"
            required
          ></b-form-select>
        </b-form-group>

        <b-form-group id="input-group-4" label="¿Tiene usted algún tipo de limitaciones a nivel social, psicológico o física?" label-for="input-16">     
          <b-form-select
            id="input-16"
            v-model="form.limitacion"
            :options="limitacion"
            required
          ></b-form-select>
        </b-form-group>

        <b-form-group id="input-group-5" label="¿Tiene alguna limitación para realizar su práctica social en alguna localidad de Bogotá?" label-for="input-17">     
          <b-form-select
          id="input-17"
          v-model="form.localidadrest"
          :options="localidad"
          required
        ></b-form-select>
        </b-form-group>

        <b-form-group id="input-group-4" label="¿Cuenta con algún tipo de transporte?" label-for="input-18">     
          <b-form-select
            id="input-18"
            v-model="form.transporte"
            :options="transporte"
            required
          ></b-form-select>
        </b-form-group>

        <b-form-group id="input-group-4" label="Ingrese el nombre del docente de su preferencia" label-for="input-19">     
          <b-form-select
            id="input-19"
            v-model="form.profe"
            :options="profe"
            required
          ></b-form-select>
        </b-form-group>

        <b-form-group id="input-group-4" label="Ingrese el nombre del docente que no es de su preferencia" label-for="input-20">     
          <b-form-select
            id="input-20"
            v-model="form.profen"
            :options="profe"
            required
          ></b-form-select>
        </b-form-group>

        <b-form-group id="input-group-4" label="¿A qué categoría corresponde su promedio acumulado?" label-for="input-21">     
          <b-form-select
            id="input-21"
            v-model="form.prom"
            :options="prom"
            required
          ></b-form-select>
        </b-form-group>

        <b-form-group id="input-group-4" label="Establezca el énfasis que seleccionado según su carrera" label-for="input-22">     
          <b-form-select
            id="input-22"
            v-model="form.enfasis"
            :options="enfasis"
            required
          ></b-form-select>
        </b-form-group>

        <b-form-group id="input-group-4" label="Seleccione el medio de contacto con el que usted prefiere comunicarse con su interlocutor" label-for="input-23">     
          <b-form-select
            id="input-23"
            v-model="form.contacto"
            :options="contacto"
            required
          ></b-form-select>
        </b-form-group>

        <b-form-group id="input-group-4" label="Seleccione la línea de acción de su interés" label-for="input-24">     
          <b-form-select
            id="input-24"
            v-model="form.pref"
            :options="pref"
            required
          ></b-form-select>
        </b-form-group>

        <b-form-group id="input-group-4" label="Seleccione la modalidad de contacto que prefiere tener con el interlocutor" label-for="input-25">     
          <b-form-select
            id="input-25"
            v-model="form.modalidad"
            :options="modalidad"
            required
          ></b-form-select>
        </b-form-group>

        <b-form-timepicker id="input-group-4" label="¿Cuáles son los días que cuenta con mayor disponibilidad para comunicarse con el interlocutor e ir al espacio de trabajo?" label-for="input-26">     
          <b-form-select
            id="input-26********************************************************************"
            v-model="form.dia"
            :options="modalidad"
            required
          ></b-form-select>
        </b-form-timepicker>
        
        <b-form-group id="input-group-4" label="Seleccione el tipo de organización social a la que le interesa ser asignado" label-for="input-27">     
          <b-form-select
            id="input-27"
            v-model="form.tipoorg"
            :options="tipoorg"
            required
          ></b-form-select>
        </b-form-group>

        <b-form-group id="input-group-4" label="Seleccione el tipo de emprendimiento al que le interesa ser asignado" label-for="input-28">     
          <b-form-select
            id="input-28"
            v-model="form.tipoemp"
            :options="tipoemp"
            required
          ></b-form-select>
        </b-form-group>

        <b-form-group id="input-group-4" label="Seleccione las actividades económicas de su interés del emprendimiento" label-for="input-29">     
          <b-form-select
            id="input-29"
            v-model="form.eco"
            :options="eco"
            required
          ></b-form-select>
        </b-form-group>

        <b-form-group id="input-group-4" label="¿De las siguientes comunidades a quienes les gustaría beneficiar en su práctica social?" label-for="input-30">     
          <b-form-select
            id="input-30"
            v-model="form.comun"
            :options="comun"
            required
          ></b-form-select>
        </b-form-group>

        <b-form-group id="input-group-4" label="Cual es el factor mas importanta para usted al momento de elegir la entidad" label-for="input-31">     
          <b-form-select
            id="input-31"
            v-model="form.nivel"
            :options="nivel"
            required
          ></b-form-select>
        </b-form-group>

        <b-form-group id="input-group-4" label="Cual es el segundo factor mas importanta para usted al momento de elegir la entidad" label-for="input-32">     
          <b-form-select
            id="input-32"
            v-model="form.nivel2"
            :options="nivel"
            required
          ></b-form-select>
        </b-form-group>

        <b-form-group id="input-group-4" label="Cual es el factor menos importanta para usted al momento de elegir la entidad" label-for="input-33">     
          <b-form-select
            id="input-33"
            v-model="form.nivel3"
            :options="nivel"
            required
          ></b-form-select>
        </b-form-group>

        <b-form-group id="input-group-4" label="¿Acepta el tratamiento de sus datos?" label-for="input-33">     
          <b-form-select
            id="input-33"
            v-model="form.datos"
            :options="actividad"
            required
          ></b-form-select>
        </b-form-group>
        

        <b-button type="submit" variant="primary">Guardar</b-button>
        <b-button type="reset" variant="danger">Cancelar</b-button>
      </b-form>
      <br>
      <router-link to="/preinscHome">
        <button type="submit" class="btn btn-dark btn-lg btn-block">
        Volver</button></router-link>
    </div>
  </b-col>
      <b-col>
        
      </b-col>
    </b-row>
  </b-container>  
</template>

<script>
import SidebarMenuAkahon from "@/components/SideBarPreIns.vue"

  export default {
    data() {
      return {
        form: {
          email: '',
          asignatura: null,
          genero: '',
          fechaTaller: null,
          telefono: '',
          municipio: '',
          localidad: null,
          barrio: '',
          direccion: '',
          actividad: null,
          cualesactiv: '',
          experiencia: null,
          limitacion: null,
          localidadrest: null,
          transporte: null,
          profe: null,
          profen: null,
          prom: null,
          enfasis: null,
          contacto: null,
          pref: null,
          modalidad: null,
          dia: null,
          tipoorg: null,
          tipoemp: null,
          eco: null,
          comun: null,
          nivel: null,
          nivel2: null,
          nivel3: null,
          datos: null,

        },
        asignatura: [{ text: 'Selecione una', value: null }, 'PSU', 'CDIO'],
        genero: [{ text: 'Selecione una', value: null }, 'Masculino', 'Femenino', 'Otro'],
        municipio: [{ text: 'Selecione una', value: null }, 'Bogota D.C.', 'Otro'],
        localidad: [{ text: 'Selecione una', value: null }, 'Usaquén', 'Chapinero', 'Santa Fe', 'San Cristóbal', 'Usme', 'Tunjuelito', 'Bosa', 'Kennedy', 'Fontibón', 'Engativá', 'Suba', 'Barrios Unidos', 'Teusaquillo', '	Los Mártires', 'Antonio Nariño', 'Puente Aranda', 'La Candelaria', 'Rafael Uribe Uribe', 'Ciudad Bolívar', 'Sumapaz'],
        actividad: [{ text: 'Selecione una', value: null }, 'Si', 'No'],
        experiencia: [{ text: 'Selecione una', value: null }, 'Monitoria en la javeriana', 'Trabajo social o voluntariado', 'No'],
        limitacion: [{ text: 'Selecione una', value: null }, 'Social', 'Psicológica', 'Física', 'No'],
        transporte: [{ text: 'Selecione una', value: null }, 'Carro', 'Moto', 'Otro', 'No'],
        profe: [{ text: 'Selecione una', value: null }, 'Clara Mabel Solano Vanegas', 'Mabel Olano', 'Giovanna Fiorillo Obando', 'Paula Andrea Villegas Gonzalez', 'Julian Mateo Zutta', 'Blanca Elvira Oviedo Torres'],
        prom: [{ text: 'Selecione una', value: null }, 'Menor a 4', 'Mayor a 4', 'No deseo contestar'],
        enfasis: [{ text: 'Selecione una', value: null }, 'Operaciones en la cadena de valor', 'Factores humanos y tecnologicos', 'Inteligencia de Negocios','Estrategia, emprendimiento y decisiones gerenciales','Metodos Cuantitativos','Tecnologia','Produccion','Emprendimiento'],
        contacto: [{ text: 'Selecione una', value: null }, 'Llamada', 'Whatsapp', 'Teams', 'Correo'],
        pref: [{ text: 'Selecione una', value: null }, 'Asesoria técnica', 'Capacitación'],
        modalidad: [{ text: 'Selecione una', value: null }, 'Presencial', 'Virtual', 'Mixto'],
        tipoorg: [{ text: 'Selecione una', value: null }, 'Fundación', 'Cooperativas', 'Colegios','Fondos de empleados','Asociaciones','Corporaciones','Hospitales'],
        tipoemp: [{ text: 'Selecione una', value: null }, 'Microempresas', 'Emprendimiento familiar', 'Emprendimiento potencial','Emprendimiento grandes empresas','Emprendimiento social','Emprendimiento pequeñas empresas'],
        eco: [{ text: 'Selecione una', value: null }, 'Manufactura - confecciones', 'Manufactura - alimentos', 'Manufactura - artículos decorativos','Servicios','Otro'],
        comun: [{ text: 'Selecione una', value: null }, 'Ancianos', 'Jóvenes', 'Niños','Adultos'],
        nivel: [{ text: 'Selecione una', value: null }, 'Ubicación', 'Disponibilidad', 'Actividad económica','Tipo de organización','Comunidad a beneficiar'],
        selected: [],
        show: true
      }
    },
    components: {
    SidebarMenuAkahon,
    },
    methods: {
      onSubmit(event) {
        axios.post("http://localhost:8080/encuesta",{
          email: this.form.email,
          asignatura: this.form.asignatura,
          genero: this.form.genero,
          fechaTaller: this.form.fechaTaller,
          telefono: this.form.telefono,
          municipio: this.form.municipio,
          localidad: this.form.localidad,
          barrio: this.form.barrio,
          direccion: this.form.direccion,
          actividad: this.form.actividad,
          experiencia: this.form.experiencia,
          limitacion: this.form.localidad,
          localidadrest: this.form.localidadrest,
          transporte: this.form.transporte,
          profe: this.form.profe,
          profen: this.form.profen,
          prom: this.form.prom,
          enfasis: this.form.enfasis,
          contacto: this.form.contacto,
          pref: this.form.pref,
          modalidad: this.form.modalidad,
          dia: this.form.dia,
          tipoorg: this.form.tipoorg,
          tipoemp: this.form.tipoemp,
          eco: this.form.eco,
          comun: this.form.comun,
          nivel: this.form.nivel,
          nivel2: this.form.nivel2,
          nivel3: this.form.nivel3,
          datos: this.form.datos,
        });
      },
      onReset(event) {
        event.preventDefault()
        // Reset our form values
        this.form.email = ''
        this.form.asignatura= null
        this.form.genero= ''
        this.form.fechaTaller= null
        this.form.telefono= ''
        this.form.municipio= ''
        this.form.localidad= null
        this.form.barrio= ''
        this.form.direccion= ''
        this.form.actividad= null
        this.form.cualesactiv= ''
        this.form.experiencia= null
        this.form.limitacion= null
        this.form.localidadrest= null
        this.form.transporte= null
        this.form.profe= null
        this.form.profen= null
        this.form.prom= null
        this.form.enfasis= null
        this.form.contacto= null
        this.form.pref= null
        this.form.modalidad= null
        this.form.dia= null
        this.form.tipoorg= null
        this.form.tipoemp= null
        this.form.eco= null
        this.form.comun= null
        this.form.nivel= null
        this.form.nivel2= null
        this.form.nivel3= null
        this.form.datos= null
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


