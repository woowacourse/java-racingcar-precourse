package racingcar;

import java.util.ArrayList;
import java.util.List;

public class InputError {
    private static final String PRINT_BLANK_ERROR = "[ERROR] 자동차 이름에 공백은 사용이 불가능합니다.";
    private static final String PRINT_SIZE_ERROR = "[ERROR] 자동차 이름은 1자이상 5자이하만 가능합니다.";
    private static final String PRINT_DUPLICATE_ERROR = "[ERROR] 자동차 이름은 중복이 불가능합니다.";
    private static final String PRINT_INTEGER_ERROR = "[ERROR] 시도 횟수는 숫자여야 한다. (입력가능범위 : 1 ~ 2147483647)";
    private static final String PRINT_POSITIVENUMBER_ERROR = "[ERROR] 시도 횟수는 1이상의 양수여야 한다. (입력가능범위 : 1 ~ 2147483647)";

    public static boolean checkInputCarNames(String[] carNames) {
        return !haveBlankCarName(carNames) && isValidSizeCarName(carNames) && !isDuplicateName(carNames);
    }

    public static boolean checkInputNumber(String numberOfTimes) {
        return isInteger(numberOfTimes) && isPositiveNumber(numberOfTimes);
    }

    private static boolean haveBlankCarName(String[] carNames) {
        for (String carName : carNames) {
            if (carName.contains(" ")) {
                System.out.println(PRINT_BLANK_ERROR);
                return true;
            }
        }
        return false;
    }

    private static boolean isValidSizeCarName(String[] carNames) {
        for (String carName : carNames) {
            if (carName.length() <= 0 || carName.length() > 5) {
                System.out.println(PRINT_SIZE_ERROR);
                return false;
            }
        }
        return true;
    }

    private static boolean isDuplicateName(String[] carNames) {
        List<String> carList = subDuplicate(carNames);

        for (String carName : carNames) {
            if (!carList.contains(carName)) {
                carList.add(carName);
            }
        }

        if (carList.size() != carNames.length) {
            System.out.println(PRINT_DUPLICATE_ERROR);
            return true;
        }

        return false;
    }

    private static List<String> subDuplicate(String[] carNames) {
        List<String> carList = new ArrayList<>();
        for (String carName : carNames) {
            if (!carList.contains(carName)) {
                carList.add(carName);
            }
        }
        return carList;
    }

    private static boolean isInteger(String numberOfTimes) {
        try {
            Integer.parseInt(numberOfTimes);
        } catch (NumberFormatException ne) {
            System.out.println(PRINT_INTEGER_ERROR);
            return false;
        }
        return true;
    }

    private static boolean isPositiveNumber(String numberOfTimes) {
        if (Integer.parseInt(numberOfTimes) < 1) {
            System.out.println(PRINT_POSITIVENUMBER_ERROR);
            return false;
        }
        return true;
    }
}
