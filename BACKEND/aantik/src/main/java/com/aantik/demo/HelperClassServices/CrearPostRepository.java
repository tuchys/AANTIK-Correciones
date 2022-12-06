package com.aantik.demo.HelperClassServices;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;;


@Repository
public interface CrearPostRepository extends JpaRepository<CrearPosts, Integer>{

    
}
