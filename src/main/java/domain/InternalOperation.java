/*
 *@(#)InternalOperation.java           1.1 2019/04/04
 *Copyright (c) 2019 Hyogeon Kim.
 *Racing Car Game, Java, Mungyeong, KOREA
 */

package domain;

import java.util.Random;

/**
 * 자동차 경주 게임의 전반적인 내부 동작에 관련 된 클래스
 *
 * @author 김효건
 * @version 1.1 2019년 04월 04일
 */

public class InternalOperation {
        /*
         * 상수를 이용해 자동차 전진 여부를 결정할 난수 값을 발생하고
         * 우승자를 가리기 위한 최대 이동 수를 구하는 역할을 하는 클래스
         *  */

        /*난수 발생 최대값+1*/
        private static final int MAXRANDOMNUMBER = 10;

        /*난수 중 움직일 최솟값*/
        private static final int MINMOVENUMBER = 4;

        /*전진할지 정지할지를 결정하는 메서드*/
        public boolean isMove() {
                Random random = new Random();
                return random.nextInt(MAXRANDOMNUMBER) >= MINMOVENUMBER ? true : false;
        }

        /*최대로 이동한 위치를 구하는 메서드*/
        public int getMaxPosition(Car[] cars) {
                int max = -1;
                for (Car car : cars) {
                        max = compareOneCarPosition(car, max);
                }
                return max;
        }

        /*각각의 자동차에 대해 최대 전진 수보다 큰지 비교하는 메서드*/
        public int compareOneCarPosition(Car car, int max) {
                int position = car.getPosiotion();
                return position > max ? position : max;
        }
}
