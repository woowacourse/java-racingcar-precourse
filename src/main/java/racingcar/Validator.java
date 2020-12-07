package racingcar;

import utils.ConstantUtils;

public class Validator {

    public Validator() {

    }

    public void checkCarNames(String[] carNames) {
        for (String carName : carNames) {
            if (carName.length() > ConstantUtils.MAX_CAR_NAME) {
                throw new IllegalArgumentException(ConstantUtils.OVER_FIVE_LETTERS);
            }
            if (carName.length() < ConstantUtils.MIN_CAR_NAME) {
                throw new IllegalArgumentException(ConstantUtils.EMPTY_LETTER);
            }
        }
    }

    public void checkNumber(String num) {
        try {
            int number = Integer.parseInt(num);
            if (number < ConstantUtils.MIN_LAP) {
                throw new IllegalArgumentException(ConstantUtils.MUST_BE_POSITIVE_INTEGER);
            }
        } catch (NumberFormatException n) {
            throw new IllegalArgumentException(ConstantUtils.MUST_BE_NUMBER);
        }
    }
}
