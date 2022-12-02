import axios from 'axios';
export default class asignacionService {

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

    getActual() {
        return axios.get(this.url + "api/infoAsigAct");
    }

    getRespDiag(correo){
        return axios.post(this.url + "getResDG",null,{
            params: { correo}
        });
    }

    changeCuanti(id,cuanti){
        return axios.post(this.url + "changeCuant",null,{
            params: { id, cuanti}
        });
    }

}