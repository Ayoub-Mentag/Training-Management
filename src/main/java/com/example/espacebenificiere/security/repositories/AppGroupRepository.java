package com.example.espacebenificiere.security.repositories;
import com.example.espacebenificiere.security.entities.AppGroup;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface AppGroupRepository extends JpaRepository<AppGroup, Long> {
}