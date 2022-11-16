<template>
  <div class="home">
    <img alt="Vue logo" src="../assets/escudoPUJ.png" width="20%" height="10%" >

    <hr width=100% color=#e3b82a  size=50   noshade="noshade">
    <hr width=100%  color=#fff size=50   noshade="noshade">
    <hr width=100%  color=#2C5698  size=50   noshade="noshade">
    <div class="texto">
    <h1><br>Ayuda del sistema AANTIK para todos los usuarios</h1>
    <br>
    <b-card>
      <template #header>
        <h2 class="mb-0">Primera vez en el sistema </h2>
      </template>
      <h3>Identifica tu rol</h3>
      La forma en que se obtiene el acceso al sistema depende del rol adquirido 
      en este, los estudiantes, docentes, proyectos de emprendimientos y organizaciones
       sociales, son habilitados en el sistema por parte del Coordinador de la asignatura
        Proyecto Social Universitario (PSU)<br><br>
      <li type="circle">Estudiantes: deben realizar la preinscripción con la coordinación 
        de la asignatura, una vez se habilite el acceso, recibirá un correo para cambiar 
        su contraseña de acceso y su usuario será su correo institucional, tendrá el rol
         de estudiante preinscrito y puede acceder por medio de la   <router-link to="../">
         pantalla inicial 
        </router-link>
          en el botón de iniciar sesión, recuerde que su rol solo tendrá vigencia
           durante el ciclo lectivo. </li><br>

      <li type="circle">
        Docentes: al ser relacionados con la asignatura de PSU o CDIO, 
        el coordinador de la asignatura diligenciara un formulario para 
        generar el acceso del docente o autorizará al administrador del 
        sistema para generar un nuevo usuario en dicho rol, una vez 
        habilitado el acceso, el docente recibirá un corre con las 
        credenciales de acceso a su correo corporativo, con las cuales 
        podrá acceder desde la <router-link to="../">
         pantalla inicial 
        </router-link>, este rol no 
        tiene vigencia, solo se inhabilitara al momento en que el docente deje de 
        ser relacionado con la asignatura
      </li><br>

      <li type="circle">
        Emprendimientos y organizaciones sociales: 
        solo se recibe el acceso al ser inscritas por parte del coordinador de asignatura, 
        con un formulario de datos básicos o con la debida autorización del coordinador para que 
        el administrador genere el usuario en el sistema, una vez realizado esto, recibirán un 
        correo con sus credenciales en la dirección de correo suministrada en el sistema, con las 
        que podrá acceder desde la <router-link to="../">
         pantalla inicial 
        </router-link>, recuerde que una vez que cuente 
        con el acceso, su usuario será vigente mientras se encuentre vinculado al proceso de madurez.
      </li><br>

      <li type="circle">
        Coordinador de asignatura: son únicamente registrados por el administrador 
        del sistema, y acceden desde la <router-link to="../">
         pantalla inicial 
        </router-link>
      </li><br>

      <li type="circle">
        Administrador: solo una persona cumple este ron, accede 
        desde la <router-link to="../">
         pantalla inicial 
        </router-link>, en caso de requerir 
        soporte, debe comunicarse con los coordinadores de la asignatura 
        PSU, para contactar al equipo de desarrollo.
      </li><br>
      <h2></h2>   
    </b-card>
    <br>
      <b-card>
        <template #header>
          <h2 class="mb-0">Inconvenientes con acceso al sistema </h2>
        </template>
        Si olvidó su contraseña recuerde que puede 
        restablecerla en la pantalla de <router-link to="../login2">
         login 
        </router-link>,
         por medio del link olvide mi contraseña, si persisten los problemas 
         de acceso o no ha recibido sus credenciales, comuníquese con la coordinación 
         de asignatura y solicite soporte por parte del administrador. <br><br>
      </b-card>
      <p class="boton">
      <router-link to="../">
        <button type="submit" class="btn btn-dark btn-lg btn-block">
        Regresar</button></router-link><br>
    </p>
    </div>
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
    text-align: left;
    margin-top: 5%;
    margin-left: 12%;
    margin-right: 12%;
  }
  div.texto {
    text-align: left;
    margin-top: 5%;
    margin-left: 12%;
    margin-right: 12%;
  }
</style>
  
