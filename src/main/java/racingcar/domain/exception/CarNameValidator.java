package racingcar.domain.exception;

public interface CarNameValidator extends Validation {
    boolean isBlank(String name);

    boolean isCars(String[] names);

    boolean isDuplication(String[] names);

    boolean validateNameRange(String name);

    boolean isNameValid(String[] cars);

    boolean isAllValid(String[] cars);
}

