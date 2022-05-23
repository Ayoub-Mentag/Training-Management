package com.example.espacebenificiere.security.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class Former extends AppUser{
    @OneToOne(mappedBy = "former")
    private Group group;
}
