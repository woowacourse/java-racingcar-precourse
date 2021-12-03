package racingcar.domain;

public class TryNumber {

    private static final String VALID_LENGTH_EXCEPTION_MESSAGE = "시도 회수는 양의 정수이어야 합니다.";
    private static final Integer MINIMUM_TRY_NUMBER = 0;

    private Integer no;

    public TryNumber(String tryNumber) {
        validTryNumber(tryNumber);
        this.no = Integer.parseInt(tryNumber);
    }

    private void validTryNumber(String tryNumber) throws IllegalArgumentException {
        validInteger(tryNumber);
        validRange(Integer.parseInt(tryNumber));
    }

    private void validInteger(String tryNumber) {
        try {
            Integer.parseInt(tryNumber);
        } catch (Exception exception) {
            throw new IllegalArgumentException(VALID_LENGTH_EXCEPTION_MESSAGE);
        }
    }

    private void validRange(Integer tryNumber) {
        if (tryNumber <= MINIMUM_TRY_NUMBER) {
            throw new IllegalArgumentException(VALID_LENGTH_EXCEPTION_MESSAGE);
        }
    }

    public boolean finish() {
        return this.no == MINIMUM_TRY_NUMBER;
    }

    public void minus() {
        this.no -= 1;
    }
}
