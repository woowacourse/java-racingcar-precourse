package racingcar.domain;

import racingcar.view.OutputView;

public class Car implements Comparable<Car> {
    private static final int MIN_CAR_NAME_LENGTH = 1;
    private static final int MAX_CAR_NAME_LENGTH = 5;
    private static final String NAME_LENGTH_ERROR = "[ERROR] 자동차 이름은 1자 이상 5자 이하만 가능합니다.";
    private final String name;
    private int position = 0;

    public Car(String name) {
        validateNameLength(name);
        this.name = name;
    }

    // 추가 기능 구현
    private void validateNameLength(String name) {
        if (name.length() < MIN_CAR_NAME_LENGTH || name.length() > MAX_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException(NAME_LENGTH_ERROR);
        }
    }

    public void goCar() {
        position++;
    }

    public void printAttemptResult() {
        OutputView.printResultScore(name, positionToBars());
    }

    private String positionToBars() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < position; i++) {
            stringBuilder.append("-");
        }
        return stringBuilder.toString();
    }

    public boolean isMaxPosition(int maxPosition) {
        if (position == maxPosition) {
            return true;
        }
        return false;
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Car o) {
        return o.getPosition() - getPosition();
    }
}
