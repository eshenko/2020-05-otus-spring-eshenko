package ru.otus.spring.service;

import java.util.Scanner;

public class Asker {
    private final Scanner scanner = new Scanner(System.in);

    public String ask() {
        return scanner.nextLine();
    }
    public void close() {
        scanner.close();
    }
}
