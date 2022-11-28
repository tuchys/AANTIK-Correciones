<template>
  <b-container>
    <div>
      <sidebar-menu-akahon/>
    </div>


    <div class="hello">
      <h3>Gestor de Coordinadores</h3>
    </div>
    Ingrese aquí para agregar coordinadores de forma masiva
    por medio de un archivo .csv
    <router-link to="/subirCoord">
      <button type="submit" class="btn btn-dark btn-lg btn-block">
        Agregar Coordinadoress</button>
    </router-link><br>
    Ingrese aquí para agregar un coordinador de forma individual
    <router-link to="/addCoord">
      <button type="submit" class="btn btn-dark btn-lg btn-block">
        Agregar Coordinador</button>
    </router-link><br>
    <br>


    <b-row>
      <b-col>
        Listado de Coordinadores inscritos

        <br>
        <div>
          <b-table striped hover id="pages-table" :items="users" :fields="fields" :key="field">
            
              <template #cell(Editar)="data">

                  <router-link id = data.item.id :to="{ path: '/coordEdit'+ data.item.id}" v-bind:tooltip=data.item.id append>

                      <b-button class="mr-2">Editar/Ver
                  </b-button></router-link>

              </template>

              <template #cell(Eliminar)="data">
                <b-button @click="coordDelete(data.item.id, data.index)" class="mr-2">Eliminar
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
import editCoord from "@/views/admin/coordinadorEdit.vue"
import axios from 'axios';


export default {
  components: {
    SidebarMenuAkahon,
    editCoord,
  },




  name: 'coord',

  data() {

    return {
      users: [{

        id: null,

        nombre: null,

        asignatura: null,

        correo: null,

      }],

      fields: [
        {
          key: "nombre",
          label: "Nombre"
        },
        {
          key: "asignatura",
          label: "Asignatiura"
        },
        {
          key: "correo",
          label: "Correo"
        },
        { key: "Editar" },
        { key: "Eliminar" },


      ],
    }
  },
  id2: null,
  mounted() {

    axios.get("http://localhost:8080/getCoord").then(

      (response) => {

        this.users = response.data;
        console.log(this.users)
      }
    );
  },
  methods: {
    coordDelete: function (id, index) {
      window.location.reload();
      console.log(index)
      console.log(id)
      axios.post("http://localhost:8080/coordDelete", {
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
