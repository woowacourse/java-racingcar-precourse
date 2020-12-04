/*
 * Application.java
 *
 * version 1.0
 *
 * 2020/12/04
 *
 * Copyright (c) 2020 Junhyoung Park
 */

package racingcar;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        RacingGame racingGame = new RacingGame();
        racingGame.start(scanner);
    }
}
