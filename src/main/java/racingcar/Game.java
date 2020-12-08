package racingcar;

import java.util.Scanner;

public class Game {

    static final int NAME_LENGTH_LIMIT = 5;
    static final int UNSET_TRY_COUNT = -1;

    private static String[] carNames;
    private static Car[] cars;
    private static int tryCnt = UNSET_TRY_COUNT;

    private Game() {
    }

    public static void playGame(Scanner scanner) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        while (carNames == null) {
            enterName(scanner);
        }

        cars = new Car[carNames.length];

        for (int i = 0; i < carNames.length; i++) {
            cars[i] = new Car(carNames[i]);
        }

        System.out.println("시도할 회수는 몇회인가요?");
        while (tryCnt < 0) {
            enterTryCnt(scanner);
        }
    }

    private static void enterName(Scanner scanner) {
        String input = scanner.nextLine();
        carNames = input.split(",");
        try {
            checkName();
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 자동차 이름은 쉼표(,) 기준으로 구분하며 이름은 5자 이하여야 한다.");
            carNames = null;
        }
    }

    private static void checkName() {
        for (int i = 0; i < carNames.length; i++) {
            if (carNames[i].length() > NAME_LENGTH_LIMIT) {
                throw new IllegalArgumentException();
            }
        }
    }

    private static void enterTryCnt(Scanner scanner) {
        try {
            String input = scanner.nextLine();
            tryCnt = Integer.parseInt(input);
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 시도 횟수는 숫자여야 한다.");
            tryCnt = UNSET_TRY_COUNT;
        }
    }
}
