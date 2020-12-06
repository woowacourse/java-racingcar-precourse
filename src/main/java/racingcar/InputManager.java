package racingcar;

import java.util.Arrays;
import java.util.List;

public class InputManager {
    public InputManager() {}

    public static List<String> readCarList(String input) throws IllegalArgumentException {
        List<String> carList;
        input = input.replace(" ", "");

        carList = Arrays.asList(input.split(","));
        if (checkIfNoEmptyName(carList)) {
            throw new IllegalArgumentException("[Error] 빈 자동차 이름이 입력되었습니다.");
        }

        return carList;
    }

    private static boolean checkIfNoEmptyName(List<String> carList) {
        return carList.contains("");
    }

    public static int readTrialNum(String trialsNum) throws IllegalArgumentException {
        if (!checkIfNumber(trialsNum)) {
            throw new IllegalArgumentException("[Error] 시도 횟수는 양의 정수로 입력합니다.");
        }

        if (Integer.parseInt(trialsNum) < 0) {
            throw new IllegalArgumentException("[Error] 시도 횟수는 양의 정수로 입력합니다.");
        }

        return Integer.parseInt(trialsNum);
    }

    private static boolean checkIfNumber(String trialsNum) {
        for (int i = 0; i < trialsNum.length(); i++) {
            if (!Character.isDigit(trialsNum.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}
