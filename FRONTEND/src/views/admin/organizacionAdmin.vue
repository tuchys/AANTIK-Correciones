<template>
  <b-container>
    <div>
      <sidebar-menu-akahon/>
    </div>


    <div class="hello">
      <h3>Gestor de organizaciones sociales</h3>
    </div>
    Ingrese aquí para agregar organizaciones sociales de forma masiva
    por medio de un archivo .csv
    <router-link to="/subirFileOrgSoc">
      <button type="submit" class="btn btn-dark btn-lg btn-block">
        Agregar organizaciones sociales</button>
    </router-link><br>
    Ingrese aquí para agregar una organizacion social de forma individual
    <router-link to="/agregarOrgSoc">
      <button type="submit" class="btn btn-dark btn-lg btn-block">
        Agregar organizacion social</button>
    </router-link><br>
    <br>


    <b-row>
      <b-col>
        Listado de organizaciones sociales inscritas

        <br>
        <div>
          <b-table striped hover id="pages-table" :items="users" :fields="fields" :key="field">
            
              <template #cell(Editar)="data">

                  <router-link id = data.item.id :to="{ path: '/orgEdit'+ data.item.id}" v-bind:tooltip=data.item.id append>
                  <b-button class="mr-2">Editar/Ver
                  </b-button></router-link>

              </template>

              <template #cell(Eliminar)="data">
                <router-link to="/orgAdmin">
                <b-button @click="orgDelete(data.item.id, data.index)" class="mr-2">Eliminar
                </b-button></router-link>
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
          key: "id",
          label: "id"
        },
        {
          key: "nombreEmp",
          label: "Nombre"
        },
        {
          key: "nombreInterOS",
          label: "Interlocutor"
        },
        {
          key: "tipoOS",
          label: "Tipo de organización"
        },
        {
          key: "actividadEco",
          label: "Actividad"
        },
        {
          key: "prodServ",
          label: "Servicio o producto"
        },
        { key: "Editar" },
        { key: "Eliminar" },


      ],
    }
  },
  id2: null,
  mounted() {

    axios.get("http://localhost:8080/getOrg").then(

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
      axios.post("http://localhost:8080/orgDelete", {
        id
      });

    },

    handleInput(value, data) { },
  },
};



/*
export default {
  name: 'estudiantesCord',
  props: {
    msg: String
  },
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
        items: [
          { ID: 40, Nombre: 'America Solidaria', email: 'lideresolidariosas@americasolidaria.org',
          tipoOrg: 'Fundación', actEco: 'Servicios', emprendimientos: '2',interlocutor: 'interlo1',
          serProd: 'Talleres, Contactos Ecosistema Emprendimiento-Apoyo financiero' },
          { ID: 21, Nombre: 'Fundacion Buena Semilla', email: 'lu.orjuela@hotmail.com',
          tipoOrg: 'Fundación', actEco: 'Manufactura - confecciones', emprendimientos: '1',interlocutor: 'interlo2',
          serProd: 'Tejidos+Carpinteria+servicios turismo+Servicio Comedor Comunitario'  },
        ],
        fields: [
          {
            key: "ID",
            label: "ID",
            sortable: true
          },
          { key: "Nombre" },
          { key: "interlocutor",
          label:"Interlocutor" },
          { key: "tipoOrg",
          label: "tipo de organización" },
          { key: "actEco",
          label: "Emprendimientos" },
          { key: "serProd",
          label: "Servicio o producto" },
          { key: "Editar" },
          { key: "Eliminar" }
        ],
      }      
  }
}*/
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
