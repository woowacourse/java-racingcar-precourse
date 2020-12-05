package racingcar;

import java.util.Scanner;

public class InputView {
    private Scanner scanner;

    InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public String receiveCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return scanner.nextLine();
    }
}
