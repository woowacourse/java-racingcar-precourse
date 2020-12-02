package racingcar;

import racingcar.game.OutputPrint;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    // 추가 기능 구현
    public void goForward(int numberToGoForward) {
        position += numberToGoForward;
    }

    public void printCurrentState() {
        OutputPrint.printCarName(name);
        OutputPrint.printCarState(position);
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }
}
