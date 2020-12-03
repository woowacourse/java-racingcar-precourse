package racingcar;

import java.util.Arrays;
import java.util.List;

public class CheckValidation {
    private static final String ERROR_MESSAGE = "[ERROR] : ";

    public static boolean carName(String userInput) {
        List<String> carList = stringToList(userInput);
        return checkValidList(carList);
    }

    public static List<String> stringToList(String userInput) {
        return Arrays.asList(userInput.split(","));
    }

    public static boolean checkValidList(List<String> carList) {
        return (checkNotSame(carList) && checkNotnull(carList) &&
                checkNameLength(carList) && checkContainBlank(carList));
    }

    public static boolean checkNotSame(List<String> carList) {
        String checkName = carList.get(0);
        for (int i = 1; i < carList.size(); i++) {
            if (carList.get(i).equals(checkName)) {
                throw new IllegalArgumentException(ERROR_MESSAGE + "중복된 이름이 존재합니다.");
            }
        }
        return true;
    }

    public static boolean checkNotnull(List<String> carList) {
        if (carList.size() <= 1 || carList == null) {
            throw new IllegalArgumentException(ERROR_MESSAGE + "두 대 이상의 자동차 이름을 입력해주세요.");
        }
        return true;
    }

    public static boolean checkNameLength(List<String> carList) {
        for (String carName : carList) {
            if (carName.length() > 5) {
                throw new IllegalArgumentException(ERROR_MESSAGE + "자동차 이름은 5글자를 넘을 수 없습니다.");
            }
        }
        return true;
    }

    public static boolean checkContainBlank(List<String> carList) {
        for (String carName : carList) {
            if(carName.contains(" ")) {
                throw new IllegalArgumentException(ERROR_MESSAGE + "이름엔 공백이 들어갈 수 없습니다.");
            }
        }
        return true;
    }

    public static boolean numberOfAttepmts(String attemptsInput) {
        return isNotnull(attemptsInput) && isNumber(attemptsInput);
    }

    public static boolean isNotnull(String input) {
        return input != null;
    }

    public static boolean isNumber(String input) {
        try {
            int parsedNum = Integer.parseInt(input);
            if (parsedNum <= 0) {
                throw new IllegalArgumentException(ERROR_MESSAGE + "올바른 숫자가 아닙니다.");
            }
        } catch (NumberFormatException error) {
            throw new IllegalArgumentException(ERROR_MESSAGE + "숫자만 입력 가능합니다.");
        }
        return true;
    }
}
