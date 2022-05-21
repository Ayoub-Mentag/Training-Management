package com.example.espacebenificiere.security.repositories;

import com.example.espacebenificiere.security.entities.Beneficiary;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BeneficiaryRepository extends JpaRepository<Beneficiary , Long> {
}
