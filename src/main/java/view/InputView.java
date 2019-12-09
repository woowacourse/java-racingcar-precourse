/*
 * InputView.java
 *
 * v 0.0.0
 *
 * 2019.12.06
 *
 * Copyright 2019. DunDung all rights reserved.
 */

package view;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String CARS_NAME = "경주할 자동차 이름을 입력해주세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String REPETITION_NUMBER = "시도할 회수는 몇회인가요?";
    private static final String NOT_INTEGER = "숫자가 아닙니다.";

    public String inputCarNames() {
        System.out.println(CARS_NAME);
        return scanner.nextLine();
    }

    public int inputRepetitionNumber() {
        try {
            System.out.println(REPETITION_NUMBER);
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_INTEGER);
        }
    }
}
