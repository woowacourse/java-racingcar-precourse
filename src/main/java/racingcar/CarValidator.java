package racingcar;

public class CarValidator {
    public boolean isValid(String carName) {
        if (carName.length() > 5)
            return false;
        return true;
    }
}
