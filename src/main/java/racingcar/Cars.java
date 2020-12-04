package racingcar;

import java.util.List;

public class Cars {
    private final List<Car> cars;
    private int firstPosition;

    public Cars(List<Car> cars){
        this.cars = cars;
        firstPosition =0;
    }

    public void tryMoveAll(){
        cars.stream().forEach(Car::tryMove);
        updateFirstPosition();
    }

    public void printCarsPosition(){
        cars.stream().forEach(Car::printPosition);
    }

    private void updateFirstPosition(){
        boolean needToUpdate = cars.stream()
                .anyMatch(car -> car.isFartherThan(this.firstPosition));

        if(needToUpdate){
            firstPosition++;
        }
    }
}
