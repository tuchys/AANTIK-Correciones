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
    getCO(idCO) {
        console.log("parametro"+idCO);
        return axios.post(this.url + "getCO-adm"
        ,null,{
            params: {idCO}
        });
    }

    getActCO(formulario,idCO){
        return axios.post(this.url + "editCoord",{
            id: idCO,
            nombre: formulario.nombre,
            correo: formulario.correo,
            asignatura: formulario.asignatura,
        });
    }

    getOS(idOrg) {
        console.log("parametro"+idOrg);
        return axios.post(this.url + "getOS-adm"
        ,null,{
            params: {idOrg}
        });
    }

    getActulizacion(formulario,idOrg){
        return axios.post(this.url + "updateOrgSoc",{
            id: idOrg,
            nombreEmp: formulario.nombreEmp,
            nitId: formulario.nitId,
            fechaCons: formulario.fechaCons,
            direccion: formulario.direccion,
            localidad: formulario.localidad,
            barrio: formulario.barrio,
            nombreInterOS: formulario.nombreInterOS,
            telefonoIOS: formulario.telefonoIOS,
            correoIOS: formulario.correoIOS,
            temaAsesorar: formulario.temaAsesorar,
            cupos: formulario.cupos,
            empleados: formulario.empleados,
            linAccion: formulario.linAccion,
            tipoOS: formulario.tipoOS,
            actividadEco: formulario.actividadEco,
            prodServ: formulario.prodServ,
            contacto: formulario.contacto,
            experiencia: formulario.experiencia,
            promedio: formulario.promedio,
            horarioNotif: formulario.horarioNotif,
            modalidad: formulario.modalidad,
            disponibilidad: formulario.disponibilidad,
            horarioAtencion: formulario.horarioAtencion,
            genero: formulario.genero,
            limitacion: formulario.limitacion,
            comunidad: formulario.comunidad,
            transporte: formulario.transporte,
        });
    }

    getAllIndicadores() {
        return axios.get(this.url + "getIndicadores");
    }

    getLIndicadores() {
        return axios.get(this.url + "getListIndicadores");
    }

    saveInd(indicador) {
        return axios.post(this.url + "addIndc",{          
            nombre:indicador.nombre,
            pregunta:indicador.pregunta
        })
    }

    borraInd(indicadorId){
        console.log("parametro"+indicadorId);
        return axios.post(this.url + "delIndc",null,{
            params: {indicadorId}
        })
    }

    getAllCiclos() {
        return axios.get(this.url + "getCiclos");
    }

    saveCiclo(ciclo) {
        
        console.log("parametro"+ciclo.nombre);
        return axios.post(this.url + "addCiclo",{          
            id:null, 
            nombre:ciclo.nombre,
            estado:null
        })
    }

    borraCiclo(cicloId){
        console.log("parametro"+cicloId);
        return axios.post(this.url + "delCiclo",null,{
            params: {cicloId}
        })
    }

    activaCiclo(cicloId){
        console.log("parametro"+cicloId);
        return axios.post(this.url + "estadoCiclo",null,{
            params: {cicloId}
        })
    }

}