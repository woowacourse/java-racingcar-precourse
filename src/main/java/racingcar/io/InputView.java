package racingcar.io;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Pattern;
import racingcar.domain.Car;

public class InputView {

    private static final int MAX_NAME_LENGTH = 5;
    private static final String RACING_CAR_NAME_REQUEST_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String RACING_CAR_NAME_SEPARATOR = ",";
    private static final String RACING_MOVE_COUNT = "시도할 회수는 몇회인가요?";
    private static final String SEPARATE_ERROR_MESSAGE = "[ERROR] 자동차 이름은 쉼표(,)를 기준으로 구분되어야합니다.";
    private static final String CAR_NAME_LENGTH_MESSAGE = "[ERROR] 자동차 이름은 5자 이하여야합니다.";
    private static final String NOT_NUMBER_INPUT_ERROR_MESSAGE = "[ERROR] 시도 횟수는 숫자여야 합니다.";
    private static final String UNDER_ZERO_INPUT_ERROR_MESSAGE = "[ERROR] 시도 횟수는 0보다 커야합니다.";
    private static final String SPECIAL_CHARACTER_ERROR_MESSAGE = "[ERROR] 자동차 이름에 특수 문자는 허용되지 않습니다.";
    private static final String DUPLICATED_CAR_NAME_ERROR_MESSAGE = "[ERROR] 중복된 자동차 이름이 존재합니다.";
    public static Scanner scanner;

    public static List<Car> getCars() {
        System.out.println(RACING_CAR_NAME_REQUEST_MESSAGE);
        try {
            List<String> carNames = parseCarNames(scanner.nextLine());
            List<Car> cars = new LinkedList<>();
            for (int i = 0; i < carNames.size(); i++) {
                cars.add(new Car(carNames.get(i)));
            }
            return cars;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return getCars();
        }
    }

    private static List<String> parseCarNames(String input) {
        input = input.replaceAll(" ", "");
        validateContainSeparator(input);
        validateContainSpecialCharacters(input);

        List<String> carNames = Arrays.asList(input.split(RACING_CAR_NAME_SEPARATOR, 0));
        validateCanSeparated(carNames);
        validateContainDuplication(carNames);

        List<String> paredCarNames = new LinkedList<>();
        for (String carName : carNames) {
            validateLength(carName);
            paredCarNames.add(carName);
        }
        return paredCarNames;
    }

    public static void validateContainSeparator(String input) {
        if (!input.contains(RACING_CAR_NAME_SEPARATOR)) {
            throw new IllegalArgumentException(SEPARATE_ERROR_MESSAGE);
        }
    }

    public static void validateContainSpecialCharacters(String name) {
        if (!Pattern.matches("[0-9|a-z|A-Z|ㄱ-ㅎ|ㅏ-ㅣ|가-힝 | ,]*", name)) {
            throw new IllegalArgumentException(SPECIAL_CHARACTER_ERROR_MESSAGE);
        }
    }

    public static void validateCanSeparated(List<String> inputs) {
        for (String input : inputs) {
            if (input.length() == 0) {
                throw new IllegalArgumentException(SEPARATE_ERROR_MESSAGE);
            }
        }
    }

    public static void validateContainDuplication(List<String> names) {
        Set<String> set = new HashSet<>();

        for (String name : names) {
            if (set.contains(name)) {
                throw new IllegalArgumentException(DUPLICATED_CAR_NAME_ERROR_MESSAGE);
            }
            set.add(name);
        }
    }

    public static void validateLength(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(CAR_NAME_LENGTH_MESSAGE);
        }
    }

    public static int getRaceCount() {
        System.out.println(RACING_MOVE_COUNT);
        try {
            String input = scanner.nextLine();
            validateNumber(input);
            int raceCount = Integer.parseInt(input);
            validateOverZero(raceCount);
            return raceCount;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return getRaceCount();
        }
    }

    private static void validateNumber(String input) {
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '-' || input.charAt(i) == '+') {
                continue;
            }
            if (!Character.isDigit(input.charAt(i))) {
                throw new IllegalArgumentException(NOT_NUMBER_INPUT_ERROR_MESSAGE);
            }
        }
    }

    private static void validateOverZero(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException(UNDER_ZERO_INPUT_ERROR_MESSAGE);
        }
    }

}
