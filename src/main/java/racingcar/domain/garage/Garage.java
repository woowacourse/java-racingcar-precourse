package racingcar.domain.garage;

import racingcar.domain.car.Car;
import racingcar.domain.result.RacingResult;
import racingcar.domain.round.Round;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
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

    public String whereAreCars() {
        StringBuilder roundResult = new StringBuilder();

        for (Car car : carList) {
            roundResult.append(car.whereIsIt() + '\n');
        }

        return roundResult.toString();
    }

    public String whichWin() {
        Collections.sort(carList);
        Car first = carList.get(0);

        return RacingResult.from(carList.stream()
                .filter(target -> first.isSamePosition(target))
                .collect(Collectors.toCollection(LinkedList::new)));
    }

    public void playAll() {
        for (Car car : carList) {
            playEach(car);
        }
    }

    private void playEach(Car car) {
        if (Round.canMove(Round.draw())) {
            car.move();
        }
    }
}
