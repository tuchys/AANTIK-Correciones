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

}