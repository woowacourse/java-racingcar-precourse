package racingcar;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    // 추가 기능 구현

    public String getName() {
        return this.name;
    }

    public int getPosition() {
        return this.position;
    }

    public void goForward() {
        this.position += 1;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + this.name + '\'' +
                ", position=" + this.position +
                '}';
    }
}
