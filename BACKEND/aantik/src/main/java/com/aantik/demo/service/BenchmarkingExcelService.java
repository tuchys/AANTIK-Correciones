package com.aantik.demo.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.aantik.demo.entidad.BenchmarkingIndica;
import com.aantik.demo.entidad.PreguntasModeloB;
import com.aantik.demo.model.ModBench;
import com.aantik.demo.model.ModelBenchAux;
import com.aantik.demo.repositorio.BenchPregunRepository;
import com.aantik.demo.service.BenchmarkingExcelReader;
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


}
