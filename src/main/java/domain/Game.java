package domain;

import java.util.Scanner;

public class Game {
    private static Car[] cars;
    private static int numCars = 0;
    private static int numGames;
    private static Scanner scanner;

    public static void setCars() {
        scanner = new Scanner(System.in);
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분");
        String carsInputString = scanner.nextLine();
        parseCarNames(carsInputString);
        scanner.close();
    }

    private static void parseCarNames(String input) {
        String[] parsedInput = input.split(",");
        for (String name : parsedInput) {
            cars[numCars++] = new Car(name);
        }
    }

    public static void setNumGames() {
        scanner = new Scanner(System.in);
        System.out.println("시도할 횟수는 몇회인가요?");
        numGames = scanner.nextInt();
    }
}
