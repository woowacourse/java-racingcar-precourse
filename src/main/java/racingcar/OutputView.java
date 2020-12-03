package racingcar;

import java.util.ArrayList;

public class OutputView {
    public static void printRacingStatus(Cars cars) {
        ArrayList<Integer> carsPositions = cars.getCarsPosition();
        ArrayList<String> carsNames = cars.getCarsName();

        for (int i = 0; i < carsNames.size(); i++) {
            System.out.print(carsNames.get(i) + " " + Constants.COLON + " ");

            for (int j = 0; j < carsPositions.get(i); j++) {
                System.out.print(Constants.DASH);
            }
            System.out.print(Constants.NEW_LINE);
        }
        System.out.print(Constants.NEW_LINE);
    }

    public static void printResult(Cars cars) {
        System.out.print(Constants.FINAL_WINNER);

        for (int i = 0; i < cars.getCars().size(); i++) {
            System.out.print(cars.getCars().get(i).getName());

            if (i != cars.getCars().size() - 1) {
                System.out.print(Constants.COMMA);
            }
        }
    }
}
