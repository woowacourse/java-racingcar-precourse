package domain;

import java.util.Arrays;

public class InputCarNameCheck {

    public static boolean checkAllCarNameLength(String[] carNamesList) {
        for (String name : carNamesList) {
            if (!checkEachCarNameLength(name)) {
                return false;
            }
        }
        return checkCarNameDuplicate(carNamesList);
    }

    public static boolean checkAllCarNameHasBlank(String[] carNamesList) {
        for (String name : carNamesList) {
            if (!checkEachCarNameHasBlank(name)) {
                return false;
            }
        }
        return checkCarNameDuplicate(carNamesList);
    }

    public static boolean checkAllCarNameIsEmpty(String[] carNamesList) {
        for (String name : carNamesList) {
            if (!checkEachCarNameIsEmpty(name)) {
                return false;
            }
        }
        return checkCarNameDuplicate(carNamesList);
    }

    public static boolean checkEachCarNameLength(String name) {
        if (name.length() >= 1 && name.length() <= 5) {
            return true;
        }
        System.out.println("[ERROR] 자동차 이름은 1글자 이상 5글자 이하로 입력해야합니다.");
        return false;
    }

    public static boolean checkEachCarNameHasBlank(String name) {
        if (name.contains(" ")) {
            System.out.println("[ERROR] 자동차 이름에는 빈칸을 입력할 수 없습니다.");
            return true;
        }
        return false;
    }

    public static boolean checkEachCarNameIsEmpty(String name){
        if (name.equals("")) {
            return true;
        }
        System.out.println("[ERROR] 자동차 이름은 1개 이상의 문자여야 합니다.");
        return false;
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
}
