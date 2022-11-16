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
            Upload
          </button>

          <div class="alert alert-light" role="alert">{{ message }}</div>

          <div class="card">
            <div class="card-header">List of Files</div>
            <ul class="list-group list-group-flush">
              <li
                class="list-group-item"
                v-for="(file, index) in fileInfos"
                :key="index"
              >
                <a :href="file.url">{{ file.name }}</a>
              </li>
            </ul>
          </div>
        </div>
      </b-col>
      <b-col>
      
      </b-col>
    </b-row>
  </b-container>  
</template>

<script>
import SidebarMenuAkahon from "@/components/SideBarSt.vue"
import UploadService from "@/service/UploadFilesService";

export default {
  components: {
    SidebarMenuAkahon,
  },
  name: "upload-files",
  data() {
    return {
      selectedFiles: undefined,
      currentFile: undefined,
      progress: 0,
      message: "",

      fileInfos: [],
    };
  },
  methods: {
    selectFile() {
      this.selectedFiles = this.$refs.file.files;
    },

    upload() {
      this.progress = 0;

      this.currentFile = this.selectedFiles.item(0);
      UploadService.upload(this.currentFile, (event) => {
        this.progress = Math.round((100 * event.loaded) / event.total);
      })
        .then((response) => {
          this.message = response.data.message;
          return UploadService.getFiles();
        })
        .then((files) => {
          this.fileInfos = files.data;
        })
        .catch(() => {
          this.progress = 0;
          this.message = "Could not upload the file!";
          this.currentFile = undefined;
        });

      this.selectedFiles = undefined;
    },
  },
  mounted() {
    UploadService.getFiles().then((response) => {
      this.fileInfos = response.data;
    });
  },
};
</script>
