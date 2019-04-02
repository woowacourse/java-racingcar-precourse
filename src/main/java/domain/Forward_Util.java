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

    /*
    *
    * */
    private static void race_Result() {
        for (int i = ZERO; i < Input.race_Car.length; i++) {
            Input.race_Car[i].Forward();
            System.out.print(Input.race_Car[i] + ":");
            Input.race_Car[i].forward_Status();
        }
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

    static void count_Repeat() {
        System.out.println("실행결과");
        for (int i = ZERO; i < count; i++){
            race_Result();
        }
    }




}
