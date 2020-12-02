package racingcar;

import utils.RandomUtils;

import java.util.List;
import java.util.stream.Collectors;

public class GameManager {
    private final String GAME_RESULT_MESSAGE = "실행 결과";
    private final String POSITION_BAR = "-";
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

    public void thisRoundMove(List<Car> cars) {
        cars.stream()
                .filter(GameManager::isGo)
                .forEach(car -> car.changePosition());
    }

    public void thisrRoundTotalResult(List<Car> cars) {
        cars.stream()
                .forEach(car -> System.out.println(thisRoundCarResult(car)));
        System.out.println();
    }

    private String thisRoundCarResult(Car car) {
        return car.getName() + " : " + drawCarPositionPicture(car);
    }

    private String drawCarPositionPicture(Car car) {
        // generate progress bar of car position (e.g. "---")
        return new String(new char[car.getPosition()]).replace("\0", POSITION_BAR);
    }

    public void getResult(List<Car> cars, int numberOfRounds) {
        System.out.println(GAME_RESULT_MESSAGE);
        // for loop
        for (int round = 0; round < numberOfRounds; round ++) {
            // position change (go or stop)
            thisRoundMove(cars);
            // sout state of the cars
            thisrRoundTotalResult(cars);
        }
    }
}
