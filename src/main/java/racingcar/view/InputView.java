package racingcar.view;

import racingcar.domain.NameController;

import java.util.Scanner;

public class InputView {

    private InputView() {

    }

    public static String[] getNames(Scanner scanner) {
        String[] names;
        while (true) {
            OutputView.getCarNames();
            String inputName = scanner.nextLine();
            names = NameController.splitNamebyComma(inputName);
            if (NameController.checkLengthOfName(names) && NameController.isDuplicatedName(names)) {
                break;
            }
            OutputView.printErrorMessageAboutName();
        }
        return names;
    }
}
