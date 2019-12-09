package domain;

import java.util.Scanner;

public class RacingCar {
    public static void main(String[] args) {
        Cars cars = createCars();
        MoveCount moveCount = createMoveCount();
        System.out.println("\n실행 결과");
        cars.showMoves(moveCount);
        cars.showWinnerName();
    }

    private static String getUserInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    private static Cars createCars() {
        String separator = Cars.SEPARATOR_NAME + "(" + Cars.SEPARATOR + ")";
        System.out.println(String.format("경주할 자동차 이름을 입력하세요.(이름은 %s 기준으로 구분)", separator));
        while (true) {
            String input = getUserInput();
            try {
                System.out.println(input);
                return new Cars(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static MoveCount createMoveCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        while (true) {
            String input = getUserInput();
            try {
                return new MoveCount(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

}
