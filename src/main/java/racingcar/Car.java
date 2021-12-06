package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import communicate.Text;

public class Car implements Comparable<Car> {
    private static final int MIN_NUMBER = 0;
    private static final int MAX_NUMBER = 9;
    private static final int MIN_MOVABLE_NUMBER = 4;
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    // 추가 기능 구현
    private int assignRandomNumber() {
        return Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
    }

    public boolean isMovable() {
        return assignRandomNumber() >= MIN_MOVABLE_NUMBER;
    }

    public void move() {
        position++;
    }

    public String getName() {
        return name;
    }

    private String showPosition() {
        StringBuilder positionStatus = new StringBuilder();

        for (int i = 0; i < position; i++) {
            positionStatus.append(Text.MOVE_MARK);
        }

        return positionStatus.toString();
    }

    public String provideInformation() {
        return getName() + Text.COLON + showPosition();
    }

    @Override
    public int compareTo(Car o) {
        return o.position - this.position;
    }
}
