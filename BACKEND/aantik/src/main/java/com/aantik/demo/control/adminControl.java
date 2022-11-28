package com.aantik.demo.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.aantik.demo.model.ModOrgSocial;
import com.aantik.demo.service.OrgSocialCRUD;

@Controller
public class adminControl {
	
	@Autowired
	OrgSocialCRUD orgScService;
	
	@PostMapping("/getOS-adm")
	public ResponseEntity<ModOrgSocial> sendOrgSocial(@RequestParam String idOrg) { 
		long idOS=2;
		System.out.println("RECIBIENDO..."+idOrg);
		ModOrgSocial orgSoc=new ModOrgSocial();
		orgSoc=orgScService.getById(idOS);
		if(orgSoc != null) {
		System.out.println("enviando organizacion social a front");
			return new ResponseEntity<ModOrgSocial>  (orgSoc, HttpStatus.OK);
		}else
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	}
	
	
	 @PostMapping("/updateOrgSoc")
	public ResponseEntity<?> actualizarOrgSoc(@RequestBody ModOrgSocial orgSocUpd) {
		 System.out.println("actuasliza"+orgSocUpd.nombreEmp);
		 orgScService.actualizar(orgSocUpd);
	    return ResponseEntity.ok("ok");	    
	 }
}
