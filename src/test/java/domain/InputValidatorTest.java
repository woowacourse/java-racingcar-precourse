package domain;

import domain.interfaces.InputValidator;
import org.junit.Assert;
import org.junit.Test;

public class InputValidatorTest {

    private InputValidator validator = new InputValidatorImpl();

    @Test
    public void testCarNamesValidation() {
        String[] testCarNames = new String[] {
                "pobi", "crong", "thesix", "", null
        };
        boolean[] expected = new boolean[] {true, true, false, false, false};

        for (int i = 0; i < testCarNames.length; i++) {
            Assert.assertEquals(expected[i], validator.isValidCarName(testCarNames[i]));
        }
    }

    @Test
    public void testProgressCountValidation() {
        int[] testProgressCounts = new int[] {1, 5, -1, 0, 100};
        boolean[] expected = new boolean[] {true, true, false, false, true};

        for (int i = 0; i < testProgressCounts.length; i++) {
            Assert.assertEquals(expected[i], validator.isValidProgressCount(testProgressCounts[i]));
        }
    }
}
