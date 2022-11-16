package com.aantik.demo.HelperClassServices;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aantik.demo.HelperClassServices.UserG;

@Repository
public interface UserRepository extends JpaRepository<UserG, Long> {
	Optional<UserG> findByUsername(String username);

	Boolean existsByUsername(String username);

}
