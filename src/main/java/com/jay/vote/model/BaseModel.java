package com.jay.vote.model;

import lombok.Data;

import java.util.Date;

@Data
public class BaseModel {

    private int id;

    private Date createDate;

    private Date editDate;

    private int creatUserId;

    private int editUserId;
}
