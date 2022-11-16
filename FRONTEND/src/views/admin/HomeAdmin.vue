<template>
  <b-container>  
       <div>
          <sidebar-menu-akahon 
          />
        </div> 
    <b-row>
      <b-col>
        <div class="hello">
          <h3>Panel administrativo</h3>
        </div><br><br>
        <router-link to="/gesStu">
        <button type="submit" class="btn btn-dark btn-lg btn-block">
        Gestionar estudiantes</button></router-link><br>
        
        <router-link to="/orgAdmin">
        <button type="submit" class="btn btn-dark btn-lg btn-block">
        Gestionar Organizaciones Sociales</button></router-link><br>
        
        <router-link to="/docAdmin">
        <button type="submit" class="btn btn-dark btn-lg btn-block">
        Gestionar Docentes</button></router-link><br>
        
        <router-link to="/classAdmin">
        <button type="submit" class="btn btn-dark btn-lg btn-block">
        Gestionar grupos de clase</button></router-link><br>
        
        <router-link to="/empAdmin">
        <button type="submit" class="btn btn-dark btn-lg btn-block">
        Gestionar emprendimientos</button></router-link><br>
        
        <router-link to="/gesCoordinador">
        <button type="submit" class="btn btn-dark btn-lg btn-block">
        Gestionar coordinadores</button></router-link><br>
        
        <router-link to="/gesForo">
        <button type="submit" class="btn btn-dark btn-lg btn-block">
        Gestionar foro</button></router-link><br>
        
        <router-link to="/notiedit">
        <button type="submit" class="btn btn-dark btn-lg btn-block">
        Gestionar noticias</button></router-link><br>
        
        <router-link to="/gesIndicadores">
        <button type="submit" class="btn btn-dark btn-lg btn-block">
        Gestionar indicadores</button></router-link><br>
      </b-col>
      <b-col>
        
      </b-col>
    </b-row>
  </b-container>   
</template>

<script>
import SidebarMenuAkahon from "@/components/SideBarAdmin.vue"

export default {
   components: {
    SidebarMenuAkahon,
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
