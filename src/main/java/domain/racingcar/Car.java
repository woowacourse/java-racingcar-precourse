package domain.racingcar;

import java.util.ArrayList;
import java.util.List;

/**
 * 자동차의 정보인 이름과 위치를 가진 객체
 *
 * @author 조연우
 * @version 1.0 2020년 12월 3일
 */
public class Car {
    public static final int INDEX_OF_NAME = 0;
    public static final int INDEX_OF_POSITION = 1;
    private static final int MINIMUM_NUMBER_TO_MOVE = 4;

    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    // 추가 기능 구현
    public void increasePosition(Integer randomNumber) {
        if (randomNumber >= MINIMUM_NUMBER_TO_MOVE) {
            this.position++;
        }
    }

    public int isGreaterThan(int maxPosition) {
        return Math.max(maxPosition, this.position);
    }

    public boolean isSameThan(int maxPosition) {
        return maxPosition == this.position;
    }

    public List<String> getInfo() {
        List<String> information = new ArrayList<>();
        information.add(this.name);
        information.add(String.valueOf(this.position));
        return information;
    }

    public String getName() {
        return name;
    }
}
