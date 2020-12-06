package racingcar.view;

import java.util.Scanner;

public class InputView {
    public static final String PLEASE_INPUT_CAR_NAME = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    public static final String PLEASE_INPUT_NUMBER_OF_ATTEMPTS = "시도할 회수는 몇회인가요?";
    private final Scanner scanner;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public String inputCarName() {
        System.out.println(PLEASE_INPUT_CAR_NAME);
        return scanner.nextLine();
    }

    public String inputNumberOfAttempts() {
        System.out.println(PLEASE_INPUT_NUMBER_OF_ATTEMPTS);
        return scanner.nextLine();
    }
}
