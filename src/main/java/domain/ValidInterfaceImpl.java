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

    /**
     * 자동차의 이름이 길이 5 이하 인지 검사.
     *
     * @param carNames 사용자 입력으로 받아온, 자동차 이름들.
     * @return 유효한 자동차 이름 판단 값.
     */
    @Override
    public boolean validCarName(String[] carNames) {
        for (String carName : carNames) {
            if (carName.length() > MAX_CAR_NAME_LENGTH)
                return false;
        }
        return true;
    }

    /**
     * Int 변환 불가, 양이 아닌 정수인지 검사.
     *
     * @param gameRepeatCounts 사용자 입력으로 받아온, 게임 횟수.
     * @return 유효한 횟수 판단 값.
     */
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
