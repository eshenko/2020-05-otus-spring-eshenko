package ru.otus.spring;

import org.springframework.context.annotation.*;
import ru.otus.spring.service.QuestionService;

@EnableAspectJAutoProxy
@Configuration
@ComponentScan
@PropertySource("classpath:application.properties")
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Main.class);
        QuestionService service = context.getBean(QuestionService.class);
        service.askQuestions();
    }
}
