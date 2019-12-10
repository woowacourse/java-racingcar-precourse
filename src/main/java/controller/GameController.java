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


public class GameController {
    String[] carNameArray;

    private void inputCarName() {
        do {
            Scanner scanner = new Scanner(System.in);
            System.out.println(Message.INPUT_CAR_NAME_MESSAGE.getMessage());
            String carNames = scanner.nextLine();
            carNames = carNames.replace(" ","");
            carNameArray = carNames.split(",");
        } while (!InputExceptionController.getInstance().validateCarName(carNameArray));
    }

    private void generateCarObject() {
        int size = carNameArray.length;
        Car[] cars = new Car[size];
        for (int i = 0; i < size; i++) {
            cars[i] = new Car(carNameArray[i]);
        }
    }

    public void run(){
        inputCarName();
        generateCarObject();
    }

}
