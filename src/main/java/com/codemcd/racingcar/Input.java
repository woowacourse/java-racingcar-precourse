package com.codemcd.racingcar;

import java.util.Scanner;

public class Input {

    public String[] inputCarName() {

        Scanner scanner = new Scanner(System.in);
        String carNames;
        String[] splitedNames;

        System.out.println("경주할 자동차의 이름을 입력하세오(이름은 쉼표(,) 기준으로 구분");
        carNames = scanner.nextLine();

        splitedNames = carNames.split(",");

        return splitedNames;
    }

    public int inputHowManyMove() {

        Scanner scanner = new Scanner(System.in);
        int numberOfMove;

        System.out.println("시도할 횟수는 몇 회인가요?");
        numberOfMove = scanner.nextInt();

        return numberOfMove;
    }
}
