package racing;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;

import org.junit.Test;

public class InputValidationTest {

    @Test
    public void inspectCarNameTest() {
        String[] successfulCase = {"12345,   1234",
                "   1234, 123, 1234",
                "1234,12,1234",
                "1234"};
        String[] failCase = {"123456, 1234",
                "    , 1234",
                "   ",
                ""};

        for (String testCase : successfulCase) {
            assertThat(InputValidation.inspectCarNames(testCase), is(true));
        }
        for (String testCase : failCase) {
            assertThat(InputValidation.inspectCarNames(testCase), is(false));
        }
    }
}
