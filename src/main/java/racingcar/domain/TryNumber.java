package racingcar.domain;

import org.mockito.internal.util.StringUtil;

public class TryNumber {
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
            throw new IllegalArgumentException("시도 회수는 양의 정수이어야 합니다. 입력 받은 수 : " + tryNumber);
        }
    }

    private void validRange(Integer tryNumber) {
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
