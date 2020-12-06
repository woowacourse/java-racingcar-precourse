package racingcar.controller.input;


import racingcar.domain.setting.Message;
import utils.Validator;

import java.util.Scanner;
import java.util.stream.Stream;

public class InputController {

    private static Scanner scanner;

    private static final String NAME_SEPARATOR = ",";

    public InputController(Scanner scanner) {
        this.scanner = scanner;
    }

    public String[] inputNames() {
        System.out.println(Message.INPUT_NAME_MESSAGE);

        String input = scanner.nextLine();
        String[] names = Stream
                .of(input.split(NAME_SEPARATOR))
                .toArray(String[]::new);

        Validator.validateNames(names);

        return names;
    }

    public int inputRepeatCount() {

        System.out.println(Message.INPUT_REPEAT_MESSAGE);

        String input = scanner.nextLine();

        Validator.validateRepeat(input);

        scanner.close();
        return Integer.parseInt(input);
    }


}
