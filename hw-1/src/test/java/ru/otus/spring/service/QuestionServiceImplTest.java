package ru.otus.spring.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.otus.spring.dao.QuestionCsv;
import ru.otus.spring.domain.Question;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Класс QuestionService")
class QuestionServiceImplTest {
    private final QuestionCsv questionDao = Mockito.mock(QuestionCsv.class);

    @Test
    void getByName() {
        //создание объекта questionService с переданной заглушкой questionDao
        QuestionService questionService = new QuestionServiceImpl(questionDao);

        //создание списка вопросов для возвращения метода questionDao.getQuestionsDao()
        String[] data = {"1","Question","A","B","C","D"};
        Question question = new Question (data);
        ArrayList<Question> questions = new ArrayList<>();
        questions.add(question);

        //получение подготовленного списка вопросов методом questionDao.getQuestionsDao()
        Mockito.when(questionDao.getQuestionsCsv()).thenReturn(questions);

        //сравнение возвращаемого списка вопросов questionService.getQuestions() с подготовленным списком вопросов
        assertEquals(questions, questionService.getQuestions());
    }
}