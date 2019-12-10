/*
 * Copyright (c) 2019 by SorinJin
 * All rights reserved.
 *
 * GameController.java
 * 게임을 진행하기 위한 클래스
 *
 * @author      Sorin Jin
 * @version     1.0
 * @date        09 Dec 2019
 *
 */

package controller;

import java.util.ArrayList;
import domain.Car;
import domain.RandomGenerator;
import view.InputView;
import view.OutputView;

public class GameController {
    public static final int GO_MIN_VALUE = 4;
    public static final int GO_MAX_VALUE = 9;
    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();

    private Car[] generateCarObject(String[] carNameArray) {
        int size = carNameArray.length;
        Car[] cars = new Car[size];
        for (int i = 0; i < size; i++) {
            cars[i] = new Car(carNameArray[i]);
        }
        return cars;
    }

    private void play(Car[] cars) {
        for(Car car : cars) {
            int randomNumber =  RandomGenerator.getInstance().getRandomNumber();
            car.setRandomNumber(randomNumber);
            car.play();
            outputView.printRoundResult(car);
        }
        outputView.printBlankLine();
    }

    private int calculateBestScore(Car[] cars) {
        int bestScore = 0;
        for (Car car : cars) {
            if (car.getPosition() > bestScore) {
                bestScore = car.getPosition();
            }
        }
        return bestScore;
    }

    private void getWinner(Car[] cars) {
        int bestScore = calculateBestScore(cars);
        ArrayList<Car> winner = new ArrayList<>();
        for (Car car : cars) {
            if (car.getPosition() == bestScore) {
                winner.add(car);
            }
        }
        outputView.printWinner(winner);
    }

    public void run(){
        String[] carNameArray = inputView.inputCarName();
        Car[] cars = generateCarObject(carNameArray);
        int round = inputView.inputRound();
        outputView.printBlankLine();
        outputView.printRoundStart();
        for (int i = 0; i < round; i++) {
            play(cars);
        }
        getWinner(cars);
    }
}