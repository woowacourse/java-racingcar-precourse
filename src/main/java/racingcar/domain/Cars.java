package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    protected List<String> makeWinnerList(final List<Car> cars) {
        final List<String> winners = new ArrayList<>();
        Car winnerCarPosition = cars.get(0);

        for (Car car : cars) {
            if (car.isFaster(winnerCarPosition)) {
                winnerCarPosition = car;
            }
        }

        System.out.println(winnerCarPosition.getCarName());

        for (Car car : cars) {
            if (car.isWinner(winnerCarPosition)) {
                winners.add(car.getCarName());
            }
        }

        return winners;
    }

}
