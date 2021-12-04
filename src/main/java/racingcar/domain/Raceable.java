package racingcar.domain;

public interface Raceable extends Comparable<Raceable> {

    <T extends Raceable> boolean isSamePositionWith(T competitor);

    boolean isMovable(int number);

    void moveForward();

    int getPosition();

    String getName();

}
