package racingcar.view;

import java.util.Scanner;

public class InputView {

    private InputView() {

    }

    public String getNames(Scanner scanner) {
        OutputView.getCarNames();
        String names = scanner.nextLine();
        return names;
    }
}
