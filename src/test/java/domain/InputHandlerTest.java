package domain;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.core.IsNot.*;
import static org.hamcrest.core.IsEqual.*;

public class InputHandlerTest {

    @Test
    public void testFailToGetValidCarNamesIfCarNamesNotSeparatedByComma() {
        InputHandler inputHandler = new InputHandler();
        String input = "abcd efgh";
        String[] carNames = {"abcd", "efgh"};

        String[] validationResult = inputHandler.getCarNamesIfValidInput(input);

        assertThat(carNames, not(equalTo(validationResult)));
    }
}
