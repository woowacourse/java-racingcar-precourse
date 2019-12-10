/*
 * Copyright (c) 2019 by SorinJin
 * All rights reserved.
 *
 * InputView.java
 * 입력을 담당하는 클래스
 *
 * @author      Sorin Jin
 * @version     1.0
 * @date        10 Dec 2019
 *
 */

package view;

import java.util.Scanner;
import controller.InputExceptionController;
import domain.Message;

public class InputView {
    final String SEPARATOR = ",";
    final String NONE = "";
    final String BLANK_SPACE = " ";

    public String[] inputCarName() {
        String[] carNameArray;
        do {
            System.out.println(Message.INPUT_CAR_NAME_MESSAGE.getMessage());
            String carNames = new Scanner(System.in).nextLine();
            carNames = carNames.replace(BLANK_SPACE,NONE);
            carNameArray = carNames.split(SEPARATOR);
        } while (!InputExceptionController.getInstance().validateCarName(carNameArray));
        return carNameArray;
    }

    public int inputRound() {
        String numberOfRound;
        do {
            System.out.println(Message.INPUT_NUMBER_OF_ROUNDS_MESSAGE.getMessage());
            numberOfRound = new Scanner(System.in).next();
        } while (!InputExceptionController.getInstance().validateRoundNumber(numberOfRound));
        int round = Integer.parseInt(numberOfRound);
        return round;
    }
}
