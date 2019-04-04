/*
 * @class       UserInput class
 * @version     1.0.0
 * @date        19.04.04
 * @author      OHSANG SEO (tjdhtkd@gmail.com)
 * @brief       receive user input and verify.
 */

package domain;

import java.util.*;

public class UserInput {
    public static final String GUIDE_INPUT_CAR_NAME = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    public static final String GUIDE_INPUT_MOVING_NUMBER = "시도할 회수는 몇회인가요?";
    public static final String REGEX_CAR_NAME = "";
    public static final String REGEX_MOVING_NUMBER = "";

    public String[] enterCar() {
        Scanner sc = new Scanner(System.in);
        String nameList;

        do {
            System.out.println(GUIDE_INPUT_CAR_NAME);
            nameList = sc.nextLine().replace(" ", "");
        } while (!(checkFormat(nameList, REGEX_CAR_NAME) && checkDuplication(nameList)));

        return nameList.split(",");
    }

    public int enterMovingNumber() {
        Scanner sc = new Scanner(System.in);
        String number;

        do {
            System.out.println(GUIDE_INPUT_MOVING_NUMBER);
            number = sc.nextLine().replace(" ", "");
        } while (!checkFormat(number, REGEX_MOVING_NUMBER));

        return Integer.parseInt(number);
    }

    public boolean checkFormat(String nameList, String regex) {
        return false;
    }

    public boolean checkDuplication(String nameList) {
        return false;
    }
}
