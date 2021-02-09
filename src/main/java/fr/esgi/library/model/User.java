package fr.esgi.library.model;

import java.util.Objects;

public class User {
    private final String type;

    public User(String type) {
        this.type = type;
    }

    public String type() {
        return type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(type, user.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type);
    }
}
