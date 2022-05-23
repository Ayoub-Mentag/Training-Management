package com.example.espacebenificiere.security.repositories;

import com.example.espacebenificiere.security.entities.Group;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupRepository extends JpaRepository<Group, Long> {
}
