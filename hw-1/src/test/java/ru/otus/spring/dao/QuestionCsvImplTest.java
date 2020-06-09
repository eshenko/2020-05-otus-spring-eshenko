package ru.otus.spring.dao;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import ru.otus.spring.domain.Question;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Класс QuestionDao")
class QuestionCsvImplTest {

    @DisplayName("конструктор создает корректный объект")
    @Test
    void constructorShouldCreateCorrectObject() {
        // создаем тестовый ArrayList с такими же данными как в подготовленном файле test.csv
        String[] raw = {"1","Question","A","B","C","D"};
        ArrayList<Question> testQuestions = new ArrayList<>();
        testQuestions.add(new Question(raw));

        // создаем объект QuestionDaoImpl используя подготовленный файл test.csv
        Resource file = new ClassPathResource("test.csv");
        QuestionCsv questions = new QuestionCsvImpl(file);

        // зная, что в списке только один элемент (Question), проверяем,
        // что данный элемент (с индексом 0), в подготовленном списке и в списке, полученном из файла при создании объекта, эквивалентны
        assertEquals(testQuestions.get(0), questions.getQuestionsCsv().get(0));
    }
}