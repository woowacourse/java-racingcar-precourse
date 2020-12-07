package racingcar.controller.input;


import racingcar.controller.view.ConsoleView;
import racingcar.controller.view.ViewController;
import racingcar.domain.setting.Message;
import racingcar.exception.DuplicateNameException;
import racingcar.exception.InvalidNameException;
import racingcar.exception.InvalidNumberException;

import java.util.Scanner;
import java.util.stream.Stream;

import static utils.Validator.validateNames;
import static utils.Validator.validateRepeat;

public class InputController {

    private static Scanner scanner;
    private static final ViewController viewController = ConsoleView.getInstance();

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
                    .map(String::trim)
                    .toArray(String[]::new);

            validateNames(names);
            return names;
        } catch (InvalidNameException | DuplicateNameException e) {
            viewController.printException(e);
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
            viewController.printException(e);
            return inputRepeatCount();
        } finally {
            scanner.close();
        }
    }


}
