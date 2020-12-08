package domain.racingcar;

import java.util.Arrays;
import java.util.List;

/**
 * 자동차의 정보인 이름과 위치를 가진 객체
 *
 * @author 조연우
 * @version 1.0 2020년 12월 8일
 */
public class Car {
    private static final int MINIMUM_NUMBER_TO_MOVE = 4;

    private final String name;
    private int position = 0;

    public Car(final String name) {
        this.name = name;
    }

    // 추가 기능 구현
    public void movePosition(final Integer randomNumber) {
        if (isGreaterThanMinimumNumber(randomNumber)) {
            this.position++;
        }
    }

    private boolean isGreaterThanMinimumNumber(final Integer randomNumber) {
        return randomNumber >= MINIMUM_NUMBER_TO_MOVE;
    }

    public int findGreaterPosition(final int comparedPosition) {
        return Math.max(comparedPosition, this.position);
    }

    public boolean isSameThan(final int comparedPosition) {
        return comparedPosition == this.position;
    }

    public List<String> getNameAndPosition() {
        return Arrays.asList(this.name, String.valueOf(this.position));
    }

    public String getName() {
        return name;
    }
}
