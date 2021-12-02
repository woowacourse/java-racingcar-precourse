package racingcar;

import java.util.Arrays;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class UserInput {
    private List<String> names;

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

    private String[] readNames() {
        return Console.readLine().replaceAll(" ", "").split(",");
    }

    private void setNames(String[] input) {
        this.names = Arrays.asList(input);
    }

    public List<String> getNames() {
        return this.names;
    }
}
