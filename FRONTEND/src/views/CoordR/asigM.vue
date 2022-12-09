<template>
  <b-container>  
       <div>
          <sidebar-menu-akahon 
            @search-input-emit="search"
          />
        </div> 
    <b-row>
      <b-col>
        <div class="hello" >
          <h3>Gestor de carga</h3>
          <br>
          <p>
          Debe seleccionar el archivo .csv que cumpla con los parametros del sistema.
          
           <br>
          <router-link to="/ayuda">Revisar parametros</router-link>
          <br></p>
        </div>
          <!-- Styled -->
          <b-form-file
            v-model="file1"
            :state="Boolean(file1)"
            placeholder="Seleccione un archivo o arrastrelo aquí..."
            drop-placeholder="Drop file here..."
          ></b-form-file>
          <div class="mt-3">Archivo seleccionado: {{ file1 ? file1.name : '' }}</div>
          <button type="submit" class="btn btn-dark btn-lg btn-block" @click="send(file1)">
          Procesar datos</button>
          <!-- Plain mode -->
          <b-form-file v-model="file2" class="mt-3" plain></b-form-file>
          <div class="mt-3">Archivo seleccionado: {{ file2 ? file2.name : '' }}</div>
       
      </b-col>
      <b-col>
      
      </b-col>
    </b-row>
  </b-container>   
</template>

<script>
import SidebarMenuAkahon from "@/components/SideBarCoord.vue"
import FileService from "@/service/FileService";
export default {
  components: {
    SidebarMenuAkahon,
  },
    data() {
      return {
        file1: null,
        file2: null
      }
    },
    fileService: null,
    created() {
      this.fileService = new FileService();
    },
    methods: {
    async send() {
      var data = {
        csv: this.file1
      };
      try {

        let self = this;
        let InstFormData = new FormData();
        InstFormData.append('archivo' , this.cvs);
        console.log('enviando ',InstFormData);
        await this.fileService.sendStudents(this.cvs)
        .then(function(response) {
          console.log(response.data); // DISPLAYS THE DATA I WANT
         // user = response.data; // THROWS TYPE ERROR: Cannot set property 'thoughtWallet' of undefined at eval
        //  self.$router.push({name:'estudiantesCord' })
        }).catch(function(error) {
          console.log(error);
        });

      } catch (error) {
        console.log(error);
      }
    },
      print() {
        console.log("Esto es un método"+this.persona.email);
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
  color: #1410dd;
}
.custom-file-input ~ .custom-file-label::after {
    content: "Elegir";
}

</style>
