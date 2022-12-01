package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class InputView {

    public static final String CAR_REGEX = ",";
    private static final String ONLY_NUMBER_REGEX = "^[0-9]+$";

    public List<String> inputCars() {
        System.out.println(Message.INPUT_CAR_MESSAGE);
        String input = Console.readLine();
        validateInputCars(input);
        String[] inputCars = input.split(CAR_REGEX);
        return Arrays.stream(inputCars).collect(Collectors.toList());
    }

    private void validateInputCars(String input) {
        if (input.endsWith(CAR_REGEX)) {
            throw new IllegalArgumentException(Message.CAR_NAME_VALIDATION);
        }

        String[] inputCars = input.split(CAR_REGEX);
        for (String inputCar : inputCars) {
            if (inputCar.length() > Car.MAX_NAME_LENGTH) {
                throw new IllegalArgumentException(Message.CAR_NAME_VALIDATION);
            }
        }
    }

    public int inputMoveCounts() {
        System.out.println(Message.INPUT_MOVE_COUNTS_MESSAGE);
        String input = Console.readLine();
        validateNumber(input);
        return Integer.parseInt(input);
    }

    private void validateNumber(String input) {
        if (!Pattern.matches(ONLY_NUMBER_REGEX, input)) {
            throw new IllegalArgumentException(Message.INPUT_NUMBER_ERROR);
        }
    }
}
