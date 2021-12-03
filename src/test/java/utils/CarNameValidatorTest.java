package utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarNameValidatorTest extends RuntimeException {

    @Test
    public void validateLengthInRangeTest() {
        String properData = "pobi";
        String improperData = "nayoung";

        assertDoesNotThrow(() -> CarNameValidator.validateLengthInRange(properData));
        assertThrows(IllegalArgumentException.class, () -> CarNameValidator.validateLengthInRange(improperData));
    }
}