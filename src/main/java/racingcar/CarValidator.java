package racingcar;

public class CarValidator {
    static final int CAR_NAME_SIZE_CONDITION = 5;
    public boolean isValid(String carName) {
        if (carName.length() > CAR_NAME_SIZE_CONDITION)
            return false;
        return true;
    }
}
