package ru.otus.spring.service;

import ru.otus.spring.domain.Question;
import java.util.ArrayList;

public interface QuestionService {
    ArrayList<Question> getQuestions();
    void askQuestions();
    int getResult(ArrayList<String> userAnswers);
    String getUserAnswer(Asker asker, int size);
    String getUserName(Asker asker);
}
