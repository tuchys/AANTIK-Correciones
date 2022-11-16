<template>
  <b-container padding-right= 0px padding-left="0px">   
    <div>
          <sidebar-menu-akahon 
            @search-input-emit="search"
          />
    </div> 
    <b-row>
    <b-col>    
    </b-col>
    <b-col>
      <h3>Requisitos</h3>
     <div class="vue-tempalte">
      <br>
      <div>
  <b-button v-b-modal.req class="btn btn-dark btn-lg btn-block">Consultar requisitos</b-button>

  <b-modal id="req" title="Requisitos">
    <p class="my-4"><b>Taller Sentido de mi practica:</b> Listo<br>
      <b>Formulario de preinscripcion:</b> Listo<br>
      <b>Asistencia reunion informativa:</b> Listo<br>

    </p>
  </b-modal>
</div>
<br>
        <router-link to="/preinscHome">
        <button type="submit" class="btn btn-dark btn-lg btn-block">
        Volver</button></router-link>
        <br>

    </div>
    </b-col>
    
    <b-col>
    </b-col>
  </b-row>
  <img src="@/assets/insc.png" width="80%" height="25%"/>

  </b-container>
</template>

<script>
import SidebarMenuAkahon from "@/components/SideBarPreIns.vue"

export default {
  name: 'preRequisitos',
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
hr {
  height: 25px;
  margin-top: 0px;
  margin-bottom: 0px;
}
.container, .container-sm {
  max-width: 100%;
}
.row {
    display: flex;
    flex-wrap: wrap;
    margin-right: 15%;
    margin-left: 15%;
}
.container, .container-fluid, .container-sm, .container-md, .container-lg, .container-xl {
    padding-top: 35px;
}
footer {
      position: absolute;
      bottom: 0;
      width: 98%;
      height: 80px;
      color: white;
  }
.titulo{
  font-family: times;
  color: #2C5698 ;
  font-style: bold;
  font-size: 30pt;
}
</style>

