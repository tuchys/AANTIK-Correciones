package com.aantik.demo.HelperClassServices;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import net.bytebuddy.utility.RandomString;
import com.aantik.demo.Services.EmailService;

@Service
public class AddUsers {

    @Autowired
	PasswordEncoder encoder;

    @Autowired
    EmailService notificarEmail;

    @Autowired
	UserRepository userRepository;

	@Autowired
	RoleRepository roleRepository;

public String addUserStudent(String correo){

    String token = RandomString.make(10);
    UserG user = new UserG(correo, 
	encoder.encode(token));
    System.out.println("Contrasena nueva es: " + token);
	Set<RoleG> roles = new HashSet<>();
	RoleG userRole = roleRepository.findByName(ERole.ROLE_STUDIANTE)
	.orElseThrow(() -> new RuntimeException("Error: Rol no encontrado."));
	roles.add(userRole);
	user.setRoles(roles);
	userRepository.save(user);		
    notificarEmail.sendMailForUsers(correo, token);
    return "agrego";
}
public String addUserProfesor(String correo){

    String token = RandomString.make(10);
    UserG user = new UserG(correo, 
	encoder.encode(token));
    System.out.println("Contrasena nueva es: " + token);
	Set<RoleG> roles = new HashSet<>();
	RoleG userRole = roleRepository.findByName(ERole.ROLE_DOCENTE)
	.orElseThrow(() -> new RuntimeException("Error: Rol no encontrado."));
	roles.add(userRole);
	user.setRoles(roles);
	userRepository.save(user);		
    notificarEmail.sendMailForUsers(correo, token);
    return "agrego";
}


}
