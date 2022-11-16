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
    <h3>Diligencie el siguiente formulario con sus datos actualizados</h3>
    <br><br>
    <div>
      <b-form @submit="onSubmit" @reset="onReset" v-if="show">

        <b-form-group id="input-group-1" label="Nombre:" label-for="input-0">     
          <b-form-input
            id="input-0"
            v-model="form.nada"
            :placeholder="encargado"
            disabled
          ></b-form-input>
        </b-form-group>

        <b-form-group id="input-group-1" label="Teléfono:" label-for="input-1">     
          <b-form-input
            id="input-1"
            v-model="form.telefono"
            placeholder="Teléfono"
            required
          ></b-form-input>
        </b-form-group>

        <b-form-group id="input-group-1" label="Municipio:" label-for="input-2">     
          <b-form-input
            id="input-2"
            v-model="form.municipio"
            placeholder="Municipio"
            required
          ></b-form-input>
        </b-form-group>

        <b-form-group id="input-group-5" label="Localidad si esta en Bogotá D.C.:" label-for="input-3">     
          <b-form-select
          id="input-3"
          v-model="form.localidad"
          :options="localidad"
        ></b-form-select>
        </b-form-group>

        <b-form-group id="input-group-4" label="Barrio:" label-for="input-4">     
          <b-form-input
            id="input-4"
            v-model="form.barrio"
            placeholder="Barrio"
            required
          ></b-form-input>
        </b-form-group>

        <b-form-group id="input-group-4" label="Dirección:" label-for="input-5">     
          <b-form-input
            id="input-5"
            v-model="form.direccion"
            placeholder="Direción"
            required
          ></b-form-input>
        </b-form-group>


        <b-form-group id="input-group-4" label="Seleccione el sector económico de preferencia:" label-for="input-8">     
          <b-form-select
            id="input-8"
            v-model="form.sector"
            :options="sector"
            required
          ></b-form-select>
        </b-form-group>

        <b-form-group id="input-group-4" label="Seleccione su medio de contacto preferido:" label-for="input-9">     
          <b-form-select
            id="input-9"
            v-model="form.contacto"
            :options="contacto"
            required
          ></b-form-select>
        </b-form-group>

        

        <b-form-group id="input-group-4" label="Seleccione el tipo de organizacion de preferencia:" label-for="input-10">     
          <b-form-select
            id="input-10"
            v-model="form.tipoOrg"
            :options="tipoOrg"
            required
          ></b-form-select>
        </b-form-group>

                <b-form-group id="input-group-4" label="Si tiene alguna limitacion seleccione aquí:" label-for="input-11">     
          <b-form-select
            id="input-11"
            v-model="form.limitacion"
            :options="limitacion"
            required
          ></b-form-select>
        </b-form-group>

        <b-form-group id="input-group-4" label="Seleccione los horarios en los que desea recibir notificaciones relacionadas con su proyecto social universitario o CDIO
" label-for="input-8">     
          <b-form-select
            id="input-8"
            v-model="form.notif"
            :options="notif"
            required
          ></b-form-select>
        </b-form-group>

        

        <b-button type="submit" variant="primary">Guardar</b-button>
        <b-button type="reset" variant="danger">Cancelar</b-button>
      </b-form>
      <br>
      <router-link to="/homeEmp">
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
import axios from 'axios';
import SidebarMenuAkahon from "@/components/SideBar.vue"
import AuthService from "@/service/auth.service"
  export default {
    data() {
      return {
        encargado: AuthService.getUser(),
        form: {
          telefono: '',
          municipio: '',
          localidad: null,
          barrio: '',
          direccion: '',
          notif: null,
          tipoOrg: null,
          contacto: null,
          sector: null,
          limitacion: null,
        },
        localidad: [{ text: 'Selecione una', value: null }, 'Usaquén', 'Chapinero', 'Santa Fe', 'San Cristóbal', 'Usme', 'Tunjuelito', 'Bosa', 'Kennedy', 'Fontibón', 'Engativá', 'Suba', 'Barrios Unidos', 'Teusaquillo', '	Los Mártires', 'Antonio Nariño', 'Puente Aranda', 'La Candelaria', 'Rafael Uribe Uribe', 'Ciudad Bolívar', 'Sumapaz'],
        notif: [{ text: 'Selecione una', value: null }, 'Lunes', 'Martes', 'Miercoles', 'Jueves'],
        notif2: [{ text: 'Selecione una', value: null }, '1', '2', '3', '4'],
        notif3: [{ text: 'Selecione una', value: null }, '1', '2', '3', '4'],
        sector: [{ text: 'Selecione una', value: null }, 'Manufactura - confecciones', 'Manufactura - alimentos', 'Manufactura - artículos decorativos', 'Servicios'],
        tipoOrg: [{ text: 'Selecione una', value: null }, 'Fundación', 'Cooperativa', 'Colegio', 'Fondo de empleados', 'Asociación', 'Corporación', 'Hospital'],
        limitacion: [{ text: 'Selecione una', value: null }, 'Social', 'Psicológica', 'Física', 'No'],
        contacto: [{ text: 'Selecione una', value: null }, 'Llamada', 'Whatsapp', 'Teams', 'Correo'],
        notif: [{ text: 'Selecione una', value: null }, 'Entre semana AM', 'Entre semana PM', 'Fines de semana AM', 'Fines de semana PM'],
        selected: [],
        show: true
      }
    },
    components: {
    SidebarMenuAkahon,
    },
    methods: {
      onSubmit() {
        axios.post("http://localhost:8080/datosDoc",{
          telefono: this.form.telefono,
          municipio: this.form.municipio,
          localidad: this.form.localidad,
          barrio: this.form.barrio,
          direccion: this.form.direccion,
          vincu: this.form.vincu,
          titulo: this.form.titulo,
          linacc: this.form.linacc,
          limitacion: this.form.limitacion,
          nombre: AuthService.getUser(),
          //id: AuthService.getUser(),
        });

      },
      onReset(event) {
        event.preventDefault()
        // Reset our form values
        this.form.telefono = ''
        this.form.municipio = ''
        this.form.localidad = null
        this.form.barrio = ''
        this.form.direccion = ''
        this.form.vincu = null
        this.form.titulo = ''
        this.form.linacc = null
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


