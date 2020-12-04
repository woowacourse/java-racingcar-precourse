package racingcar;

import java.util.Scanner;

public class Application {
    private static final String splitString = ",";
    private static final String CAR_NAME_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String CAR_MOVE_ATTEMPT_COUNT_INPUT_MESSAGE = "시도할 회수는 몇회인가요?";
    private static final String CAR_MOVE_ATTEMPT_COUNT_ERROR_MESSAGE = "[ERROR] 시도 횟수는 숫자여야한다.";

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        // TODO 구현 진행
        RacingGame racingGame = new CarRacingGame();

        String[] carNames = inputCarNames(scanner);
        for (int i = 0; i < carNames.length; i++) {
            Car car = new Car(carNames[i]);
            car.carNameValidate();
            racingGame.addCar(car);
        }

        int carMoveAttemptCount = inputCarMoveAttemptCount(scanner);
        racingGame.startRacingGame(carMoveAttemptCount);

        racingGame.printWinner();
    }

    private static String[] inputCarNames(Scanner scanner) {
        System.out.println(CAR_NAME_INPUT_MESSAGE);
        String[] carNames = scanner.next().split(splitString);
        return carNames;
    }

    private static int inputCarMoveAttemptCount(Scanner scanner) {
        System.out.println(CAR_MOVE_ATTEMPT_COUNT_INPUT_MESSAGE);
        String input = scanner.next();
        int carMoveAttemptCount = carMoveAttemptCountValidate(input);
        return carMoveAttemptCount;
    }

    private static int carMoveAttemptCountValidate(String input) {
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (!Character.isDigit(c)) {
                System.out.println(CAR_MOVE_ATTEMPT_COUNT_ERROR_MESSAGE);
                throw new RuntimeException();
            }
        }
        return Integer.parseInt(input);
    }
}
