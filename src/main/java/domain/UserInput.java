/*
 * @class       UserInput class
 * @version     1.0.0
 * @date        19.04.04
 * @author      OHSANG SEO (tjdhtkd@gmail.com)
 * @brief       receive user input and verify.
 */

package domain;

import java.util.*;
import java.util.regex.*;

public class UserInput {
    public static final String GUIDE_INPUT_CAR_NAME = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    public static final String GUIDE_INPUT_MOVING_NUMBER = "시도할 회수는 몇회인가요?";
    public static final String REGEX_CAR_NAME = "(\\s{0,})[a-zA-Z0-9]{1,5}((\\s{0,}),(\\s{0,})[a-zA-Z0-9]{1,5}(\\s{0,})){0,}";
    public static final String REGEX_MOVING_NUMBER = "(\\s{0,})[0-9]{1,}(\\s{0,})"; // "(\s{0,})" is for space.
    public static final String ERROR_MSG_FORMAT = "입력실패: 알맞은 형태로 입력해주세요.";
    public static final String ERROR_MSG_DUPLICATION = "입력실패: 이름이 중복되었습니다.";

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
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(nameList);

        if (matcher.matches()) {
            return true;
        }
        System.out.println(ERROR_MSG_FORMAT);
        return false;
    }

    public boolean checkDuplication(String nameList) {
        String[] names = nameList.split(",");
        Set<String> nameSet = new HashSet(Arrays.asList(names));

        if (names.length == nameSet.size()) {
            return true;
        }
        System.out.println(ERROR_MSG_DUPLICATION);
        return false;
    }
}
