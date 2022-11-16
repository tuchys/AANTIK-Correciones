<template>
  <div class="home">
    <img alt="Vue logo" src="../assets/escudoPUJ.png" width="20%" height="10%" >

    <hr width=100% color=#e3b82a  size=50   noshade="noshade">
    <hr width=100%  color=#fff size=50   noshade="noshade">
    <hr width=100%  color=#2C5698  size=50   noshade="noshade">
    <router-link to="/ayuda">
        <i class='bx bx-help-circle bx-lg' color="red"></i>
    </router-link>
    <h1>Bienvenido a AANTIK</h1>
    <p>AANTIK es un sistema de información personalizado para la gestión de procesos de madurez
      empresarial, aplicandose en emprendimientos que pertenecen al programa de PSU, facilitando tareas de 
      asignación de entidad y estudiantes por medio de la personalización.
      AANTIK cuenta con servicios que permiten tener el historial y trazabilidad de todo el proceso de madurez
      empresarial aplicado al emprendimiento, adicionalmente cuenta con servicios de información presentando
      noticias relevantes y del sector de interés de los emprendimientos, servicio de Benchmarking,
      foro para comunicación entre entidades, tejido social que facilita el contacto de proveedores
      y clientes entre las organizaciones que usan AANTIK.
    </p>
    <p class="boton">
      <router-link to="/login2">
        <button type="submit" class="btn btn-dark btn-lg btn-block">
        Iniciar sesión</button></router-link><br>
    </p>

  </div>
</template>

<script>
// @ is an alias to /src
import Login from '@/views/Login.vue'

export default {
  name: 'home',
  components: {
    Login
  }
}
</script>

<style scoped>
@import url('https://fonts.googleapis.com/css2?family=Poppins:wght@200;300;400;500;600;700&display=swap');
@import url('https://unpkg.com/boxicons@2.0.7/css/boxicons.min.css');
  hr {
    height: 25px;
    margin-top: 0px;
    margin-bottom: 0px;
  }
  img {
    margin-bottom:35px;
    margin-top:30px;
  }
  p {
    text-align: justify;
    margin-top: 5%;
    margin-left: 12%;
    margin-right: 12%;
  }
  p.boton {
    margin-top: 5%;
    margin-left: 40%;
  }
  .btn-block {
    display: block;
    width: 30%;
    align-items: center;
  }
  i{
    font-size:50px;
    padding: 20px;
    margin-right: 20px;
    float: right;
  }
  h1{
    padding-top: 50px;
    color: #2C5698;
  }
</style>
  
