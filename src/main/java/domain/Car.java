/*
 *@(#)Car.java           1.0 2019/04/04
 *Copyright (c) 2019 Hyogeon Kim.
 *Racing Car Game, Java, Mungyeong, KOREA
 */

package domain;

/**
 * 자동차에 관련 된 클래스
 *
 * @author 김효건
 * @version 1.0 2019년 04월 04일
 */

public class Car {
        /* 자동차 위치 출력
         * 자동차 이름 출력
         * 1회 전진
         * 자동차 전진 수 반환
         * 구현
         *  */

        private final String name;
        private int position = 0;

        public Car(String name) {
                this.name = name;
        }

        /*전진한 위치를 출력하는 메서드*/
        public void printPosition() {
                for (int i = 0; i < this.position; i++) {
                        System.out.print("-");
                }
                System.out.println();
        }

        /*이름을 출력하는 메서드*/
        public void printName() {
                System.out.print(this.name);
        }

        /*자동차 1회 전진하는 메서드*/
        public void moveCar() {
                this.position++;
        }

        /*자동차의 전진 수를 반환하는 메서드*/
        public int getPosiotion() {
                return this.position;
        }
}
