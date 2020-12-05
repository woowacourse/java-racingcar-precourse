package racingcar;

import java.util.Arrays;
import java.util.List;

public class InputManager {
    public InputManager() {}

    public List<String> getCarList(String input) {
        List<String> carList;

        input = input.replace(" ", "");
        carList = (Arrays.asList(input.split(",")));
        return carList;
    }
}
