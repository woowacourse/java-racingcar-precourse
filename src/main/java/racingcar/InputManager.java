package racingcar;

import java.util.Arrays;
import java.util.List;

public class InputManager {
    public InputManager() {}

    public List<String> readCarList(String input) {
        input = input.replace(" ", "");
        return Arrays.asList(input.split(","));
    }

    public int readTrialNum(String trialsNum) throws IllegalArgumentException {
        if (!checkIfNumber(trialsNum)) {
            throw new IllegalArgumentException("[Error] 시도 횟수는 양의 정수로 입력합니다.");
        }

        if (Integer.parseInt(trialsNum) < 0) {
            throw new IllegalArgumentException("[Error] 시도 횟수는 양의 정수로 입력합니다.");
        }

        return Integer.parseInt(trialsNum);
    }

    private boolean checkIfNumber(String trialsNum) {
        for (int i = 0; i < trialsNum.length(); i++) {
            if (!Character.isDigit(trialsNum.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}
