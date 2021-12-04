package racingcar.strategy;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomMoveStrategy implements MoveStrategy {

    private static final int MIN_COMMAND = 1;
    private static final int MAX_COMMAND = 9;
    private static final int MIN_MOVEABLE_COMMAND = 4;

    @Override
    public boolean isMoveable() {
        int command = Randoms.pickNumberInRange(MIN_COMMAND, MAX_COMMAND);
        return command >= MIN_MOVEABLE_COMMAND;
    }
}
