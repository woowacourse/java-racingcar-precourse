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
import domain.Message;


public class GameController {

    private void inputCarName() {
        String[] carArray;
        do {
            Scanner scanner = new Scanner(System.in);
            System.out.println(Message.INPUT_CAR_NAME_MESSAGE.getMessage());
            String carNames = scanner.nextLine();
            carNames = carNames.replace(" ","");
            carArray = carNames.split(",");
        } while (!InputExceptionController.getInstance().validateCarName(carArray));
    }

    public void run(){
        inputCarName();
    }

}
