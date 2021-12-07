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

    @Override
    public String getLine() {
        String line = makeNamePrompt() + makePositionStatus();
        return line;
    }

    @Override
    public int getPosition() {
        return position;
    }

    private String makeNamePrompt() {
        String line = "";
        line += this.name + " : ";
        return line;
    }

    private String makePositionStatus() {
        String positionStatus = "";
        for (int i = 0; i < position; i++) {
            positionStatus += "-";
        }
        return positionStatus;
    }
}
