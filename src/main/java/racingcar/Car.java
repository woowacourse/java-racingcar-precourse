package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import static racingcar.Constant.MOVE_MARK;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    // 추가 기능 구현

    public void move() {
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        if (randomNumber >= 4) {
            position++;
        }
    }

    public void printPosition() {
        StringBuilder executeResult = new StringBuilder();
        executeResult.append(name);
        executeResult.append(" : ");
        for (int i = 0; i < position; i++) {
            executeResult.append(MOVE_MARK);
        }
        System.out.println(executeResult.toString());
    }

    public int getPosition() {
        return position;
    }
}
