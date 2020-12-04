package racingcar;

import java.util.List;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars){
        this.cars = cars;
    }

    public void tryMoveAll(){
        cars.stream().forEach(Car::tryMove);
    }

    public void printCarsPosition(){
        cars.stream().forEach(Car::printPosition);
    }
}
