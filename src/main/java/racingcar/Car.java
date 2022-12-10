package racingcar;

import racingcar.util.Number;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    // 추가 기능 구현
    private void move(int moveInput){
        if(moveInput >= Number.STANDARD_NUMBER.getNumber())position++;
    }
}
