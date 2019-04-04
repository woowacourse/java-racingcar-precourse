/*
 * @(#)Input.java
 * v2.0
 * 2019/04/03
 */

package com.codemcd.racingcar;

import java.util.Scanner;

/**
 * 사용자의 입력을 받는 클래스
 *
 * @author 박성범
 * @version v2.0
 */
public class Input {

    public static String[] inputCarName() {

        Scanner scanner = new Scanner(System.in);
        String inputCarName;
        String[] splitedName;
        System.out.println("경주할 자동차의 이름을 입력하세오(이름은 쉼표(,) 기준으로 구분");
        while (true) {
            inputCarName = scanner.nextLine();
            if (InputError.isInputCarNameFormat(inputCarName)) {
                inputCarName = InputError.removeFirstAndLastComma(inputCarName);
                splitedName = inputCarName.split(",");
                return splitedName;
            }
        }
    }

    public static int inputHowManyMove() {

        Scanner scanner = new Scanner(System.in);
        String inputNumber;
        int numberOfMove;
        System.out.println("시도할 횟수는 몇 회인가요?");
        while (true) {
            inputNumber = scanner.nextLine();
            if (InputError.isNumeric(inputNumber)) {
                numberOfMove = Integer.parseInt(inputNumber);
                return numberOfMove;
            }
            System.out.println("<오류> 잘못된 입력입니다. 숫자를 입력해주세요!");
        }
    }
}
