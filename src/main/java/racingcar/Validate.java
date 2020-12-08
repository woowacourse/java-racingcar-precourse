package racingcar;

import java.util.ArrayList;
import java.util.Arrays;

public class Validate {

    private static final String ERR_PREFIX = "[Error]";
    private static final String ERR_MSG_IS_EMPTY = ERR_PREFIX + "글자를 입력해주세요.";
    private static final String ERR_MSG_ENDS_WITH_COMMA = ERR_PREFIX + "마지막이 쉼표로 끝납니다.";
    private static final String ERR_MSG_LONGER_THAN_MAX_CHARACTER = ERR_PREFIX + "차 이름은 5자 이하여야 합니다.";
    private static final String ERR_MSG_HAS_EMPTY_NAME = ERR_PREFIX + "비어있는 차 이름이 존재합니다.";
    private static final String ERR_MSG_HAS_DUPLICATE = ERR_PREFIX + "중복된 차 이름이 존재합니다.";
    private static final String ERR_MSG_IS_NOT_INT = ERR_PREFIX + "1 이상의 정수를 입력해주세요";
    private static final String ERR_MSG_LESS_THAN_ONE = ERR_PREFIX + "0보다 큰 정수를 입력해주세요";
    private static final int MAX_CAR_NAME_LENGTH = 5;

    public static ArrayList<String> validateCarName(String carString) throws IllegalArgumentException {
        carStringHasError(carString);
        ArrayList<String> tempCarList = new ArrayList<>(Arrays.asList(carString.split(",")));
        ArrayList<String> resultCarList = new ArrayList<>();

        for (int i = 0; i < tempCarList.size(); i++) {
            String car = tempCarList.get(i);
            carNameInListHasException(car, resultCarList);
            resultCarList.add(car);
        }
        return resultCarList;
    }

    public static void carStringHasError(String carNamesInput) {
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