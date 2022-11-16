<template>
<b-container class="bv-example-row">
  <div class="home">
    <img alt="Vue logo" src="@/assets/escudoPUJ.png" width="20%" height="10%" >

    <hr width=100% color=#e3b82a  size=50   noshade="noshade">
    <hr width=100%  color=#fff size=50   noshade="noshade">
    <hr width=100%  color=#2C5698  size=50   noshade="noshade">
    <div class="texto">
    <h1><br>Bienvenido a la red colaborativa de AANTIK</h1><br>
    <h3>Acá podrá solucionar sus dudas con la comunidad</h3><br>
    </div>
  </div>
  
  <div v-for="(item, i) in items">
    <b-card bg-variant="light" border-variant="secondary">
      <template #header>
        <h6 class="mb-0"> <b>Pregunta de: </b> </h6> <v-card-title v-text="item.Nombres"/>
      </template>
      <h4><b><v-card-title v-text="item.Titulo"/></b></h4>
      <b-card-text>
        <h6><b>Fecha:</b></h6> <v-card-text v-text="item.Fecha"/><br><br>
        <v-card-text v-text="item.Pregunta"/><br><br>

        <br>
        <div v-for="(item, i) in items2">
        <b-card ><b><v-card-title v-text="item.Nombres"/></b>
          <b-card-text  v-text="item.Respuesta"></b-card-text> 
          <b-button variant="primary">Eliminar</b-button>
        </b-card>
      </div>
      <b-form-textarea
      id="textarea"
      v-model="text"
      placeholder="Ingresar una respuesta..."
      rows="3"
      max-rows="6"
    ></b-form-textarea>
        </b-card-text>
      <template #footer>
        <em> </em>
      </template>
      <b-button variant="primary">Eliminar</b-button>
    </b-card>
    <br>
    
  </div>
   
    <b-col></b-col>

</b-container>
</template>

<script>
export default {
  name: 'foro',
  props: {
    msg: String
  },
   components: {
  },
  methods: {
    search() {
      
    }
  },
  data() {
      return {
        items: [
          { Nombres: 'America solidaria', Pregunta: 'Como puedo registrar un nuevo emprendimiento', Fecha: '01/01/22'},
          { Nombres: 'Org Soc1 ', Pregunta: 'Como puedo encontrar clientes', Fecha: '02/03/22' },
         ],
        items2: [
          { Nombres: 'Emprendimiento 1', Respuesta: 'Comunicandose con coordinacion de proyectos' },
          { Nombres: 'Estudiante pepito', Respuesta: 'Te enviaremos un correo con la información'},
       ]
      }      
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
  b-row.entidad{
    text-align: left;
    color: aqua;
    margin-top: 5%;
    margin-left: 12%;
    margin-right: 12%;
  }
</style>
  
