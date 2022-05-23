package com.example.espacebenificiere.security.repositories;

import com.example.espacebenificiere.security.entities.Choice;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
public interface ChoiceRepository extends JpaRepository<Choice, Long> {
    List<Choice> findByBeneficiary(Long id);
}
