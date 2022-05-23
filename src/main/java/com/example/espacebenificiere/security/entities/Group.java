package com.example.espacebenificiere.security.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.text.Normalizer;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Group {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long groupId;
    private String halfDay;
    //-1  -> the group is less than 6
    // 0  -> the group is btw 6 & 14
    // 1  -> the group is = 14
    // 2  -> the group is great than 14
    private int status;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "userId")
    private Former former;
    @OneToOne(mappedBy = "group")
    private Choice choice;

//    public Group(Long groupId, String halfDay, int status) {
//        this.groupId = groupId;
//        this.halfDay = halfDay;
//        this.status = status;
//    }
}
