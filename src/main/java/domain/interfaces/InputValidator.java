package domain.interfaces;

public interface InputValidator {
    int MAX_CAR_NAME_LENGTH = 5;

    boolean isValidCarName(String carName);
    boolean isValidProgressCount(int progressCount);
}
