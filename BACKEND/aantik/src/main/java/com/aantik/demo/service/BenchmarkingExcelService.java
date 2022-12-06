package com.aantik.demo.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.aantik.demo.entidad.BenchmarkingIndica;
import com.aantik.demo.entidad.PreguntasModeloB;
import com.aantik.demo.model.ModBench;
import com.aantik.demo.model.ModIndicadorBench;
import com.aantik.demo.model.ModelBenchAux;
import com.aantik.demo.repositorio.BenchPregunRepository;
import com.aantik.demo.repositorio.PreguntasRepository;

@Service
public class BenchmarkingExcelService {
    
    @Autowired
    BenchPregunRepository repository;

    @Autowired
    PreguntasRepository Rerepository;

    public void save(MultipartFile file) {
        try {
          List<BenchmarkingIndica> tutorials = BenchmarkingExcelReader.excelToTutorials(file.getInputStream());
          repository.saveAll(tutorials);

        } catch (IOException e) {
          throw new RuntimeException("fail to store excel data: " + e.getMessage());
        }
      }
    
      public List<BenchmarkingIndica> getAllTutorials() {
        return repository.findAll();
      }

	public ModelBenchAux[] getInfo(ModelBenchAux[] auxB) {
		// TODO Auto-generated method stub
		int cantidad=cantidad();
		auxB= new ModelBenchAux[cantidad];
		int i=0;
		List<BenchmarkingIndica> aux=repository.findAll();
		for(BenchmarkingIndica var: aux) {
			auxB[i]=new ModelBenchAux();
			auxB[i].numero=var.getIdPregunta();
			auxB[i].indicador=var.getCategoriaPregunta();
			i++;
		}
		return auxB;			
	}

	public int cantidad() {
		// TODO Auto-generated method stub
		int cant=0;
		List<BenchmarkingIndica> aux=repository.findAll();
		for(BenchmarkingIndica var: aux)
			cant++;			
		return cant;
	}

	@SuppressWarnings("deprecation")
	public void getDesc(ModBench[] est) {
		// TODO Auto-generated method stub
		
		for(ModBench aux: est) {
			Iterable<BenchmarkingIndica> indc=repository.getByCategoriaPregunta(aux.nombre);
			for(BenchmarkingIndica bm: indc) {
				if(bm !=null) {
					PreguntasModeloB desc= Rerepository.getById((long)bm.getIdDef());
					
					aux.descripcion=desc.getdescripcion();
				}
			}
			
			
		}
	}

	public ModIndicadorBench[] getAllIndicadores(ModIndicadorBench[] indicadores) {
		// TODO Auto-generated method stub
		
		int i=0;
		List<BenchmarkingIndica> aux=repository.findAll();
		for(BenchmarkingIndica var: aux) {
			indicadores[i]=new ModIndicadorBench();
			indicadores[i].id=var.getIdBenchIndica();
			indicadores[i].pregunta=var.getIdPregunta();
			indicadores[i].nombre=var.getCategoriaPregunta();
			i++;
		}
		return indicadores;
	}

	public void addIndicador(ModIndicadorBench indicador) {
		// TODO Auto-generated method stub
		Iterable<BenchmarkingIndica> aux=repository.getByCategoriaPregunta(indicador.nombre);
		BenchmarkingIndica addIn=new BenchmarkingIndica();
		for(BenchmarkingIndica bm: aux) {
			if(bm !=null) {
				BenchmarkingIndica desc= repository.getById((long)bm.getIdDef());
				System.out.println("Datos"+desc.getCategoriaPregunta());
				addIn.setCategoriaPregunta(desc.getCategoriaPregunta());
				addIn.setIdPregunta(indicador.pregunta);
				addIn.setIdDef(desc.getIdDef());
				break;
			}
		}
		repository.save(addIn);
	}

	public int cantidadInd() {
		// TODO Auto-generated method stub
		int cant=cantidad();
		int cant2=1;
		List<BenchmarkingIndica> aux=repository.findAll();
		for(int i=0;i<cant;i++) {
			BenchmarkingIndica dato1=aux.get(i);
			if(i>0) {
				BenchmarkingIndica dato2=aux.get(i-1);
				if(!dato1.getCategoriaPregunta().equals(dato2.getCategoriaPregunta()))
					cant2++;
			}
		}		
		return cant2;
	}

	public String[] getListaInd(String[] listaInd) {
		// TODO Auto-generated method stub
		int cant=cantidad();
		int cant2=1;
		List<BenchmarkingIndica> aux=repository.findAll();
		for(int i=0;i<cant;i++) {
			BenchmarkingIndica dato1=aux.get(i);
			if(i>0) {
				BenchmarkingIndica dato2=aux.get(i-1);
				if(!dato1.getCategoriaPregunta().equals(dato2.getCategoriaPregunta())) {
					//System.out.println("datos--------"+cant2+"<<<<<<<<"+dato1.getCategoriaPregunta());
					listaInd[cant2]=new String();
					listaInd[cant2]=dato1.getCategoriaPregunta();
					cant2++;
				}
			}else if(i==0) {
				listaInd[0]=new String();
				listaInd[0]=dato1.getCategoriaPregunta();
			}
		}		
		return listaInd;
	}

	public void deleteIndicador(long indicadorId) {
		// TODO Auto-generated method stub
		BenchmarkingIndica del=repository.findByIdBenchIndica(indicadorId);
		repository.delete(del);
	}


}
