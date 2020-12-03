package racingcar;

public class AttemptsCount {

    private int count = 0;

    public AttemptsCount(String count) {
        int attemptsCount = toInt(count);
        validatePositiveNumber(attemptsCount);
        this.count = attemptsCount;
    }

    private void validatePositiveNumber(int count) {
        if (count < 0) {
            throw new IllegalArgumentException(ErrorMessage.SHOULD_BE_NOT_NEGATIVE_NUMBER);
        }
    }

    private int toInt(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.SHOULD_INPUT_ONLY_NUMBER);
        }
    }

    public int getCount() {
        return count;
    }
}
