package racingcar;

public class AttemptsCount {
    private int count = 0;

    public AttemptsCount(String count) {
        try {
            this.count = toInt(count);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
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
