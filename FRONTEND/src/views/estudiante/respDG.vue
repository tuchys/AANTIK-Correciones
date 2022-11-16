<template>
    <b-container>  
         <div>
            <sidebar-menu-akahon 
            />
          </div> 
      <b-row>
        <b-col>
          <div class="hello">
            <h3>Conozca los resultados del emprendimiento asesorado</h3>
          </div>
          Recuerde que el diagnóstico de madurez cuenta con preguntas que son cuantificadas
          automáticamente por el sistema, usted podrá modificar dichos valores y 
          asignar el puntaje a las preguntas que no han sido cuantificadas por AANTIK.
          <br>
          <br>
  
          resultados obtenidos de {{entidad}}
          <br>
          <div>
  
            
           <b-table striped hover :items="resp" :fields="campos">
              <template #cell(Editar)="row">
                <b-form inline>
                <label class="mr-sm-2" for="inline-form-custom-select-pref">Preference</label>
                <b-form-select
                id="inline-form-custom-select-pref"
                class="mb-2 mr-sm-2 mb-sm-0"
                :options="[{ text: '0', value: null }, '1', '2', '3','4','5']"
                :value="null"
            ></b-form-select>
            <b-button class="mr-2"  @click="enviar(row)">Editar
                            </b-button>
    
            </b-form>
                
              </template>
            </b-table>
          </div>

             <br>  
        </b-col>
      </b-row>
    </b-container>   
</template>
  
<script>
import SidebarMenuAkahon from "@/components/SideBarSt.vue"
import AuthService from "@/service/auth.service"
import serviceD from "@/service/diagnosticoService"

  export default {
    components: {
      SidebarMenuAkahon,
    },
    name: "user",
  
    data() {
      return{
        resp:[{
          pregunta:null,
          respuesta:null,
          puntaje:null
        }],
  
        campos: [
          { key: "pregunta" },
          { key: "respuesta" },
          { key: "puntaje"},
          { key: "Editar" }
        ],
        entidad: "yku",
      }
    },
    mounted() {
        this.serviceD = new serviceD();
        this.getAll()
    },
    methods: {
        editarSt(idSt){
          console.log("id---------",idSt);
          //self.$router.push({name:'preEdit' })
        },
        editarPre(idSt){
          console.log("id---------",idSt);
          //self.$router.push({name:'preEdit' })
        },
        getAll() {
            try{
                this.serviceD.getRespDiag(AuthService.getCorreo())
                .then(data => {
                 this.resp = data.data;
                    console.log(this.resp.data);
                }).catch(function(error) {
                    console.log(error);
                });   
            } catch (error) {
            console.log(error);
            }
        
        console.log("gj-----");
        console.log(this.resp.pregunta);
      },
      enviar(roww){
        console.log("id cargaqdo",roww)
      }
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
  .w-100 {
      width: 80% !important;
  }
  </style>
  