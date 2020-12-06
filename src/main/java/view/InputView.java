package view;

import validation.CarNameValidator;
import validation.TryNumberValidator;

import java.util.Scanner;

public class InputView {
    private InputView() {
    }

    public static String getCarName(Scanner scanner) {
        OutputView.showCarNameMessage();
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
        OutputView.showTryNumberMessage();

        while (!scanner.hasNextInt()) {
            scanner.next();
            OutputView.showTryNumberTypeErrorMessage();
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
