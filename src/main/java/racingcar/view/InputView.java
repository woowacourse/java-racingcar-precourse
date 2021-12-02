package racingcar.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String INPUT_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_TRY_COUNT_MESSAGE = "시도할 회수는 몇회인가요?";
    private static final String SPLIT_REGEX = ",";

    public List<String> getNames() {
        System.out.println(INPUT_NAMES_MESSAGE);
        String inputNames = Console.readLine();
        String[] names = inputNames.split(SPLIT_REGEX);
        return new ArrayList<>(Arrays.asList(names));
    }

    public int getTryCount() {
        System.out.println(INPUT_TRY_COUNT_MESSAGE);
        String inputTryCount = Console.readLine();
        return Integer.parseInt(inputTryCount);
    }
}