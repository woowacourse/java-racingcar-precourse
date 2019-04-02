/*
 * @Input.java  1.0 2019/04/02
 */

package domain;

import java.util.*;

/**
 * 자동차 객체 생성 클래스
 *
 * @version 1.00 2019년 4월 2일
 * @author 최훈하
 */


public class Input {

    static Car race_Car[];
    static Scanner scan = new Scanner(System.in);
    private static String[] car_Name_Enter;


    static String[] enter_Car_Name() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,) 기준으로 꾸분");

        car_Name_Enter = scan.nextLine().split(",");
        car_Name_Check();
        return car_Name_Enter;
    }
    /**
     *  car_Name_Check() car_Name_Enter의 글자 길이가 5 이상을 찾는다면 새로 입력하게 합니다.
     *  */
    private static void car_Name_Check() {
        for (int i = Forward_Util.ZERO; i < car_Name_Enter.length; i++){
            if (car_Name_Enter[i].length() > 5){
                name_Error();
                break;
            }
        }
    }

    private static void name_Error() {
        System.out.println("이름은 5자 이하만 가능합니다. 다시입력하세요");
        enter_Car_Name();
    }

    static void car_Object_Create () {
        race_Car = new Car[car_Name_Enter.length];
        for (int i = Forward_Util.ZERO; i < race_Car.length; i++) {
            race_Car[i] = new Car(car_Name_Enter[i]);
        }
    }


}
