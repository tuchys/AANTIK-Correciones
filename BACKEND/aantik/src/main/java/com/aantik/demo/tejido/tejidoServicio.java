package com.aantik.demo.tejido;

import com.aantik.demo.entidad.Ciiu_Emp;
import com.aantik.demo.entidad.Emprendimiento;
import com.aantik.demo.entidad.OrgSocial;
import com.aantik.demo.entidad.RedTejido;
import com.aantik.demo.model.ModCiiuXemp;
import com.aantik.demo.model.ModRedTejido;
import com.aantik.demo.model.RedNodoHijo;
import com.aantik.demo.model.tejidoSocial;

public class tejidoServicio {
	
	public ModRedTejido hacerTejido(Ciiu_Emp buscar,Iterable<RedTejido> redTejido, Iterable<Ciiu_Emp> cruzar, Iterable<Emprendimiento> empL, Iterable<OrgSocial> osL) {
		
		ModRedTejido tejido=new ModRedTejido();
		tejido.clientes=new RedNodoHijo[5];
		tejido.proveedores=new RedNodoHijo[5];
		tejido.aliados=new RedNodoHijo[5];
		int i=0,j=0;
		System.out.println("GENERANDO TEJIDO:");
		for (RedTejido lista: redTejido) {

			if(buscar.getIdCiiu().equals(lista.getEmprenOrigen()) && i<5) {
				String nom=getNombre(lista.getEmprenDest(),cruzar);
				getDatosC(tejido,nom,i,empL,osL);
				/*System.out.println("Cliente :"+lista.getEmprenDest());
				tejido.clientes[i]=new RedNodoHijo();
				tejido.clientes[i].nombre="cliente "+lista.getEmprenDest();
				tejido.clientes[i].teleefono="tel: cliente "+i;
				tejido.clientes[i].producto="producto cliente "+i;
				i++;	*/
			}
			if(buscar.getIdCiiu().equals(lista.getEmprenDest()) && j<5) {
				String nom=getNombre(lista.getEmprenOrigen(),cruzar);
				getDatosP(tejido,nom,j,empL,osL);
				/*System.out.println("Proveedor :"+lista.getEmprenOrigen());
				tejido.proveedores[j]=new RedNodoHijo();
				tejido.proveedores[j].nombre="Proveedor "+lista.getEmprenOrigen();
				tejido.proveedores[j].teleefono="tel: Proveedor "+j;
				tejido.proveedores[j].producto="producto Proveedor "+j;
				j++;*/
			}
		}
		complemento(cruzar,tejido,buscar.getIdCiiu(),buscar.getIdName(),empL,osL);

		return tejido;
	}
	
	private void getDatosC(ModRedTejido tejido, String nom, int i, Iterable<Emprendimiento> empL,
			Iterable<OrgSocial> osL) {
		// TODO Auto-generated method stub
		for(Emprendimiento emprend: empL) {
			if(emprend.getNombreEmp().equals(nom)||emprend.getOrgSocial().equals(nom)) {
				tejido.clientes[i]=new RedNodoHijo();
				tejido.clientes[i].nombre=nom;
				tejido.clientes[i].teleefono=emprend.getTelefonoIE() ;
				tejido.clientes[i].producto=emprend.getProdServ();				
				i++;
				System.out.println("Aliado "+nom);
				break;
			}
		}
		for(OrgSocial orgsp: osL) {
			if(orgsp.getNombreEmp().equals(nom)) {
				tejido.clientes[i]=new RedNodoHijo();
				tejido.clientes[i].nombre=nom;
				tejido.clientes[i].teleefono=orgsp.getTelefonoIOS() ;
				tejido.clientes[i].producto=orgsp.getProdServ();				
				i++;
				System.out.println("Aliado "+nom);
				break;
			}
		}
	}

	private void getDatosP(ModRedTejido tejido, String nom, int j, Iterable<Emprendimiento> empL,Iterable<OrgSocial> osL) {
		// TODO Auto-generated method stub
		for(Emprendimiento emprend: empL) {
			if(emprend.getNombreEmp().equals(nom)|| emprend.getOrgSocial().equals(nom)) {
				tejido.proveedores[j]=new RedNodoHijo();
				tejido.proveedores[j].nombre=nom;
				tejido.proveedores[j].teleefono=emprend.getTelefonoIE() ;
				tejido.proveedores[j].producto=emprend.getProdServ();				
				j++;
				System.out.println("Aliado "+nom);
				break;
			}
		}
		for(OrgSocial orgsp: osL) {
			if(orgsp.getNombreEmp().equals(nom)) {
				tejido.proveedores[j]=new RedNodoHijo();
				tejido.proveedores[j].nombre=nom;
				tejido.proveedores[j].teleefono=orgsp.getTelefonoIOS() ;
				tejido.proveedores[j].producto=orgsp.getProdServ();				
				j++;
				System.out.println("Aliado "+nom);
				break;
			}
		}
	}
	
	private void getDatosA(ModRedTejido tejido, String nom, int k, Iterable<Emprendimiento> empL,Iterable<OrgSocial> osL) {
		// TODO Auto-generated method stub
		for(Emprendimiento emprend: empL) {
			if(emprend.getNombreEmp().equals(nom) || emprend.getOrgSocial().equals(nom)) {
				tejido.aliados[k]=new RedNodoHijo();
				tejido.aliados[k].nombre=nom;
				tejido.aliados[k].teleefono=emprend.getTelefonoIE() ;
				tejido.aliados[k].producto=emprend.getProdServ();				
				k++;
				System.out.println("Aliado "+nom);
				break;
			}
		}
		for(OrgSocial orgsp: osL) {
			if(orgsp.getNombreEmp().equals(nom)) {
				tejido.aliados[k]=new RedNodoHijo();
				tejido.aliados[k].nombre=nom;
				tejido.aliados[k].teleefono=orgsp.getTelefonoIOS() ;
				tejido.aliados[k].producto=orgsp.getProdServ();				
				k++;
				System.out.println("Aliado "+nom);
				break;
			}
		}
	}
	
	private String getNombre(Long emprenDest, Iterable<Ciiu_Emp> cruzar) {
		String ret="";
		for (Ciiu_Emp lista: cruzar){
			if(emprenDest.equals(lista.getIdCiiu())) {
				System.out.println("Nombre "+lista.getIdName());
				ret=lista.getIdName();
				return ret;
			}
		}
		return ret;
	}

	public void complemento(Iterable<Ciiu_Emp> aliados,ModRedTejido red, Long ciiuB,String nombre,Iterable<Emprendimiento> empL,Iterable<OrgSocial> osL) {
	//	for(int j=0;j<tamAliados;j++) 
		int k=0;
		for (Ciiu_Emp lista: aliados){
			if(ciiuB.equals(lista.getIdCiiu()) && !nombre.equals(lista.getIdName()) && k<5) {
				getDatosA(red, nombre, k, empL,osL);
				/*System.out.println("Aliado "+lista.getIdName());
				red.aliados[k]=new RedNodoHijo();
				red.aliados[k].nombre="aliados "+lista.getIdName();
				red.aliados[k].teleefono="tel: aliados "+k;
				red.aliados[k].producto="producto aliados "+k;
				k++;*/
			}
		}
	}
	
}
