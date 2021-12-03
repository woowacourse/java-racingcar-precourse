package racingcar;


import domain.Car;
import domain.CarList;
import domain.Turn;

import java.util.List;

public class Game {
    private List<Car> cars;
    private int turns;

    public Game(CarList cars, Turn turns){
        this.cars  = cars.getCarList();
        this.turns = turns.getTurns();
    }

    public void start(){
        for(int i = 0; i < turns; i++) {
            for (Car car : cars) {
                car.goOrStop();
            }
        }
    }

}
