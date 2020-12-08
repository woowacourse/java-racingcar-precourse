package racingcar;

import java.util.Scanner;

public class Game {
    private static String[] carNames;
    private static Car[] cars;
    private static int round;
    public Game() {
    }

    public static void playGame(Scanner scanner) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = scanner.nextLine();
        carNames = input.split(",") ;
        cars = new Car[carNames.length];

        for (int i = 0; i < carNames.length; i++) {
            cars[i] = new Car(carNames[i]);
        }

        System.out.println("시도할 회수는 몇회인가요?");
        round = scanner.nextInt();
    }
}
