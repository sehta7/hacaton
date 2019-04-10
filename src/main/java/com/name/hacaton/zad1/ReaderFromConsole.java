package com.name.hacaton.zad1;

import java.util.InputMismatchException;
import java.util.Scanner;

class ReaderFromConsole {

    private Scanner scanner;

    public ReaderFromConsole(Scanner scanner) {
        this.scanner = scanner;
    }

    int readNumberOfPeople() {
        Scanner scanner = new Scanner(System.in);
        int numberOfPeople = 0;
        try {
            numberOfPeople = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Give number!");
            readNumberOfPeople();
        }
        return numberOfPeople;
    }

    String readFileName() {
        return scanner.nextLine();
    }

}
