/*
 * class: MakeCar
 *
 * version: 1.0
 *
 * date: 2019.12.07
 *
 * 이 프로그램의 저작권은 정은석에게 있습니다.
 * Copyright 2019.12.07
 */

package domain;

import java.util.*;

/**
 * car의 이름을 입력받아 (,)구분자로 파싱해서
 * car의 객체를 동적으로 생성시켜는 기능을하는 class이다.
 *
 * @author joseph415
 * @version 1.0 2019.12.07
 */
public class MakeCar {

    /**
     * car의 객체를 입력한 이름수만큼 동적으로 생성시켜 반환하는 소드.
     *
     * @return Car클래스의 객체를 입력한 이름수만큼 생성하는 동적배열
     */
    public Car[] makingCar() {
        boolean check;
        String carString = "";
        Car[] car;
        Scanner sc = new Scanner(System.in);

        while (true) {
            check = false;
            System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
            carString = sc.nextLine();

            /*(,)구분자로 문자열 파싱*/
            String[] carList = carString.split(",");

            /*예외 처리 */
            for (int i = 0; i < carList.length; i++) {
                if (carList[i].length() < 1 || carList[i].length() > 5) {
                    check = true;
                    System.out.println("car이름은 1~5글자 입니다. 재입력!!!");
                }
            }

            /*예외처리 있으면 재입력*/
            if (check) {
                continue;
            }

            /*파싱해서 얻은 차의 수만큼 동적배열생성*/
            car = new Car[carList.length];

            /*자동차 개수만큼 동적배열 선언*/
            for (int i = 0; i < carList.length; i++) {
                car[i] = new Car(carList[i]);
            }

            /*예외 처리없으면 무한루프탈*/
            break;
        }
        return car;
    }
}
