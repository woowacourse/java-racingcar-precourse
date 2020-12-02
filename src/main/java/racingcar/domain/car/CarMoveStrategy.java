package racingcar.domain.car;

public interface CarMoveStrategy {

    int RANDOM_START_INCLUSIVE = 0;
    int RANDOM_END_INCLUSIVE = 9;

    boolean isPossibleMove(final int value);
}
