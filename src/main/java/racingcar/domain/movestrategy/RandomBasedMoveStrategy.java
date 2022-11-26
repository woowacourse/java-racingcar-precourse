package racingcar.domain.movestrategy;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomBasedMoveStrategy implements MoveStrategy {
    public static final int MIN_RANDOM_NUMBER = 0;
    public static final int MAX_RANDOM_NUMBER = 9;
    public static final int MIN_MOVABLE_NUMBER = 4;
    
    @Override
    public boolean isMovable() {
        return isFourOrMore();
    }
    
    private boolean isFourOrMore() {
        return Randoms.pickNumberInRange(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER) >= MIN_MOVABLE_NUMBER;
    }
}
