package com.jay.vote.model.user;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import java.util.Date;

@Data
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String email;

    private String phoneNumber;

    private String passwordHash;

    @CreatedBy
    private Long createUserId;

    @CreatedDate
    private Date createDate;

    @LastModifiedBy
    private Long editUserId;

    @LastModifiedDate
    private Date editDate;
}
