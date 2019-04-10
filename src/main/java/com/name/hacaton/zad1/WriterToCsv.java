package com.name.hacaton.zad1;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

class WriterToCsv {

    private static final String COMMA_DELIMITER = ", ";
    private static final String NEW_LINE_SEPARATOR = "\n";
    private File fileToSave;

    public WriterToCsv() {
    }

    public WriterToCsv(File fileToSave) {
        this.fileToSave = fileToSave;
        makeHeader(fileToSave);
    }

    void writePeopleToFile(String fileName, List<Person> people) {

        try(FileWriter fileWriter = new FileWriter("/home/ola/Documents/personGenerator/" + fileName)) {
            fileWriter.append("name, last_name, mail, id");
            fileWriter.append(NEW_LINE_SEPARATOR);
            for (Person person : people) {
                fileWriter.append(person.getName());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(person.getLastName());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(person.getEmail());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(person.getPesel());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(NEW_LINE_SEPARATOR);
            }
        } catch (IOException e) {
            System.out.println("Something bad happen with file");
        }
    }

    void writePersonToFile(Person person) {
        try(FileWriter fileWriter = new FileWriter(fileToSave, true)) {
                fileWriter.append(person.getName());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(person.getLastName());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(person.getEmail());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(person.getPesel());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(NEW_LINE_SEPARATOR);
        } catch (IOException e) {
            System.out.println("Something bad happen with file");
        }
    }

    void writePartOfPeopleToFile(List<Person> people) {
        try(FileWriter fileWriter = new FileWriter(fileToSave, true)) {
            for (Person person : people) {
                fileWriter.append(person.getName());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(person.getLastName());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(person.getEmail());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(person.getPesel());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(NEW_LINE_SEPARATOR);
            }
        } catch (IOException e) {
            System.out.println("Something bad happen with file");
        }
    }

    private void makeHeader(File fileToSave) {
        try(FileWriter fileWriter = new FileWriter(fileToSave)) {
            fileWriter.append("name, last_name, mail, id");
            fileWriter.append(NEW_LINE_SEPARATOR);
        } catch (IOException e){
            System.out.println("Something bad happen with file");
        }
    }
}
