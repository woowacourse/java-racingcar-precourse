import domain.Car;

import java.util.ArrayList;

public class RacingGame {
    private ArrayList<Car> cars;
    private final int trials;

    public RacingGame(ArrayList<Car> cars, int trials) {
        this.cars = cars;
        this.trials = trials;
    }

    public void play() {
        System.out.println("RacingGame play called");
    }
}
