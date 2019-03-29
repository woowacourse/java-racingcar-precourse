package domain;

import domain.interfaces.InputValidator;

public class InputValidatorImpl implements InputValidator {

    @Override
    public boolean isValidCarName(String carName) {
        if (carName == null) {
            return false;
        }
        if (carName.isEmpty() || carName.length() > MAX_CAR_NAME_LENGTH) {
            return false;
        }

        return true;
    }

    @Override
    public boolean isValidProgressCount(int progressCount) {
        if (progressCount <= 0) {
            return false;
        }

        return true;
    }
}
