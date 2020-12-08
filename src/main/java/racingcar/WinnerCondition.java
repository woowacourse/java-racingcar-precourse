package racingcar;

import java.util.ArrayList;
import java.util.List;

public class WinnerCondition {

    public Cars getWinners(Cars participants) {
        return new Cars(checkWinner(participants.getCars()));
    }

    private List<Car> checkWinner(List<Car> cars) {
        int max = getMaxPosition(cars);
        ArrayList<Car> winners = new ArrayList();
        for (Car car : cars) {
            if (car.getPosition() == max) {
                winners.add(car);
            }
        }
        return winners;
    }

    private int getMaxPosition(List<Car> cars) {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
    }
}
