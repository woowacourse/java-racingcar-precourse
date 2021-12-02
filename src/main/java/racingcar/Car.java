package racingcar;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class Car {
    private final String name;
    private int position = 0;

    static final int START_RANDOM = 0;
    static final int END_RANDOM = 9;
    static final int BOUNDARY_RANDOM = 4;
    static final String MOVE_HISTORY = "-";

    public Car(String name) {
        this.name = name;
    }

    void move() {
        int random = pickNumberInRange(START_RANDOM, END_RANDOM + 1);

        if (random > BOUNDARY_RANDOM) {
            this.position++;
        }
    }

    void showPosition() {
        System.out.println(this.name + " : " + this.getMoveHistory());
    }

    private String getMoveHistory() {
        String moveHistory = "";

        for (int i = 1; i <= this.position; i++) {
            moveHistory += MOVE_HISTORY;
        }
        return moveHistory;
    }
}
