package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {
    private static final String INPUT_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String NAME_DELIMITER = ",";
    private static final String TRY_COUNT_MESSAGE = "시도할 회수는 몇회인가요?";

    public List<String> readName() {
        System.out.println(INPUT_NAME_MESSAGE);
        String names = Console.readLine();
        return Arrays.stream(names.split(NAME_DELIMITER)).collect(Collectors.toList());
    }

    public int readCount() {
        System.out.println(TRY_COUNT_MESSAGE);
        return inputNumber();
    }

    private int inputNumber() {
        try {
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수는 숫자여야 한다.");
        }
    }
}
