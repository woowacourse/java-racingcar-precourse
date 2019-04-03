package domain;

import static domain.Car.getCarName;

public class RacingGame {
    public static void main(String[] args){

        Car cars = new Car(getCarName());
        Car[] racingCar = cars.inputCarName(cars.divideCarName(cars));
        DuringRace runningRace = new DuringRace();

        runningRace.runRacingGame(racingCar);
    }
}
