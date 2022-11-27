<template>
  <b-container>
    <div>
      <sidebar-menu-akahon/>
    </div>


    <div class="hello">
      <h3>Gestor de Emprendimientos</h3>
    </div>
    Ingrese aquí para agregar emprendimiento de forma masiva
    por medio de un archivo .csv
    <router-link to="/subirEmp">
      <button type="submit" class="btn btn-dark btn-lg btn-block">
        Agregar organizaciones sociales</button>
    </router-link><br>
    Ingrese aquí para agregar un emprendimiento de forma individual
    <router-link to="/addEmp">
      <button type="submit" class="btn btn-dark btn-lg btn-block">
        Agregar Emprendmiento</button>
    </router-link><br>
    <br>


    <b-row>
      <b-col>
        Listado de emprendimientoss inscritos

        <br>
        <div>
          <b-table striped hover id="pages-table" :items="users" :fields="fields" :key="field">
            
              <template #cell(Editar)="data">

                  <router-link id = data.item.id :to="{ path: '/empEdit'+ data.item.id}" v-bind:tooltip=data.item.id append>
                  <b-button class="mr-2">Editar/Ver
                  </b-button></router-link>

              </template>

              <template #cell(Eliminar)="data">
                <b-button @click="empDelete(data.item.id, data.index)" class="mr-2">Eliminar
                </b-button>
              </template>
          </b-table>
        </div>
        <br>
      </b-col>


    </b-row>
  </b-container>
</template>

<script>
import SidebarMenuAkahon from "@/components/SideBar.vue"
import axios from 'axios';


export default {
  components: {
    SidebarMenuAkahon,
  },




  name: 'orgS',

  data() {

    return {
      users: [{

        id: null,

        nombreEmp: null,

        nombreInterOS: null,

        tipoOS: null,

        actividadEco: null,

        prodServ: null,

      }],

      fields: [
        {
          key: "nombreEmp",
          label: "Nombre"
        },
        {
          key: "nombreInterOS",
          label: "Interlocutor"
        },
        {
          key: "correoIE",
          label: "Correo"
        },
        {
          key: "correoIE",
          label: "TelefonoIE"
        },
        {
          key: "orgSocial",
          label: "Organizacion",
        },

        { key: "Editar" },
        { key: "Eliminar" },


      ],
    }
  },
  id2: null,
  mounted() {

    axios.get("http://localhost:8080/getEmp").then(

      (response) => {

        this.users = response.data;
        console.log(this.users)
      }
    );
  },
  methods: {
    empDelete: function (id, index) {
      window.location.reload();
      console.log(index)
      console.log(id)
      axios.post("http://localhost:8080/empDelete", {
        id
      });

    },

    handleInput(value, data) { },
  },
};


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
