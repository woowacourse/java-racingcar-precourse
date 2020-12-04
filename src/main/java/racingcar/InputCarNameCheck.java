package racingcar;

import java.util.Arrays;

public class InputCarNameCheck {

    public InputCarNameCheck() {

    }

    public static boolean checkInputCarName(String[] input) {
        if (!checkAllCarNameLength(input)) {
            System.out.println(Arrays.toString(input));
            return false;
        }
        if (!checkCarNameDuplicate(input)) {
            System.out.println(Arrays.toString(input));
            return false;
        }
        if (!checkAllCarNameHasBlank(input)) {
            System.out.println(Arrays.toString(input));
            return false;
        }

        return true;
    }

    public static boolean checkAllCarNameLength(String[] carNames) {
        for (String name : carNames) {
            if (!checkEachCarNameLength(name)) {
                System.out.println("[ERROR] 자동차 이름은 1글자 이상 5글자 이하로 입력해야합니다.");
                return false;
            }
        }
        return true;
    }

    public static boolean checkEachCarNameLength(String name) {
        return name.length() >= 1 && name.length() <= 5;
    }

    public static boolean checkCarNameDuplicate(String[] carNames) {
        Arrays.sort(carNames);
        for (int i = 0; i < carNames.length - 1; i++) {
            if (carNames[i].equals(carNames[i + 1])) {
                System.out.println("[ERROR] 자동차 이름은 중복 작성할 수 없습니다.");
                return false;
            }
        }
        return true;
    }

    public static boolean checkAllCarNameHasBlank(String[] carNames) {
        for (String name : carNames) {
            if (!checkEachCarNameHasBlank(name)) {
                System.out.println("[ERROR] 자동차 이름에는 빈칸을 입력할 수 없습니다.");
                return false;
            }
        }
        return true;
    }

    public static boolean checkEachCarNameHasBlank (String name){
        if (name.contains(" ")) {
            return false;
        }
        return true;
    }
}
