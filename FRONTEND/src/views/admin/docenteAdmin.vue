<template>
  <b-container>
    <div>
      <sidebar-menu-akahon @search-input-emit="search" />
    </div>
    <b-row>
      <b-col>
        <div class="hello">
          <h3>Gestor de docentes</h3>
        </div>
        Ingrese aquí para agregar docentes de forma masiva
        por medio de un archivo excel
        <router-link to="/subirFile">
          <button type="submit" class="btn btn-dark btn-lg btn-block">
            Agregar docentes </button>
        </router-link><br>
        Ingrese aquí para agregar un docente individual
        <router-link to="/addDocentes">
          <button type="submit" class="btn btn-dark btn-lg btn-block">
            Agregar docente</button>
        </router-link><br>
        <br>
        Listado de docentes actuales

        <br>
        <div>
          <b-table striped hover id="pages-table" :items="users" :fields="fields" :key="field">
            
            <template #cell(Editar)="data">

                <router-link id = data.item.id :to="{ path: '/orgEdit'+ data.item.id}" v-bind:tooltip=data.item.id append>
                <b-button class="mr-2">Editar/Ver
                </b-button></router-link>

            </template>

            <template #cell(Eliminar)="data">
              <b-button @click="orgDelete(data.item.id, data.index)" class="mr-2">Eliminar
              </b-button>
            </template>
        </b-table>
        </div>
        <br>

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
  name: 'docentesCord',

  components: {
    SidebarMenuAkahon,
  },
  methods: {
    search() {

    },
    update(data) {
      // I need to disable the button here
      this.output = data;
      data.item.name = "Dave";
      this.$refs["btn" + data.index].disabled = true
    }
  },
  data() {
    return {
      users: [{


        nombre: '',
        vinculacion: '',
        especialidad: '',
        asignatura: '',
        correo: '',

}],

      fields: [

        { key: "nombre" },
        { key: "vinculacion" },
        { key: "especialidad" },
        { key: "asignatura" },
        { key: "correo" },
        { key: "Editar" },
        { key: "Eliminar" }
      ],


    }
  },
  id2: null,
  mounted() {

    axios.get("http://localhost:8080/getDoc").then(

      (response) => {

        this.users = response.data;
        console.log(this.users)
      }
    );
  },
  methods: {
    orgDelete: function (id, index) {
      window.location.reload();
      console.log(index)
      console.log(id)
      axios.post("http://localhost:8080/docDelete", {
        id
      });

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
