<template>
  <div id="app">
    
    <div>
      <sidebar-menu-akahon 
      />
    </div> 
    <container></container>
    <br>
  </div>
</template>

<script>
import Container from "@/components/Container";
import SidebarMenuAkahon from "@/components/SideBarCoord.vue"

export default {
  name: "App",
  components: {
    SidebarMenuAkahon,
    Container
  },
};
</script>

<style>
#app {
  font-family: "Avenir", Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  /* margin-top: 60px; */
  width: 100%;
  height: 100%;
}
html,
body {
  margin: 0;
  width: 100%;
  height: 100%;
}
</style>
