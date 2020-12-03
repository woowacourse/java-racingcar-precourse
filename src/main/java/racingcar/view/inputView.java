package racingcar.view;

import java.util.List;
import java.util.Scanner;

public class inputView {
    private static final String INPUT_CAR_NAMES_PHRASE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)\n";

    private Scanner scanner;

    public inputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public List<String> getCarNames() {
        System.out.print(INPUT_CAR_NAMES_PHRASE);
        return null;
    }
}
