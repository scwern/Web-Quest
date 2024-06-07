package com.javarush.alisov.webquest.repository;

import com.javarush.alisov.webquest.entity.Answer;
import com.javarush.alisov.webquest.entity.Question;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class Repository {
    private static final List<Question> QUESTIONS = new ArrayList<>();
    private static final List<Answer> ANSWERS = new ArrayList<>();

    public Repository() {

        Question question1 = new Question(0, "Тебя опутали цифровые сети. Принять вызов искусственного интеллекта?", Question.Type.NEXT);
        Question question2 = new Question(1, "Ты принял вызов. Войдешь в виртуальный мир для встречи с искусственным интеллектом?", Question.Type.NEXT);
        Question question3 = new Question(2, "Ты отклонил вызов искусственного интеллекта. Запутался в цифровых ловушках и погиб.", Question.Type.LOSE);
        Question question4 = new Question(3, "Ты вошел в виртуальный мир. Доверишься ли ты искусственному интеллекту?", Question.Type.NEXT);
        Question question5 = new Question(4, "Ты отказался от встречи с искусственным интеллектом. Цифровые сети убили тебя.", Question.Type.LOSE);
        Question question6 = new Question(5, "Искусственный интеллект помог тебе выбраться. Победа.", Question.Type.WIN);
        Question question7 = new Question(6, "Искусственный интеллект не смог помочь тебе выбраться. Конец пути.", Question.Type.LOSE);

        Answer answer1 = new Answer(0, "Принять вызов искусственного интеллекта.", question1, question2);
        Answer answer2 = new Answer(1, "Отказаться от вызова искусственного интеллекта.", question1, question3);
        Answer answer3 = new Answer(2, "Войти в виртуальный мир.", question2, question4);
        Answer answer4 = new Answer(3, "Избежать встречи с искусственным интеллектом.", question2, question5);
        Answer answer5 = new Answer(4, "Довериться искусственному интеллекту.", question4, question6);
        Answer answer6 = new Answer(5, "Не доверять искусственному интеллекту.", question4, question7);


        QUESTIONS.add(question1);
        QUESTIONS.add(question2);
        QUESTIONS.add(question3);
        QUESTIONS.add(question4);
        QUESTIONS.add(question5);
        QUESTIONS.add(question6);
        QUESTIONS.add(question7);

        ANSWERS.add(answer1);
        ANSWERS.add(answer2);
        ANSWERS.add(answer3);
        ANSWERS.add(answer4);
        ANSWERS.add(answer5);
        ANSWERS.add(answer6);
    }

    public Question getQuestionById(Integer id) {
        if (id >= 0 && id < QUESTIONS.size()) {
            return QUESTIONS.get(id);
        }
        return null;
    }

    public Answer getAnswerById(Integer id) {
        if (id >= 0 && id < ANSWERS.size()) {
            return ANSWERS.get(id);
        }
        return null;
    }

    public Collection<Answer> getAnswersFromQuestionId(Integer id) {
        return ANSWERS.stream()
                .filter(a -> a.getPrevious().equals(getQuestionById(id)))
                .collect(Collectors.toList());
    }
}


