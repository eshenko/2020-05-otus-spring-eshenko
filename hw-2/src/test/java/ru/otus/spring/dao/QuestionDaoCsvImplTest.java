package ru.otus.spring.dao;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.core.io.Resource;
import ru.otus.spring.domain.Question;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Класс QuestionDao")
class QuestionDaoCsvImplTest {

    @DisplayName("конструктор создает корректный объект")
    @Test
    void constructorShouldCreateCorrectObject() throws IOException {
        Resource fileMock = Mockito.mock(Resource.class);

        String[] row = {"1","Question","1","A","B","C","D"};
        Question question = new Question(row);

        String rawData = "\"№\",\"Question\",\"Right Answer\",\"Answer1\",\"Answer2\",\"Answer3\",\"Answer4\"\n" +
                "\"1\",\"Question\",\"1\",\"A\",\"B\",\"C\",\"D\"";

        try (InputStream is = new ByteArrayInputStream(rawData.getBytes())) {
            Mockito.when(fileMock.getInputStream()).thenReturn(is);
            QuestionDaoCsv questions = new QuestionDaoCsvImpl(fileMock);

            assertEquals(question.getRightAnswer(), questions.getQuestionsDaoCsv().get(0).getRightAnswer());
        }
    }
}