import axios from 'axios';
export default class FileService {

    url = "http://localhost:8080/";

    getAll() {
        return axios.get(this.url + "all");
    }

    async sendStudents(file1) {
      console.log(file1);
        return axios.post(this.url , file1);
    }    
      
}