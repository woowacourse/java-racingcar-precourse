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
            throw new IllegalArgumentException("[Error] 시도 횟수는 음수이면 안 됩니다.");
        }
    }

    private int toInt(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[Error] 숫자만을 입력해야 합니다.");
        }
    }

    public int getCount() {
        return count;
    }
}
