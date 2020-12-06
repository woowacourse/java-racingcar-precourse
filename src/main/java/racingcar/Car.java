package racingcar;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    // 추가 기능 구현
    public String getCarName() {
        return this.name;
    }

    public int getCarPosition() {
        return this.position;
    }

}
