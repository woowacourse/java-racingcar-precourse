/*
 * Main.java
 * version 1.0
 * 2019.04.04
 * Copyright (c) 2019 Hyunji Choi
 * This program is made available under the terms of the MIT License.
 */

package racingcar;

import racingcar.util.Game;
import racingcar.util.Constants;

public class Main {
    public static void main(String[] args) {
        Game.getGameSettings();
        System.out.println(Constants.PRINT_RESULT_GUIDE);
        Game.playGame();
    }
}
