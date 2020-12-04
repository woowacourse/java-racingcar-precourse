package domain;

public class CountValidator {
    private final String inputData;

    public CountValidator(String inputData) {
        this.inputData = inputData;
    }

    public int makeValidCount() {
        if (isNotNumber()) {
            throw new IllegalArgumentException("횟수 입력은 숫자여야 한다.");
        }
        checkMoreThanZero();
        return Integer.parseInt(this.inputData);
    }

    private void checkMoreThanZero() {
        if (Integer.parseInt(this.inputData) < 0) {
            throw new IllegalArgumentException("횟수 입력은 0 이상이어야 한다.");
        }
    }

    private boolean isNotNumber() {
        try {
            Integer.parseInt(this.inputData);
            return false;
        } catch (NumberFormatException e) {
            return true;
        }
    }
}
