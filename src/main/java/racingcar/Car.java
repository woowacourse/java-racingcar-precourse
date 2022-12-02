package racingcar;

public class Car {
    private final String name;
    private int position = 0;
    private NumberGenerator numberGenerator;

    public Car(String name, NumberGenerator numberGenerator) {
        this.name = name;
        this.numberGenerator = numberGenerator;
    }

    // 추가 기능 구현
    public void move() {
        if (isUnmovable()) {
            return;
        }
        position += 1;
    }

    public int getPosition() {
        return position;
    }

    private boolean isUnmovable() {
        if (numberGenerator.generate() < 4) {
            return true;
        }

        return false;
    }
}
