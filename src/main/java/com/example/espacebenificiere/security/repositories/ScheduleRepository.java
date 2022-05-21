package com.example.espacebenificiere.security.repositories;

import com.example.espacebenificiere.security.entities.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.TypedQuery;

public interface ScheduleRepository extends JpaRepository<Schedule , Long> {


}
