package org.example;

public class Account {

    private final String name;

    public Account(String name) {
        this.name = name;
    }

    public boolean checkNameToEmboss() {
        return name.matches("^(?=\\S*\\s\\S*$)\\S.{1,17}\\S$");
    }
}
