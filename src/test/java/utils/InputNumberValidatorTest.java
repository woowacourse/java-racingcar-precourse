package utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InputNumberValidatorTest extends RuntimeException {

    @Test
    void isSatisfyNumberOfRaces() {
        String properInput = "23";
        String includeCharInput = "34-5";
        String negativeNumber = "-76";

        assertDoesNotThrow(() -> InputNumberValidator.isSatisfyNumberOfRaces(properInput));
        assertThrows(IllegalArgumentException.class, () -> InputNumberValidator.isSatisfyNumberOfRaces(includeCharInput));
        assertThrows(IllegalArgumentException.class, () -> InputNumberValidator.isSatisfyNumberOfRaces(negativeNumber));
    }
}