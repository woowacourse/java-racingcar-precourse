package racingcar;

import enums.GameProcess;
import utils.RandomUtils;

public class Car {
    private static int turnsToTry = GameProcess.NO_TURN.getValue();

    private final String name;
    private int position = GameProcess.INITIAL_POSITION.getValue();

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public int getPosition() {
        return this.position;
    }

    public static int getTurnsToTry() {
        return turnsToTry;
    }

    protected static void setTurnsToTry(int turnsToTryParam) {
        turnsToTry = turnsToTryParam;
    }

    protected void moveOrStay() {
        int randomValue = getRandomValue();
        if (isRandomValueMoreThanCriteria(randomValue)) {
            position++;
        }
    }

    private int getRandomValue() {
        return RandomUtils.nextInt(GameProcess.RANDOM_START_INCLUSIVE.getValue(),
                                    GameProcess.RANDOM_END_INCLUSIVE.getValue());
    }

    private boolean isRandomValueMoreThanCriteria(int randomValue) {
        return randomValue >= GameProcess.CRITERIA_TO_GO_OR_STOP.getValue();
    }

    protected static void useOneTurn() {
        turnsToTry--;
    }
}
