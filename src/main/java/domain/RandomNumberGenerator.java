/**
 * RandomNumberGenerator 클래스는 자릿수에 걸맞는 임의의 난수 조합을 생성합니다.
 */
package domain;

import java.util.ArrayList;
import java.util.Random;

public class RandomNumberGenerator {
    private static int times;

    public RandomNumberGenerator(int passedTimes) {
        times = passedTimes;
    }

    /* 일정 범위 내 (본 문제에선 [0,9])의 값을 갖는 난수 생성 */
    public ArrayList<Integer> generate() {
        final int boundary = 10;
        ArrayList<Integer> target = new ArrayList<Integer>();

        Random random = new Random();
        random.setSeed(System.currentTimeMillis());

        for (int i = 0; i < times; i++) {
            target.add(random.nextInt(boundary));
        }
        return target;
    }

    /* 생성된 난수가 임계 수치(본 문제에선 '4') 이상인지 확인, 이상일 경우 true 대입*/
    public ArrayList<Boolean> goNoGo() {
        final int boundary = 4;
        ArrayList<Boolean> direction = new ArrayList<Boolean>();
        ArrayList<Integer> target = generate();
        for (int i = 0; i < times; i++) {
            if (target.get(i) >= boundary) {
                direction.add(true);
                continue;
            }
            direction.add(false);
        }
        return direction;
    }

}
