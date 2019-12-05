package io;

import domain.Car;

public class OutputRacingCar {
    public static void printGameResult() {
        System.out.println("실행 결과");
    }

    public static void printCarProgress(Car car) {
        System.out.print(car.getName() + " : ");
        for (int i = 0; i <= car.getPosition(); i++) {
            System.out.print("-");
        }
        System.out.println();
    }
}
