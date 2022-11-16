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
    <h3>Diligencie el siguiente formulario con los del grupo de clase</h3>
    <br><br>
    <div>
      <b-form @submit="onSubmit" @reset="onReset" v-if="show">
        
  <b-container>  
    <b-col> 
        <b-form-group id="input-group-1" label="Nombres de la clase:" label-for="input-1">     
          <b-form-input
            id="input-1"
            v-model="form.name"
            placeholder="Nombre"
            required
          ></b-form-input>
        </b-form-group>

        <b-form-group
          id="input-group-2"
          label="Código:"
          label-for="input-2"
        >
          <b-form-input
            id="input-2"
            v-model="form.codigo"
            placeholder="Código"
            required
          ></b-form-input>
        </b-form-group>
      </b-col> 
        <b-col> 
        
        <b-form-group id="input-group-4" label="Cupos disponibles:" label-for="input-4">     
          <b-form-input
            id="input-4"
            v-model="form.cupos"
            placeholder="Cupos disponibles"
            required
          ></b-form-input>
        </b-form-group>

        <b-form-group id="input-group-5" label="Asignatura a la que pertenece:" label-for="input-5">     
          <b-form-select
          id="input-5"
          v-model="form.asignatura"
          :options="asignatura"
          required
        ></b-form-select>
        </b-form-group>

        <b-form-group id="input-group-5" label="Docente:" label-for="input-5">     
          <b-form-select
          id="input-5"
          v-model="form.Docente"
          :options="Docente"
          required
        ></b-form-select>
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

  export default {
    data() {
      return {
        form: {
          email: '',
          name: '',
          food: null,
          checked: []
        },
        asignatura: [{ text: 'Selecione una', value: null }, 'PSU', 'CDIO'],
        show: true
      }
    },
    components: {
    SidebarMenuAkahon,
    },
    methods: {
      onSubmit(event) {
        event.preventDefault()
        alert(JSON.stringify(this.form))
      },
      onReset(event) {
        event.preventDefault()
        // Reset our form values
        this.form.email = ''
        this.form.name = ''
        this.form.food = null
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