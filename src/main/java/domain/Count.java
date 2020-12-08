package domain;

/**
 * 게임 횟수를 가진 객체
 *
 * @author 조연우
 * @version 1.0 2020년 12월 7일
 */
public class Count {
    private Integer count;

    public Count(final String inputCount) {
        this.count = CountValidator.makeValidCount(inputCount);
    }

    public boolean isBiggerThanZeroWhenDecreaseOne() {
        return this.count-- > 0;
    }
}
