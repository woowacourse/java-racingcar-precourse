/*
 * Game Class
 *
 * @version 1
 *
 * @date 2019-04-03
 *
 * Copyright (c) 2019. Jihun oh
 * All rights reserved
 */

package domain;

import domain.interfaces.UserInterface;
import domain.interfaces.ValidInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Game {
    public static final int ONCE_MOVE_DISATANCE = 1;
    public static final int RANDOM_NUM_LIMIT = 10;
    public static final int HURDLE_GO_STOP = 3;
    private UserInterface userinterface;
    private ValidInterface validInterface;
    private Random randomGenerator;
    private List<Car> carList;
    private int gameCount;

    public Game(UserInterface userinterface, ValidInterface validInterface) {
        this.randomGenerator = new Random();
        this.userinterface = userinterface;
        this.validInterface = validInterface;
        this.carList = new ArrayList<>();
    }

    public void run() {
        settingCars();
        settingGameCount();

        for (int loop = 0; loop < gameCount; loop++) {
            carsRandomlyForward(carList);
            printGameState();
        }
        printWinner();
    }

    private void settingCars() {
        String[] carNames = getNameByUser();
        makeCars(carNames);
    }

    private String[] getNameByUser() {
        String[] carNames = userinterface.inputCarName();

        while (!validInterface.validCarName(carNames)) {
            userinterface.alertInvalidCarName();
            carNames = userinterface.inputCarName();
        }
        return carNames;
    }

    private void makeCars(String[] carNames) {
        for (String carName : carNames)
            carList.add(new Car(carName));
    }

    private void settingGameCount() {
        this.gameCount = getGameCountByUser();
    }

    private int getGameCountByUser() {
        String gameCount = userinterface.inputGameCount();

        while (!validInterface.validGameCount(gameCount)) {
            userinterface.alertInvalidGameCount();
            gameCount = userinterface.inputGameCount();
        }
        return Integer.parseInt(gameCount);
    }

    private void carsRandomlyForward(List<Car> carList) {
        for (Car car : carList) {
            if (isCarForward())
                car.moveForward(ONCE_MOVE_DISATANCE);
        }
    }

    private boolean isCarForward() {
        int randNum = getRandomNumber();

        if (randNum <= HURDLE_GO_STOP)
            return false;
        return true;
    }

    private int getRandomNumber() {
        return randomGenerator.nextInt(RANDOM_NUM_LIMIT);
    }

    private void printGameState() {
        userinterface.printGameState(carList);
    }

    private void printWinner() {
        userinterface.printWinner(getWinnerList());
    }

    private List<Car> getWinnerList() {
        List<Car> winnerCarList = new ArrayList<>();
        int maxCarPosition = getMaxCarPosition();

        for (Car car : carList) {
            int carPosition = car.getPosition();

            if (carPosition == maxCarPosition)
                winnerCarList.add(car);
        }
        return winnerCarList;
    }

    private int getMaxCarPosition() {
        int maxPosition = 0;

        for (Car car : carList) {
            int carPosition = car.getPosition();

            if (maxPosition < carPosition)
                maxPosition = carPosition;
        }
        return maxPosition;
    }

}
