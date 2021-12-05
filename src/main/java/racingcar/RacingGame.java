package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class RacingGame {
    private static final int MAX_NAME_LENGTH = 5;
    private static final int MIN_NAME_LENGTH = 1;
    private static final String MSG_INPUT_CAR_NAMES = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String MSG_INPUT_ATTEMPTS_NUM = "시도할 회수는 몇회인가요?";
    private static final String MSG_PRINT_EXECUTE_RESULT = "실행 결과";
    private static final String MSG_PRINT_WINNER = "최종 우승자 : ";
    private static final String ERROR_INVALID_NAME_LENGTH = "[ERROR] 자동차 이름의 길이는 1이상 5이하여야 한다.";
    private static final String ERROR_ATTEMPT_NOT_NUMBER = "[ERROR] 시도 횟수는 숫자여야 한다.";

    private final List<Car> cars;
    private int maxPosition;

    public RacingGame() {
        cars = new ArrayList<>();
        maxPosition = 0;
    }

    public void play() {
        createCarObjByName(inputCarNames());
        int numberOfAttempts = inputNumberOfAttempts();
        System.out.println(MSG_PRINT_EXECUTE_RESULT);
        while (numberOfAttempts-- > 0) {
            for (Car car : cars) {
                car.moveForward();
                printEachAttempts(car.getName(), car.getPosition());
                updateMaxPosition(car.getPosition());
            }
            System.out.println();
        }
        printWinner();
    }

    private void printWinner() {
        StringBuilder sb = new StringBuilder();
        sb.append(MSG_PRINT_WINNER);
        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                sb.append(car.getName());
                sb.append(", ");
            }
        }
        System.out.println(sb.substring(0, sb.length()-2));
    }

    private void updateMaxPosition(int position) {
        this.maxPosition = Math.max(maxPosition, position);
    }

    private void printEachAttempts(String name, int position) {
        System.out.print(name + " : ");
        while (position-- > 0) {
            System.out.print("-");
        }
        System.out.println();
    }

    private void createCarObjByName(List<String> carNameList) {
        for (String name : carNameList) {
            this.cars.add(new Car(name));
        }
    }

    private List<String> inputCarNames() {
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

    private void validateNameLength(List<String> names) throws IllegalArgumentException{
        for (String name : names) {
            if (name.length() > MAX_NAME_LENGTH || name.length() < MIN_NAME_LENGTH) {
                throw new IllegalArgumentException();
            }
        }
    }

    private int inputNumberOfAttempts() {
        while (true) {
            try {
                System.out.println(MSG_INPUT_ATTEMPTS_NUM);
                return convertToInteger(Console.readLine());
            } catch (IllegalArgumentException e) {
                System.out.println(ERROR_ATTEMPT_NOT_NUMBER);
            }
        }
    }

    private int convertToInteger(String attempts) throws IllegalArgumentException{
        try {
            return Integer.parseInt(attempts);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }
}
