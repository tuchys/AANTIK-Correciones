<template>
  <b-container>  
       <div>
          <sidebar-menu-akahon 
          />
        </div> 
    <b-row>
      <b-col>
        <div class="hello" >
          <h3>Gestor de carga para estudiantes pre-inscritos</h3>
          <br>
          <p align=left>
          Debe seleccionar el archivo .xlsx que cumpla con los parametros del sistema.
           <br>
          <router-link to="/ayuda">Revisar parametros</router-link>
          <br></p>
        </div>
  <div>
    <div v-if="currentFile" class="progress">
      <div
        class="progress-bar progress-bar-info progress-bar-striped"
        role="progressbar"
        :aria-valuenow="progress"
        aria-valuemin="0"
        aria-valuemax="100"
        :style="{ width: progress + '%' }"
      >
        {{ progress }}%
      </div>
    </div>

    <label class="btn btn-default">
      <input type="file" ref="file" @change="selectFile" />
    </label>

    <button class="btn btn-success" :disabled="!selectedFiles" @click="upload">
      Subir
    </button>

    <div class="alert alert-light" role="alert">{{ message }}</div>

  </div>
</b-col>
    </b-row>
  </b-container>   
</template>
  <script>
  import SidebarMenuAkahon from "@/components/SideBarCoord.vue"
  import UploadFileService from "@/service/CargaMasivaService"
  import auth from "@/service/auth.service"
  import axios from "axios";
  export default {
  name: "upload-files",
  components: {
      SidebarMenuAkahon,
    },
  data() {
    return {
      selectedFiles: undefined,
      currentFile: undefined,
      user:auth.getUser,
      progress: 0,
      message: "",

      fileInfos: []
    };
  },
  methods: {
    selectFile() {
      this.selectedFiles = this.$refs.file.files;
    },
    upload() {
      this.progress = 0;
      this.currentFile = this.selectedFiles.item(0);
      let formData = new FormData();
      formData.append("file", this.currentFile);

    return axios.post("http://localhost:8080/aut/upload", formData, {       //change method
      headers: {
        "Content-Type": "multipart/form-data"
      }
    })
        .then(response => {
          this.message = response.data.message;
          this.progress= 100
        })
     // this.selectedFiles = undefined;
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
.hello{
    text-align: center;
}
.custom-file-input ~ .custom-file-label::after {
    content: "Elegir";
}

</style>