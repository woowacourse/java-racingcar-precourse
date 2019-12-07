/**
 * Copyright (c) 2019 Seungwan Park,
 * All rights reserved.
 */

package domain;

/**
 * 클래스 이름 : PlayRacing.java
 *
 * @author Seungwan Park, github.com/toneyparky
 * @version 1.0
 * <p>
 * 날짜 : 2019.12.5 목요일
 */

import java.util.ArrayList;

public class PlayRacing {
    /*
     * PlayRacing 클래스의 playRacing메서드에서는 게임을 실행하는 로직을 담당한다.
     */

    private static ArrayList<Car> carArrayList = new ArrayList<>();
    private static int roundNumber = 1;

    public static void playRacing() {
        // 테스트용
        System.out.println("RACING START!");
        Car toneyCar = new Car("toney");
        System.out.println(toneyCar.getName());
        System.out.println(toneyCar.getPosition());
        for (int i = 0; i < 4; i++) {
            toneyCar.moveForward(toneyCar.decideGoOrNot(toneyCar.getRandomInt()));
            System.out.println("move?");
            System.out.println(toneyCar.getPosition());
        }

        carArrayList = CarNameGenerator.carNameGenerator();

        /*// 테스트용
        System.out.println("========인스턴스에 저장==========");
        for (Car car : carArrayList) {
            System.out.println(car.getName());
            car.moveForward(car.decideGoOrNot(car.getRandomInt()));
            car.moveForward(car.decideGoOrNot(car.getRandomInt()));
            car.moveForward(car.decideGoOrNot(car.getRandomInt()));
            System.out.println(car.getPosition());
        }*/

        roundNumber = RoundNumberGetter.controlRoundNumberGetting();
        carArrayList = RacingStarter.RacingStarter(carArrayList, roundNumber);

    }

}
