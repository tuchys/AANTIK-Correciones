package com.aantik.demo.service;

import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aantik.demo.entidad.Diagnostico;
import com.aantik.demo.entidad.Preguntas_Dig;
import com.aantik.demo.model.ModDGRes;
import com.aantik.demo.model.ModDGV;
import com.aantik.demo.repositorio.DiagnosticoRepositorio;
import com.aantik.demo.repositorio.PreguntaRepositorio;

@Service
public class DiagnosticoCRUD implements DiagnosticoCRUDLocal{
	
	@Autowired
	DiagnosticoRepositorio repDG;
	
	@Autowired
	PreguntaRepositorio repPreg;
	
	@Override
	public Iterable<Diagnostico> getAll() {
		// TODO Auto-generated method stub
		Iterable<Diagnostico> lista = repDG.findAll();
		return lista;
	}

	@Override
	public void crearDiagnostico(ModDGV diag) throws Exception {
		// TODO Auto-generated method stub
		Diagnostico addDg =new Diagnostico();		 
		if(diag.puntajeN != 0) {
			addDg.setCorreo(diag.correo);
			addDg.setPreguntaCod(diag.codigo);
			addDg.setPuntajeN(diag.puntajeN);
			addDg.setPuntajeS(diag.puntajeS);	    
		}else  if(diag.puntajeS != null) {
				addDg.setCorreo(diag.correo);
				addDg.setPreguntaCod(diag.codigo);
				addDg.setPuntajeS(diag.puntajeS);
		}
		if(valida(addDg)) {
			repDG.save(addDg);
		}else {
			Diagnostico actualiza=repDG.getByPreguntaCod(addDg.getPreguntaCod());
			mapeo(actualiza,addDg);
			System.out.println("aCTUALIZANDO..."+actualiza.getPreguntaCod());
			repDG.save(actualiza);
		}
			
	}

	private void mapeo(Diagnostico actualiza, Diagnostico addDg) {
		// TODO Auto-generated method stub
		actualiza.setCorreo(addDg.getCorreo());
		actualiza.setPreguntaCod(addDg.getPreguntaCod());
		actualiza.setPuntajeN(addDg.getPuntajeN());
		actualiza.setPuntajeS(addDg.getPuntajeS());
		
	}

	private boolean valida(Diagnostico addDg) {
		// TODO Auto-generated method stub
		Optional<Diagnostico> docEncontrado = repDG.findByPreguntaCod(addDg.getPreguntaCod());
		if(docEncontrado.isPresent()) {
			System.out.println("Nodo ya se encuentra registrado");
			return false;
		}
		return true;
	}

	@Override
	public Iterable<Diagnostico> getNoRespondidas(Iterable<Preguntas_Dig> listaPreg, Diagnostico dg_actual) {
		// TODO Auto-generated method stub
		return null;
	}

	public int getPuntaje(String codigo) {
		// TODO Auto-generated method stub
		Diagnostico aux=repDG.getByPreguntaCod(codigo);
		if(aux==null)
			return 0;
		return aux.getPuntajeN();
	}

	public ModDGRes[] getResXuser(ModDGRes[] resp, String correo) {
		// TODO Auto-generated method stub
		Iterable<Diagnostico> respuestas = repDG.findByCorreo(correo);
		if(respuestas != null) {
			int i=0;
			int tam= cantidad(respuestas);
			//resp= new ModDGRes[tam];
			for(Diagnostico aux: respuestas) {
				
				resp[i]= new ModDGRes();
				resp[i].pregunta=getPreguntaXcod(aux.getPreguntaCod());				
				resp[i].respuesta=aux.getPuntajeS();				
				resp[i].puntaje=aux.getPuntajeN();
				System.out.println("-----"+resp[i].pregunta);
				i++;
			}
		}
		return resp;
	}

	private String getPreguntaXcod(String preguntaCod) {
		// TODO Auto-generated method stub
		Preguntas_Dig pregunta=repPreg.getByCodigo(preguntaCod);
		if(pregunta != null)
			return pregunta.getPregunta();
		return null;
	}

	private int cantidad(Iterable<Diagnostico> respuestas) {
		// TODO Auto-generated method stub
		int tam=0;
		for(@SuppressWarnings("unused") Diagnostico aux:respuestas)
			tam++;
		return tam;
	}

	public int getTamanio(String correo) {
		Iterable<Diagnostico> respuestas = repDG.findByCorreo(correo);
		// TODO Auto-generated method stub
		int tam=0;
		for(@SuppressWarnings("unused") Diagnostico aux:respuestas)
			tam++;
		return tam;
	}

}
