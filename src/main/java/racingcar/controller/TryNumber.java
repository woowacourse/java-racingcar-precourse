package racingcar.controller;

public class TryNumber {

    public TryNumber(Integer tryNumber) {
        validTryNumber(tryNumber);
    }

    private void validTryNumber(Integer tryNumber) throws IllegalArgumentException {
        if (tryNumber <= 0) {
            throw new IllegalArgumentException("시도 회수는 양의 정수이어야 합니다.");
        }
    }
}
