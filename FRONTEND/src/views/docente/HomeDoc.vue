<template>
  <b-container>  
       <div>
          <sidebar-menu-akahon 
          />
        </div> 
    <b-row>
      <b-col>
        <div class="hello">
          <h3>Docente 'nombre'</h3>
       </div>
        <br>
        Aquí puede entrar a ver los archivos subidos por los estudiantes.
        <router-link to="/repoEstudiantes">
        <button type="submit" class="btn btn-dark btn-lg btn-block">
        Ver archivos</button></router-link>
        <br>
        Aquí puede ver el listado de estudiantes.
        <router-link to="/estClass">
        <button class="btn btn-dark btn-lg btn-block">
        Estudiantes</button></router-link>
        <b-modal id="my-modal1">Estado: En proceso de maduracion (tilde plz)</b-modal>
        <br>
        Recuerde mantener sus datos actualizados con el fin de garantizar
         el buen funcionamiento del sistema.
         <router-link to="/datosDoc">
        <button type="submit" class="btn btn-dark btn-lg btn-block">
        Actualizar datos</button></router-link>
        <br>
        Aquí puede ver todas las asesorías técnicas realizadas a 
        las organizaciones sociales que han sido parte de su curso.
        <router-link to="/histoAsesorias">          
        <button type="submit" class="btn btn-dark btn-lg btn-block">
        Ver historial</button></router-link>
        <br>
        Aqui puede consultar las noticias cargadas por los estudiates.
        <router-link to="/modInfor">
        <button type="submit" class="btn btn-dark btn-lg btn-block">
        Módulo de información</button></router-link>
      </b-col>
      <b-col>
        
      </b-col>
    </b-row>
  </b-container>   
</template>

<script>
import SidebarMenuAkahon from "@/components/SideBarDocente.vue"

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
