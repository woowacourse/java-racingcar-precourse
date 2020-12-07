package racingcar.view;

import java.util.Scanner;

public class InputView {

    public static String getTrialCount(Scanner scanner) {
        String userTrialCount = scanner.nextLine();
        return userTrialCount;
    }

    public static String getUserNames(Scanner scanner) {
        String userNames = scanner.nextLine();
        return userNames;
    }
}
