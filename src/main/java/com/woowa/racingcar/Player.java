package com.woowa.racingcar;

import java.util.Scanner;

public class Player {
    private static Scanner s = new Scanner(System.in);

    Player() {}

    public static String inputCarName() {
        String name;

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        name = s.nextLine();

        return name;
    }

    public int inputTime() {
        int time;

        System.out.println("시도할 횟수는 몇회인가요?");
        time = s.nextInt();
        if(time < 0) {
            System.out.println("횟수는 음수가 될 수 없습니다. 다시 입력하세요.\n");
            return inputTime();
        }

        return time;
    }

    public void close() {
        s.close();
    }
}