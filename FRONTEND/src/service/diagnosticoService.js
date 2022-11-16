import axios from 'axios';
export default class diagnosticoService {

    url = "http://localhost:8080/";

    async save(dgR,correoS) {
            console.log(correoS)
        return axios.post(this.url + "saveDGV",{          
            puntajeN:dgR.valorN,
            puntajeS:dgR.valorS,
            codigo:dgR.codigoP,
            correo: correoS
        })
    }

    getAllDgv() {
        return axios.get(this.url + "dgvGet");
    }

    getRespDiag(correo){
        return axios.post(this.url + "getResDG",null,{
            params: { correo}
        });
    }

}