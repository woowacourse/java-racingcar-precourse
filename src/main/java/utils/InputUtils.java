package utils;

import java.util.Arrays;
import java.util.IllegalFormatException;
import java.util.Scanner;

public class InputUtils {
    private final Scanner scanner;

    private InputUtils(Scanner scanner) {
        this.scanner = scanner;
    }

    public static InputUtils of(Scanner scanner) {
        return new InputUtils(scanner);
    }

    private String getNextLine() {
        return scanner.nextLine();
    }

    public String[] getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carName = getNextLine();
        String[] carNames = splitByRest(carName);
        return carNames;
    }

    public int getTryCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        String tryCountString = getNextLine();
        int tryCount = stringToInt(tryCountString);
        validateTryCount(tryCount);
        return tryCount;
    }

    public String[] splitByRest(String carName) {
        String[] carNames = carName.split(",");
        validateSplitNames(carNames);
        return carNames;
    }

    private void validateSplitNames(String[] carNames) {
        Arrays.stream(carNames).forEach(carName -> {
            if (carName.equals("")) {
                throw new IllegalArgumentException("[ERROR] 연속된 쉼표는 허용하지 않습니다.");
            }
        });
    }

    private void validateTryCount(int tryCount) {
        if (tryCount < 1) {
            throw new IllegalArgumentException("[ERROR] 시도할 회수는 1이상 이어야 합니다.");
        }
    }

    private int stringToInt(String tryCount) {
        try {
            return Integer.parseInt(tryCount);
        } catch (NumberFormatException numberFormatException) {
            throw new NumberFormatException("[ERROR] 시도할 횟수는 숫자만 입력해주세요.");
        }
    }
}
