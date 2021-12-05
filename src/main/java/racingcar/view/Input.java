package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    private static final String INPUT_CAR_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_TRY_MESSAGE = "시도할 회수는 몇회인가요?";

    public Input() {
    }

    public static String inputCarNames() {
        System.out.println(INPUT_CAR_MESSAGE);

        String carValue = Console.readLine();
        return carValue;
    }

    public static String inputTry() {
        System.out.println(INPUT_TRY_MESSAGE);

        String tryValue = Console.readLine();
        return tryValue;
    }

}
