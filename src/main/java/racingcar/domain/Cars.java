package racingcar.domain;

import racingcar.message.Message;
import racingcar.util.CarOperator;

import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static racingcar.message.Message.*;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public void moveCars(CarOperator operator) {
        List<Integer> nowMove = operator.tempPosition();
        IntStream.range(0, cars.size()).forEach(index -> {
            cars.get(index).move((nowMove.get(index)));
        });
    }

    public String printCars() {
        return cars.stream().map(car -> car.toString() + ESCAPE_SEQUENCE.getMessage())
                .collect(Collectors.joining());
    }

    public int getMaxPosition() {
        return cars.stream().mapToInt(Car::getPosition).max()
                .orElseThrow(IllegalArgumentException::new);
    }

    public String getWinCar() {
        int max = getMaxPosition();
        StringJoiner joiner = new StringJoiner(DELIMITER.getMessage() + " ");
        IntStream.range(0, cars.size())
                .filter(i -> cars.get(i).getPosition() == max)
                .mapToObj(i -> cars.get(i).getName())
                .forEach(joiner::add);
        return joiner.toString();
    }

    public int getSize(){
        return cars.size();
    }
}
