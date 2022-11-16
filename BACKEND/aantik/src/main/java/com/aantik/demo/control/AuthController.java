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
import org.springframework.web.multipart.MultipartFile;
import java.util.List;
import java.util.stream.Collectors;

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

import com.aantik.demo.HelperClassServices.*;
import com.aantik.demo.Payload.*;
import com.aantik.demo.Security.Services.UserDetailsImpl;
import com.aantik.demo.Security.jwt.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/aut")

public class AuthController {
    
    @Autowired
	AuthenticationManager authenticationManager;

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
}
