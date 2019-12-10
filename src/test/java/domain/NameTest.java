package domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NameTest {

    @Test
    void getName() {
        Name name = new Name("이름");
        assertEquals("이름", name.getName());
    }
}