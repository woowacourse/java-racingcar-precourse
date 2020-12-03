package racingcar;

import java.util.List;
import java.util.regex.Pattern;

public class Validator {
    private static final String ONE_CAR_ERROR = "[ERROR] 만들어진 자동차가 1개입니다.";
    private static final String STRANGE_NAME_ERROR = "[ERROR] 자동차 이름은 숫자,영문만 가능합니다.";
    private static final String CAR_NAME_LENGTH_ERROR = "[ERROR] 자동차 이름은 5자 이하만 가능합니다.";
    private static final String DUPLICATE_NAME_ERROR = "[ERROR] 중복된 자동차 이름이 있습니다.";
    private static final String ONLY_ENGLISH_NUMBER = "^[0-9a-zA-Z]*$";
    private static final int CAR_NAME_LENGTH = 5;
    
    public static void validateCarNames(List<String> splittedCarNames) {
        validateNameLength(splittedCarNames);
        validateSeparator(splittedCarNames);
        validateDuplicate(splittedCarNames);
        validateNullName(splittedCarNames);
    }

    private static void validateNameLength(List<String> splittedCarNames) {
        for (String carName : splittedCarNames) {
            isLongerThanCondition(carName.length());
        }
    }

    public static void validateSeparator(List<String> splittedCarNames) {
        if (splittedCarNames.size() == 1) {
            throw new IllegalArgumentException(ONE_CAR_ERROR);
        }
    }

    private static void validateDuplicate(List<String> splittedCarNames) {
        boolean duplicate = splittedCarNames.stream()
            .distinct()
            .count() != splittedCarNames.size();

        if (duplicate) {
            throw new IllegalArgumentException(DUPLICATE_NAME_ERROR);
        }
    }

    private static void validateNullName(List<String> splittedCarNames) {
        for(String carName:splittedCarNames){
            isNotEnglishAndNumber(carName);
        }
    }

    private static void isLongerThanCondition(int length) {
        if (length > CAR_NAME_LENGTH) {
            throw new IllegalArgumentException(CAR_NAME_LENGTH_ERROR);
        }
    }

    private static void isNotEnglishAndNumber(String carName) {
        if(!Pattern.matches(ONLY_ENGLISH_NUMBER, carName)) {
            throw new IllegalArgumentException(STRANGE_NAME_ERROR);
        }
    }
}
