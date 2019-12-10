/*
 * Copyright (c) 2019 by SorinJin
 * All rights reserved.
 *
 * OutputView.java
 * 출력을 담당하는 클래스
 *
 * @author      Sorin Jin
 * @version     1.0
 * @date        10 Dec 2019
 *
 */

package view;

import java.util.ArrayList;
import domain.Car;
import domain.Message;

public class OutputView {
    final String PRINT_STRING_FORMAT = "%-6s";
    final String COLON = ": ";
    final String SCORE = "-";
    final String SEPARATOR = ", ";

    public void printRoundResult(Car car) {
        System.out.printf(PRINT_STRING_FORMAT,car.getName());
        System.out.print(COLON);
        for (int i = 0; i < car.getPosition(); i++) {
            System.out.print(SCORE);
        }
        System.out.println();
    }

    public void printWinner(ArrayList<Car> winner) {
        int index = 0;
        int lastIndex = winner.size()-1;
        for (Car car : winner) {
            System.out.print(car.getName());
            if (index != lastIndex) {
                System.out.print(SEPARATOR);
                index++;
            }
        }
        System.out.println(Message.WINNER_MESSAGE.getMessage());
    }

    public void printRoundStart() {
        System.out.println(Message.RESULT_MESSAGE.getMessage());
    }

    public void printBlankLine() {
        System.out.println();
    }

}
