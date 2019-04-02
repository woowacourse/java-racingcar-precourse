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

    private void car_Name_Check() {
        for (int i = 0; i < car_Name_Enter.length; i++){
            if (car_Name_Enter[i].length() > 5){
                name_Error();
                break;
            }
        }
    }

    private void name_Error() {
        System.out.println("이름은 5자 이하만 가능합니다. 다시입력하세요");
        enter_Car_Name();
    }

}
