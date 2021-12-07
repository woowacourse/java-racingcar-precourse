package racingcar.view;

import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static List<String> requestCarInput() {
        List<String> result;
        String input;
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        input = Console.readLine();
        result = input;

        return result;
    }

    public static int requestTryCount() {
        String input;
        System.out.println("시도할 회수는 몇회인가요?");
        input = Console.readLine();
        return Integer.parseInt(input);
    }
}