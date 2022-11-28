import http from "../http-common";

class UploadFilesService {
  uploadMasivaDoce(file) { //Cambia a donde se desea enviar
    let formData = new FormData();

    formData.append("file", file);

    return http.post("/upiiload", formData, {
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