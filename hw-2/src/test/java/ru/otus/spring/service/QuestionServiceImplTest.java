package ru.otus.spring.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.otus.spring.dao.QuestionDaoCsv;
import ru.otus.spring.domain.Question;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Класс QuestionService")
class QuestionServiceImplTest {

    private final QuestionDaoCsv questionDaoCsv = Mockito.mock(QuestionDaoCsv.class);
    private final Asker asker = Mockito.mock(Asker.class);

    @DisplayName("корректное получение имени пользователя")
    @Test
    void getUserName() {
        QuestionService questionService = new QuestionServiceImpl(questionDaoCsv);
        Mockito.when(asker.ask()).thenReturn("Alex");
        assertEquals("Alex", questionService.getUserName(asker));
    }

    @DisplayName("корректное получение пользовательского ответа")
    @Test
    void getUserAnswer() {
        QuestionService questionService = new QuestionServiceImpl(questionDaoCsv);
        Mockito.when(asker.ask()).thenReturn("1");
        assertEquals("1", questionService.getUserAnswer(asker, 4));
    }

    @DisplayName("корректное получение результата")
    @Test
    void getResult() {
        QuestionService questionService = new QuestionServiceImpl(questionDaoCsv);

        //подготовка списка вопросов/ответов для проверки (один вопрос с правильным ответом "1")
        String[] data = {"1","Question","1","A","B","C","D"};
        Question question = new Question (data);
        ArrayList<Question> questions = new ArrayList<>();
        questions.add(question);

        //подготовка списка пользовательских ответов (один ответ "1")
        ArrayList<String> userAnswers = new ArrayList<>();
        userAnswers.add("1");

        Mockito.when(questionDaoCsv.getQuestionsDaoCsv()).thenReturn(questions);

        assertEquals(1, questionService.getResult(userAnswers));
    }
}