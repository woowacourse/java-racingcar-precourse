package racingcar;

import java.util.ArrayList;

public interface IRacingGamePrinter {
    void inputNames();

    void errorInputPlayer();

    void inputReps();

    void errorInputReps();

    void start();

    void status(ArrayList<Car> cars);

    void winner(ArrayList<Car> cars);
}
