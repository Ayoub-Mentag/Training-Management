package com.example.espacebenificiere.security.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Choice {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long choiceId;
    @ManyToOne
    @JoinColumn(name="user_id", nullable=false)
    private Beneficiary beneficiary;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "group_id", referencedColumnName = "groupId")
    private Group group;
    //1st choice or second choice..
    private int priority;

}