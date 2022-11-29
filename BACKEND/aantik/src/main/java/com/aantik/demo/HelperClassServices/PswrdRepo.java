package com.aantik.demo.HelperClassServices;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface  PswrdRepo extends JpaRepository<Password_reset, String> {
    Optional<Password_reset> findById(String id);
}
