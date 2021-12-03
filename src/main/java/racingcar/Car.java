package racingcar;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public static Car from(String pobi) {
        return new Car("pobi");
    }

    public String getName() {
        return name;
    }

    // 추가 기능 구현
}
