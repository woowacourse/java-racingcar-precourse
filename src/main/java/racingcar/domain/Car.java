package racingcar.domain;

public class Car {
    private final String name;

    private Position position;

    public Car(String name) {
        this(name, 0);
    }

    public Car(String name, int position) {
        this.name = name;
        this.position = new Position(position);
    }

    // 추가 기능 구현
}
