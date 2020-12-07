package racingcar;

import java.util.ArrayList;
import java.util.Arrays;

public class Validate {

    public static final String ERR_MSG_IS_EMPTY = "[Error] 글자를 입력해주세요.";
    public static final String ERR_MSG_ENDS_WITH_COMMA = "[Error] 마지막이 쉼표로 끝납니다.";
    public static final String ERR_MSG_LONGER_THAN_MAX_CHARACTER = "[Error] 차 이름은 5자 이하여야 합니다.";
    public static final String ERR_MSG_HAS_EMPTY_NAME = "[Error] 비어있는 차 이름이 존재합니다.";
    public static final String ERR_MSG_HAS_DUPLICATE = "[ERROR] 중복된 차 이름이 존재합니다.";
    public static final String ERR_MSG_IS_NOT_INT = "[ERROR] 1 이상의 정수를 입력해주세요";
    public static final String ERR_MSG_LESS_THAN_ONE = "[ERROR] 0보다 큰 정수를 입력해주세요";
    public static final int MAX_CAR_NAME_LENGTH = 5;

    public static ArrayList<String> validateCarName(String carNamesInput) throws IllegalArgumentException {
        carInputStringHasException(carNamesInput);
        ArrayList<String> tempCarList = new ArrayList<String>(Arrays.asList(carNamesInput.split(",")));
        ArrayList<String> resultCarList = new ArrayList<String>();

        for (int i = 0; i < tempCarList.size(); i++) {
            String car = tempCarList.get(i);
            carNameInListHasException(car, resultCarList);
            resultCarList.add(car);
        }
        return resultCarList;
    }

    public static void carInputStringHasException(String carNamesInput) {
        isEmptyLine(carNamesInput);
        endsWithComma(carNamesInput);
    }

    public static void carNameInListHasException(String car, ArrayList<String> carList) {
        over5Characters(car);
        hasNoName(car);
        hasDuplicate(carList, car);
    }

    public static void isEmptyLine(String userInput) {
        if (userInput.equals("")) {
            throw new IllegalArgumentException(ERR_MSG_IS_EMPTY);
        }
    }

    public static void endsWithComma(String userInput) {
        if (userInput.charAt(userInput.length() - 1) == ',') {
            throw new IllegalArgumentException(ERR_MSG_ENDS_WITH_COMMA);
        }
    }

    public static void over5Characters(String carName) {
        if (carName.length() > MAX_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException(ERR_MSG_LONGER_THAN_MAX_CHARACTER);
        }
    }

    public static void hasNoName(String carName) {
        if (carName.length() < 1) {
            throw new IllegalArgumentException(ERR_MSG_HAS_EMPTY_NAME);
        }
    }

    public static void hasDuplicate(ArrayList<String> cars, String car) {
        if (cars.contains(car)) {
            throw new IllegalArgumentException(ERR_MSG_HAS_DUPLICATE);
        }
    }

    public static Integer validateRound(String roundInput) throws IllegalArgumentException {
        Integer roundNumber = stringToNumber(roundInput);
        isBiggerThanZero(roundNumber);
        return roundNumber;
    }
    public static Integer stringToNumber(String numberString) {
        try {
            return Integer.parseInt(numberString);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERR_MSG_IS_NOT_INT);
        }
    }
    public static void isBiggerThanZero(Integer roundNumber) {
        if (roundNumber < 1) {
            throw new IllegalArgumentException(ERR_MSG_LESS_THAN_ONE);
        }
    }
}