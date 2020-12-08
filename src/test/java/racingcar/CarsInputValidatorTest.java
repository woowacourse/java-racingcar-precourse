package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

public class CarsInputValidatorTest {

    CarsInputValidator carsInputValidator;

    @Before
    public void setUp() throws Exception {
        carsInputValidator = new CarsInputValidator();
    }

    @Test
    public void validate_success_naturalNumber() {
        String invalidNames = "joy,happy,car1";
        carsInputValidator.validate(invalidNames);

        assertThat(carsInputValidator.isValid()).isEqualTo(true);
    }

    @Test
    public void validate_fail_duplicate() {
        String invalidNames = "joy,joy,a";
        carsInputValidator.validate(invalidNames);

        assertThat(carsInputValidator.isValid()).isEqualTo(false);
    }

    @Test
    public void validate_fail_maxlength() {
        String invalidNames = "123456,23";
        carsInputValidator.validate(invalidNames);

        assertThat(carsInputValidator.isValid()).isEqualTo(false);
    }

    @Test
    public void validate_fail_empty() {
        String invalidNames = "aa, ,bb";
        carsInputValidator.validate(invalidNames);

        assertThat(carsInputValidator.isValid()).isEqualTo(false);
    }

    @Test
    public void validate_fail_comma() {
        String invalidNames = "aa,bb,";
        carsInputValidator.validate(invalidNames);
        assertThat(carsInputValidator.isValid()).isEqualTo(false);

        invalidNames = ",aa,bb";
        carsInputValidator.validate(invalidNames);
        assertThat(carsInputValidator.isValid()).isEqualTo(false);
    }
}