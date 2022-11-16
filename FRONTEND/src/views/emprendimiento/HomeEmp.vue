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
          <h3>Emprendimiento 'nombre'</h3>
          <label-edit :text="text" id="labeledit1" v-on:text-updated="textUpdated" placeholder="Enter some text"></label-edit>
        </div>
        <br>
        Recuerde mantener sus datos actualizados con el fin de garantizar
         el buen funcionamiento del sistema.
         
        <router-link to="/datosEmp">
        <button type="submit" class="btn btn-dark btn-lg btn-block">
        Actualizar datos</button></router-link>
        <br>
        Aquí puede responder las preguntas del diagnóstico organizacional.
        <router-link to="/dgvf"><button type="submit" class="btn btn-dark btn-lg btn-block">
        Diagnostico organizacional</button></router-link>
        <br>
        Aquí puede ver el estado de la asesoría en curso.
        <button @click="$bvModal.show('my-modal3')" class="btn btn-dark btn-lg btn-block">
        Ver estado</button>
        <b-modal id="my-modal3">Estado: En proceso de maduracion <br> 
        </b-modal>
        <br>
        Aquí puede ver los estudiantes asignados a su proyecto
        <button @click="$bvModal.show('my-modal2')" class="btn btn-dark btn-lg btn-block">
        Estudiantes asiganados</button>
        <b-modal id="my-modal2">Billy <br>Correo<br>Telefono <br><br> Mandy <br>Correo<br>Telefono</b-modal>        
        <br>
        Aquí puede ver las asesorías realizadas al emprendimiento desde su inscripción.  
        <router-link to="/asesoria">
        <button type="submit" class="btn btn-dark btn-lg btn-block">
        Ver asesorias</button></router-link>
        <br>
        En este módulo puede encontrar noticias por sector economico y 
        enfocadas a los emprendimientos.
        <router-link to="/noticias">
        <button type="submit" class="btn btn-dark btn-lg btn-block">
        Módulo de información</button></router-link>
        <br>
        En este módulo puede encontrar la red de colaboración para hacer peticiones y preguntas.
        <router-link to="/foroEmp">
        <button type="submit" class="btn btn-dark btn-lg btn-block">
        Red de colaboración</button></router-link>
        <br>
        Si te interesa conseguir clientes, proveedores o posibles 
        aliados, ingrese aquí.
        <router-link to="/tejido">
        <button type="submit" class="btn btn-dark btn-lg btn-block">
        Tejido social</button></router-link><br>
      </b-col>
      <b-col>
        
      </b-col>
    </b-row>
  </b-container>   
</template>

<script>
import SidebarMenuAkahon from "@/components/SideBarEmpren.vue"

export default {
  name: 'Homecoordinador',
  props: {
    msg: String
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
