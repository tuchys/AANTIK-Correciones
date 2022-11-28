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
          <p align=left>
          Debe seleccionar el archivo .csv que cumpla con los parametros del sistema.
           <br>
          <router-link to="/ayuda">Revisar parametros</router-link>
          <br></p>
        </div>
        <!--<b-form-file
            v-model="file1"
            :state="Boolean(file1)"
            placeholder="Seleccione un archivo o arrastrelo aquí..."
            drop-placeholder="Drop file here..."
          ></b-form-file>-->
          
      <label class="btn btn-default" >
        <input type="file" ref="file" @change="selectFile"/>
      </label>
  
      <button class="btn btn-success" :disabled="!selectedFiles" @click="upload">
        Subir archivo
      </button>
  
      <div class="alert alert-light" role="alert">{{ message }}</div>
  
    </b-col>
    </b-row>
  </b-container>   
  </template>
  <script>
  import SidebarMenuAkahon from "@/components/SideBarCoord.vue"
  import UploadFileService from "@/service/CargaMasivaService"
  export default {
    name: "upload-files",
    components: {
      SidebarMenuAkahon,
    },
    data() {
    return {
      selectedFiles: undefined,
      currentFile: undefined,
      message: "",
    };
  },
  methods: {
    selectFile() {
      this.selectedFiles = this.$refs.file.files;
    },
    upload() {
      this.currentFile = this.selectedFiles.item(0);
      UploadFileService.uploadMasivaDoce(this.currentFile)
        .then(response => {
          this.message = response.data.message;
        })
        .then(files => {
          this.fileInfos = files.data;
        })
        .catch(() => {
          this.message = "No se pudo cargar el archivo!";
          this.currentFile = undefined;
        });

      this.selectedFiles = undefined;
    },

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
  color: #1410dd;
}
.hello{
    text-align: center;
}
.custom-file-input ~ .custom-file-label::after {
    content: "Elegir";
}

</style>