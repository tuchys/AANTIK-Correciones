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
          <h3>Organización Social 'nombre'</h3>
          <label-edit :text="text" id="labeledit1" v-on:text-updated="textUpdated" placeholder="Enter some text"></label-edit>
        </div>
        <br>
        Aqui puede ver los emprendimientos asociados a su organización social
        en caso de tenerlos.
        <router-link to="/estudiantes">
        <button type="submit" class="btn btn-dark btn-lg btn-block">
        Ver emprendimientos</button></router-link>
        <br>
        Si su organización social cuenta con emprendimientos que estén siendo asesorados, 
        aquí puede consular el progreso y validar la continuidad del emprendimiento en 
        el programa de asesoría técnica.
        <router-link to="/estudiantes">
        <button type="submit" class="btn btn-dark btn-lg btn-block">
        Progreso</button></router-link>       
        <br>
        Aquí puede consultar las asignaciones de sus emprendimientos o 
        de su organización social si se encuentra en proceso de 
        asistencia tecnica.
        <router-link to="/estudiantes">
        <button type="submit" class="btn btn-dark btn-lg btn-block">
        Consultar asignación actual</button>
        <br></router-link>   
        Recuerde mantener sus datos actualizados con el fin de garantizar
         el buen funcionamiento del sistema.
         <router-link to="/estudiantes">
        <button type="submit" class="btn btn-dark btn-lg btn-block">
        Actualizar datos</button></router-link>
        <br>
        Aqui puede ver el historial de los procesos de madurez realizados
        desde el uso de la aplicación.
        <router-link to="/estudiantes">
        <button type="submit" class="btn btn-dark btn-lg btn-block">
        Ver historial</button></router-link>
        <br>
        Si te interesa conocer de estrategias sugeridas de crecimiento
         basado en la situación del sector economico, ingresa aquí.
         <router-link to="/benchOS">
        <button type="submit" class="btn btn-dark btn-lg btn-block">
        Benchmarking</button></router-link>
        <br>
        En este módulo puede encontrar noticias por sector economico y 
        enfocadas a los emprendimientos, adicionalmente puede acceder a la 
        red de colaboracion.
        <router-link to="/estudiantes">
        <button type="submit" class="btn btn-dark btn-lg btn-block">
        Módulo de información</button></router-link>
        <br>
        Si te interesa conseguir clientes, proveedores o posibles 
        aliados, ingrese aquí.
        <router-link to="/tejidoOS">
        <button type="submit" class="btn btn-dark btn-lg btn-block">
        Tejido social</button></router-link>
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
