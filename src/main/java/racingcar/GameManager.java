package racingcar;

import utils.RandomUtils;
import java.util.List;
import java.util.stream.Collectors;

public class GameManager {
    private static final String GAME_RESULT_MESSAGE = "실행 결과";
    private static final String POSITION_BAR = "-";
    private static final int FIRST_ROUND = 1;
    private static final int START_INCLUSIVE_NUMBER = 0;
    private static final int END_EXCLUSIVE_NUMBER = 10;
    private static final String WINNER_ANNOUCEMENT = "최종 우승자: ";
    private static final String WINNER_DELIMITER = ", ";

    private void moveCars(List<Car> cars) {
        cars.forEach(car -> {
                    int randomNumber = RandomUtils.nextInt(START_INCLUSIVE_NUMBER, END_EXCLUSIVE_NUMBER);
                    car.changePosition(randomNumber);
                });
    }

    private void announceCurrentStatus(List<Car> cars) {
        cars.forEach(car -> System.out.println(getCarPositionInformation(car)));
        System.out.println();
    }

    private String getCarPositionInformation(Car car) {
        return car.getName() + " : " + drawCarPositionPicture(car);
    }

    private String drawCarPositionPicture(Car car) {
        // generate progress bar of car position (e.g. "---")
        return new String(new char[car.getPosition()]).replace("\0", POSITION_BAR);
    }

    private int getMaxPosition(List<Car> cars) {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .getAsInt();
    }

    private String getWinners(List<Car> cars) {
        int maxPosition = getMaxPosition(cars);
        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .collect(Collectors.joining(WINNER_DELIMITER));
    }

    private void announceWinners(List<Car> cars) {
        String winners = getWinners(cars);
        System.out.println(WINNER_ANNOUCEMENT + winners);
    }

    public void startRacing(List<Car> cars, int numberOfRounds) {
        System.out.println(GAME_RESULT_MESSAGE);
        for (int round = FIRST_ROUND; round <= numberOfRounds; round ++) {
            moveCars(cars);
            announceCurrentStatus(cars);
        }
        announceWinners(cars);
    }
}
