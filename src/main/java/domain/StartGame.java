/*
 * 클래스 이름   StartGame
 * 버전 정보    1.0
 * 날짜        2019.12.05
 * 저작권      YebinK
 */

package domain;

import java.util.Scanner;

public class StartGame {

    private String[] carNames;
    private Car[] cars;

    public void start() {
        do {
            String input = getCarNames();
            carNames = splitCars(input);
            if (!validationCheck()) System.out.println("자동차 이름은 5자 이하로 입력해주세요.");
        } while (!validationCheck());

        System.out.println("시도할 횟수는 몇회인가요?");

        Scanner sc = new Scanner(System.in);
        int attempts = sc.nextInt();

        createCarInstance();
    }

    private String getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분");

        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        return input;
    }

    private String[] splitCars(String input) {
        String[] result = input.split(",");
        return result;
    }

    private boolean validationCheck() {
        for (int i = 0 ; i < carNames.length; i++) {
            if (carNames[i].length() > 5) return false;
        }
        return true;
    }

    private void createCarInstance() {
        cars = new Car[carNames.length];

        for (int i = 0 ; i < carNames.length ; i++) {
            cars[i] = new Car(carNames[i]);
        }
    }
}
