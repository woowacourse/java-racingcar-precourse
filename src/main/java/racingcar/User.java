package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class User {
    static final String DIVISION_STRING = ",";
    static final String CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    static final String COUNTS_MESSAGE = "시도할 회수는 몇회인가요?";

    public int setAttemptCounts() {
        System.out.println(COUNTS_MESSAGE);
        String inputCountsByClient = Console.readLine();
        int attemptCounts;
        try {
            AttemptCountValidator.checkException(inputCountsByClient);
            attemptCounts = Integer.parseInt(inputCountsByClient);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            attemptCounts = setAttemptCounts();
        }
        return attemptCounts;
    }

    public List<String> setCarNames() {
        System.out.println(CAR_NAME_MESSAGE);
        String carNames = Console.readLine();
        List<String> carNameList = Arrays.stream(carNames.split(DIVISION_STRING))
                .collect(Collectors.toList());
        try {
            CarNameValidator.checkException(carNameList);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            carNameList = setCarNames();
        }
        return carNameList;
    }
}
