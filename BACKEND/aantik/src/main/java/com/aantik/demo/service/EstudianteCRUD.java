package com.aantik.demo.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.aantik.demo.entidad.Estudiante;
import com.aantik.demo.entidad.Role;
import com.aantik.demo.entidad.User;
import com.aantik.demo.model.ModEstudLiv;
import com.aantik.demo.model.ModEstudiante;
import com.aantik.demo.model.Mpreinscrito;
import com.aantik.demo.model.gestEstudiantes;
import com.aantik.demo.repositorio.EstudianteRepositorio;
import com.aantik.demo.repositorio.RoleRepositorio;
import com.aantik.demo.repositorio.UsuarioRepositorio;

@Service
public class EstudianteCRUD implements EstudianteCRUDLocal{

	@Autowired
	EstudianteRepositorio repository;
	@Autowired
	UsuarioRepositorio repositoryUser;
	@Autowired
	RoleRepositorio repositoryRol;
	

	
	@Override
	public void crearEstudiante(Estudiante estd) throws Exception {
		if(existe(estd) && existeUser(estd.getCorreo())) {
			if(estd.getCorreo()!=null && estd.getCorreo().length()>1) {
				User userDoc=new User();
				userDoc.setUsername(estd.getCorreo());
				userDoc.setPassword("1236");
				Role rolDoc;
				rolDoc=repositoryRol.findByName("Estudiante");
				userDoc.setRoles(rolDoc.getId());
				repositoryUser.save(userDoc);
				System.out.println("insertando usuario");
				estd.setUserId(userDoc.getId());
			}
			if(estd.getNombre() !=null) {
				estd = repository.save(estd);
				System.out.println("insertando estudiante");
			}
		}else {
			Estudiante actualizar=repository.getByCorreo(estd.getCorreo());
			mapear(estd,actualizar);
			repository.save(actualizar);
		}
		
		
	}

	private void mapear(Estudiante estd, Estudiante actualizar) {
		actualizar.setActividadEco(estd.getActividadEco());
		actualizar.setActividadExtra(estd.getActividadExtra());
		//actualizar.setAsignatura(estd.getAsignatura());
		actualizar.setBarrio(estd.getBarrio());
		actualizar.setCiudad(estd.getCiudad());
		//actualizar.setClase(estd.getClase());
		actualizar.setComunidad(estd.getComunidad());
		actualizar.setContacto(estd.getContacto());
		//actualizar.setCorreo(estd.getCorreo());
		actualizar.setDireccion(estd.getDireccion());
		actualizar.setDisponibilidad(estd.getDisponibilidad());
		actualizar.setDocenteNoPref(estd.getDocenteNoPref());
		actualizar.setDocentePref(estd.getDocentePref());
		actualizar.setDocumento(estd.getDocumento());
		actualizar.setEnfasis(estd.getEnfasis());
		//actualizar.setEntidad(estd.getEntidad());
		actualizar.setExperiencia(estd.getExperiencia());
		//actualizar.setFechaSP(estd.getFechaSP());
		actualizar.setGenero(estd.getGenero());
		//actualizar.setId(estd.getId());
		//actualizar.setIdentificacion(estd.getIdentificacion());
		//actualizar.setIdEstudiantil(estd.getIdEstudiantil());
		//actualizar.setInfografia(estd.getInfografia());
		actualizar.setLimitacion(estd.getLimitacion());
		actualizar.setLimitLocalidad(estd.getLimitLocalidad());
		actualizar.setLinAccion(estd.getLinAccion());
		actualizar.setLocalidad(estd.getLocalidad());
		actualizar.setModalidad(estd.getModalidad());
		//actualizar.setNombre(estd.getNombre());
		actualizar.setNotificaciones(estd.getNotificaciones());
		actualizar.setPromedio (estd.getPromedio());
		//actualizar.setTallerSP(estd.getTallerSP());
		actualizar.setTelefono(estd.getTelefono());
		actualizar.setTipoEmp(estd.getTipoEmp());
		actualizar.setTipoOrg(estd.getTipoOrg());
		actualizar.setTransporte(estd.getTransporte());
		//actualizar.setUserId(estd.getUserId());   
	}

