package racingcar;

import utils.InputValidator;
import utils.RandomUtils;
import view.OutputView;

public class Car {
    public static final int MIN_NAME_LEN = 1;
    public static final int MAX_NAME_LEN = 5;

    private static final int TRY_NUMBER_MIN = 0;
    private static final int TRY_NUMBER_MAX = 9;
    private static final int MOVE_CONDITION = 4;

    private static final String SEPARATOR_NAME_AND_POSITION = " : ";
    private static final String POSITION_BAR = "-";

    private final String name;
    private int position = 0;

    public Car(String name) {
        InputValidator.checkValidCarName(name);
        this.name = name;
    }

    public void tryMove() {
        int rand = RandomUtils.nextInt(TRY_NUMBER_MIN, TRY_NUMBER_MAX);
        if (rand >= MOVE_CONDITION) {
            position++;
        }
    }

    public void printPosition() {
        OutputView.printMsg(name);
        OutputView.printMsg(SEPARATOR_NAME_AND_POSITION);
        OutputView.printMsg(getPositionBar());
        OutputView.printNextLine();
    }

    private String getPositionBar() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < position; i++) {
            sb.append(POSITION_BAR);
        }
        return sb.toString();
    }

    public boolean isFartherThan(int position) {
        return position < this.position;
    }

    public String getNameIfWinner(int firstPosition) {
        if (isOn(firstPosition)) {
            return this.name;
        }
        return null;
    }

    private boolean isOn(int position) {
        return this.position == position;
    }
}
