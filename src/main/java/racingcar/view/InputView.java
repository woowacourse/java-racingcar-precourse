package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {

    private static final String INPUT_CAR_NAMES = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";

    private InputView() {
    }

    public static List<String> inputCarNames() {
        System.out.println(INPUT_CAR_NAMES);
        return Arrays.stream(Console.readLine().split(","))
            .collect(Collectors.toList());
    }
}
