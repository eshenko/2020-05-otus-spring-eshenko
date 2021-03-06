package ru.otus.spring.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class Question {
    private final String numberOfQuestion;
    private final String question;
    private final String rightAnswer;
    private final ArrayList<String> answers = new ArrayList<>();

    public Question(String[] data) {
        this.numberOfQuestion = data[0];
        this.question = data[1];
        this.rightAnswer = data[2];
        this.answers.addAll(Arrays.asList(data).subList(3, data.length));
    }

    public String getNumberOfQuestion() {
        return numberOfQuestion;
    }

    public String getQuestion() {
        return question;
    }

    public String getRightAnswer() {
        return rightAnswer;
    }

    public ArrayList<String> getAnswers() {
        return answers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Question question1 = (Question) o;
        return Objects.equals(numberOfQuestion, question1.numberOfQuestion) &&
                Objects.equals(question, question1.question) &&
                Objects.equals(answers, question1.answers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numberOfQuestion, question, answers);
    }
}
