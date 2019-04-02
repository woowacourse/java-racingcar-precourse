package domain;

import java.util.*;

public class Input {

    static Car race_Car[];
    static Scanner scan = new Scanner(System.in);
    private static String[] car_Name_Enter;

    /* */
    static String[] enter_Car_Name() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,) 기준으로 꾸분");

        car_Name_Enter = scan.nextLine().split(",");

        return car_Name_Enter;
    }

}
