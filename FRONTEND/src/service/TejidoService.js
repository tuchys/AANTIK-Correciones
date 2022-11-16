import axios from 'axios';
export default class TejidoService {

    url = "http://localhost:8080/";

    getAll() {
        return axios.get(this.url + "generaRed");
    }

}