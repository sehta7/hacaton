package com.name.hacaton.zad1;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Main {

    public static void main(String[] args) {
        ReaderFromConsole reader = new ReaderFromConsole(new Scanner(System.in));
        System.out.println("Give number of people");
        int numberOfPeople = reader.readNumberOfPeople();
        System.out.println("Give file name");
        String fileName = reader.readFileName();
        PersonGenreator personGenreator = new PersonGenreator();
        List<Person> people = new ArrayList<>();
        for (int i =  0; i < numberOfPeople; i++){
            people.add(personGenreator.createPerson());
        }
        WriterToCsv writer = new WriterToCsv();
        writer.writePeopleToFile(fileName, people);

        String file = "/home/ola/Documents/personGenerator/" + fileName;
        CsvToJsonConverter converter = new CsvToJsonConverter();
        try {
            converter.convert(new File(file));
        } catch (IOException e) {
            e.printStackTrace();
        }

        CsvToXmlConverter csvToXmlConverter = new CsvToXmlConverter();
        csvToXmlConverter.convert(file);
    }
}
