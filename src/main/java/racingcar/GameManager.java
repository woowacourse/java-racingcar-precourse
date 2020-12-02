package racingcar;

import utils.RandomUtils;

import java.util.List;

public class GameManager {
    private final String GAME_RESULT_MESSAGE = "실행 결과";
    private final String POSITION_BAR = "-";
    private final int FIRST_ROUND = 1;
    private static final int START_INCLUSIVE_NUMBER = 0;
    private static final int END_INCLUSIVE_NUMBER = 9;
    private static final int GO_THRESHOLD = 4;

    private static boolean isGo(Car car) {
        int randomNumber = RandomUtils.nextInt(START_INCLUSIVE_NUMBER,END_INCLUSIVE_NUMBER);
        if (GO_THRESHOLD <= randomNumber) {
            return true; // GO
        }
        return false; // STOP
    }

    private void moveCars(List<Car> cars) {
        cars.stream()
                .filter(GameManager::isGo)
                .forEach(car -> car.changePosition());
    }

    private void announceCurrentStatus(List<Car> cars) {
        cars.stream()
                .forEach(car -> System.out.println(getCarPositionInformation(car)));
        System.out.println();
    }

    private String getCarPositionInformation(Car car) {
        return car.getName() + " : " + drawCarPositionPicture(car);
    }

    private String drawCarPositionPicture(Car car) {
        // generate progress bar of car position (e.g. "---")
        return new String(new char[car.getPosition()]).replace("\0", POSITION_BAR);
    }

    public void getResult(List<Car> cars, int numberOfRounds) {
        System.out.println(GAME_RESULT_MESSAGE);
        // for loop
        for (int round = FIRST_ROUND; round <= numberOfRounds; round ++) {
            // position change (go or stop)
            moveCars(cars);
            // sout state of the cars
            announceCurrentStatus(cars);
        }
    }
}
