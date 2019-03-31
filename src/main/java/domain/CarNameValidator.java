package domain;

public class CarNameValidator {

    public boolean doesValidCarName(String input) {
        if (doesCarNameIsNotNull(input) && doesCarNameLessOrEqualToUpperBound(input)) {
            return true;
        }
        return false;
    }

    private boolean doesCarNameLessOrEqualToUpperBound(String input) {
        return input.length() <= CarNameBound.UPPER.getBound();
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
