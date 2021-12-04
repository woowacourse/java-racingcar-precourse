package racingcar.domain.exception;

public interface Validation {
    String ERROR = "[ERROR] ";

    void printMessage(String errorMessage);
}
