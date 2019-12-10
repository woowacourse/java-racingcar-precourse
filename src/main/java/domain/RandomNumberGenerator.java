/**
 * RandomNumberGenerator 클래스는 임의의 난수 조합을 생성합니다.
 */

package domain;

import java.util.Random;

public class RandomNumberGenerator {
    private static Random random;

    public RandomNumberGenerator() {
        random = new Random();
        random.setSeed(System.currentTimeMillis());
    }

    /* 일정 범위 내 (본 문제에선 [0,9])의 값을 갖는 난수 생성 */
    public int generate() {
        final int boundary = 10;
        return random.nextInt(boundary);
    }

    /* 생성된 난수가 임계 수치(본 문제에선 '4') 이상인지 확인, 이상일 경우 true 대입*/
    public boolean goNoGo() {
        final int boundary = 4;
        if (generate() >= boundary) {
            return true;
        }
        return false;
    }

}
