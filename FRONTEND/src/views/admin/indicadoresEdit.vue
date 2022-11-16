<template>
  <b-container>  
       <div>
          <sidebar-menu-akahon 
            @search-input-emit="search"
          />
        </div> 
    <b-row>
      <b-col>
        <div class="hello">
          <h3>Gestor de noticias</h3>
          <label-edit :text="text" id="labeledit1" v-on:text-updated="textUpdated" placeholder="Enter some text"></label-edit>
        </div>
        <div>
          <b-table striped hover id="pages-table" :items="items" :fields="fields">
            <template #cell(Editar)="row">
            </template>
            <template #cell(Eliminar)="row">
              <b-button class="mr-2">Eliminar
              </b-button>
            </template>
          </b-table>
        </div>
        <br>
        <b-form @submit="onSubmit" @reset="onReset" v-if="show">

          <b-form-group
          id="input-group-2"
          label="Indicador:"
          label-for="input-2"
        >
          <b-form-input
            id="input-2"
            v-model="form.vinculacion"
            type="email"
            placeholder="Indicador"
            required
          ></b-form-input>
        </b-form-group>
        <b-form-group
          id="input-group-2"
          label="Descripción:"
          label-for="input-2"
        >
          <b-form-input
            id="input-2"
            v-model="form.Descripcion"
            type="email"
            placeholder="Descripción"
            required
          ></b-form-input>
        </b-form-group>
        <b-form-group
          id="input-group-2"
          label="Preguntas:"
          label-for="input-2"
        >
          <b-form-input
            id="input-2"
            v-model="form.Preguntas"
            type="email"
            placeholder="Preguntas"
            required
          ></b-form-input>
        </b-form-group>
        

        <b-button type="submit" variant="primary">Guardar</b-button>
        <b-button type="reset" variant="danger">Cancelar</b-button>
      </b-form>
      <br>
      <router-link to="/gesIndicadores">
        <button type="submit" class="btn btn-dark btn-lg btn-block">
        Volver</button></router-link>
        

      </b-col>
      <b-col>
        
      </b-col>
    </b-row>
  </b-container>   
</template>

<script>
import SidebarMenuAkahon from "@/components/SideBar.vue"

export default {
  name: 'Homecoordinador',
  props: {
    msg: String
  },
  data() {
      return {
        items: [
          { ID: 40, Indicador: 'Eficacia', Descripcion: 'Alcanzar las metas establecidas de la empresa durante un determinado periodo de tiempo', Preguntas: '1,2,3' },

        ],
        fields: [
          {
            key: "ID",
            label: "ID",
            sortable: true
          },
          { key: "Indicador" },
          { key: "Descripcion" },
          { key: "Preguntas" },
          { key: "Eliminar" }
        ],

        form: {
          estado: '',

        },

        emprendimiento: [{ text: 'Selecione una', value: null }, 'America', 'Rosita'],
        show: true
      
      }
      
            
  },
  
   components: {
    SidebarMenuAkahon,
  },
  methods: {
    search() {
      
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
