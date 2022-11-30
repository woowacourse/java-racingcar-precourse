package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {
    private static final String MESSAGE_INPUT_CARS = "경주할 자동차 이름을 입력하세요.";
    private static final String MESSAGE_INPUT_COUNT = "시도할 회수는 몇회인가요?";
    private final inputValidator validator = new inputValidator();

    public List<String> inputCars() {
        System.out.println(MESSAGE_INPUT_CARS);

        String input = Console.readLine();
        return createCarLists(input);
    }

    public List<String> createCarLists(String input) {
        return Arrays.stream(input.split(","))
                .collect(Collectors.toList());
    }

    public int inputMovingCount() {
        System.out.println(MESSAGE_INPUT_COUNT);

        String input = Console.readLine();
        validator.validateMovingCount(input);
        return Integer.parseInt(input);
    }

}
