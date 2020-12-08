package racingcar.domains.output;

import racingcar.domains.Game.Game;
import racingcar.domains.car.Car;

import java.util.List;

public class GameStatus implements Output {
    private List<Car> cars;

    public GameStatus(List<Car> cars) {
        this.cars = cars;
    }

    @Override
    public void print() {
        cars.forEach(car -> {
            car.getStatus().print();
        });
        System.out.println();
    }
}
