package racingcar.domain.car;

@FunctionalInterface
public interface MovingPolicy {
    boolean isMoving();
}