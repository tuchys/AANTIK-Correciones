package com.aantik.demo.HelperClassServices;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<RoleG, Long> {
	Optional<RoleG> findByName(ERole name);
}
