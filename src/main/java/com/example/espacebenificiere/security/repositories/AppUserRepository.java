package com.example.espacebenificiere.security.repositories;


import com.example.espacebenificiere.security.entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepository extends JpaRepository<AppUser , String> {
    public AppUser findAppUserByEmail(String email);
}
