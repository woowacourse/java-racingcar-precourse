/*
 * @(#)MainApp.java        1.00    2019/04/02
 *
 * Copyright (c) 2019 Yumin Kim.
 * All rights reserved
 */

package domain;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * 레이싱 경주 게임의 메인 메소드가 존재하는 클래스입니다.
 *
 * @author 김유민
 * @version 1.00    2019/04/02
 */
public class MainApp {
    public static void main(String[] args) {
        int numOfTrials;
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNames[] = getCarNames();
        Car cars[] = createArrayOfCars(carNames);
        do {
            System.out.println("시도할 회수는 몇회인가요?");
            numOfTrials = getNumOfTrials();              // 사용자가 1 이상의 정수를 입력할 때까지 반복합니다.
        } while (numOfTrials == -1);
        System.out.println("\n실행 결과");
        raceCars(cars, numOfTrials);
        System.out.println(getWinners(cars) + "가 최종 우승했습니다.");
    }

    /**
     * 사용자로부터 자동차의 이름들을 입력받아 반환하는 메소드입니다.
     *
     * @return 자동차의 이름을 각 원소로 하는 문자열 배열
     */
    public static String[] getCarNames() {
        String arrCarNames[];
        try {
            Scanner rd = new Scanner(System.in);
            String strCarNames = rd.nextLine();
            arrCarNames = strCarNames.split(",");
        } catch (Exception e) {
            return null;
        }
        return arrCarNames;
    }

    /**
     * 입력으로 받은 이름을 갖는 자동차의 배열을 생성하고 반환합니다.
     *
     * @param carNames 자동차의 이름의 배열로, 문자열의 배열입니다.
     * @return 자동차 객체의 배열을 반환합니다.
     */
    public static Car[] createArrayOfCars(String[] carNames) {
        Car cars[] = new Car[carNames.length];
        for (int i = 0; i < carNames.length; i++) {
            cars[i] = new Car(carNames[i]);
        }
        return cars;
    }

    /**
     * 사용자로부터 경주 시도 횟수를 입력받고 반환합니다.
     *
     * @return 경주 시도 횟수를 반환합니다.
     */
    public static int getNumOfTrials() {
        int numOfTrials;
        try {
            Scanner rd = new Scanner(System.in);
            numOfTrials = rd.nextInt();
            if (numOfTrials <= 0) {
                System.out.println("[ERROR] 1 이상의 자연수를 입력하셔야 합니다.");
                return -1;
            }
        } catch (InputMismatchException e) {
            System.out.println("[ERROR] 정수를 입력하셔야 합니다.");
            return -1;
        }
        return numOfTrials;
    }

    /**
     * 입력받은 자동차를 확률적으로 전진시키거나, 멈춥니다.
     *
     * @param c 자동차 객체의 참조변수입니다.
     * @return 확률변수 값으로 0 부터 9 사이의 값입니다. (테스트용)
     */
    public static int randomlyMoveCar(Car c) {
        int randomNumber = (int) (Math.random() * 10);   // 0 ~ 9 사이의 임의의 정수
        if (randomNumber < 4 && randomNumber >= 0) {
            return randomNumber;
        }
        if (randomNumber >= 4 && randomNumber <= 9) {
            c.moveForward();
            return randomNumber;
        }
        return -1;
    }

    /**
     * 입력받은 자동차의 배열에서 우승자(들)를 가립니다.
     *
     * @param candidates 우승 후보 자동차들입니다.
     * @return 우승한 자동차들의 이름을 합쳐 하나의 문자열로 반환합니다.
     */
    public static String getWinners(Car[] candidates) {
        String result = "";
        int maxPosition = 0;

        /* 후보 자동차들 중 가장 높은 점수를 찾습니다. */
        for (Car c : candidates) {
            if (c.getPosition() > maxPosition) {
                maxPosition = c.getPosition();
            }
        }

        /* 가장 높은 점수를 얻은 후보 자동차들은 모두 우승후보입니다. */
        for (Car c : candidates) {
            if (c.getPosition() == maxPosition) {
                result += c.getName() + ", ";
            }
        }
        return result.substring(0, result.length() - 2);  // 맨 뒤에 붙은 ", " 를 제거합니다.
    }

    /**
     * 자동차들을 경주시키는 메소드입니다.
     *
     * @param cars        경주하는 자동차 객체들의 배열입니다.
     * @param numOfTrials 경주 시도 횟수입니다.
     */
    private static void raceCars(Car cars[], int numOfTrials) {
        for (int i = 0; i < numOfTrials; i++) {
            for (Car c : cars) {
                randomlyMoveCar(c);
                System.out.println(c.printStatus());
            }
            System.out.println();
        }
    }
}
