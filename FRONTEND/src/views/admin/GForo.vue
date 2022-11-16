<template>
  <b-container fluid="xl">  
       <div>
          <sidebar-menu-akahon 
          />
        </div> 
    <b-row class="change_row">
      <b-col class="change_col">
        <div class="hello">
          <h3>Gestor de contenido colaborativo</h3>
        </div>
        <div>
          <b-table class="table" striped Bordered hover id="pages-table" :items="this.user" :fields="fields" :key="id">
            <template #cell(Eliminar)="row">
        <b-button size="sm" @click="Eliminate(row.item.id)" class="mr-2"> Eliminar
        </b-button>
      </template>

            <template >
              <b-button class="mr-2">Elminar
              </b-button>
            </template>
          </b-table>
        </div>
        <br>

      </b-col>
      <b-col>
        
      </b-col>
    </b-row>
  </b-container>   
</template>

<script>
import SidebarMenuAkahon from "@/components/SideBarAdmin.vue"
import axios from 'axios'
export default {
  name: 'Homecoordinador',
  props: {
    msg: String
  },
  data() {
      return {
        user: [],
        fields:[
          {
            key:"id",
            label:"Id",
            thStyle: { width: "5%" }
          },
          {
            key:"postedby",
            label:"Autor"
          },
          {
            key:"postBody",
            label:"pregunta",
            thStyle: { width: "50%" }
          },
          {
            key:"createDate",
            label:"Fecha",
            thStyle: { width: "20%" }
          },
          {
            key:"Eliminar",
          },
        ],
      }      
  },
   components: {
    SidebarMenuAkahon,
  },
  methods: {
    Eliminate(id){
      console.log(id)
       axios.post("http://localhost:8080/deletePost", { 
        postedby:id,
    }).then((response) => {
      this.user=response.data;
    })
    }
    
  },
  mounted(){
    axios.get("http://localhost:8080/foroPreguntas").then((response)=>{
     // console.log(response)
      this.user=response.data;
      console.log(this.user)
    })
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
.table{
  width: 50rem;
}
.change_row{
  width: 100rem;
}
.change_col{
  width: 100rem;
}
</style>
