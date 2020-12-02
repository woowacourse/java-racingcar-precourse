package racingcar;

import java.util.List;
import java.util.Scanner;

public class CarRacing {
    private final Scanner scanner;

    public CarRacing(Scanner scanner) {
        this.scanner = scanner;
    }

    public void run() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNameInput = scanner.nextLine();
        List<String> carNamesSplitList = CarNamesSplitList.carNamesSplitList(carNameInput);
    }
}
