package com.aantik.demo.control;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import com.aantik.demo.HelperClassServices.ResponseMessage;
import com.aantik.demo.model.ModBench;
import com.aantik.demo.model.ModelBenchAux;
import com.aantik.demo.service.BenchmarkingExcelService;
import com.aantik.demo.service.DiagnosticoCRUD;
import com.aantik.demo.service.PreguntaCRUD;
import com.aantik.demo.service.PreguntaExcelService;
import com.aantik.demo.service.PreguntasExcelReader;
import com.aantik.demo.repositorio.PreguntasRepository;

@CrossOrigin("http://localhost:8081")
@Controller
@RequestMapping("/api/benchmarking")
public class BenchmarkingController {
    
    @Autowired
    PreguntaExcelService fileService;

    @Autowired
    BenchmarkingExcelService BenfileService;

    @Autowired
    PreguntasRepository tt;

   
    @Autowired
    DiagnosticoCRUD dgvServ;
    
    @Autowired
    PreguntaCRUD pregServ;

    @PostMapping("/upload")
  public ResponseEntity<ResponseMessage> uploadFileDef(@RequestParam("file") MultipartFile file) {
    String message = "";

    if (PreguntasExcelReader.hasExcelFormat(file)) {
      try {
        fileService.save(file);
        BenfileService.save(file);
        message = "Uploaded the file successfully: " + file.getOriginalFilename();
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
      } catch (Exception e) {
        message = "Could not upload the file: " + file.getOriginalFilename() + "!";
        return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
      }
    }

    message = "Please upload an excel file!";
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessage(message));
  }

  @PostMapping("/uploadInd")
  public ResponseEntity<ResponseMessage> uploadFileInd(@RequestParam("file") MultipartFile file) {
    String message = "";

    if (PreguntasExcelReader.hasExcelFormat(file)) {
      try {
        BenfileService.save(file);

        message = "Uploaded the file successfully: " + file.getOriginalFilename();
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
      } catch (Exception e) {
        message = "Could not upload the file: " + file.getOriginalFilename() + "!";
        return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
      }
    }

    message = "Please upload an excel file!";
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessage(message));
  }

  @GetMapping("/indicadores")
  public ResponseEntity<?> getPosts(){ //assigment id

	  

  return ResponseEntity.ok(tt.findAll());
  }

	@GetMapping("/benchGet")
	public ResponseEntity<ModBench[]> generarBench(@RequestBody String correo) { 
	//public ResponseEntity<Mpreinscrito[],String>  sendStudents() {
		ModBench est[] = new ModBench[10];
		try {
			int tamanio=BenfileService.cantidad();
			ModelBenchAux[] auxB = new ModelBenchAux[tamanio];
			auxB=BenfileService.getInfo(auxB);
			pregServ.getCodigoPreg(auxB,auxB.length);
			String aux=auxB[0].indicador;	
			int i=0,total=0,CP=0;
			est[0]=new ModBench();
			for(ModelBenchAux var: auxB) {
				System.out.println("preguntas que aplican"+var.codigo+var.indicador);
				if(aux.equals(var.indicador)) {
					total=total+dgvServ.getPuntaje(var.codigo);		
					est[i].nombre=var.indicador;
					est[i].puntaje=total;
					System.out.println(var.indicador+"--------"+total);		
					CP++;
					System.out.println("----CANTIDAD X INDICADOR----"+CP);	
				}else {
					if(CP>1 && i>1) {
						float promedio = est[i-1].puntaje/CP;
						System.out.println("----anterior----"+est[i-1].puntaje+"-.----actual"+est[i].puntaje+"prom...."+promedio);		
					}else
						System.out.println("----promerio----"+total);		
					CP=1;
					i++;
					est[i]=new ModBench();
					aux=var.indicador;
					total=dgvServ.getPuntaje(var.codigo);
					System.out.println(var.indicador+"--------"+total);						
					est[i].nombre=var.indicador;
					est[i].puntaje=total;
				}
			}
			System.out.println("RESULTADO......");
			for(int j=0;j<i;j++) {
				System.out.println(est[j].nombre+"----"+est[j].puntaje);
			}
			
			return new ResponseEntity<ModBench[]>  (est, HttpStatus.OK);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("Usuario no existe"+e);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
  
}
