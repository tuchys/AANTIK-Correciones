package com.aantik.demo.control;

import java.time.LocalDate;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import com.aantik.demo.HelperClassServices.*;
import com.aantik.demo.Payload.*;

import net.bytebuddy.utility.RandomString;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
//@RequestMapping("/comments")
public class CommentController {
    
    @Autowired
    CommentsRepository repo;

    @Autowired
    CrearPostRepository crearPostRepository;

    @PostMapping("/make")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody Comments comment) {

        System.out.println(comment.getCreatedby());
        System.out.println(comment.getCommentBody());
        System.out.println(comment.getIdPost());
        comment.setCreateDate(LocalDate.now());
        repo.save(comment);

        return ResponseEntity.ok(repo.findAll());
	}
    
    @PostMapping("/deletePost")
	public ResponseEntity<?> authewnticaateUser(@Valid @RequestBody CrearPosts crearPosts) {

        int l=Integer.parseInt(crearPosts.getPostedby());
        //l=l+1;
        crearPostRepository.deleteById(l);
        //repo.deleteAllByIdPost(crearPosts.getPostedby());
        return ResponseEntity.ok(crearPostRepository.findAll());
	}
    @PostMapping("/delete")
	public ResponseEntity<?> authewnticateUser(@Valid @RequestBody Comments comment) {

       int l=Integer.parseInt(comment.getIdPost());       
       repo.deleteById(l);

        return ResponseEntity.ok(repo.findAll());
	}
    @GetMapping("/foro")
    public ResponseEntity<?> getComments(){ //assigment id

        
    return ResponseEntity.ok(repo.findAll());
    }
    @GetMapping("/foroPreguntas")
    public ResponseEntity<?> getPosts(){ //assigment id

        

    return ResponseEntity.ok(crearPostRepository.findAll());
    }
    @PostMapping("/crear")
    public ResponseEntity<?> crearPosts(@Valid @RequestBody CrearPosts crearPosts) {

    System.out.println(crearPosts.getPostedby());
    System.out.println(crearPosts.getPostBody());
    String token = RandomString.make(5);   

     crearPosts.setCreateDate(LocalDate.now());
     crearPosts.setIdGeneration(token); 
     
     crearPostRepository.save(crearPosts);

     return ResponseEntity.ok(new MessageResponse("Post registrado exitosamente!"));
    }
}