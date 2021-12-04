package racingcar.domain.result;

import racingcar.domain.car.Car;

import java.util.Queue;

public class RacingResult {
    public static String from(Queue<Car> carList) {
        StringBuilder winners = new StringBuilder();
        Car first = carList.poll();

        first.writeName(winners);

        while (!carList.isEmpty()) {
            winners.append(", ");
            carList.poll().writeName(winners);
        }

        return winners.toString();
    }
}
