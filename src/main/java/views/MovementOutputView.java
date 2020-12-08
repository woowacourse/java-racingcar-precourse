package views;

import domain.Car;
import domain.RacingCars;

public class MovementOutputView {
    private static final String COLON = " : ";
    private static final String HYPHEN = "-";

    public static void printAllCarMovement(RacingCars racingCars) {
        printOneCarMovement(racingCars);
        System.out.println();
    }

    private static void printOneCarMovement(RacingCars racingCars) {
        for (Car car : racingCars.getCarList()) {
            System.out.println(car.getName() + COLON + makeMovementMark(car));
        }
    }

    private static String makeMovementMark(Car car) {
        StringBuilder movementMark = new StringBuilder();
        for (int i = 1; i <= car.getPosition(); i++) {
            movementMark.append(HYPHEN);
        }
        return movementMark.toString();
    }
}
