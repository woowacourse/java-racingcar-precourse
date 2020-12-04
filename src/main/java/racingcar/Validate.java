package racingcar;

import java.util.ArrayList;

public class Validate {
    public static boolean validateUserInput(String userInput, ArrayList<String> carList) throws IllegalArgumentException {
        if (endsWithComma(userInput)) {
            return false;
        }
        for (int i = 0; i < carList.size(); i++) {
            String car = carList.get(i);
            if (over5Character(car) || hasNoName(car)) {
                return false;
            }
        }
        return true;
    }

    public static boolean endsWithComma(String userInput) {
        if (userInput.charAt(userInput.length() - 1) == ',') {
            throw new IllegalArgumentException("[Error] 쉼표로 구분된 차 목록을 입력해주세요.");
        }
        return false;
    }

    public static boolean over5Character(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException("[Error] 차 이름은 5자 이하여야 합니다.");
        }
        return false;
    }

    public static boolean hasNoName(String carName) {
        if (carName.length() < 1) {
            throw new IllegalArgumentException("[Error] 차 이름을 제대로 입력해주세요.");
        }
        return false;
    }
}