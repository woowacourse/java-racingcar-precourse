package racingcar.controller.input;


import racingcar.domain.setting.Message;
import racingcar.exception.DuplicateNameException;
import racingcar.exception.InvalidNameException;
import racingcar.exception.InvalidNumberException;

import static utils.Validator.*;

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

        try {
            String input = scanner.nextLine();
            String[] names = Stream
                    .of(input.split(NAME_SEPARATOR))
                    .toArray(String[]::new);

            validateNames(names);
            return names;
        } catch (InvalidNameException | DuplicateNameException e) {
            System.out.println(e.getMessage());
            return inputNames();
        }


    }

    public int inputRepeatCount() {

        try {
            System.out.println(Message.INPUT_REPEAT_MESSAGE);

            String input = scanner.nextLine();

            validateRepeat(input);

            return Integer.parseInt(input);

        } catch (InvalidNumberException e) {
            System.out.println(e.getMessage());
            return inputRepeatCount();
        } finally {
            scanner.close();
        }
    }


}
