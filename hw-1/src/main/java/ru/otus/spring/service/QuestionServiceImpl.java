package ru.otus.spring.service;

import ru.otus.spring.dao.QuestionCsv;
import ru.otus.spring.domain.Question;
import java.util.ArrayList;

public class QuestionServiceImpl implements QuestionService{
    private final QuestionCsv dao;

    public QuestionServiceImpl(QuestionCsv dao) {
        this.dao = dao;
    }

    public ArrayList<Question> getQuestions() {
        return dao.getQuestionsCsv();
    }
}
