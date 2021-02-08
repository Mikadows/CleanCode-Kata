package fr.esgi.library.model;

public class User {
    private final String type;

    public User(String type) {
        this.type = type;
    }

    public String type() {
        return type;
    }
}
