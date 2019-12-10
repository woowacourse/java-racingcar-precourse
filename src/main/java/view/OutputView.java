package view;

import domain.Cars;

public class OutputView {
    private OutputView() { }

    public static void printCarPositions(Cars cars) {
        cars.printPositions();
        System.out.println();
    }

    public static void printWinners(Cars cars) {
        System.out.println(cars.getMaxPositionCars() + "가 최종 우승했습니다.");
    }

    public static void printTitleOfResult() {
        System.out.println();
        System.out.println("실행 결과");
    }
}