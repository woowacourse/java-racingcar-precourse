/*
 * 클래스 이름   PrepareGame
 * 버전 정보    1.0
 * 날짜        2019.12.10
 * 저작권      YebinK
 */

package domain;

import java.util.Scanner;

/**
 * 자동차 이름과 시도 힛수를 입력받아 게임에 필요한 Car 배열과 시도 횟수를 얻는다.
 */

public class PrepareGame {

    private String[] carNames;
    private Car[] cars;
    private int attempts;

    /**
     * 자동차의 이름을 입력받고, 이름이 5자 이하인지 확인한다.
     * 이상이 없을 때까지 다시 입력받는다.
     * 입력된 이름만큼 자동차 객체 배열 cars에 자동차 객체를 만들고 이름을 채운다.
     * 시도 횟수를 입력받는다.
     */

    public Car[] prepare() {
        do {
            String input = getCarNames();
            carNames = splitCars(input);
            if (!validationCheck()) System.out.println("자동차 이름은 5자 이하로 입력해주세요.");
        } while (!validationCheck());

        createCarInstance();
        attempts = getAttempts();
        return cars;
    }

    private String getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        return input;
    }

    /**
     * 자동차의 이름을 쉼표 단위로 쪼갠다.
     */
    private String[] splitCars(String input) {
        String[] result = input.split(",");
        return result;
    }

    /**
     * 이름이 5자 초과이면 false를 return한다.
     */
    private boolean validationCheck() {
        for (int i = 0; i < carNames.length; i++) {
            if (carNames[i].length() > 5) return false;
        }
        return true;
    }

    private void createCarInstance() {
        cars = new Car[carNames.length];

        for (int i = 0; i < carNames.length; i++) {
            cars[i] = new Car(carNames[i]);
        }
    }

    private int getAttempts() {
        System.out.println("시도할 횟수는 몇회인가요?");
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();

        return input;
    }

    public Car[] Cars() {
        return cars;
    }

    public int Attempts() {
        return attempts;
    }
}