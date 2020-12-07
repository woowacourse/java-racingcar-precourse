package racingcar.view;

import java.util.Scanner;

public class View {
    private InputView inputView;

    public View(Scanner scanner) {
        inputView = new InputView(scanner);
    }

    public String[] askCarName() {
        while (true) {

            String[] names = inputView.askCarName();

            if (names != null) {
                return names;
            }

        }
    }
}
