package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

public class InputValidatorTest {

    InputValidator inputValidator;

    @Before
    public void setUp() throws Exception {
        inputValidator = new InputValidator();
    }

    @Test
    public void validate_success_naturalNumber() {
        String invalidTurns = "1";
        inputValidator.validate(invalidTurns);

        assertThat(inputValidator.isValid()).isEqualTo(true);
    }

    @Test
    public void validate_fail_string() {
        String invalidTurns = "s";
        inputValidator.validate(invalidTurns);

        assertThat(inputValidator.isValid()).isEqualTo(false);
    }

    @Test
    public void validate_fail_zero() {
        String invalidTurns = "0";
        inputValidator.validate(invalidTurns);

        assertThat(inputValidator.isValid()).isEqualTo(false);
    }
    @Test
    public void validate_fail_negative() {
        String invalidTurns = "-1";
        inputValidator.validate(invalidTurns);

        assertThat(inputValidator.isValid()).isEqualTo(false);
    }
}