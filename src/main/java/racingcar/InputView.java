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
        String[] inputCars = input.split(CAR_REGEX);
        return Arrays.stream(inputCars).collect(Collectors.toList());
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
