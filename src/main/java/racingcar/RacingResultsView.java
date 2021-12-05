package racingcar;

import static racingcar.StringConstants.NEW_LINE;

import java.util.ArrayList;
import java.util.List;

public class RacingResultsView {
    private final List<Car> cars;
    private List<StringBuilder> racingResultsView = new ArrayList<>();

    public RacingResultsView(List<Car> cars) {
        this.cars = cars;
    }

    public void print() {
        writeResults();
        writeNewLine();
        printResults();
    }

    private void writeResults() {
        for (Car car : cars) {
             RacingResultView racingResultView = new RacingResultView(car);
             racingResultsView.add(racingResultView.writeResult());
        }
    }

    private void writeNewLine() {
        racingResultsView.add(new StringBuilder());
    }

    private void printResults() {
        for (StringBuilder result : racingResultsView) {
            System.out.println(result.toString());
        }
    }
}
