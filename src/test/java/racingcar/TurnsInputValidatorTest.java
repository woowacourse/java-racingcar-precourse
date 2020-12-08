package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

public class TurnsInputValidatorTest {

    TurnsInputValidator turnsInputValidator;

    @Before
    public void setUp() throws Exception {
        turnsInputValidator = new TurnsInputValidator();
    }

    @Test
    public void validate_success_naturalNumber() {
        String invalidTurns = "1";
        turnsInputValidator.validate(invalidTurns);

        assertThat(turnsInputValidator.isValid()).isEqualTo(true);
    }

    @Test
    public void validate_fail_string() {
        String invalidTurns = "s";
        turnsInputValidator.validate(invalidTurns);

        assertThat(turnsInputValidator.isValid()).isEqualTo(false);
    }

    @Test
    public void validate_fail_zero() {
        String invalidTurns = "0";
        turnsInputValidator.validate(invalidTurns);

        assertThat(turnsInputValidator.isValid()).isEqualTo(false);
    }
    @Test
    public void validate_fail_negative() {
        String invalidTurns = "-1";
        turnsInputValidator.validate(invalidTurns);

        assertThat(turnsInputValidator.isValid()).isEqualTo(false);
    }
}