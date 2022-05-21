package com.example.espacebenificiere.security.repositories;

import com.example.espacebenificiere.security.entities.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Long> {
}
