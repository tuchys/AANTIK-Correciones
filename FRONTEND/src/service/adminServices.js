import axios from 'axios';
export default class adminServices {

    url = "http://localhost:8080/";

    async save(dgR,correoS) {
            console.log(correoS)
        return axios.post(this.url + "updateOrgSoc",{          
            puntajeN:dgR.valorN,
            puntajeS:dgR.valorS,
            codigo:dgR.codigoP,
            correo: correoS
        })
    }

    getOS(idOrg) {
        console.log("parametro"+idOrg);
        return axios.post(this.url + "getOS-adm"
        ,null,{
            params: {idOrg}
        });
    }

    getRespDiag(correo){
        return axios.post(this.url + "getResDG",null,{
            params: { correo}
        });
    }

}