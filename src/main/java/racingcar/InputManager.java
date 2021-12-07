package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class InputManager {
    private final InputValidator inputValidator = new InputValidator();

    public String[] getCarNames() {
        String input = Console.readLine();
        String[] names = input.split(",");

        try {
            inputValidator.validateCarNamesInput(names);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getCarNames();
        }

        return names;
    }

    public int getTryCount() {
        String input = Console.readLine();

        try {
            inputValidator.validateTryCount(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getTryCount();
        }

        return Integer.parseInt(input);
    }
}
