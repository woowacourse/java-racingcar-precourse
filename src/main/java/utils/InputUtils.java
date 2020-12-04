package utils;

import java.util.Arrays;
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
}
