package racingcar.strategy;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomMoveStrategy implements MoveStrategy {

    @Override
    public boolean isMoveable() {
        int command = Randoms.pickNumberInRange(1, 9);
        return command >= 4;
    }
}
