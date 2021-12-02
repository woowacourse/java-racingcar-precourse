package racingcar;

public class Car {
    private final String name;
    private int position;

    public Car(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public String getCarName() {
        return name;
    }

    // 추가 기능 구현
}
