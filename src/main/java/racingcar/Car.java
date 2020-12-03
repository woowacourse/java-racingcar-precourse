package racingcar;

public class Car {
    private static final String MOVE_SIGN = "-";

    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    // 추가 기능 구현
    public void goForward() {
        position++;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public String getMoveSign() {
        StringBuilder moveSign = new StringBuilder();

        for (int i = 0; i < position; i++) {
            moveSign.append(MOVE_SIGN);
        }

        return moveSign.toString();
    }
}
