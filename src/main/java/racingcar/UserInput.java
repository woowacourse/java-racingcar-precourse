package racingcar;

import java.util.Scanner;

public class UserInput {
    private static final String NAME_SPLITTER = ",";

    public static String[] getCarNames(Scanner scanner) {
        UserScreen.askCarNames();
        String userString = scanner.nextLine();
        InputValidator.checkIfSplitterAtStartOrEnd(userString, NAME_SPLITTER);
        String[] carNames = userString.split(NAME_SPLITTER);
        InputValidator.checkEachCarNameLength(carNames);

        return carNames;
    }

    public static int getStageCount(Scanner scanner) {
        UserScreen.askStageCount();
        String userString = scanner.nextLine();
        InputValidator.checkIfNaturalNumber(userString);

        return Integer.parseInt(userString);
    }
}
