package racingcar.view;

import racingcar.Constants;
import racingcar.model.Car;
import racingcar.model.Cars;

import java.util.ArrayList;
import java.util.List;

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

    public static void printResult(List<Car> cars) {
        StringBuilder racingResult = new StringBuilder();
        racingResult.append(Constants.FINAL_WINNER);

        for (int i = 0; i < cars.size(); i++) {
            racingResult.append(cars.get(i).getName());

            if (i != cars.size() - 1) {
                racingResult.append(Constants.COMMA);
            }
        }
        System.out.print(racingResult.toString());
    }
}
