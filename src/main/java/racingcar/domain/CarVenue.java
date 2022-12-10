package racingcar.domain;

import racingcar.util.CarOperator;
import racingcar.util.RandomNumberGenerate;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CarVenue {
    private final List<Car> cars;
    private final CarOperator carOperator;
    private final int finalRound;


    public CarVenue(List<Car> cars, int finalRound) {
        this.cars = cars;
        this.carOperator = new CarOperator(new RandomNumberGenerate(), cars.size());
        this.finalRound = finalRound;
    }

    public void moveTurn(){
        List<Integer> nowMove = carOperator.tempPosition();
        IntStream.range(0, cars.size()).forEach(index -> cars.get(index).move(nowMove.get(index)));
    }
    public String printTurn(){
        return cars.stream().map(car -> car.toString() + "\n").collect(Collectors.joining());
    }

}
