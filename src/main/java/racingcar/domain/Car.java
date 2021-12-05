package racingcar.domain;

import java.util.Objects;
import racingcar.exception.CarNameBlankException;
import racingcar.exception.CarNameLengthException;
import racingcar.exception.CarNameNullPointException;
import racingcar.strategy.MoveStrategy;
import racingcar.strategy.RandomMoveStrategy;

public class Car {

    private static final int START_POSITION = 0;
    private static final int NAME_MAX_LENGTH = 5;
    private static final int NAME_MIN_LENGTH = 1;
    private static final String BLANK_NAME = " ";

    private final String name;
    private final MoveStrategy moveStrategy;
    private int position = START_POSITION;

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
        if (name.length() > NAME_MAX_LENGTH || name.length() < NAME_MIN_LENGTH) {
            throw new CarNameLengthException();
        }
    }

    private static void checkNameNull(String name) {
        if (Objects.isNull(name)) {
            throw new CarNameNullPointException();
        }
    }

    private static void checkNameBlank(String name) {
        if (name.contains(BLANK_NAME)) {
            throw new CarNameBlankException();
        }
    }

    public int move() {
        if (moveStrategy.isMoveable()) {
            position++;
        }
        return position;
    }

    public int position() {
        return position;
    }
}
