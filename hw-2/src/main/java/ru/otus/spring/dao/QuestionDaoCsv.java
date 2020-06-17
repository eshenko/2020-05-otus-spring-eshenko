package ru.otus.spring.dao;

import org.springframework.core.io.Resource;
import ru.otus.spring.domain.Question;
import java.util.ArrayList;

public interface QuestionDaoCsv {
    ArrayList<Question> getQuestionsDaoCsv();
}
