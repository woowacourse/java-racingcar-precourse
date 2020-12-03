package domain;

public class CountValidator {
    private String inputData;

    public CountValidator(String inputData) {
        this.inputData = inputData;
    }

    public int makeValidCount() {
        if (isNotNumber()) {
            throw new IllegalArgumentException("횟수 입력은 숫자여야 한다.");
        }
        return Integer.parseInt(this.inputData);
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
