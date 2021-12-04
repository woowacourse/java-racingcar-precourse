package racingcar;

import static racingcar.StringConstants.*;

import java.util.ArrayList;
import java.util.List;

public class RacingResultBoard {
    private final List<StringBuilder> racingResults;

    public RacingResultBoard() {
        racingResults = new ArrayList<>();
    }

    public void writeCarNames(List<Car> cars) {
        for (Car car : cars) {
            StringBuilder racingResult = new StringBuilder();
            racingResult.append(car.getName());
            racingResult.append(DELIMITER_BETWEEN_NAME_AND_DISTANCE_RECORD);
            racingResults.add(racingResult);
        }
    }

    public void updateBoard(List<Car> cars) {
        for (int order = START_NUMBER_OF_ORDER; order < cars.size(); order++) {
            Car carAfterRacing = cars.get(order);
            if (carAfterRacing.hasMovedForward()) {
                updateRacingResult(order);
            }
        }
    }

    private void updateRacingResult(int order) {
        StringBuilder racingResultBeforeUpdate = racingResults.get(order);
        racingResultBeforeUpdate.append(MARK_FOR_DISTANCE_RECORD);
    }

    public void showBoard() {
        for (StringBuilder racingResult : racingResults) {
            System.out.println(racingResult.toString());
        }
        System.out.println();
    }
}





