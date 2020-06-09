package ru.otus.spring.dao;

import au.com.bytecode.opencsv.CSVReader;
import org.springframework.core.io.Resource;
import ru.otus.spring.domain.Question;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class QuestionCsvImpl implements QuestionCsv{
    private final ArrayList<Question> questions = new ArrayList<>(5);

    public QuestionCsvImpl(Resource file) {
        try {
            CSVReader data = new CSVReader(new InputStreamReader(file.getInputStream()), ',' , '"', 1);
            List<String[]> allRows = data.readAll();
            for (String[] row : allRows) {
                this.questions.add(new Question(row));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Question> getQuestionsCsv(){
        return questions;
    }
}
