package racingcar;

public interface IRacingGame {
    void readyForSetCars();

    boolean trySetCars(String names);

    void readyForSetReps();

    boolean trySetReps(String reps);

    void start();
}
