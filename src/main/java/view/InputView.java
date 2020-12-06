package view;

import validation.CarNameValidator;

import java.util.Scanner;

public class InputView {
    private static final String CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";

    private InputView() {
    }

    public static String getCarName(Scanner scanner) {
        System.out.println(CAR_NAME_MESSAGE);
        String carName = scanner.next();
        try {
            CarNameValidator.validateCarName(carName);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            getCarName(scanner);
        }
        return carName;
    }
}
