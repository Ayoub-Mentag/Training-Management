package com.example.espacebenificiere.security.entities;
//we put it here cuz it concern the security side

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppUser //why AppUser : to avoid the confusion with spr sec
{
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    @Column(unique = true)
    private String email;
    private String password;
    private boolean active;
    private String fName ;
    private String lName;
    private String tel;
    private String som;
    private String acR;
    private String eta;
    private String cyE;
    private String dirP;
    private String fon;
    @ManyToMany(fetch = FetchType.EAGER)
    private List<AppRole> appRoles = new ArrayList<>();




}
