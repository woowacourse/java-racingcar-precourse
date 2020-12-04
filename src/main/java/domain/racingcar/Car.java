package domain.racingcar;

public class Car {
    public static final int MINIMUM_NUMBER_TO_MOVE = 4;

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

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
