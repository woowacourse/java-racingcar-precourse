package domain.validator;

public class CarNameValidator implements Validator {

    private final String[] carNames;

    private CarNameValidator(String[] carNames) {
        this.carNames = carNames;
    }

    public static CarNameValidator createCarNameValidatorWithCarNames(String[] carNames) {
        return new CarNameValidator(carNames);
    }

    @Override
    public boolean doesValid() {
        return doesValidCarNames(carNames);
    }

    public boolean doesValidCarName(String input) {
        if (doesCarNameIsNotNull(input) && doesCarNameLessOrEqualToUpperBound(input)) {
            return true;
        }
        return false;
    }

    public boolean doesValidCarNames(String[] carNames) {
        for (String carName : carNames) {
            if (!doesValidCarName(carName)) {
                return false;
            }
        }
        return true;
    }

    public static int getCarNameLengthBound() {
        return CarNameBound.UPPER.getBound();
    }

    private boolean doesCarNameLessOrEqualToUpperBound(String input) {
        return input.length() <= getCarNameLengthBound();
    }

    private boolean doesCarNameIsNotNull(String input) {
        return input != null;
    }

    enum CarNameBound {

        UPPER(5);

        final int bound;

        CarNameBound(int bound) {
            this.bound = bound;
        }

        public int getBound() {
            return bound;
        }
    }
}
