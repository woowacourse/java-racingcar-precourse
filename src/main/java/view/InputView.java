package view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final String DELIMITER = ",";
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String EMPTY = "";

    public static List<String> inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세.(이름은 쉼표(,) 기준으로 구분)");
        String rawInput = SCANNER.nextLine();
        validateNames(rawInput);

        return Arrays.stream(rawInput.split(DELIMITER))
                .collect(Collectors.toList());
    }

    private static void validateNames(String rawInput) {
        if (rawInput == null || rawInput.trim().equals(EMPTY)) {
            throw new IllegalArgumentException("올바른 입력이 아닙니다.");
        }
    }

    public static int inputGameCount() {
        System.out.println("시도할 횟수는 몇회인가요?");
        try {
            return Integer.parseInt(SCANNER.nextLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자가 아닙니다.");
        }
    }
}
