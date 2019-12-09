package domain;

import java.util.Scanner;

public class RacingCar {
    public static void main(String[] args) {
        Cars cars = createCars();
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

}
