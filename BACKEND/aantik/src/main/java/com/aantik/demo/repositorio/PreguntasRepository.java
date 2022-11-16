package com.aantik.demo.repositorio;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.aantik.demo.entidad.PreguntasModeloB;


public interface  PreguntasRepository extends JpaRepository<PreguntasModeloB, Long> {
   Optional<PreguntasModeloB>findByindicaid(String indicaid);
   
}
