package ru.otus.spring.logging;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    @Before("execution(* ru.otus.spring.dao.QuestionDaoCsvImpl.*(..))")
    public void logBeforeDao(JoinPoint joinPoint) {
        System.out.println("Вызов метода : " + joinPoint.getSignature().getName() + "\n");
    }

    @Before("execution(* ru.otus.spring.service.QuestionServiceImpl.*(..))")
    public void logBeforeService(JoinPoint joinPoint) {
        System.out.println("Вызов метода : " + joinPoint.getSignature().getName() + "\n\n");
    }

    @After("execution(* ru.otus.spring.service.QuestionServiceImpl.askQuestions())")
    public void logAroundService(JoinPoint joinPoint) {
        System.out.println("\n\nВызов метода : " + joinPoint.getSignature().getName() + " завершен");
    }
}
