package ru.otus.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.otus.spring.domain.Question;
import ru.otus.spring.service.QuestionService;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
        QuestionService service = context.getBean(QuestionService.class);
        ArrayList<Question> questions = service.getQuestions();
        for (Question row : questions) {
            System.out.println("Question №" + row.getNumberOfQuestion() + "\n"
                    + row.getQuestion() + "\nAnswers:");
            for (int i = 0; i < row.getAnswers().size(); i++) {
                System.out.println(i+1 + ". " + row.getAnswers().get(i));
            }
        }
    }
}
