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

    /**
     * 사용자에게 자동차들의 이름을 입력하라는 메시지를 출력하는 메소드
     */
    private static void nameEnterMsg() {
        System.out.print("경주할 자동차 이름을 입력하세요.");
        System.out.println("(이름은 쉼표(,) 기준으로 구분)");
    }

    /**
     * 사용자에게 시도할 회수를 입력하라는 멧기지를 출력하는 메소드
     */
    private static void timesEnterMsg() {
        System.out.println("시도할 회수는 몇회인가요?");
    }
}
