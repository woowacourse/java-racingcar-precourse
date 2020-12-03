package racingcar.view;

import racingcar.domain.NameController;
import racingcar.domain.Trial;

import java.util.Scanner;

public class InputView {

    private InputView() {

    }

    public static String[] getNames(Scanner scanner) {
        String[] names;
        while (true) {
            OutputView.getCarNames();
            String inputName = scanner.nextLine();
            names = NameController.splitNameByComma(inputName);
            if (NameController.isEmptyString(names) &&
                    NameController.checkLengthOfEachName(names) &&
                    NameController.isDuplicatedName(names)) {
                break;
            }
            OutputView.printErrorMessageAboutName();
        }
        return names;
    }

    public static Trial getTrials(Scanner scanner) {
        Trial trial;
        while (true) {
            OutputView.getTrials();
            String inputNumber = scanner.nextLine();
            if (Trial.isValidateNumber(inputNumber) && Trial.isMoreThanZero(inputNumber)) {
                trial = new Trial(inputNumber);
                return trial;
            }
            OutputView.printErrorMessageAboutTrial();
        }
    }
}
