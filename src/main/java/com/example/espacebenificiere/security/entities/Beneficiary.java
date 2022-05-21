package com.example.espacebenificiere.security.entities;

import com.example.espacebenificiere.security.repositories.ScheduleRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Beneficiary extends AppUser{
    private String fName ;
    private String lName;
    private String tel;
    private String som;
    private String acR;
    private String eta;
    private String cyE;
    private String dirP;
    private String fon;
}
