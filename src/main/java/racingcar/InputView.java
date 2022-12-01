package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class InputView {

    public static final String CAR_REGEX = ",";
    private static final String ONLY_NUMBER_REGEX = "^[0-9]+$";

    public static final String INPUT_CAR_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    public static final String INPUT_MOVE_COUNTS_MESSAGE = "시도할 회수는 몇회인가요?";

    public List<String> inputCars() {
        System.out.println(INPUT_CAR_MESSAGE);
        String input = Console.readLine();
        validateInputCars(input);
        String[] inputCars = input.split(CAR_REGEX);
        return Arrays.stream(inputCars).collect(Collectors.toList());
    }

    private void validateInputCars(String input) {
        if (input.endsWith(CAR_REGEX)) {
            throw new IllegalArgumentException("자동차의 이름은 1~5자여야 합니다.");
        }

        String[] inputCars = input.split(CAR_REGEX);
        for (String inputCar : inputCars) {
            if (inputCar.length() > Car.MAX_NAME_LENGTH) {
                throw new IllegalArgumentException("자동차의 이름은 1~5자여야 합니다.");
            }
        }
    }

    public int inputMoveCounts() {
        System.out.println(INPUT_MOVE_COUNTS_MESSAGE);
        String input = Console.readLine();
        validateNumber(input);
        return Integer.parseInt(input);
    }

    private void validateNumber(String input) {
        if (!Pattern.matches(ONLY_NUMBER_REGEX, input)) {
            throw new IllegalArgumentException("숫자만 입력이 가능합니다.");
        }
    }
}
