package com.example.espacebenificiere.security.repositories;

import com.example.espacebenificiere.security.entities.AppChoice;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface AppChoiceRepository extends JpaRepository<AppChoice, Long> {
}
