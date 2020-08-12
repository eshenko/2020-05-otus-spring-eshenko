package ru.otus.spring.dao;

import au.com.bytecode.opencsv.CSVReader;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Repository;
import ru.otus.spring.domain.Question;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@Repository("daoCsv")
public class QuestionDaoCsvImpl implements QuestionDaoCsv {
    private final Resource file;
    private final ArrayList<Question> questions = new ArrayList<>();

    public QuestionDaoCsvImpl(@Value("${csv.name}") Resource file) {
        this.file = file;
    }

    public ArrayList<Question> getQuestionsDaoCsv(){
        if (questions.isEmpty()) {
            try {
                List<String[]> allRows = new CSVReader(new InputStreamReader(file.getInputStream()), ',', '"', 1).readAll();
                for (String[] row : allRows) {
                    this.questions.add(new Question(row));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return questions;
    }
}
