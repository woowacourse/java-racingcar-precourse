package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class RacingGame {
    private static final int START = 0;
    private static final int END = 9;

    public void playGame(Scanner scanner) {
        String[] carNames;

        while (true) {
            System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
            carNames = scanner.nextLine().split(",");
            System.out.println(Arrays.toString(carNames));

            if (!isAvailableCarName(carNames)) {
                continue;
            }
            break;
        }

        List<Car> carList = new ArrayList<>();
        for (String carName : carNames) {
            carList.add(new Car(carName));
        }

    }

    private boolean isAvailableCarName(String[] carNames) {
        for (String carName : carNames) {
            if (carName.length() <= 0 || carName.length() > 5) {
                System.out.println("[ERROR] 자동차 이름은 0자이상 5자이하만 가능합니다.");
                return false;
            }
        }
        return true;
    }
}
