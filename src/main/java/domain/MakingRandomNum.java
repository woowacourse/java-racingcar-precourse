/*
 *class: MakingRandomNum
 *
 * version: 3.0
 *
 * date: 2019.12.08
 *
 * 이 프로그램의 저작권은 정은석에게 있습니다.
 * Copyright 2019.12.08
 */

package domain;

import java.util.Random;

/**
 * 랜덤으로 숫자를 생성하는 기능을 갖은 class.
 * Car class의 forwordPosition() 매소드에서 사용.
 *
 * @author joseph415
 * @version 3.0 2019.12.08
 */
public class MakingRandomNum {
    Random randomInput = new Random();

    /**
     * 랜덤으로 숫자를 생성해서 4이상이면 전진 이하이면 전진하지못하게 boolean값을 return 한다.
     *
     * @return 4이상이면 true값을 리턴.
     */
    public boolean randomMakeNum() {
        int input;

        input = randomInput.nextInt(9) + 1;
        return input >= 4;
    }
}
