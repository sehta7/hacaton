package com.name.hacaton.zad1;

import io.codearte.jfairy.Fairy;

import java.util.Locale;

class PersonGenreator {

    Fairy fairy = Fairy.create(Locale.forLanguageTag("pl"));

    Person createPerson(){
        Person person = new Person();
        person.setName(fairy.person().getFirstName());
        person.setLastName(fairy.person().getLastName());
        person.setEmail(fairy.person().getEmail());
        person.setPesel(fairy.person().getNationalIdentificationNumber());
        return person;
    }
}
