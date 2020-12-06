package racingcar.io;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import racingcar.domain.Car;

public class InputView {

    private static final int MAX_NAME_LENGTH = 5;
    private static final String RACING_CAR_NAME_REQUEST_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String RACING_CAR_NAME_SEPARATOR = ",";
    private static final String RACING_MOVE_COUNT = "시도할 회수는 몇회인가요?";
    public static Scanner scanner;

    public static List<Car> getCars() {
        System.out.println(RACING_CAR_NAME_REQUEST_MESSAGE);
        try {
            List<String> carNames = parseCarNameInput(scanner.nextLine());
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

    private static List<String> parseCarNameInput(String input) {
        input = input.replaceAll(" ", "");

        List<String> delimitedInputs = Arrays.asList(input.split(RACING_CAR_NAME_SEPARATOR, 0));
        List<String> paredInputs = new LinkedList<>();

        for (String delimitedInput : delimitedInputs) {
            if (delimitedInput.length() == 0) {
                throw new IllegalArgumentException("[ERROR] 자동차 이름은 쉼표(,)를 기준으로 구분되어야합니다.");
            } else if (delimitedInput.length() > MAX_NAME_LENGTH) {
                throw new IllegalArgumentException("[ERROR] 자동차 이름은 5자 이하여야합니다.");
            }
            paredInputs.add(delimitedInput);
        }
        return paredInputs;
    }

    public static int getRaceCount() {
        System.out.println(RACING_MOVE_COUNT);
        try {
            String input = scanner.nextLine();
            validateIsNumber(input);
            int raceCount = Integer.parseInt(input);
            validateMoreThanZero(raceCount);
            return raceCount;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return getRaceCount();
        }
    }

    private static void validateIsNumber(String input) {
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '-' || input.charAt(i) == '+') {
                continue;
            }
            if (!Character.isDigit(input.charAt(i))) {
                throw new IllegalArgumentException("[ERROR] 시도 횟수는 숫자여야 합니다.");
            }
        }
    }

    private static void validateMoreThanZero(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException("[ERROR] 시도 횟수는 0보다 커야합니다.");
        }
    }

}
