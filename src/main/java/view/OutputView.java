package view;

import domain.Cars;

public class OutputView {
    private OutputView() {}

    public static void printCarPositions(Cars cars) {
        cars.printPositions();
    }
}
