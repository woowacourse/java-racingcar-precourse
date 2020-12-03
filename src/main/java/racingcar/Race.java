package racingcar;

import utils.RandomUtils;

import java.util.ArrayList;
import java.util.List;

public class Race {
    private final int attemptNum;
    private final List<Car> cars;

    public Race(List<Car> cars, int attemptNum) {
        this.cars = new ArrayList<>(cars);
        this.attemptNum = attemptNum;
    }

    public void raceStart() {
        for (int i = 0; i < attemptNum; i++) {
            Car car = cars.get(i);
            carTryMove(car);
            printCarCurrentLocation(car);
            System.out.println();
        }
        winnerPrize();
    }

    private void carTryMove(Car car) {
        int fate = RandomUtils.nextInt(0, 10);
        if (fate <= 3) {
            return;
        }
        car.move();
    }

    private void printCarCurrentLocation(Car car) {
        StringBuilder curLocation = new StringBuilder();
        String carName = car.getName();
        int position = car.getPosition();

        for (int i = 0; i < position; i++) {
            curLocation.append("-");
        }

        System.out.println(carName + " : " + curLocation);
    }

    private void winnerPrize() {
        String[] winners = getWinners();
        int winnerNum = winners.length;

        System.out.print(MessageBox.FINAL_WINNER_MESSAGE);

        for (int i = 0; i < winnerNum; i++) {
            if (i == winnerNum - 1) {
                System.out.print(winners[i]);
                break;
            }
            System.out.print(winners[i] + ", ");
        }
    }

}
