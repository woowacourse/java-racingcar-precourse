package view;

import java.util.Scanner;

public class InputView {

    private static final String ASK_CAR_NAMES = "경주할 자동차 이름을 입력하세요.";
    private static final String TELL_CAR_NAME_SEPARATOR = "(이름은 쉼표(,) 기준으로 구분)";
    private static final String ASK_ROUND_COUNT = "시도할 횟수는 몇회인가요?";
    private final Scanner userInput;

    public InputView(Scanner userInput) {
        this.userInput = userInput;
    }

    public String getInput() {
        return userInput.nextLine();
    }

    public String getCarNames() {
        System.out.println(ASK_CAR_NAMES + TELL_CAR_NAME_SEPARATOR);
        return getInput();
    }

    public String getRoundCount() {
        System.out.println(ASK_ROUND_COUNT);
        return getInput();
    }
}
