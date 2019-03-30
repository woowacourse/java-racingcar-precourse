/**
 * 클래스 설명
 *
 * @version
 * @author
 */

package domain;

import java.util.Random;

/**
 * 클래스이름.class        버젼 날짜
 *
 * <Copyright 2019. LeeNamJun. All rights reserved.>
 */

public class RacingManager {

    private static Random random = new Random();
    /**
     * 0~9 사이의 랜덤한 정수를 리턴해주는 메소드
     * @return 0~9 사의 랜덤한 정수
     */
    private static int getRndNum() {
        return random.nextInt(10);
    }
}
