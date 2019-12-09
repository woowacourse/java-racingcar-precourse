package ui;

import java.util.Scanner;

public class InputControllerImpl implements InputController {

    private Scanner scanner;

    public InputControllerImpl(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public String nextLine() {
        return scanner.nextLine();
    }
}
