package view.output;

import dto.AttemptResult;
import model.car.Car;

import java.util.List;

public interface OutputDisplayable {
    void printOperationResultLetters();

    void showAttemptResult(final List<AttemptResult> cars);

    void showWinners(final List<Car> winners);
}
