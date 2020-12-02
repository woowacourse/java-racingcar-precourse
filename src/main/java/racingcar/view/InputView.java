package racingcar.view;

import racingcar.domain.NameController;

import java.util.Scanner;

public class InputView {

    private InputView() {

    }

    public static String[] getNames(Scanner scanner) {
        boolean stopFlag;
        String[] names;
        do {
            stopFlag = true;
            OutputView.getCarNames();
            String inputName = scanner.nextLine();
            names = NameController.splitNamebyComma(inputName);
            for (String name : names) {
                if (!NameController.checkLengthOfName(name)) {
                    stopFlag = false;
                    OutputView.printErrorMessageAboutLengthOfName();
                    break;
                }
            }
        } while (!stopFlag);
        return names;
    }
}
