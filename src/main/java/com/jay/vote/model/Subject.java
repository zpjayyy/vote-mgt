package com.jay.vote.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class Subject {

    private String name;

    private String description;

    private Date expireDate;
}