	private boolean existeUser(String correo) {
		Optional<User> Encontrado = repositoryUser.findByUsername(correo);
		if(Encontrado.isPresent()) {
			System.out.println("Usuario ya se encuentra registrado");
			return false;
		}
		return true;
	}

	@Override
	public Iterable<Estudiante> getAll() {
        return repository.findAll();
	}

	public void saveAll(ModEstudiante[] stlista, int cantSt) {
		// TODO Auto-generated method stub
		
	}

	public void saveAllPre(Mpreinscrito[] preLista, int cant) {
		Estudiante preins=new Estudiante();
		System.out.println("VERIFICANDO "+preLista.length);
		for(int i =0;i<preLista.length;i++) {
			preins=new Estudiante();
			if(preLista[i]!=null) {
				preins.setNombre(preLista[i].nombre);
				preins.setCorreo(preLista[i].correo);
				preins.setTelefono(preLista[i].telefono);
				preins.setDireccion(preLista[i].direccion);
				preins.setAsignatura(preLista[i].asignatura);
				preins.setIdEstudiantil(preLista[i].idEstudiantil);
				preins.setIdentificacion(preLista[i].identificacion);
				preins.setTallerSP(preLista[i].tallerSP);
				preins.setFechaSP(preLista[i].fechaSP);
				preins.setInfografia(preLista[i].infografia);
				try {
					crearPreins(preins);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
	}

	public void crearPreins(Estudiante preins) {
		if(existe(preins)) {
			if(preins.getCorreo()!=null && preins.getCorreo().length()>1) {
				User userDoc=new User();
				userDoc.setUsername(preins.getCorreo());
				userDoc.setPassword("1236");
				Role rolDoc;
				rolDoc=repositoryRol.findByName("Preinscrito");
				userDoc.setRoles(rolDoc.getId());
				repositoryUser.save(userDoc);
				System.out.println("insertando usuario");
				preins.setUserId(userDoc.getId());
			}
			if(preins.getNombre() !=null) {
				preins = repository.save(preins);
				System.out.println("insertando preinscrito");
			}
		}
	}

	private boolean existe(Estudiante preins) {
		Optional<Estudiante> preEncontrado = repository.findByNombre(preins.getNombre());
		if(preEncontrado.isPresent()) {
			System.out.println("Estudiante ya se encuentra registrado");
			return false;
		}
		return true;
	}

	public void saveAllstud(ModEstudiante[] estLista, int cant) {
		// TODO Auto-generated method stub
		Estudiante insc=new Estudiante();
		System.out.println("VERIFICANDO "+estLista.length);
		for(int i =0;i<estLista.length;i++) {
			insc=new Estudiante();
			if(estLista[i]!=null) {
				insc.setActividadEco(estLista[i].actividadEco);
				insc.setActividadExtra(estLista[i].actividadExtra);
				insc.setAsignatura(estLista[i].asignatura);
				insc.setBarrio(estLista[i].barrio);
				insc.setCiudad(estLista[i].ciudad);
				insc.setComunidad(estLista[i].comunidad);
				insc.setContacto(estLista[i].contacto);
				insc.setCorreo(estLista[i].correo);
				insc.setDireccion(estLista[i].direccion);
				insc.setDisponibilidad(estLista[i].disponibilidad);
				insc.setDocenteNoPref(estLista[i].docenteNoPref);
				insc.setDocentePref(estLista[i].docentePref);
				insc.setDocumento(estLista[i].documento);
				insc.setEnfasis(estLista[i].enfasis);
				insc.setExperiencia(estLista[i].experiencia);
				insc.setGenero(estLista[i].genero);
				insc.setLimitacion(estLista[i].limitacion);
				insc.setLimitLocalidad(estLista[i].limitLocalidad);
				insc.setLinAccion(estLista[i].linAccion);
				insc.setLocalidad(estLista[i].localidad);
				insc.setModalidad(estLista[i].modalidad);
				insc.setNombre(estLista[i].nombre);
				insc.setNotificaciones(estLista[i].notificaciones);
				insc.setPromedio(estLista[i].promedio);
				insc.setTelefono(estLista[i].telefono);
				insc.setTipoEmp(estLista[i].tipoEmp);
				insc.setTransporte(estLista[i].transporte);
				try {
					crearEstudiante(insc);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
	}

	public Iterable<Estudiante> getInscritos() {
		// TODO Auto-generated method stub
		return null;
	}

	public Estudiante[] getpreins(Estudiante[] preinscritos) {
		// TODO Auto-generated method stub
		Role rol=repositoryRol.findByName("Preinscrito");
		Iterable<User> buscar =repositoryUser.getByRoles((long)rol.getId()); 
		int cantidad= countUser(buscar);
		preinscritos=new Estudiante[cantidad];
		int i=0;
		for(User user:buscar){
			Optional<Estudiante> preEncontrado = repository.findByUserId(user.getId());
			if(preEncontrado.isPresent()) {
				preinscritos[0]=new Estudiante(); 
			//	preinscritos[0]=preEncontrado.; 
						
			//	System.out.println("Estudiante ya se encuentra registrado");
			}
		}
		return preinscritos;
	}

	private int countUser(Iterable<User> buscar) {
		// TODO Auto-generated method stub
		int tam=0;
		for (@SuppressWarnings("unused") User contar: buscar)
			tam++;
		return tam;
	}

	public int getTamanio(Iterable<Estudiante> insc) {
		// TODO Auto-generated method stub
		int tam=0;
		for (@SuppressWarnings("unused") Estudiante contar: insc)
			tam++;
		return tam;
	}

	public void getGestStud(gestEstudiantes resp) {
		// TODO Auto-generated method stub
		Role rol=repositoryRol.findByName("Preinscrito");
		Role rol2=repositoryRol.findByName("Estudiante");
		Iterable<User> buscarPre =repositoryUser.getByRoles((long)rol.getId()); 
		Iterable<User> buscarSt =repositoryUser.getByRoles((long)rol2.getId());
		int cantidad= countUser(buscarPre);
		int cantidad2= countUser(buscarSt);
		int i=0,j=0;
		resp.preins=new ModEstudLiv[cantidad];
		resp.ins=new ModEstudLiv[cantidad2];
		for(User user:buscarPre){
			Optional<Estudiante> preEncontrado = repository.findByUserId(user.getId());
			if(preEncontrado.isPresent()) {
				Estudiante aux=repository.getByUserId(user.getId());
				resp.preins[i]=new ModEstudLiv();
				resp.preins[i].id=aux.getId();
				resp.preins[i].nombre=aux.getNombre();
				resp.preins[i].datoCambiante=aux.getAsignatura();
				i++;	
				System.out.println("Preinscrito");
			}
		}
		for(User user:buscarSt){
			Optional<Estudiante> preEncontrado = repository.findByUserId(user.getId());
			if(preEncontrado.isPresent()) {
				Estudiante aux=repository.getByUserId(user.getId());
				resp.ins[j]=new ModEstudLiv();
				resp.ins[j].id=aux.getId();
				resp.ins[j].nombre=aux.getNombre();
				if(aux.getEntidad()==null)
					resp.ins[j].datoCambiante="Pendiente asiganacion";
				else
				resp.ins[j].datoCambiante=aux.getEntidad();
				j++;	
				System.out.println("Estudiante");
			}
		}
	}

	@Override
	public Iterable<Estudiante> getpreins() {
		// TODO Auto-generated method stub
		return null;
	}

}
