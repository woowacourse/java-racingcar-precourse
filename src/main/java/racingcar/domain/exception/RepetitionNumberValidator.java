package racingcar.domain.exception;

public interface RepetitionNumberValidator extends Validation {
    int convertStringToInt(String number);

    boolean isValid(String targetNumber);

    boolean validateRange(int number);
}
