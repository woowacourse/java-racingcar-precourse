package racingcar.domain.exception;

public interface RepetitionNumberValidator {
    int convertStringToInt(String number);

    boolean isValid(String targetNumber);

    boolean validateRange(int number);
}
