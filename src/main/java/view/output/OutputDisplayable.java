package view.output;

import model.car.Car;

import java.util.List;

public interface OutputDisplayable {
    void printOperationResultLetters();

    void showAttemptResult(final List<Car> cars);

    void showWinners(final List<Car> winners);
}
