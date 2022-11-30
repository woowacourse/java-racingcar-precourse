package racingcar.view;

import java.util.Arrays;
import java.util.List;
import racingcar.utils.InputValidator;
import camp.nextstep.edu.missionutils.Console;


public class InputView {

    public List<String> readPlayerName() throws IllegalArgumentException {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        InputValidator.notContainsComma(input);
        String[] inputList = InputValidator.moreThanLenFive(input);
        return Arrays.asList(inputList);
    }

    public int readGameRound() throws IllegalArgumentException {
        System.out.println("시도할 회수는 몇회인가요?");
        String input = Console.readLine();
        return InputValidator.notNumber(input);
    }
}
