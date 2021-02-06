package racingcar;

import utils.RandomUtils;
import java.util.Arrays;

public class Game {
    public Game(Car[] cars) {
        carScore(cars);
        Car.move(getScore());
        Arrays.stream(cars).forEach(e -> e.getName , ":" , e.getPosition * '-');
        printWinner(cars);
    }

    private void carScore(Car[] cars) {
        for (int i = 0; i < cars.length; i++) {
            if ( randomNum() >= 4)
                cars[i].getPosition++;
        }
    }

    private String printWinner(Car[] cars) {
        int max = 0;
        int winnerIndex = 0;
        for (int i = 0; i < cars.length; i++) {
            if (cars[i].getPosition > max) {
                max = cars[i].getPosition;
                winnerIndex++;
            }
        }
        return cars[winnerIndex].getName;
    }

    public int randomNum() {
        return RandomUtils.nextInt(0, 9);
    }
    public Object getScore() {
        if (randomNum() >= 4) { return 1; }

        return 0;
    }



}
