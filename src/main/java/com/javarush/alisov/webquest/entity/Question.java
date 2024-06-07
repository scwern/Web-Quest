package com.javarush.alisov.webquest.entity;

import lombok.Data;

@Data
public class Question {
    private Integer id;
    private String text;
    private Type type;

    public Question(Integer id, String text, Type type) {
        this.id = id;
        this.text = text;
        this.type = type;
    }
    public enum Type {
        NEXT,
        WIN,
        LOSE
    }
}


