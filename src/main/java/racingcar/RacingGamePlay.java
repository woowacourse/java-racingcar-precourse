package racingcar;

import java.util.ArrayList;

public class RacingGamePlay {

    private ArrayList<Car> racingCarsForThisTimes;

    public RacingGamePlay(ArrayList<Car> racingCarsForThisTimes) {
        this.racingCarsForThisTimes = racingCarsForThisTimes;
    }

    public void runTimes(ArrayList<Car> racingCarsForThisTimes) {
        for (Car car : racingCarsForThisTimes) {
            car.moveCar();
            RacingGameSystemMessageOut.printEachMoves(car);
        }
        System.out.println();
    }
}

