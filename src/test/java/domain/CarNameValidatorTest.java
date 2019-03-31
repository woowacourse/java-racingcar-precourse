package domain;

import org.junit.Test;

import static org.junit.Assert.*;

public class CarNameValidatorTest {

    @Test
    public void testFailToValidateCarNamesIfCarNameIsNull() throws AssertionError {
        CarNameValidator carNameValidator = new CarNameValidator();

        assertFalse(carNameValidator.doesValidCarName(null));
    }

    @Test
    public void testFailToValidateCarNamesIfCarNameLongerThanUpperBound() throws AssertionError {
        CarNameValidator carNameValidator = new CarNameValidator();
        int aboveUpperBound = CarNameValidator.CarNameBound.UPPER.getBound() + 1;

        String input = "";
        for (int i = 0; i < aboveUpperBound; i++) {
            input += "a";
        }

        assertFalse(carNameValidator.doesValidCarName(input));
    }
}
