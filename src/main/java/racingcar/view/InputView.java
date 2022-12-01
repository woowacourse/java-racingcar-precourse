package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {

    public List<String> readName() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String names = Console.readLine();
        return Arrays.stream(names.split(",")).collect(Collectors.toList());
    }

    public int readCount() {
        System.out.println("시도할 회수는 몇회인가요?");
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
