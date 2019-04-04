package domain;

import java.util.Scanner;

public class CarRacingGame {
    private static boolean checkNameLength(String[] carName) {
        boolean checkResult = true;

        for (String e : carName) {
            if (e.length() > 5) {
                checkResult = false;
            }
        }

        return checkResult;
    }

    public static void main(String[] args) {
        boolean isRightNames = false;

        while (!isRightNames) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("경주할 자동차의 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구)");
            String input = scanner.nextInt();

            String[] carName = input.split(",");

            isRightNames = checkNameLength(carName);
        }
    }
}
