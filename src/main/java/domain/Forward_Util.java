/*
 * @Forward_Util.java    1.0 2019/04/02
 */

package domain;

import java.util.*;

/**
 *
 * 자동차 전진 유틸리티 클래스
 *
 * @version 1.00 2019년 4월 2일
 * @author 최훈하
 */



public class Forward_Util {

    static int ZERO = 0;


    static void race_Result() {
        for (int i =ZERO; i < Input.race_Car.length; i++){
            System.out.print(Input.race_Car[i]+":");
        }
    }

}
