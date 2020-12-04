package racingcar;

import java.util.ArrayList;

public class OutputView {
    public static void printRacingStatus(Cars cars) {
        ArrayList<Integer> carsPositions = cars.getCarsPosition();
        ArrayList<String> carsNames = cars.getCarsName();
        StringBuilder racingStatus = new StringBuilder();
        for (int i = 0; i < carsNames.size(); i++) {
            racingStatus.append(carsNames.get(i) + " " + Constants.COLON + " ");
            for (int j = 0; j < carsPositions.get(i); j++) {
                racingStatus.append(Constants.DASH);
            }
            racingStatus.append(Constants.NEW_LINE);
        }
        System.out.println(racingStatus.toString());
    }

    public static void printResult(Cars cars) {
        StringBuilder racingResult = new StringBuilder();
        racingResult.append(Constants.FINAL_WINNER);

        for (int i = 0; i < cars.getCars().size(); i++) {
            racingResult.append(cars.getCars().get(i).getName());

            if (i != cars.getCars().size() - 1) {
                racingResult.append(Constants.COMMA);
            }
        }
        System.out.print(racingResult.toString());
    }
}
