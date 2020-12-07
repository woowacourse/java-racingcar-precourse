package racingcar;

import java.util.ArrayList;
import java.util.Arrays;

public class Validate {
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
        over5Character(car);
        hasNoName(car);
        hasDuplicate(carList, car);
    }

    public static void isEmptyLine(String userInput) {
        if (userInput.equals("")) {
            throw new IllegalArgumentException("[Error] 글자를 입력해주세요.");
        }
    }

    public static void endsWithComma(String userInput) {
        if (userInput.charAt(userInput.length() - 1) == ',') {
            throw new IllegalArgumentException("[Error] 쉼표로 구분된 차 목록을 입력해주세요.");
        }
    }

    public static void over5Character(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException("[Error] 차 이름은 5자 이하여야 합니다.");
        }
    }

    public static void hasNoName(String carName) {
        if (carName.length() < 1) {
            throw new IllegalArgumentException("[Error] 차 이름을 제대로 입력해주세요.");
        }
    }

    public static void hasDuplicate(ArrayList<String> cars, String car) {
        if (cars.contains(car)) {
            throw new IllegalArgumentException("[ERROR] 중복된 차이름이 존재합니다.");
        }
    }

    public static void isInteger(String numberString) {
        try {
            Integer.parseInt(numberString);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 1 이상의 정수를 입력해주세요");
        }
    }
}