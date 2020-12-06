package utils;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ValidationUtilsTest {
    @Test
    public void isValidCarNames() {
        String carNames = "pobi,woni,jun,KIA5,Kia7";
        boolean validated = ValidationUtils.isValidCarNames(carNames);
        assertThat(validated).isTrue();
    }

    @Test
    public void isValidCarNames_invalidDelimiter() {
        String carNames = "pobi/woni/jun";
        boolean validated = ValidationUtils.isValidCarNames(carNames);
        assertThat(validated).isFalse();
    }

    @Test
    public void isValidCarNames_exceedFiveCharacters() {
        String carNames = "lamborghini";
        boolean validated = ValidationUtils.isValidCarNames(carNames);
        assertThat(validated).isFalse();
    }

    @Test
    public void isValidCarNames_empty() {
        String carNames = "";
        boolean validated = ValidationUtils.isValidCarNames(carNames);
        assertThat(validated).isFalse();
    }

    @Test
    public void isValidCarNames_includeBlank() {
        String carNames = "po bi";
        boolean validated = ValidationUtils.isValidCarNames(carNames);
        assertThat(validated).isFalse();
    }

    @Test
    public void isValidCarNames_includeSpecialCharacters() {
        String carNames = "pobi@";
        boolean validated = ValidationUtils.isValidCarNames(carNames);
        assertThat(validated).isFalse();
    }

    @Test
    public void isValidCarNames_endWithComma() {
        String carNames = "pobi,";
        boolean validated = ValidationUtils.isValidCarNames(carNames);
        assertThat(validated).isFalse();
    }
}
