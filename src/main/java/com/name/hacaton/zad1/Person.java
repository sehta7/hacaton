package com.name.hacaton.zad1;

class Person {

    private String name;
    private String lastName;
    private String email;
    private String pesel;

    void setName(String name) {
        this.name = name;
    }

    void setLastName(String lastName) {
        this.lastName = lastName;
    }

    void setEmail(String email) {
        this.email = email;
    }

    void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPesel() {
        return pesel;
    }
}
