package racingcar.domain.car;

public class NormalCarMoveStrategy implements CarMoveStrategy {

    static final int MOVING_THRESHOLD = 4;

    @Override
    public boolean isPossibleMove(final int value) {
        return value >= MOVING_THRESHOLD;
    }

    private static class LazyHolder {
        public static final NormalCarMoveStrategy INSTANCE = new NormalCarMoveStrategy();
    }

    public static NormalCarMoveStrategy getInstance() {
        return LazyHolder.INSTANCE;
    }
}
