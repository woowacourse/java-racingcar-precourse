package domain;

import java.util.Scanner;

public class RacingManager {
    String[] splitedCarNames;
    static Scanner scanner = new Scanner(System.in);

    static String inputCarNames() {
        String carNames;
        System.out.println("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)");
        return carNames = scanner.next();
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

    static int inputNumberOfLaps() {
        int numberOfLaps;
        System.out.println("시도할 횟수는 몇회인가요?");
        return numberOfLaps = scanner.nextInt();
    }
}
