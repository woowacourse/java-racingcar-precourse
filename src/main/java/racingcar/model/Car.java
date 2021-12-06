package racingcar.model;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void moveForward() {
        // TODO: 위치 1만큼 이동
    }

    public void getCurrentInfo() {
        // TODO: 자동차 이름과 위치 정보
    }
}
