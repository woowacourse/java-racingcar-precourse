package racingcar.model.classes;

import racingcar.model.CarInterface;

public class Car implements CarInterface {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    // 추가 기능 구현
    @Override
    public void go() {
        position++;
    }
}
