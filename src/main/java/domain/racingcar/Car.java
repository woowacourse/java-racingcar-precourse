package domain.racingcar;

import java.util.ArrayList;
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
    public void increasePosition(final Integer randomNumber) {
        if (isGreaterThanMoveNumber(randomNumber)) {
            this.position++;
        }
    }

    private boolean isGreaterThanMoveNumber(final Integer randomNumber) {
        return randomNumber >= MINIMUM_NUMBER_TO_MOVE;
    }

    public int findGreaterPosition(final int maxPosition) {
        return Math.max(maxPosition, this.position);
    }

    public boolean isSameThan(final int maxPosition) {
        return maxPosition == this.position;
    }

    public List<String> getNamePosition() {
        List<String> namePosition = new ArrayList<>();
        namePosition.add(this.name);
        namePosition.add(String.valueOf(this.position));
        return namePosition;
    }

    public String getName() {
        return name;
    }
}
