package racingcar;

import java.util.Arrays;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class Player {
    private static final int MAX_NAME_LENGTH = 5;
    private static final int MIN_NAME_LENGTH = 1;
    private static final String MSG_INPUT_CAR_NAMES = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String MSG_INPUT_ATTEMPTS_NUM = "시도할 회수는 몇회인가요?";
    private static final String ERROR_INVALID_NAME_LENGTH = "[ERROR] 자동차 이름의 길이는 1이상 5이하여야 한다.";
    private static final String ERROR_ATTEMPT_NOT_NUMBER = "[ERROR] 시도 횟수는 숫자여야 한다.";

    public List<String> inputCarNames() {
        while (true) {
            try {
                System.out.println(MSG_INPUT_CAR_NAMES);
                List<String> names = Arrays.asList(Console.readLine().split(","));
                validateNameLength(names);
                return names;
            } catch (IllegalArgumentException e) {
                System.out.println(ERROR_INVALID_NAME_LENGTH);
            }
        }
    }

    public int inputNumberOfAttempts() {
        while (true) {
            try {
                System.out.println(MSG_INPUT_ATTEMPTS_NUM);
                return convertToPositiveInteger(Console.readLine());
            } catch (IllegalArgumentException e) {
                System.out.println(ERROR_ATTEMPT_NOT_NUMBER);
            }
        }
    }

    private void validateNameLength(List<String> names) throws IllegalArgumentException{
        if (names.isEmpty()) {
            throw new IllegalArgumentException();
        }
        for (String name : names) {
            if (name.length() > MAX_NAME_LENGTH || name.length() < MIN_NAME_LENGTH) {
                throw new IllegalArgumentException();
            }
        }
    }

    private int convertToPositiveInteger(String attempts) throws IllegalArgumentException{
        try {
            int converted = Integer.parseInt(attempts);
            if (converted < 1){
                throw new IllegalArgumentException();
            }
            return converted;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }
}
