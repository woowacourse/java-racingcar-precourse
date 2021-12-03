package racingcar;


import domain.Car;
import domain.CarList;
import domain.Turn;

public class Game {
    private CarList cars;
    private int turns;

    public Game(CarList cars, Turn turns){
        this.cars  = cars;
        this.turns = turns.getTurns();
    }

    public void start(){
        for(int i = 0; i < turns; i++) {
            for (Car car : cars.getCarList()) {
                car.goOrStop();
            }
        }
        cars.decideWinner();
    }

}
