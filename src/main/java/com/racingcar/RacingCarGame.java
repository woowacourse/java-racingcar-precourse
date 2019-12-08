package com.racingcar;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * RacingCarGame
 *
 * @author hyochan
 * @version 0.0.1
 * @since 2019-12-06
 */


public class RacingCarGame {
    private List<Car> cars;
    private int count;
    public Output output = new Output();

    public void racingCarGame() {
        Input input = new Input();
        List<String> winner;

        this.cars = input.inputCarNames();
        count = input.inputCount();

        System.out.println("\n실행 결과");
        for (int i = 0; i < count; i++) {
            run();
        }
        winner = selectWinner();
        output.printWinner(winner);
        return;
    }

    public void run() {
        Iterator itr = this.cars.iterator();
        while (itr.hasNext()) {
            Car car = (Car) itr.next();
            randomAdvance(car);
            output.printCarPosition(car);
        }
        System.out.println();

    }

    public void randomAdvance(Car car) {
        int randNum = (int) (Math.random() * 10);
        if (randNum >= 4) {
            car.advance();
        }
    }

    public List<String> selectWinner() {
        int max = 0;
        List<String> winners = new ArrayList<>();
        Iterator itr = this.cars.iterator();
        while (itr.hasNext()) {
            Car car = (Car) itr.next();
            if (car.getPosition() < max) {
                continue;
            }
            if (car.getPosition() > max) {
                max = car.getPosition();
                winners.clear();
            }
            winners.add(car.getName());
        }
        return winners;
    }
}
