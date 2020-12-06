package domain;

import java.util.Arrays;

public class InputCarNameCheck {

    public static boolean checkInputCarName(String carNames) {
        String[] carNamesList = carNames.split(",");
        for (String name : carNamesList) {
            if (!checkEachCarNameIsEmpty(name)) {
                System.out.println("[ERROR] 자동차는 1개 이상 입력되어야 합니다.");
                return false;
            }
            if (!checkEachCarNameLength(name)) {
                System.out.println("[ERROR] 자동차 이름은 1글자 이상 5글자 이하로 입력해야합니다.");
                return false;
            }
            if (!checkEachCarNameHasBlank(name)) {
                System.out.println("[ERROR] 자동차 이름에는 빈칸을 입력할 수 없습니다.");
                return false;
            }
        }
        if (!checkCarNameDuplicate(carNamesList)) {
            System.out.println("[ERROR] 자동차 이름은 중복 작성할 수 없습니다.");
            return false;
        }
        return true;
    }

    public static boolean checkEachCarNameLength(String name) {
        return name.length() >= 1 && name.length() <= 5;
    }

    public static boolean checkEachCarNameHasBlank(String name) {
        return !name.contains(" ");
    }

    public static boolean checkEachCarNameIsEmpty(String name){
        return !name.equals("");
    }

    public static boolean checkCarNameDuplicate(String[] carNames) {
        Arrays.sort(carNames);
        for (int i = 0; i < carNames.length - 1; i++) {
            if (carNames[i].equals(carNames[i + 1])) {

                return false;
            }
        }
        return true;
    }
}
