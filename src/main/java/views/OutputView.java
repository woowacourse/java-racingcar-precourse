package views;

import domain.Car;
import domain.RacingCars;

public class OutputView {
    private final static String COLON = " : ";
    private final static String HYPHEN = "-";

    public static void printOneRound(RacingCars racingCars) {
        for (Car car : racingCars.getCarList()) {
            System.out.print(car.getName() + COLON);
            drawPosition(car);
            System.out.println();
        }
        System.out.println();
    }

    private static void drawPosition(Car car) {
        int position = car.getPosition();
        for (int i = 1; i <= position; i++) {
            System.out.print(HYPHEN);
        }
    }
}
