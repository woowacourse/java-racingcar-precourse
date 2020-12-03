package racingcar;

import java.util.Arrays;

public class InputCarNameCheck {

    public InputCarNameCheck() {

    }

    public static boolean checkInputCarName(String[] input) {

        if (checkAllCarNameLength(input)) {
            System.out.println(Arrays.toString(input));
            return true;
        }
        return false;
    }

    public static boolean checkAllCarNameLength (String[] carNames) {
        for (String name : carNames) {
            if (!checkEachCarNameLength(name)) {
                System.out.println("[ERROR] 자동차 이름은 5글자 이하로 입력해야합니다.");
                return false;
            }
        }
        return true;
    }

    public static boolean checkEachCarNameLength(String name) {
        return name.length() >= 1 && name.length() <= 5;
    }
}
