package domain;

import java.io.IOException;
import java.util.*;

public class RacingGame {
    private static final int TIME_TO_BREAK = 1000;
    private ArrayList<Car> cars;
    private int tries;
    private int maxLenOfName = 0;
    private int positionOfWinners = 0;

    public RacingGame(RacingGameConfig config) {
        cars = config.getCars();
        tries = config.getTries();
    }

    public RacingGameResult start() {
        calculateMaxLenOfName();        /* for alignedName() */

        System.out.println();
        System.out.println("실행 결과");
        pause();
        progressGame();

        return new RacingGameResult(cars, positionOfWinners);
    }

    public void calculateMaxLenOfName() {
        for (Car car : cars) {
            int lenOfName = car.getName().length();
            maxLenOfName = (lenOfName > maxLenOfName) ? lenOfName : maxLenOfName;
        }
    }

    public void progressGame() {
        for (int i = 0; i < tries; i++) {
            for (Car car : cars) {
                car.accelerate();
                System.out.println(getAlignedName(car) + " : "
                        + getDisplayOfPosition(car));

                updatePositionOfWinners(car);
            }
            System.out.println();
            sleep(TIME_TO_BREAK);
        }
    }

    public String getAlignedName(Car car) {
        String name = car.getName();
        return String.format("%-" + maxLenOfName + "s", name);
    }

    public String getDisplayOfPosition(Car car) {
        StringBuffer hyphens = new StringBuffer();
        for (int i = 0; i < car.getPosition(); i++) {
            hyphens.append("-");
        }
        return hyphens.toString();
    }

    public void updatePositionOfWinners(Car car) {
        int pos = car.getPosition();
        positionOfWinners = (pos > positionOfWinners) ? pos : positionOfWinners;
    }

    public void sleep(int timeToBreak) {
        try {
            Thread.sleep(timeToBreak);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void pause() {
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        RacingGameConfig config = new RacingGameConfig();
        RacingGame racingGame = new RacingGame(config);
        RacingGameResult racingGameResult = racingGame.start();
        racingGameResult.show();
    }
}
