package racingcar;

import java.util.ArrayList;
import java.util.Scanner;
import utils.ValidateUtils;

public class Race {
    public static final String INPUT_MESSAGE_FOR_CAR_NAMES =
            "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    public static final String INPUT_MESSAGE_FOR_TRY_COUNT = "시도할 회수는 몇회인가요?";
    private ArrayList<Car> cars;
    private int countOfTry;

    public Race() {
        cars = new ArrayList<>();
    }

    public void inputCarNamesWithComma(Scanner scanner) {
        printInputMessageForName();
        String[] carNames = splitCarNamesWithComma(scanner.nextLine());

        while (!ValidateUtils.validateCarNames(carNames)) {
            printInputMessageForName();
            carNames = splitCarNamesWithComma(scanner.nextLine());
        }

        initCars(carNames);
    }

    public void inputCountOfTry(Scanner scanner) {
        printInputMessageForTryCount();
        String input = scanner.next();
        while (!ValidateUtils.validateCountOfTry(input)) {
            printInputMessageForTryCount();
            input = scanner.next();
        }
        countOfTry = Integer.parseInt(input);
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

    private void printInputMessageForName() {
        System.out.println(INPUT_MESSAGE_FOR_CAR_NAMES);
    }

    private void printInputMessageForTryCount() {
        System.out.println(INPUT_MESSAGE_FOR_TRY_COUNT);
    }
}
