/*
 * @Forward_Util.java    1.0 2019/04/02
 */

package domain;

import java.util.*;

/**
 * 자동차 전진 유틸리티 클래스
 *
 * @author 최훈하
 * @version 1.00 2019년 4월 2일
 */


public class Forward_Util {

    static int ZERO = 0;

    /* 시도 할 횟수 입력할 변수 */
    private static int count;

    private static int random_number;

    /* 자동자 최고 postion 값 저장 */
    static int max = ZERO;

    /* 우승자 저장 변수 */
    static String winner = "";

    /**
     * 각 자동차의 전진여부를 결정 및 position값 반환
     * 자동차 이름 출력
     * 각 자동차의 position만큼 전진상태를 dash로 출력
     */
    private static void race_Result() {
        for (int i = ZERO; i < Input.race_Car.length; i++) {
            Input.race_Car[i].Forward();
            System.out.print(Input.race_Car[i] + ":");
            Input.race_Car[i].forward_Status();
        }
        System.out.println();
    }

    static void try_Number() {
        System.out.println("시도할 회수는 몇회인가요?");
        count = Input.scan.nextInt();
    }

    static int random_Number_Create() {
        Random rand = new Random();
        random_number = rand.nextInt(10);
        return random_number;
    }

    /* 시도할 횟수 만큼 반복 메소드 */
    static void count_Repeat() {
        System.out.println("실행결과");
        for (int i = ZERO; i < count; i++) {
            race_Result();
        }
    }

    /* 각 자동차 중 1등 postion 값을 저장 메소드 */
    private static int winner_Max_Position() {
        max = Input.race_Car[ZERO].getPosition();
        for (int i = ZERO; i < Input.race_Car.length; i++) {
            if (max < Input.race_Car[i].getPosition()) {
                max = Input.race_Car[i].getPosition();
            }
        }
        return max;
    }

    /* 경주 자동차중 최고값과 비교하고 변수에 저장 후 반환 메소드 */
    private static String winner_Result() {
        for (int i = ZERO; i < Input.race_Car.length; i++) {
            if (Input.race_Car[i].getPosition() == winner_Max_Position()) {

                /* 우승자가 한명 이상일 경우 , 추가한다 */
                winner_Comma(i);
                winner += Input.race_Car[i].toString();
            }
        }
        return winner;
    }

    static void winner_Print() {
        System.out.println(winner_Result() + "가 최종 우승했습니다");
    }


    private static void winner_Comma(int i) {
        if ((!winner.equals("")) && i < Input.race_Car.length) {
            winner += ", ";
        }
    }

}
