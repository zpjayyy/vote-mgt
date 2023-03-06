package com.jay.vote.model;

import lombok.Data;

import java.util.List;

@Data
public class Vote {

    private User user;

    private Subject subject;

    private List<SubjectItem> itemList;
}
