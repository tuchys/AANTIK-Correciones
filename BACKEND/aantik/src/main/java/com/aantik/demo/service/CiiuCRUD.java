package com.aantik.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.aantik.demo.entidad.Ciiu_Emp;
import com.aantik.demo.entidad.CIIU;
import com.aantik.demo.repositorio.CiiuRepositorio;
import com.aantik.demo.repositorio.CiiuEmpRepositorio;

@Service
public class CiiuCRUD implements CiiuCRUDLocal{
	
	@Autowired
	CiiuRepositorio repository;
	
	@Autowired
	CiiuEmpRepositorio repositoryComp;
	
	private boolean checkciiuExiste(CIIU ciiu)  {
		Optional<CIIU> ciiuFindCod = repository.findByCodigo(ciiu.getCodigo());
		System.out.println("dato obtenido------------"+ciiuFindCod);
		if(ciiuFindCod.isPresent()) {
			System.out.println("Objeto repetido: "+ciiu.getActividad()+"-"+ciiu.getCodigo());
			return false;//throw new Exception("Codigo CIIU ya se encuentra registrado");
		}
		return true;
	}
	
	@Override
	public CIIU crearCIIU(CIIU ciiu) {
		if(checkciiuExiste(ciiu)) {
			ciiu = repository.save(ciiu);
		}
		return ciiu;
	}

	@Override
	public Iterable<CIIU> getAll() {
        return repository.findAll();
	}
	
	@Override
	public Iterable<Ciiu_Emp> getAllCE() {//geet all ciiu x emprendimiento
        return repositoryComp.findAll();
	}

	public void saveAll(com.aantik.demo.model.CIIU[] CIIUlista,int cant) {
		// TODO Auto-generated method stub
		CIIU addCiiu=new CIIU();
		for(int i =0;i<cant;i++) {
			addCiiu.setActividad(CIIUlista[i].actividad);
			addCiiu.setAgrupacion(CIIUlista[i].agrupacion.toString());
			addCiiu.setCodigo(CIIUlista[i].codigo.toString());
			addCiiu.setDescripcion(CIIUlista[i].descripcion);
			addCiiu.setTipo(CIIUlista[i].tipo);
			addCiiu.setSector(CIIUlista[i].sector);
			addCiiu.setId((CIIUlista[i].codigo));
			crearCIIU(addCiiu);
		}		
	}

	public void saveAll2(com.aantik.demo.model.ModCiiuXemp[] cIIUlista, int cant) {
		// TODO Auto-generated method stub
		Ciiu_Emp addCiiuEmp=new Ciiu_Emp();
		for(int i =0;i<cant;i++) {
			addCiiuEmp.setId(cIIUlista[i].id);
			addCiiuEmp.setIdCiiu(cIIUlista[i].idCiiu);
			addCiiuEmp.setIdName(cIIUlista[i].nombreEmp.toString());
			crearCIIUxEmp(addCiiuEmp);
		}		
	}

	private Ciiu_Emp crearCIIUxEmp(Ciiu_Emp addCiiuEmp) {
		if(checkciiuExiste(addCiiuEmp)) {
			addCiiuEmp = repositoryComp.save(addCiiuEmp);
		}
		return addCiiuEmp;
	}

	private boolean checkciiuExiste(Ciiu_Emp addCiiuEmp) {
		Optional<Ciiu_Emp> ciiuFindCod = repositoryComp.findById(addCiiuEmp.getId());
		System.out.println("dato obtenido------------"+ciiuFindCod);
		if(ciiuFindCod.isPresent()) {
			System.out.println("Objeto repetido: "+addCiiuEmp.getIdName()+"-"+addCiiuEmp.getIdCiiu());
			return false;//throw new Exception("Codigo CIIU ya se encuentra registrado");
		}
		return true;
	}

}
