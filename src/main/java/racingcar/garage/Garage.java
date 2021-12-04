package racingcar.garage;

import racingcar.Car;
import racingcar.RacingResult;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

public class Garage {
    private final List<Car> carList;

    public Garage(List<Car> carList) {
        this.carList = carList;
    }

    public static Garage from(List<Car> carSet) {
        return new Garage(carSet);
    }

    public boolean containsCar(Car car) {
        return carList.contains(car);
    }

    public String getRoundResult() {
        StringBuilder stringBuilder = new StringBuilder();
        for(Car car : carList) {
            stringBuilder.append(car.whereIsIt() + '\n');
        }

        return stringBuilder.toString();
    }

    public String whichWin() {
        Collections.sort(carList);
        Car first = carList.get(0);

        Queue<Car> winners = carList.stream().filter(target -> first.isSamePosition(target))
                .collect(Collectors.toCollection(LinkedList::new));

        return RacingResult.from(winners);
    }
}
