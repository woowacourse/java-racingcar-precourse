package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.regex.PatternSyntaxException;

public class InputView {
    private static final String SEPARATOR = ",";

    public CarNames readCarNames() {
        System.out.println("경주할 자동차 이름을 입다력하세요.(이름은 쉼표(,) 기준으로 구분)\n");

        String[] carNames = split(read());
        validateEmpties(carNames);

        return CarNames.from(carNames);
    }

    public Coin readCoins() {
        System.out.println("시도할 회수는 몇회인가요?");

        return new Coin(
                parseInt(read())
        );
    }

    private String read() {
        String userInput = Console.readLine();
        validateEmpty(userInput);
        return userInput;
    }

    private String[] split(String input) {
        try {
            return input.split(SEPARATOR);
        } catch (PatternSyntaxException e) {
            throw new IllegalArgumentException("[ERROR] '?', '*', '+', '(', '{' 등 메타 문자는 이름으로 등록할 수 없습니다");
        }
    }

    private int parseInt(String input) {
        try {
            return Integer.parseInt(read());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 시도 횟수는 숫자가 입력돼야 합니다");
        }
    }

    private void validateEmpty(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 아무 값도 입력되지 않았습니다");
        }
    }

    private void validateEmpties(String[] inputs) {
        Arrays.stream(inputs)
                .forEach(s -> validateEmpty(s));
    }
}
