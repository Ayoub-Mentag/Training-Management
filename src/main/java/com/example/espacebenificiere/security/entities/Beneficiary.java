package com.example.espacebenificiere.security.entities;


import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
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
    @OneToMany(mappedBy="beneficiary")
    private List<Choice> choices = new ArrayList<>();
}
