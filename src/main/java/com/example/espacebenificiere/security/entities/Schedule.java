package com.example.espacebenificiere.security.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Schedule {
    @Id
    private Long user_id;
    private String c1;
    private String c2;
    private String c3;
    private String c4;
}