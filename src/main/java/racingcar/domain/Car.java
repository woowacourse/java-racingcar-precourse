package racingcar.domain;

import java.util.Objects;
import racingcar.exception.CarNameBlankException;
import racingcar.exception.CarNameLengthException;
import racingcar.exception.CarNameNullPointException;
import racingcar.strategy.MoveStrategy;
import racingcar.strategy.RandomMoveStrategy;

public class Car {

    private final String name;
    private final MoveStrategy moveStrategy;
    private int position = 0;

    public Car(String name, MoveStrategy moveStrategy) {
        checkNameNull(name);
        checkNameBlank(name);
        checkNameLength(name);
        this.name = name;
        this.moveStrategy = moveStrategy;
    }

    public static Car createRandomMoveCar(String name) {
        return new Car(name, new RandomMoveStrategy());
    }

    private static void checkNameLength(String name) {
        if (name.length() > 5 || name.length() == 0) {
            throw new CarNameLengthException();
        }
    }

    private static void checkNameNull(String name) {
        if (Objects.isNull(name)) {
            throw new CarNameNullPointException();
        }
    }

    private static void checkNameBlank(String name) {
        if (name.contains(" ")) {
            throw new CarNameBlankException();
        }
    }

    public int move() {
        if (moveStrategy.isMoveable()) {
            position++;
        }
        return position;
    }
}
