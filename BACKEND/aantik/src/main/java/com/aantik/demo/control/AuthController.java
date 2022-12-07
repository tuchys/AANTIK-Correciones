package com.aantik.demo.control;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.multipart.MultipartFile;
import java.util.List;
import java.util.stream.Collectors;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.aantik.demo.HelperClassServices.*;
import com.aantik.demo.Payload.*;
import com.aantik.demo.Security.Services.UserDetailsImpl;
import com.aantik.demo.Security.jwt.*;
import com.aantik.demo.entidad.Estudiante;
import com.aantik.demo.repositorio.EstudianteRepositorio;
import com.aantik.demo.entidad.Profesor;
import com.aantik.demo.repositorio.ProfesorRepositorio;

import net.bytebuddy.utility.RandomString;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/aut")

public class AuthController {
    
    @Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	AddUsers agregStd;

	@Autowired
	ProfesorRepositorio ProfeRepo;

	EstudianteRepositorio repoEst;

	@Autowired
  	private FileStorageService storageService;

	@Autowired
	UserRepository userRepository;

	@Autowired
	RoleRepository roleRepository;


	@Autowired
	PasswordEncoder encoder;

	@Autowired
	JwtUtils jwtUtils;

    @PostMapping("/login2")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtUtils.generateJwtToken(authentication);
		
		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();		
		List<String> roles = userDetails.getAuthorities().stream()
				.map(item -> item.getAuthority())
				.collect(Collectors.toList());

		return ResponseEntity.ok(new JwtResponse(jwt, 
												 userDetails.getId(), 
												 userDetails.getUsername(),  
												 roles));
	}

    @PostMapping("/registro")
	public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
		if (userRepository.existsByUsername(signUpRequest.getUsername())) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Error: Ya se encuentra un Usuario con este correo!"));
		}

		// Create new user's account
		UserG user = new UserG(signUpRequest.getUsername(), 
							 encoder.encode(signUpRequest.getPassword()));

		Set<String> strRoles = signUpRequest.getRole();
		//
		Set<RoleG> roles = new HashSet<>();

		if (strRoles == null) {
			RoleG userRole = roleRepository.findByName(ERole.ROLE_PREINSCRITO)
					.orElseThrow(() -> new RuntimeException("Error: Rol no encontrado."));
			roles.add(userRole);
		} else {
			strRoles.forEach(role -> {
				switch (role) {
				case "Admin":
					RoleG adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
							.orElseThrow(() -> new RuntimeException("Error: Rol no encontrado."));
					roles.add(adminRole);

					break;
				case "Organizacion":
					RoleG orgRole = roleRepository.findByName(ERole.ROLE_ORGANIZACION)
							.orElseThrow(() -> new RuntimeException("Error: Rol no encontrado."));
					roles.add(orgRole);

					break;
                case "Emprendimiento":
                RoleG empRole = roleRepository.findByName(ERole.ROLE_EMP)
                        .orElseThrow(() -> new RuntimeException("Error: Rol no encontrado."));
                roles.add(empRole);

                    break;    

                case "Coordinador":
                RoleG coorRole = roleRepository.findByName(ERole.ROLE_COORDINADOR)
                        .orElseThrow(() -> new RuntimeException("Error: Rol no encontrado."));
                roles.add(coorRole);

                    break;

                case "Docente":
                RoleG decRole = roleRepository.findByName(ERole.ROLE_DOCENTE)
                        .orElseThrow(() -> new RuntimeException("Error: Rol no encontrado."));
                roles.add(decRole);
    
                        break;

                case "Estudiante":
                RoleG EstRole = roleRepository.findByName(ERole.ROLE_STUDIANTE)
                        .orElseThrow(() -> new RuntimeException("Error: Rol no encontrado."));
                roles.add(EstRole);
            
                        break;

				default:
					RoleG userRole = roleRepository.findByName(ERole.ROLE_PREINSCRITO)
							.orElseThrow(() -> new RuntimeException("Error: Rol no encontrado."));
					roles.add(userRole);
				}
			});
		}

		user.setRoles(roles);
		userRepository.save(user);

		return ResponseEntity.ok(new MessageResponse("Usuario registrado exitosamente!"));
	}

	@PostMapping("/agregEst")
	public ResponseEntity<?> AgregueStu(@Valid @RequestBody Estudiante estud ) {

		String s=String.valueOf(estud.getIdEstudiantil());
		long l=Long.parseLong(s);  
		estud.setIdEstudiantil(s);
		if(!repoEst.findByIdEstudiantil(s).isPresent()){
			repoEst.save(estud);
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////			
			agregStd.addUserStudent(estud.getCorreo());
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/* 	String token = RandomString.make(10);
	UserG user = new UserG(estud.getCorreo(), 
	encoder.encode(token));
	System.out.println("Contrasena nueva es: " + token);
	Set<RoleG> roles = new HashSet<>();
	RoleG userRole = roleRepository.findByName(ERole.ROLE_STUDIANTE)
	.orElseThrow(() -> new RuntimeException("Error: Rol no encontrado."));
	roles.add(userRole);
	user.setRoles(roles);
	userRepository.save(user);	*/	
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
			return ResponseEntity.ok(new MessageResponse("Estudiante registrado exitosamente!"));
		}else{
			return ResponseEntity.ok(new MessageResponse("Estudiante ya se encuentra registrado"));
		}
		
	}
	
	@PostMapping("/agregEstFile")
	public ResponseEntity<ResponseMessage> uploadFile(@RequestBody @RequestParam("file")  MultipartFile file) {

		String message = "";
		try {
		  storageService.store(file);
	
		  message = "Uploaded the file successfully: " + file.getOriginalFilename();
		  return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
		} catch (Exception e) {
		  message = "Could not upload the file: " + file.getOriginalFilename() + "!";
		  return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
		}
	  }

	  @PostMapping("/EditTeacher")
	public ResponseEntity<?> EditPro(@Valid @RequestBody Profesor estud ) {

		System.out.print(estud.getNombre());
		//System.out.print(estud.getDocumento());
		System.out.print(estud.getAsignatura());
		//System.out.print(estud.getFechaSP());
		System.out.print(estud.getTelefono());
		System.out.print(estud.getCorreo());
		//System.out.print(estud.getIdEstudiantil());

		//String s=String.valueOf(estud.getIdEstudiantil());
		//long l=Long.parseLong(s);  
		//estud.setIdEstudiantil(s);
		//if(!repoEst.findByIdEstudiantil(s).isPresent()){
			
			ProfeRepo.save(estud);
			return ResponseEntity.ok(new MessageResponse("Profesor actalizado exitosamente!"));
		//}else{
		//	return ResponseEntity.ok(new MessageResponse("Estudiante ya se encuentra registrado"));
		//}*/
	//	return ResponseEntity.ok(new MessageResponse("Estudiante registrado exitosamente!"));
	}

}
