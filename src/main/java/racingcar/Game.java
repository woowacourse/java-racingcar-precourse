package racingcar;

import utils.RandomUtils;

import java.util.ArrayList;
import java.util.stream.IntStream;

public class Game {
    private final int MIN_RANDOM_NUMBER = 0;
    private final int MAX_RANDOM_NUMBER = 9;
    private ArrayList<Car> cars;

    public Game() {
        cars = new ArrayList<>();
    }

    public void enter(Car car) {
        cars.add(car);
    }

    public void play(int round) {
        IntStream.range(0,round).forEach(i -> playSingleRound(cars));
    }

    private void playSingleRound(ArrayList<Car> cars) {
        cars.forEach(this::playSingleRound);
    }

    private void playSingleRound(Car car) {
        if (randomGameNumber() <= 4) {
            car.move();
        }
    }

    private int randomGameNumber() {
        return RandomUtils.nextInt(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER);
    }
}
