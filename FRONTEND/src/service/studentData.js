import axios from 'axios';
export default class studentData {

    url = "http://localhost:8080/";

    getAll() {
        return axios.get(this.url + "all");
    }

}