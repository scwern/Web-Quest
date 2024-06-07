package com.javarush.alisov.webquest.entity;

import lombok.Data;

@Data
 public class Answer {
        private Integer id;
        private String answerText;
        private Question previous;
        private Question next;

        public Answer(Integer id, String answerText, Question previous, Question next) {
            this.id = id;
            this.answerText = answerText;
            this.previous = previous;
            this.next = next;
        }
    }
