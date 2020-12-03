package view;

import java.util.Scanner;

public class InputView {
    private Scanner scanner;
    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public String receiveNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return this.scanner.nextLine();
    }
}
