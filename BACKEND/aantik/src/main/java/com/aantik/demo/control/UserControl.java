package com.aantik.demo.control;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import com.aantik.demo.entidad.User;
import com.aantik.demo.model.Mpreinscrito;
import com.aantik.demo.service.UserCRUD;

@Controller
public class UserControl {

	@Autowired
	UserCRUD userService;

	@GetMapping("/test")
    public ArrayList<User> obtenerUsuarios(){
		
        return (ArrayList<User>) userService.getAll();
    }

	
/*	@GetMapping("/test")
	public String ingresoAdm(Model model) {
		
		try {
			User usertest = userService.getUserById((long) 1);
			System.out.println("user name: "+usertest.getUsername());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "test";
	}*/
	
	@GetMapping({"/","/index","/index/{id}"})
	public String index(@PathVariable(required = false)Long id) {
		return "index";
	}

	@PostMapping("/login")
	public ResponseEntity<String> save(@RequestBody User persona) {
		System.out.println("RECIBE: "+persona.getUsername());
		User personaAux = new User();
		try {
			String rolS="0";
			if(userService.login(persona.getUsername(),persona.getPassword())==true) {
				personaAux = userService.getUserByUsername(persona.getUsername());


			//	Set<Role> rol=personaAux.getRoles();
			//	for (Role value : rol)
		    //        rolS= Long.toString(value.getId());				


				long rol=personaAux.getRoles();
		        //rolS= rol.getName();		
		        rolS= "ddd";												
				return new ResponseEntity<String>(rolS, HttpStatus.OK);			

								
			}							
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("Usuario no existe");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		//return personaAux;
	}
	
	@PostMapping("/preinscritosFile")
	public void preinscritosFile(@RequestParam("file") MultipartFile fileM) {
		System.out.println(fileM.getSize());
		System.out.println(fileM.toString());
	}

	@GetMapping("/all")
	public ResponseEntity<Map<Mpreinscrito[],String>> sendStudents() { 
	//public ResponseEntity<Mpreinscrito[],String>  sendStudents() {
		Mpreinscrito est[] = new Mpreinscrito[2];
		 Map<Mpreinscrito[],String> response = new HashMap<Mpreinscrito[], String>();
		try {
			est[0]=new Mpreinscrito();
			est[1]=new Mpreinscrito();
			est[0].nombre="Pepito Perez";
			est[0].correo="pepitoPe@gmail.com";
			est[0].telefono="3123125";
			System.out.println("Enviar estudiante: "+est[0].nombre);
			est[1].nombre="Julia Perez";
			est[1].correo="Julia@gmail.com";
			est[1].telefono="11122233";
			System.out.println("Enviar estudiante: "+est[1].nombre);
			response.put(est, "success saving data");
			return ResponseEntity.accepted().body(response);
				//return new ResponseEntity<MultiValueMap<Mpreinscrito[],String>>  (est, HttpStatus.OK);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("Usuario no existe"+e);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	
}
