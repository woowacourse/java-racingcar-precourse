package View;

import exceptions.Validator;

import java.util.Scanner;

public class InputView {

    private static final String INPUT_CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_NUMBER_OF_PROGRESS = "시도할 회수는 몇회인가요?";

    public static String inputCarName(Scanner scanner) {
        System.out.println(INPUT_CAR_NAME_MESSAGE);
        return scanner.nextLine();
    }

    public static int inputNumberOfProgress(Scanner scanner) {
        System.out.println(INPUT_NUMBER_OF_PROGRESS);
        String numberOfProgress = scanner.nextLine();
        Validator.validateNumberOfProgress(numberOfProgress);

        return Integer.parseInt(numberOfProgress);
    }

}
