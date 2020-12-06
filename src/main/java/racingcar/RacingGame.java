package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class RacingGame {
    private static final int START = 0;
    private static final int END = 9;

    private String[] carNames;

    public void playGame(Scanner scanner) {

        while (true) {
            System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
            carNames = scanner.nextLine().split(",");

            if (haveBlankCarName() || !isValidSizeCarName() || isDuplicateName()) {
                continue;
            }
            break;
        }

        List<Car> carList = new ArrayList<>();
        for (String carName : carNames) {
            carList.add(new Car(carName));
        }
    }

    private boolean haveBlankCarName() {
        for (String carName : carNames) {
            if (carName.contains(" ")) {
                System.out.println("[ERROR] 자동차 이름에 공백은 사용이 불가능합니다.");
                return true;
            }
        }
        return false;
    }

    private boolean isValidSizeCarName() {
        for (String carName : carNames) {
            if (carName.length() <= 0 || carName.length() > 5) {
                System.out.println("[ERROR] 자동차 이름은 0자이상 5자이하만 가능합니다.");
                return false;
            }
        }
        return true;
    }

    private boolean isDuplicateName() {
        List<String> carList = new ArrayList<>();

        for (String carName : carNames) {
            if (!carList.contains(carName)) {
                carList.add(carName);
            }
        }

        if (carList.size() != carNames.length) {
            System.out.println("[ERROR] 자동차 이름은 중복이 불가능합니다.");
            return true;
        }

        return false;
    }
}
