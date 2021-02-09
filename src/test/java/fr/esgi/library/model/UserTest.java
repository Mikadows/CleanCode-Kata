package fr.esgi.library.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UserTest {
    private User sut;

    @BeforeEach
    public void setup() {
        this.sut = new User("guest");
    }

    @Test
    public void userNominalTest() {
        Assertions.assertEquals(this.sut, new User("guest"));
    }
}
