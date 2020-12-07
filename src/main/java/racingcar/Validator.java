package racingcar;

public class Validator {

    public Validator() {

    }

    public void checkCarNames(String[] carNames) {
        for (String carName : carNames) {
            if (carName.length() > Constants.MAX_CAR_NAME) {
                throw new IllegalArgumentException(Constants.OVER_FIVE_LETTERS);
            }
            if (carName.length() < Constants.MIN_CAR_NAME) {
                throw new IllegalArgumentException(Constants.EMPTY_LETTER);
            }
        }
    }

    public void checkNumber(String num) {
        try {
            int number = Integer.parseInt(num);
            if (number < Constants.MIN_LAP) {
                throw new IllegalArgumentException(Constants.MUST_BE_POSITIVE_INTEGER);
            }
        } catch (NumberFormatException n) {
            throw new IllegalArgumentException(Constants.MUST_BE_NUMBER);
        }
    }
}
