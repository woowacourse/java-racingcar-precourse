package view;

import validation.CarNameValidator;
import validation.TryNumberValidator;

import java.util.Scanner;

public class InputView {
    private static final String CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String TRY_NUMBER_MESSAGE = "시도할 횟수는 몇 회인가요?";
    private static final String TRY_NUMBER_ERROR_MESSAGE = "[ERROR] 시도 횟수는 숫자여야 합니다.";

    private InputView() {
    }

    public static String getCarName(Scanner scanner) {
        System.out.println(CAR_NAME_MESSAGE);
        String carName = scanner.nextLine();
        try {
            CarNameValidator.validateCarName(carName);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            getCarName(scanner);
        }
        return carName;
    }

    public static int getTryNumber(Scanner scanner) {
        System.out.println(TRY_NUMBER_MESSAGE);

        while (!scanner.hasNextInt()) {
            scanner.next();
            System.out.println(TRY_NUMBER_ERROR_MESSAGE);
        }
        int tryNumber = scanner.nextInt();

        try {
            TryNumberValidator.validateTryNumber(tryNumber);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return tryNumber;
    }
}
