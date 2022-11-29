package com.aantik.demo.HelperClassServices;

import java.util.Set;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentsRepository extends JpaRepository<Comments, Integer>{
    
    Set<Comments> findByIdPost(String idPost);
    void deleteAllByIdPost(String idPost);
}
