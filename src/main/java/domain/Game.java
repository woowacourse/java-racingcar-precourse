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

    /**
     * 자동차의 이름을 받고, 자동차 객체 생성.
     */
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

    /**
     * 각각의 자동차들을 랜덤하게 이동 또는 정지를 수행.
     *
     * @param carList : 모든 자동차들의 List
     */
    private void carsRandomlyForward(List<Car> carList) {
        for (Car car : carList) {
            if (isCarForward())
                car.moveForward(ONCE_MOVE_DISATANCE);
        }
    }

    /**
     * 랜덤으로 자동차가 이동할지 안 할지 결정한다.
     *
     * @return 자동차 행동에 대한 결정값.
     */
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

    /**
     * 자동차들의 최대 이동 거리를 기준으로 승리자 리스트를 생성.
     *
     * @return 승리 자동차 리스트를 받아온다.
     */
    private List<Car> getWinnerList() {
        List<Car> winnerCarList = new ArrayList<>();
        int maxCarPosition = getMaxCarPosition();

        for (Car car : carList) {
            int carPosition = car.getPosition();

            //최대 거리와 현재 자동차의 거리가 같으면 승리자에 추가.
            if (carPosition == maxCarPosition)
                winnerCarList.add(car);
        }
        return winnerCarList;
    }

    private int getMaxCarPosition() {
        int maxPosition = 0;

        for (Car car : carList) {
            int carPosition = car.getPosition();

            // 최대 위치보다 현재 차의 위치가 더 크면 갱신.
            if (maxPosition < carPosition)
                maxPosition = carPosition;
        }
        return maxPosition;
    }

}
