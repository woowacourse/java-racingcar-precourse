import domain.Car;

import static domain.Car.*;

public class RacingGame {
    public static void main(String[] args){

        String[] getRacingCarNameArray = divideCarName(getCarName());
        Car[] racingCar = new Car[getRacingCarNameArray.length];

        racingCar = inputCarName(getRacingCarNameArray);

        runRacingGame(racingCar);
        showWinner(racingCar);
    }
}
