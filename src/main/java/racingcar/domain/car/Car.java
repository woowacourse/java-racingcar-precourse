package racingcar.domain.car;

import racingcar.domain.result.RoundResult;

public class Car implements Comparable<Car> {
    private final String name;

    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    // 추가 기능 구현
    public static Car from(String name) {
        return new Car(name);
    }

    public void move() {
        position++;
    }

    public String whereIsIt() {
        return RoundResult.of(name, position);
    }

    public boolean isSamePosition(Car car) {
        return car.position == this.position;
    }

    public void writeName(StringBuilder stringBuilder) {
        stringBuilder.append(name);
    }

    @Override
    public int compareTo(Car target) {
        return target.position - this.position;
    }
}
