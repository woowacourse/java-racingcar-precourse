package racingcar.controller;

public class TryNumber {
    private Integer no;

    public TryNumber(Integer tryNumber) {
        validTryNumber(tryNumber);
        this.no = tryNumber;
    }

    private void validTryNumber(Integer tryNumber) throws IllegalArgumentException {
        if (tryNumber <= 0) {
            throw new IllegalArgumentException("시도 회수는 양의 정수이어야 합니다.");
        }
    }

    public boolean finish() {
        return this.no == 0;
    }

    public void minus() {
        this.no -= 1;
    }
}
