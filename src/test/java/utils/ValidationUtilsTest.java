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

    @Test
    public void isValidNumberOfMoves() {
        String numberOfMoves = "5";
        boolean validated = ValidationUtils.isValidNumberOfMoves(numberOfMoves);
        assertThat(validated).isTrue();
    }

    @Test
    public void isValidNumberOfMoves_empty() {
        String numberOfMoves = "";
        boolean validated = ValidationUtils.isValidNumberOfMoves(numberOfMoves);
        assertThat(validated).isFalse();
    }

    @Test
    public void isValidNumberOfMoves_includeBlank() {
        String numberOfMoves = " ";
        boolean validated = ValidationUtils.isValidNumberOfMoves(numberOfMoves);
        assertThat(validated).isFalse();
    }

    @Test
    public void isValidNumberOfMoves_notNumeric() {
        String numberOfMoves = "five";
        boolean validated = ValidationUtils.isValidNumberOfMoves(numberOfMoves);
        assertThat(validated).isFalse();
    }

    @Test
    public void isValidNumberOfMoves_zero() {
        String numberOfMoves = "0";
        boolean validated = ValidationUtils.isValidNumberOfMoves(numberOfMoves);
        assertThat(validated).isFalse();
    }

    @Test
    public void isValidNumberOfMoves_negativeNumber() {
        String numberOfMoves = "-2";
        boolean validated = ValidationUtils.isValidNumberOfMoves(numberOfMoves);
        assertThat(validated).isFalse();
    }

    @Test
    public void isValidNumberOfMoves_exceedMovingRange() {
        String numberOfMoves = "999";
        boolean validated = ValidationUtils.isValidNumberOfMoves(numberOfMoves);
        assertThat(validated).isFalse();
    }
}
