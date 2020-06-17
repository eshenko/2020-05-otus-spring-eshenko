package ru.otus.spring.dao;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.core.io.ClassPathResource;
import ru.otus.spring.domain.Question;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Класс QuestionDao")
class QuestionDaoCsvImplTest {

    @DisplayName("корректное получение данных")
    @Test
    void getQuestionsDaoCsv() {
        String[] row = {"1","Question","1","A","B","C","D"};

        List<Question> testQuestions = new ArrayList<>();
        testQuestions.add(new Question(row));

        ClassPathResource resource = new ClassPathResource("test.csv");
        QuestionDaoCsv dao = new QuestionDaoCsvImpl(resource);

        assertEquals(testQuestions, dao.getQuestionsDaoCsv());
    }
}