package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {

    public static final String CAR_REGEX = ",";

    public List<String> inputCars() {
        String input = Console.readLine();
        String[] inputCars = input.split(CAR_REGEX);
        return Arrays.stream(inputCars).collect(Collectors.toList());
    }
}
