package domain;

import java.util.Scanner;

public class RacingDriver {
    public static getWinners() {

    }

    public static String getCarNames() {
        Scanner scan = new Scanner(System.in);

        System.out.println("경주할 자동차 이름을 입력하세요. (이름은 쉽표(,) 기준으로 구분)");

        return scan.nextLine();
    }

    public static String[] parseCarNames() {
        String cars[] = getCarNames().split(",");

        for (int i = 0; i < cars.length; i++) {
            cars[i] = cars[i].trim();
        }

        return cars;
    }


    public  static void main(String args[]) {

    }
}
