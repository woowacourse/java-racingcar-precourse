/*
 * ValidInterfaceImpl Class
 *
 * @version 1
 *
 * @date 2019-04-02
 *
 * Copyright (c) 2019. Jihun oh
 * All rights reserved
 */


package domain;

import domain.interfaces.ValidInterface;

public class ValidInterfaceImpl implements ValidInterface {
    public static final int MAX_CAR_NAME_LENGTH = 5;

    @Override
    public boolean validCarName(String[] carNames) {
        for (String carName : carNames) {
            if (carName.length() > MAX_CAR_NAME_LENGTH)
                return false;
        }
        return true;
    }

    @Override
    public boolean validGameCount(String gameRepeatCounts) {
        int gameRepeatCount;

        try {
            gameRepeatCount = Integer.parseInt(gameRepeatCounts);
        } catch (Exception e) {
            return false;
        }
        if (gameRepeatCount <= 0)
            return false;
        return true;
    }
}
