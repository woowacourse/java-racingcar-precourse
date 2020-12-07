package racingcar.view;

import java.util.Scanner;

public class View {
    private InputView inputView;
    private OutputView outputView;

    public View(Scanner scanner) {
        inputView = new InputView(scanner);
        outputView = new OutputView();
    }

    public String[] askCarName() {
        while (true) {
            outputView.askCarName();
            String[] names = inputView.askCarName();

            if (names != null) {
                return names;
            }

            outputView.errorInvalidName();
        }
    }
}
