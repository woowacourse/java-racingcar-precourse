package racingcar;
import java.util.ArrayList;
import java.util.StringTokenizer;

import camp.nextstep.edu.missionutils.Console;
public class RacingCarGame  implements Game {
    ArrayList<Car> racingCars;
    int numberOfTrial;

    final int MAXIMUM_LENGTH = 5;

    @Override
    public void play() {

    }

    private String getRacingCarsNameFromUser() {
        return Console.readLine();
    }

    private StringTokenizer splitByMark(String neededToSplit, String delimiter) {
        return new StringTokenizer(neededToSplit, delimiter);
    }

    private boolean checkMoreThanMaximumLength(String neededToCheck) {
        return neededToCheck.length() <= MAXIMUM_LENGTH;
    }

    private Car createRacingCarEntity(String carName) {
        return new Car(carName);
    }

    private void addRacingCarEntity(Car car) {
        racingCars.add(car);
    }

    private void getNumberOfTrialFromUser() {

    }


}
