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

public class PlayRacing {
    /*
     * PlayRacing 클래스의 playRacing메서드에서는 게임을 실행하는 로직을 담당한다.
     */

    public static void playRacing() {
        // 테스트용
        System.out.println("RACING START!");
        Car car = new Car("toney");
        System.out.println(car.getName());
        System.out.println(car.getPosition());
        for (int i = 0; i < 4; i++) {
            car.moveForward(car.decideGoOrNot(car.getRandomInt()));
            System.out.println("move?");
            System.out.println(car.getPosition());
        }


    }

}
