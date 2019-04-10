package com.name.hacaton.zad1;

import java.io.File;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

class ThreadsSave {

    private static final int HOW_MANY_THREADS = 100;
    private static final int HOW_MANY_PEOPLE = 10000;
    private final static BlockingQueue<Person> people = new ArrayBlockingQueue<>(HOW_MANY_THREADS);

    public static void main(String[] args) {

        PersonGenreator genreator = new PersonGenreator();
        WriterToCsv writer = new WriterToCsv(new File("/home/ola/Documents/personGenerator/name"));

      /*  for (int i = 0; i < HOW_MANY_THREADS; i++) {
            new Thread(() -> {
                try {
                    int counter = 0;

                    while (true) {
                        Person person = people.take();
                        writer.writePersonToFile(person);
                        counter++;
                        if (counter == HOW_MANY_THREADS) {
                            return;
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }, "sender" + i).start();
        }*/

        /*for (int i = 0; i < HOW_MANY_THREADS; i++) {
            new Thread(() -> {
                for (int j = 0; j < HOW_MANY_PEOPLE / HOW_MANY_THREADS; j++) {
                    Person person = genreator.createPerson();
                    writer.writePersonToFile(person);
                }
            }, "conqueror " + i).start();
        }*/

        for (int i = 0; i < HOW_MANY_THREADS; i++){
            new Thread(new MyTh()).start();
        }

    }

    static class MyTh implements Runnable{

        @Override
        public void run() {
            PersonGenreator genreator = new PersonGenreator();
            WriterToCsv writer = new WriterToCsv(new File("/home/ola/Documents/personGenerator/name"));

            for (int j = 0; j < HOW_MANY_PEOPLE / HOW_MANY_THREADS; j++) {
                Person person = genreator.createPerson();
                writer.writePersonToFile(person);
            }
        }
    }
}
