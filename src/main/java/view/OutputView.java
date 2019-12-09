package view;

import domain.Cars;

public class OutputView {
    private OutputView() { }

    public static void printCarPositions(Cars cars) {
        cars.printPositions();
    }

    public static void printWinners(Cars cars) {
        System.out.println(cars.getMaxPositionCars() + "가 최종 우승했습니다.");
    }
}
