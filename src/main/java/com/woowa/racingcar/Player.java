package com.woowa.racingcar;

import java.util.Scanner;

public class Player {
    private Scanner s = new Scanner(System.in);

    Player() {}

    public String inputCarName() {
        return s.nextLine();
    }

    public int inputTime() {
        return s.nextInt();
    }

    public void close() {
        s.close();
    }
}