package racingcar;

import java.util.ArrayList;
import java.util.Scanner;
import utils.ValidateUtils;

public class Race {
    public static final String INPUT_MESSAGE_FOR_CAR_NAMES =
            "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    public static final String INPUT_MESSAGE_FOR_TRY_COUNT = "시도할 회수는 몇회인가요?";
    public static final String DASH_STRING = "-";
    public static final String RESULT_OF_EXECUTION = "실행 결과";
    public static final String FINAL_WINNER = "최종 우승자: ";

    private ArrayList<Car> cars;
    private Rank rank;
    private Scanner scanner;
    private int countOfTry;

    public Race(Scanner scanner) {
        cars = new ArrayList<>();
        rank = new Rank();
        this.scanner = scanner;
    }

    public void inputCarNamesWithComma() {
        printInputMessageForName();
        String[] carNames = splitCarNamesWithComma(scanner.nextLine());

        while (!ValidateUtils.validateCarNames(carNames)) {
            printInputMessageForName();
            carNames = splitCarNamesWithComma(scanner.nextLine());
        }

        initCars(carNames);
    }

    public void inputCountOfTry() {
        printInputMessageForTryCount();
        String input = scanner.next();
        while (!ValidateUtils.validateCountOfTry(input)) {
            printInputMessageForTryCount();
            input = scanner.next();
        }
        countOfTry = Integer.parseInt(input);
    }

    public void startGame() {
        inputCarNamesWithComma();
        inputCountOfTry();
        printExecutionResultMessage();
        for (int count = 0; count < countOfTry; count++) {
            moveCars();
            printNameAndPosition();
        }
        printWinner();
    }

    private void printWinner() {
        ArrayList<String> winnerNames = rank.judgeWinner(cars);
        String winner = String.join(", ", winnerNames);
        System.out.println(winner);
    }

    private void moveCars() {
        for (Car car : cars) {
            car.move();
        }
    }

    private void printNameAndPosition() {
        for (Car car : cars) {
            String dash = convertPositionToDashString(car.getPosition());
            System.out.println(car.getName() + " : " + dash);
        }
        System.out.println();
    }

    private String convertPositionToDashString(int position) {
        StringBuilder sb = new StringBuilder();
        for (int count = 0; count < position; count++) {
            sb.append(DASH_STRING);
        }
        return sb.toString();
    }

    private void initCars(String[] carNames) {
        for (String name : carNames) {
            cars.add(new Car(name));
        }
    }

    private String[] splitCarNamesWithComma(String input) {
        String[] split = input.split(",");
        return split;
    }

    private void printExecutionResultMessage() {
        System.out.println(RESULT_OF_EXECUTION);
    }

    private void printInputMessageForName() {
        System.out.println(INPUT_MESSAGE_FOR_CAR_NAMES);
    }

    private void printInputMessageForTryCount() {
        System.out.println(INPUT_MESSAGE_FOR_TRY_COUNT);
    }
}
