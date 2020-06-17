package ru.otus.spring.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Класс Question")
class QuestionTest {

    @DisplayName("корректное получение номера вопроса")
    @Test
    void getNumberOfQuestion() {
        String[] raw = {"1","Question","1","A","B","C","D"};
        Question question = new Question(raw);

        assertEquals("1", question.getNumberOfQuestion());
    }

    @DisplayName("корректное получение вопроса")
    @Test
    void getQuestion() {
        String[] raw = {"1","Question","1","A","B","C","D"};
        Question question = new Question(raw);

        assertEquals("Question", question.getQuestion());
    }

    @DisplayName("корректное получение списка ответов")
    @Test
    void getAnswers() {
        String[] raw = {"1","Question","1","A","B","C","D"};
        Question question = new Question(raw);
        ArrayList<String> answers = new ArrayList<>();
        answers.add("A");
        answers.add("B");
        answers.add("C");
        answers.add("D");

        assertEquals(answers, question.getAnswers());
    }

    @DisplayName("корректное получение правильного ответа")
    @Test
    void getRightAnswer() {
        String[] raw = {"1","Question","1","A","B","C","D"};
        Question question = new Question(raw);

        assertEquals("1", question.getRightAnswer());
    }
}