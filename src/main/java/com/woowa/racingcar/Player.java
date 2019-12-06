package com.woowa.racingcar;

import java.util.Scanner;

public class Player {
    private Scanner s = new Scanner(System.in);

    Player() {}

    public String inputCarName() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return s.nextLine();
    }

    public int inputTime() {
        System.out.println("시도할 횟수는 몇회인가요?");
        return s.nextInt();
    }

    public void close() {
        s.close();
    }
}