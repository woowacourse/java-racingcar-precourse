package racingcar.controller.input;


import java.util.Arrays;
import java.util.Scanner;

public class InputController {

    private static Scanner scanner;

    private static final String NAME_SEPARATOR = ",";
    private static final String INPUT_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_REPEAT_MESSAGE = "시도할 회수는 몇회인가요?";

    public InputController(Scanner scanner) {
        this.scanner = scanner;
    }

    public String[] inputNames() {
        System.out.println(INPUT_NAME_MESSAGE);

        String input = scanner.nextLine();
        String[] names = input.split(NAME_SEPARATOR);

        return names;
    }

    public int inputRepeatCount() {

        System.out.println(INPUT_REPEAT_MESSAGE);

        String input = scanner.nextLine();

        scanner.close();
        return Integer.parseInt(input);
    }


}
