package com.community.domain;

import com.community.domain.enums.UserType;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table
public class User implements Serializable {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "password")
    private String password;

    @Column(name = "email")
    private String email;

    @Column(name = "userType")
    @Enumerated(EnumType.STRING)
    private UserType userType;

    @Column(name = "createdDate")
    private LocalDateTime createdDate;


    @Builder
    public User(String name, String password, String email, UserType userType, LocalDateTime createdDate, LocalDateTime updatedDate) {
        this.name = name;
        this.password = password;
        this.email = email;
        this.userType = userType;
        this.createdDate = createdDate;
    }
}
