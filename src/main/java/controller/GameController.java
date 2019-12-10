/*
 * Copyright (c) 2019 by SorinJin
 * All rights reserved.
 *
 * GameController.java
 * 게임을 진행하기 위한 클래스
 *
 * @author		Sorin Jin
 * @version		1.0
 * @date		09 Dec 2019
 *
 */

package controller;

import java.util.Scanner;
import domain.Car;
import domain.Message;
import domain.RandomGenerator;

public class GameController {

    public static final int GO_MIN_VALUE = 4;
    public static final int GO_MAX_VALUE = 9;
    private String[] carNameArray;
    private Car[] cars;
    private int round;

    private void inputCarName() {
        do {
            System.out.println(Message.INPUT_CAR_NAME_MESSAGE.getMessage());
            String carNames = new Scanner(System.in).nextLine();
            carNames = carNames.replace(" ","");
            carNameArray = carNames.split(",");
        } while (!InputExceptionController.getInstance().validateCarName(carNameArray));
    }

    private void generateCarObject() {
        int size = carNameArray.length;
        cars = new Car[size];
        for (int i = 0; i < size; i++) {
            cars[i] = new Car(carNameArray[i]);
        }
    }

    private void inputRound() {
        String numberOfRound;
        do {
            System.out.println(Message.INPUT_NUMBER_OF_ROUNDS_MESSAGE.getMessage());
            numberOfRound = new Scanner(System.in).next();
        } while (!InputExceptionController.getInstance().validateRoundNumber(numberOfRound));
        round = Integer.parseInt(numberOfRound);
    }

    private void play() {
        System.out.println(Message.RESULT_MESSAGE.getMessage());
        for(Car car : cars) {
            int randomNumber =  RandomGenerator.getInstance().getRandomNumber();
            car.setRandomNumber(randomNumber);
            car.play();
        }
        System.out.println();
    }

    public void run(){
        inputCarName();
        generateCarObject();
        inputRound();
        for(int i = 0; i < round; i++){
            play();
        }
    }

}
