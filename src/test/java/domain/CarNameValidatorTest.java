package domain;

import org.junit.Test;

import static org.junit.Assert.*;

public class CarNameValidatorTest {

    @Test
    public void testFailToValidateCarNamesIfCarNameIsNull() throws AssertionError {
        String[] carNames = {null, null};

        CarNameValidator carNameValidator = new CarNameValidator(carNames);

        assertFalse(carNameValidator.doesValid());
    }

    @Test
    public void testFailToValidateCarNamesIfCarNameLongerThanUpperBound() throws AssertionError {
        int aboveUpperBound = CarNameValidator.CarNameBound.UPPER.getBound() + 1;
        String input = "";
        for (int i = 0; i < aboveUpperBound; i++) {
            input += "a";
        }
        String[] carNames = { input };

        CarNameValidator carNameValidator = new CarNameValidator(carNames);

        assertFalse(carNameValidator.doesValid());
    }
}
