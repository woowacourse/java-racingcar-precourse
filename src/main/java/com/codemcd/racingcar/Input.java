package com.codemcd.racingcar;

import java.util.Scanner;

public class Input {

    public String[] inputCarName() {

        Scanner scanner = new Scanner(System.in);
        String carNames;
        String[] splitedNames;
        System.out.println("경주할 자동차의 이름을 입력하세오(이름은 쉼표(,) 기준으로 구분");
        while (true) {
            carNames = scanner.nextLine();
            if (InputError.isInputCarNameFormat(carNames)) {
                carNames = InputError.removeFirstAndLastComma(carNames);
                splitedNames = carNames.split(",");
                return splitedNames;
            }
        }
    }

    public int inputHowManyMove() {

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
