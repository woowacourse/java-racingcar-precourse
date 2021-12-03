package racingcar;

import java.util.Arrays;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class UserInput {
    private List<String> names;
    private int attempt;

    public void inputNames() {
        try {
            System.out.println(Constant.PLEASE_INPUT_NAMES);
            String[] input = readNames();
            Validation.isValidNames(input);
            setNames(input);
        } catch (IllegalArgumentException e) {
            inputNames();
        }
    }

    public void inputAttempt() {
        try {
            System.out.println(Constant.PLEASE_INPUT_ATTEMPT);
            String input = Console.readLine();
            Validation.isValidAttempt(input);
            setAttempt(input);
        } catch (IllegalArgumentException e) {
            inputAttempt();
        }
    }

    private String[] readNames() {
        return Console.readLine().replaceAll(" ", "").split(",");
    }

    private void setNames(String[] input) {
        this.names = Arrays.asList(input);
    }

    public List<String> getNames() {
        return this.names;
    }

    private void setAttempt(String input) {
        this.attempt = Integer.parseInt(input);
    }

}
