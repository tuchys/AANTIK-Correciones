package com.aantik.demo.HelperClassServices;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aantik.demo.HelperClassServices.ERole;
import com.aantik.demo.HelperClassServices.RoleG;

@Repository
public interface RoleRepository extends JpaRepository<RoleG, Long> {
	Optional<RoleG> findByName(ERole name);
}
