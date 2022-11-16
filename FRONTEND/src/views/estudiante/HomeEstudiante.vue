<template>
  <b-container>  
       <div>
          <sidebar-menu-akahon 
          />
        </div> 
    <b-row>
      <b-col>
        <div class="hello">
          <h3>Se encuentra inscrito al ciclo {{ciclo}}</h3>
         </div><br>
        Aquí puede consultar el puntaje del diagnóstico del emprendimiento asignado
         y asignar puntaje a las preguntas del diagnóstico que no se califican automáticamente.
        <router-link to="/respDG">
        <button type="submit" class="btn btn-dark btn-lg btn-block">
        Gestionar diagnóstico</button></router-link>
        <br>
        Aquí puede definir el proyecto social y subir los informes de soporte.
        <router-link to="/progress">
        <button type="submit" class="btn btn-dark btn-lg btn-block">
        Progreso</button></router-link>
        <br>
        Aquí puede consultar los indicadores del benchmarking.
        <router-link to="/benchInd">
        <button type="submit" class="btn btn-dark btn-lg btn-block">
        Benchmarking</button></router-link>
        <br>
        Aquí puede subir una noticia, ver su historial o dirigirse a 
        las noticias publicadas en el sistema.
        <router-link to="/noticiaEs">
        <button type="submit" class="btn btn-dark btn-lg btn-block">
        Noticias</button></router-link>
        <br>
        Puede acceder a la red colaborativa y contestar preguntas realizados por los emprendimientos
         que se están asesorando en el ciclo actual.
        <router-link to="/foro">
        <button type="submit" class="btn btn-dark btn-lg btn-block">
        Red colaborativa</button></router-link>

        <br>
        Aquí puede consultar el proyecto asignado para que realice su asesoría técnica.
       
        <b-button v-b-modal.req class="btn btn-dark btn-lg btn-block">Consultar asignación</b-button>

<b-modal id="req" title="Asignación">
  <p v-if="false" class="my-4"><b>Aun no tiene un emprendimiento asiganado</b>
  </p>
  <p v-else class="my-4">
    <b>Organizacion Social:</b> America Solidaria<br>
    <b>Emprendimiento:</b> Doña rosita<br>
    <b>Interlocutor:</b> Rosa Maria<br>
    <b>Telefono:</b> 316-325-2584<br>
    <b>Dirección:</b> Cr 123-45-6<br>

  </p>
</b-modal>
<br>
        No olvide mantener sus datos actualizados.
        <router-link to="/datosEs">   
        <button type="submit" class="btn btn-dark btn-lg btn-block">
        Actualizar datos</button></router-link>

      </b-col>
      <b-col>
        
      </b-col>
    </b-row>
  </b-container>   
</template>

<script>
import SidebarMenuAkahon from "@/components/SideBarSt.vue"

export default {
   components: {
    SidebarMenuAkahon,
  },
  data() {
    return{
      ciclo: "2022-03",
    };
  },
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
