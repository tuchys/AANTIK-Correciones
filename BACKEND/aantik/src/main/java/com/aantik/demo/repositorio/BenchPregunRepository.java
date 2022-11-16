package com.aantik.demo.repositorio;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.aantik.demo.entidad.BenchmarkingIndica;

public interface BenchPregunRepository extends JpaRepository<BenchmarkingIndica, Long> {
    Optional<BenchmarkingIndica> findByCategoriaPregunta(String CategoriaPregunta);
	Iterable<BenchmarkingIndica> getByCategoriaPregunta(String nombre);
}
