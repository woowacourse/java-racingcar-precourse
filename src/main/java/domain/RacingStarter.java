/**
 * Copyright (c) 2019 Seungwan Park,
 * All rights reserved.
 */

package domain;

import java.util.ArrayList;

/**
 * 클래스 이름 : RacingStarter.java
 *
 * @author Seungwan Park, github.com/toneyparky
 * @version 1.1
 * <p>
 * 날짜 : 2019.12.8 일요일
 */
public class RacingStarter {
    /*
     * RacingStarter 클래스는 입력받은 횟수를 이용하여 경주를 실시한다.
     */
    private static ArrayList<Car> carArrayList = new ArrayList<>();
    private static int roundNumber = 1;
    private static String positionByDash;

    /**
     * Race를 시작하는 로직을 수행하는 메서드(생성자).
     * 입력값으로 Car 인스턴스가 저장된 ArrayList와 라운드 횟수를 받는다.
     * 리턴값으로 race후 차량의 position이 저장된 ArrayList를 돌려준다.
     */
    public static ArrayList<Car> RacingStarter(ArrayList<Car> inputCarArrayList, int inputRoundNumber) {
        carArrayList = inputCarArrayList;
        roundNumber = inputRoundNumber;
        controlRacingTotalRound();
        return carArrayList;
    }

    /**
     * Round별로 로직을 컨트롤하기 위한 메서드.
     */
    public static void controlRacingTotalRound() {
        System.out.println("실행 결과");
        for (int i = 0; i < roundNumber; i++) {
            controlRacingByRound();
            System.out.print("\n");
        }
    }

    /**
     * 각 round에 해당하는 차량의 전진여부를 출력하는 메서드.
     */
    public static void controlRacingByRound() {
        for (Car car : carArrayList) {
            executeRacing(car);
            exchangePositionToDash(car);
            System.out.println(car.getName() + " : " + positionByDash);

        }
    }

    /**
     * 차량의 전진여부를 결정하는 메서드.
     */
    public static void executeRacing(Car car) {
        car.moveForward(car.decideGoOrNot(car.getRandomInt()));
    }

    /**
     * 차량의 position 멤버변수의 정수를 dash로 바꾸는 메서드. 예) 3 -> ---
     */
    public static void exchangePositionToDash(Car car) {
        positionByDash = new String(new char[car.getPosition()]).replace("\0", "-");
    }

}
