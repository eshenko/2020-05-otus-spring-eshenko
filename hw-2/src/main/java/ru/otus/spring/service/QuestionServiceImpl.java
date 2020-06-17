package ru.otus.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.otus.spring.dao.QuestionDaoCsv;
import ru.otus.spring.domain.Question;
import java.util.ArrayList;

@Service("service")
public class QuestionServiceImpl implements QuestionService{
    private final QuestionDaoCsv dao;
    private ArrayList<Question> daoList = new ArrayList<>();

    @Autowired
    public QuestionServiceImpl(QuestionDaoCsv dao) {
        this.dao = dao;
    }

    public ArrayList<Question> getQuestions() {
        if (daoList.isEmpty()) {
            daoList = dao.getQuestionsDaoCsv();
        }
        return daoList;
    }

    public void askQuestions() {
        Asker asker = new Asker();
        String userName = getUserName(asker);
        ArrayList<String> userAnswers = new ArrayList<>();
        for (Question row : getQuestions()) {
            System.out.println("Question №" + row.getNumberOfQuestion() + "\n"
                    + row.getQuestion() + "\nAnswers:");
            for (int i = 0; i < row.getAnswers().size(); i++) {
                System.out.println(i+1 + ". " + row.getAnswers().get(i));;
            }
            userAnswers.add(getUserAnswer(asker, row.getAnswers().size()));
        }
        System.out.println("Dear " + userName + "! Your result: " + getResult(userAnswers) + " right answer(s) from " + userAnswers.size());
        asker.close();
    }

    public String getUserName(Asker asker) {
        System.out.println("Enter your name: ");
        return asker.ask().trim();
    }

    public String getUserAnswer(Asker asker, int size) {
        System.out.println("Write answer(number): ");
        String answer = asker.ask().trim();
        while (!answer.matches("[1-" + size + "]")) {
            System.out.println("Error, write correct answer: ");
            answer = asker.ask().trim();
        }
        System.out.println("Answer accepted\n");
        return answer;
    }

    public int getResult(ArrayList<String> userAnswers) {
        int count = 0;
        for(int i = 0; i < userAnswers.size(); i++) {
            if (getQuestions().get(i).getRightAnswer().equals(userAnswers.get(i))) {
                count++;
            }
        }
        return count;
    }
}
