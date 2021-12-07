package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.util.RandomCondition;
import racingcar.util.Symbol;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void movePosition() {
        if (pickRandomNumber() >= RandomCondition.MOVABLE) {
            position++;
        }
    }

    public void printCurrentInfo() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(name).append(Symbol.COLON_SPACE);

        for (int i = 0; i < position; i++) {
            stringBuilder.append(Symbol.HYPHEN);
        }
        System.out.println(stringBuilder);
    }

    private int pickRandomNumber() {
        return Randoms.pickNumberInRange(RandomCondition.MIN, RandomCondition.MAX);
    }
}
