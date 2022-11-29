
class UploadFilesService {
  uploadMasivaDoce(file) { //Cambia a donde se desea enviar
    let formData = new FormData();

    formData.append("file", file);

    return http.post("http://localhost:8080/aut/agregEstFile", formData, {
      headers: {
        "Content-Type": "multipart/form-data"
      }
    });
  }

  getFiles() {
    return http.get("/files");
  }
}

export default new UploadFilesService();