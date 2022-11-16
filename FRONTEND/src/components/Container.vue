<template>
  <b-container> 
  <div>
    <h2>Bienvenido al tejido humano</h2>
    <p>
  Este es un espacio colaborativo, donde podrá contactar a posibles clientes proveedores 
  y aliados estratégicos.
  <br></p></div>
    <div class="container">
      <Playground :nodes="nodes" :links="links"></Playground>
    </div>
  </b-container>
</template>
  
<script>
import Playground from "./Playground";
import TejidoService from "@/service/TejidoService";
  
  export default {
    name: "Container",
    components: {
      Playground,
    },
    data() {
      return {
        nodes: [
          { id: "node1", x: -50, y: 100, width: 320, height: 330, texto:'CLIENTES', 
          clientes:[        ]},
          { id: "node2", x: 700, y: 100, width: 320, height: 330 ,texto:'PROVEEDORES',
          clientes:[ ]},
          { id: "node3", x: 330, y: 290, width: 320, height: 330 ,texto:'ALIADOS',
          clientes:[ ]},
          { id: "node4", x: 400, y: 80, width: 150, height: 100 ,texto:'Emprendimiento',
          clientes:{nombre:'', producto:'', contacto:'' }},
        ],
        emprendimiento: {nombre:null,clientes:[{nombre:null,teleefono:null,contacto:null}],
        aliados:[{nombre:null,teleefono:null,contacto:null}],
        proveedores:[{nombre:null,teleefono:null,contacto:null}]
  },
        auxiliar: null,
        links: [{ from: "node1", to: "node4" },
        { from: "node2", to: "node4" },
        { from: "node4", to: "node3" }]
      };
    },
    tejidoService: null,
    created() {      
      this.tejidoService = new TejidoService();
      this.getAll();
    },
    methods: {      
      getAll() {
      this.tejidoService.getAll().then(data => {
        this.emprendimiento = data.data;
        this.nodes[3].texto=this.emprendimiento.raiz.nombre
        console.log(this.nodes[3].texto)
        this.emprendimiento.clientes.forEach((i,j)=>{
          if(i!=null){
            console.log("for each "+i.nombre+"kk "+j)
            var add={nombre:i.nombre,
              producto:i.producto,
              contacto:i.teleefono}
            this.nodes[0].clientes.push(add)
            console.log(this.nodes[0].clientes[j].nombre)
          }
          })
            console.log("tamaño "+this.nodes[0].clientes.length)
        this.emprendimiento.proveedores.forEach((i,j)=>{
          if(i!=null){
          console.log("for each "+i.nombre+"kk "+j)
          var add={nombre:i.nombre,
            producto:i.producto,
            contacto:i.teleefono}
          this.nodes[1].clientes.push(add)
          console.log(this.nodes[1].clientes[j].nombre)
         }
       })
        this.emprendimiento.aliados.forEach((i,j)=>{
          if(i!=null){
          console.log("for each "+i.nombre+"kk "+j)
          var add={nombre:i.nombre,
            producto:i.producto,
            contacto:i.teleefono}
            this.nodes[2].clientes.push(add)
            console.log(this.nodes[2].clientes[j].nombre)
          }  
        })
          
      });
      }   
    }
  };
  </script>
  
  <style scoped>
  .container {
    position: relative;
    width: 100%;
    height: 100%;
  }
  </style>
  