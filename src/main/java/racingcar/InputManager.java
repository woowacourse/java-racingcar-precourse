package racingcar;

import java.util.Arrays;
import java.util.List;

public class InputManager {
    public InputManager() {}

    public List<String> readCarList(String input) {
        List<String> carList;

        input = input.replace(" ", "");
        carList = (Arrays.asList(input.split(",")));
        return carList;
    }
}
