package racingcar.game;

import java.util.ArrayList;
import java.util.List;
import racingcar.Car;

public class Cars {
    private static final int INDEX_OF_WINNER = 0;
    private static final int MIN_COUNT_OF_WINNER = 1;
    private static final String JOIN_DELIMITER = ", ";
    private final List<Car> cars;

    public Cars() {
        this.cars = new ArrayList<>();
    }

    public void createCar(String carName) {
        cars.add(new Car(carName));
    }

    public void startRacing(int tryTimes) {
        for (int i = 0; i < tryTimes; i++) {
            goForward();
            System.out.println();
        }
    }

    private void goForward() {
        for (Car car : cars) {
            car.goForwardRandomly();
            car.printCurrentState();
            System.out.println();
        }
    }

    public void findWinners() {
        cars.sort((o1, o2) -> -Integer.compare(o1.getPosition(), o2.getPosition()));
        int winnerPosition = cars.get(INDEX_OF_WINNER).getPosition();
        printWinnersName(winnerPosition);
    }

    private void printWinnersName(int winnerPosition) {
        String[] winnerNames = getWinners(winnerPosition);
        if (winnerNames.length == MIN_COUNT_OF_WINNER) {
            System.out.println(winnerNames[INDEX_OF_WINNER]);
            return;
        }
        if (winnerNames.length > MIN_COUNT_OF_WINNER) {
            System.out.println(String.join(JOIN_DELIMITER, winnerNames));
        }
    }

    private String[] getWinners(int winnerPosition) {
        List<String> winnerNames = new ArrayList<>();
        for (Car car : cars) {
            if (car.getPosition() == winnerPosition) {
                winnerNames.add(car.getName());
            }
            if (car.getPosition() < winnerPosition) {
                break;
            }
        }
        return winnerNames.toArray(new String[winnerNames.size()]);
    }
}
