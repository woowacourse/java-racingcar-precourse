package racingcar;

import utils.RandomUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static racingcar.MessageBox.FINAL_WINNER_MESSAGE;
import static racingcar.MessageBox.PROCESS_RESULT_MESSAGE;

public class Race {
    private final int attemptNum;
    private final List<Car> cars;

    public Race(List<Car> cars, int attemptNum) {
        this.cars = new ArrayList<>(cars);
        this.attemptNum = attemptNum;
    }

    public void raceStart() {
        int carsNum = cars.size();

        System.out.println(PROCESS_RESULT_MESSAGE);
        for (int i = 0; i < attemptNum; i++) {
            for (int j = 0; j < carsNum; j++) {
                Car car = cars.get(j);
                carTryMove(car);
                printCarCurrentLocation(car);
            }
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
        List<String> winners = getWinners();
        int winnerNum = winners.size();

        System.out.print(FINAL_WINNER_MESSAGE);

        for (int i = 0; i < winnerNum; i++) {
            if (i == winnerNum - 1) {
                System.out.print(winners.get(i));
                break;
            }
            System.out.print(winners.get(i) + ", ");
        }
    }

    private List<String> getWinners() {
        List<String> winners = new ArrayList<>();
        int maxPosition = 0;

        Collections.sort(cars);
        maxPosition = cars.get(0).getPosition();

        for (Car car : cars) {
            int position = car.getPosition();
            String carName = car.getName();

            if (position != maxPosition) {
                break;
            }
            winners.add(carName);
        }

        return winners;
    }

}
