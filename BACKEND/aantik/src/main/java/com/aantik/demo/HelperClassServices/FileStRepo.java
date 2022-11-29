package com.aantik.demo.HelperClassServices;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.aantik.demo.HelperClassServices.FileSt;

public interface FileStRepo extends JpaRepository<FileSt, String> {
    
}
