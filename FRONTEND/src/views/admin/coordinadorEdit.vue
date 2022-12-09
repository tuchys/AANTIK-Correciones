<template>
  <b-container>
    <div>
      <sidebar-menu-akahon />
    </div>
    <b-row>
      <b-col>
        <br><br>
        <h3>Diligencie el siguiente formulario con los datos del coordinador con ID: </h3>
        
        <h3>{{ this.$route.params.idCO }}</h3><br>
        <br><br>
        <div>
          <b-form @submit="onSubmit" @reset="onReset" v-if="show">

            <b-container>

              <b-col>
                <b-form-group id="input-group-3" label="Ingrese el nombre:" label-for="input-3">
                  <b-form-input id="input-3" v-model="form.nombre" placeholder="nombre" required></b-form-input>
                </b-form-group>

                <b-form-group id="input-group-4" label="Correo:" label-for="input-4">
                  <b-form-input id="input-4" v-model="form.correo" placeholder="Correo" required></b-form-input>
                </b-form-group>

                <b-form-group id="input-group-5" label="Asignatura:" label-for="input-5">
                  <b-form-select id="input-5" v-model="form.asignatura" :options="asignatura" required></b-form-select>
                  <option :selected="form.asignatura">{{form.asignatura}}</option>
                </b-form-group>



              </b-col>
              <b-button type="submit" variant="primary" @click="actualizar(form)" >Guardar</b-button>
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
    idCO: String
  },
  data() {
    return {
      form: {
        nombre: '',
        correo: '',
        asignatura: '',
      },
        asignatura: [{ text: 'Selecione una', value: null }, 'PSU', 'CDIO'],

      show: true,
    }
  },

  components: {
    SidebarMenuAkahon,
  },
 
  created() {
        this.admService = new admService();
        this.getCO(this.$route.params.idCO);

  },

  methods: {
    getCO(idCoord) {
            console.log("gj-----",idCoord);
        this.admService.getCO(idCoord).then(data => {
          this.form = data.data;
          console.log("gj-----");
          console.log("key-----",typeof data.headers);
        });        
    },
    actualizar(formR){
    },

    onSubmit() {
      this.admService.getActCO(this.form,this.$route.params.idCO).
      then(function(response) {
          console.log(response.data);
      }).catch(function(error) {
          console.log(error);
      });
    },


    onReset(event) {
      event.preventDefault()
      // Reset our form values
      this.form.nombre = ''
      this.form.correo = ''
      this.form.asignatura= ''
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