package racingcar;

import java.util.*;
import java.util.stream.Collectors;

public class GameSystem {
    private static final String DELIMITER = ",";
    private static final String CAR_NAME_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String NUMBER_OF_ROUNDS_INPUT_MESSAGE = "시도할 회수는 몇회인가요?";
    private static final String NON_INTEGER_NUMBER_OF_ROUNDS_INPUT_ERROR_MESSAGE = "[ERROR] 시도 횟수는 정수여야 합니다.";
    private static final String NEGATIVE_NUMBER_OF_ROUNDS_INPUT_ERROR_MESSAGE = "[ERROR] 시도 횟수는 양수여야 합니다.";
    private static final String REPLAY_OR_QUIT_INPUT_MESSAGE = "다시 시작하려면 1, 종료를 원하시면 2를 입력해주세요.";
    private static final String REPLAY_OR_QUIT_INPUT_ERROR_MESSAGE = "[ERROR] 1 혹은 2만 입력 가능합니다.";

    private static String[] getCarNames(Scanner scanner) {
        return scanner.nextLine().split(DELIMITER);
    }

    private static List<Car> getCarList(Scanner scanner) {
        return Arrays.stream(getCarNames(scanner))
                .map(Car::new)
                .collect(Collectors.toList());
    }

    private static Cars tryToCreateCars(Scanner scanner) {
        Cars cars = new Cars(Collections.emptyList());
        System.out.println(CAR_NAME_INPUT_MESSAGE);
        try {
            cars = new Cars(getCarList(scanner));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return cars;
    }

    public static Cars createCars(Scanner scanner) {
        Cars cars;
        // try to create Cars until all Car elements have valid car names
        do {
            cars = tryToCreateCars(scanner);
        } while (cars.getNumberOfCars() == 0);
        return cars;
    }

    private static void validatePositiveNumber(String numberOfRounds) throws IllegalArgumentException {
        int numberOfRoundsInput;
        try {
            numberOfRoundsInput = Integer.parseInt(numberOfRounds);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NON_INTEGER_NUMBER_OF_ROUNDS_INPUT_ERROR_MESSAGE);
        }
        if (numberOfRoundsInput < 0) {
            throw new IllegalArgumentException(NEGATIVE_NUMBER_OF_ROUNDS_INPUT_ERROR_MESSAGE);
        }
    }

    private static int getNumberOfRoundsInput(Scanner scanner) throws IllegalArgumentException {
        String numberOfRounds = scanner.nextLine();
        validatePositiveNumber(numberOfRounds);
        return Integer.parseInt(numberOfRounds);
    }

    public static int getNumberOfRounds(Scanner scanner) {
        int numberOfRounds = 0;
        boolean isValidNumberOfRounds = false;
        while(!isValidNumberOfRounds) {
            try {
                System.out.println(NUMBER_OF_ROUNDS_INPUT_MESSAGE);
                numberOfRounds = getNumberOfRoundsInput(scanner);
                isValidNumberOfRounds = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println();
        return numberOfRounds;
    }

    private static void validateIntegerForReplayOrQuitInput(String replayOrQuitInput) throws IllegalArgumentException {
        try {
            Integer.parseInt(replayOrQuitInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(REPLAY_OR_QUIT_INPUT_ERROR_MESSAGE);
        }
    }

    private static void validateOneOrTwoForReplayOrQuitInput(String replayOrQuitInput) throws IllegalArgumentException {
        int replayOrQuit = Integer.parseInt(replayOrQuitInput);
        if (replayOrQuit != 1 && replayOrQuit != 2) {
            throw new IllegalArgumentException(REPLAY_OR_QUIT_INPUT_ERROR_MESSAGE);
        }
    }

    private static int tryToGetReplayOrQuitInput(Scanner scanner) {
        System.out.println(REPLAY_OR_QUIT_INPUT_MESSAGE);
        String replayOrQuitInput = scanner.nextLine();
        try {
            validateIntegerForReplayOrQuitInput(replayOrQuitInput);
            validateOneOrTwoForReplayOrQuitInput(replayOrQuitInput);
            return Integer.parseInt(replayOrQuitInput);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return 0;
    }

    private static int getReplayOrQuitInput(Scanner scanner) {
        int replayOrQuitInput;
        do {
            replayOrQuitInput = tryToGetReplayOrQuitInput(scanner);
        } while (replayOrQuitInput == 0);
        return replayOrQuitInput;
    }

    public static void replayOrQuit(Scanner scanner) {
        int replayOrQuitInput = getReplayOrQuitInput(scanner);
        if (replayOrQuitInput == 1) {
            Application.main(null); // REPLAY
        }
        // OTHERWISE QUIT
    }
}
