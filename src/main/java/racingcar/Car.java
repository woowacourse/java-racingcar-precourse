package racingcar;

import java.util.ArrayList;

public class Car {

    private static final String ENTER_LINE = "\n";
    private static final String WHITE_SPACE = " ";
    private static final String NO_STRING = "";
    private static final String COLON = " : ";
    private static final String DASH = "-";
    private static final int MAX_LENGTH = 5;
    private static final int EMPTY = 0;

    private final String name;
    private final GasTank gasTank;
    private int position = 0;

    private Car(String name) {
        validateEmpty(name);
        validateLength(name);
        this.name = name;
        this.gasTank = GasTank.randomChargeGasTank();
    }

    // 추가 기능 구현
    public static Car newCar(String name) {
        return new Car(name);
    }

    public void tryForward() {
        if (gasTank.isEnoughGas()) {
            position++;
        }
    }


    private void validateEmpty(String name) {
        if (name.length() == EMPTY || name.replaceAll(WHITE_SPACE, NO_STRING).length() == EMPTY) {
            throw new IllegalArgumentException("자동차 이름을 입력해주세요.");
        }
    }

    private void validateLength(String name) {
        if (name.length() > MAX_LENGTH) {
            throw new IllegalArgumentException("각 자동차의 이름은 5자 이하여야 합니다.");
        }
    }

    public void currentPosition(StringBuilder positions) {
        positions.append(name);
        positions.append(COLON);
        positions.append(convertPosition());
        positions.append(ENTER_LINE);
    }

    private StringBuilder convertPosition() {
        StringBuilder position = new StringBuilder();
        for (int i = 0; i < this.position; i++) {
            position.append(DASH);
        }
        return position;
    }

    public int award(ArrayList<String> winners, int max_distance) {
        if (max_distance < position) {
            winners.clear();
            max_distance = position;
        }
        if (max_distance == position) {
            winners.add(name);
        }
        return max_distance;
    }
}
