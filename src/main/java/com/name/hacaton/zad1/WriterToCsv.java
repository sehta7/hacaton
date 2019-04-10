package com.name.hacaton.zad1;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

class WriterToCsv {

    private static final String COMMA_DELIMITER = ", ";
    private static final String NEW_LINE_SEPARATOR = "\n";

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
            System.out.println("Something bad happend with file");
            e.printStackTrace();
        }
    }
}
