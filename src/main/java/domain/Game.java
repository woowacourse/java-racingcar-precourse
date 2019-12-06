package domain;

import java.util.Scanner;

public class Game {
    private static Car[] cars;
    private static int numCars = 0;
    private static int numGames;
    private static Scanner scanner = new Scanner(System.in);

    public static void initGames() {
        setCars();
        setNumGames();
        System.out.println("\n실행 결과");
        for (int i = 0; i < numGames; i++) {
            runGame();
        }
        printWinnerName();
    }

    private static void setCars() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carsInputString = scanner.nextLine();
        parseCarNames(carsInputString);
    }

    private static void parseCarNames(String input) {
        String[] parsedInput = input.split(",");
        cars = new Car[parsedInput.length];
        for (String name : parsedInput) {
            cars[numCars++] = new Car(name);
        }
    }

    private static void setNumGames() {
        System.out.println("시도할 횟수는 몇회인가요?");
        numGames = scanner.nextInt();
    }

    private static void runGame() {
        for (Car car : cars) {
            car.March();
        }
        printGameResult();
    }

    private static void printGameResult() {
        for (Car car : cars) {
            System.out.printf("%s: %d\n", car.getName(), car.getPosition());
        }
        System.out.println();
    }

    private static String getWinnerName() {
        String winnerName = "";
        int maxPosition = -1;
        for (Car car : cars) {
            if (car.getPosition() > maxPosition) maxPosition = car.getPosition();
        }
        boolean firstWinnerFlag = true;
        for (Car car : cars) {
            if (car.getPosition() == maxPosition && firstWinnerFlag) {
                winnerName += car.getName();
                firstWinnerFlag = false;
                continue;
            }
            if (car.getPosition() == maxPosition) {
                winnerName += ", "+car.getName();
            }
        }
        return winnerName;
    }

    private static void printWinnerName() {
        System.out.printf("%s가 최종 우승했습니다.", getWinnerName());
    }
}
