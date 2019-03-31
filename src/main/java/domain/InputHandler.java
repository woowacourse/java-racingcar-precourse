package domain;

import java.util.Scanner;
import java.util.regex.Pattern;

public class InputHandler {

    private final CarNameValidator carNameValidator;
    private final Scanner scanner;
    private static final String[] NULL_OBJECT = new String[0];

    public InputHandler() {
        carNameValidator = new CarNameValidator();
        scanner = new Scanner(System.in);
    }

    public String[] getCarNames() {
        while (true) {
            System.out.println("경주할 자동차 이름(5글자 이내)을 입력하세요. (이름은 쉼표(,) 기준으로 구분)");
            String input = scanner.nextLine();
            String[] carNames = getCarNamesIfValidInput(input);
            if (carNames != NULL_OBJECT) {
                return carNames;
            }
        }
    }

    String[] getCarNamesIfValidInput(String input) {
        String[] carNames = splitByComma(input);
        if (doesValidCarNames(carNames)) {
            return carNames;
        }
        return NULL_OBJECT;
    }

    boolean doesValidCarNames(String[] carNames) {
        for (String carName : carNames) {
            if (!carNameValidator.doesValidCarName(carName)) {
                System.out.println("잘못된 입력입니다.");
                return false;
            }
        }
        return true;
    }

    // TODO 성능을 위해 Pattern을 미리 컴파일해놓고 matcher를 사용하는 방식으로 구현할 것
    private String[] splitByComma(String input) {
        return input.split(",");
    }
}
