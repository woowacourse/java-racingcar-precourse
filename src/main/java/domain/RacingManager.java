package domain;

import java.util.Scanner;

public class RacingManager {
    String[] splitedCarNames;

    static String inputCarNames() {
        Scanner scanner = new Scanner(System.in);

        String carNames;

        System.out.println("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)");
        carNames = scanner.next();
        return carNames;
    }

    static String[] splitCarNames(String carNames,
                                  String divideStandard) {
        return carNames.split(divideStandard);
    }

    static boolean namesLengthGraterThanFive
            (String[] splitedCarNames) {
        for (String carName : splitedCarNames) {
            if (carName.length() > 5) {
                System.out.println("자동차 이름을 5자 이하로 입력하세요!!");
                return true;
            }
        }
        return false;
    }
}
