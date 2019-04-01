/*
 * RacingGame.java    1.00 20190401
 *
 * Copyright (c) 2019 Hyeonyeong Baek.
 * All rights reserved.
 */
package domain;

import java.util.HashSet;
import java.util.Set;

public class RacingGame {
    private static final int MAX_NAME_LENGTH = 5;

    public void play() {
        String[] names = getNames();
    }

    private String[] getNames() {
        String input;
        String[] names;

        do {
            System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
            input = UserInput.getString();
            names = input.split(",");
        } while (!validateNames(names));

        return names;
    }

    private boolean validateNames(String[] names) {
        Set<String> uniqueNames = new HashSet<>();

        for (String name : names) {
            if ((name.length() > MAX_NAME_LENGTH) || (uniqueNames.contains(name))) {
                return false;
            }
            uniqueNames.add(name);
        }

        return true;
    }
}