package utils;

import java.util.Scanner;

public class InputUtil {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final int ZERO = 0;
    private static final String COMMA = ",";
    private static final String SPACE = " ";
    private static final String EMPTY = "";

    public static String[] inputRacingCars() {
        String inputCarNames = SCANNER.nextLine();
        // TODO : 여기서 검증하는 로직 추가
        validCommaNumber(inputCarNames);
        return inputCarNames.trim().replace(SPACE, EMPTY).split(COMMA);
    }

    public static int inputCount() {
        return SCANNER.nextInt();
    }

    private static void validCommaNumber(String carNames) {
        if (countComma(carNames) != carNames.split(COMMA).length + 1) {
            throw new IllegalArgumentException("쉼표를 너무 많이 사용하셨어요!");
        }
    }

    private static int countComma(String inputString) {
        return (int) inputString.chars()
                .filter(value -> value == COMMA.charAt(ZERO))
                .count();
    }
}
