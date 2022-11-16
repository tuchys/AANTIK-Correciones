package com.aantik.demo.HelperClassServices;

import java.util.Optional;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.aantik.demo.HelperClassServices.Comments;

@Repository
public interface CommentsRepository extends JpaRepository<Comments, Integer>{
    
    Set<Comments> findByIdPost(String idPost);
    void deleteAllByIdPost(String idPost);
}
