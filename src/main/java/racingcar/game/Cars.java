package racingcar.game;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import racingcar.Car;
import utils.RandomUtils;

public class Cars {
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
            int numberToGoForward = RandomUtils.nextInt(0, 9);
            car.goForward(numberToGoForward);
            car.printCurrentState();
            System.out.println();
        }
    }

    public void findWinners() {
        cars.sort(new Comparator<Car>() {
            @Override
            public int compare(Car o1, Car o2) {
                return -Integer.compare(o1.getPosition(), o2.getPosition());
            }
        });

        int winnerPosition = cars.get(0).getPosition();
        printWinnersName(winnerPosition);
    }

    private void printWinnersName(int winnerPosition) {
        String[] winnerNames = getWinners(winnerPosition);
        if (winnerNames.length == 1) {
            System.out.println(winnerNames[0]);
            return;
        }
        if (winnerNames.length > 1) {
            System.out.println(String.join(", ", winnerNames));
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
