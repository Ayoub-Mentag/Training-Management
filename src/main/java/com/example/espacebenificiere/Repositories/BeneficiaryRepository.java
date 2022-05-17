package com.example.espacebenificiere.Repositories;

import com.example.espacebenificiere.Entities.Beneficiary;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BeneficiaryRepository extends JpaRepository<Beneficiary , Long> {

       Beneficiary findByEmail(String email);


}
