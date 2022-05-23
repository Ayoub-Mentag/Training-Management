package com.example.espacebenificiere.security.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Former extends AppUser{
    @OneToOne(mappedBy = "former")
    private AppGroup group;
}
