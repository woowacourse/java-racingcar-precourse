/*
 * class: MakingCar
 *
 * version: 3.0
 *
 * date: 2019.12.08
 *
 * 이 프로그램의 저작권은 정은석에게 있습니다.
 * Copyright 2019.12.08
 */

package domain;

/**
 * car의 이름을 입력받아 (,)구분자로 파싱해서
 * car의 객체를 동적으로 생성시켜는 기능을하는 class이다.
 *
 * @author joseph415
 * @version 3.0 2019.12.08
 */
public class MakingCar {
    boolean check;
    Car[] car;
    ParsingCarString parseCar = new ParsingCarString();
    ExceptionCarInput except = new ExceptionCarInput();

    /**
     * car의 객체를 입력한 이름수만큼 동적으로 생성시켜 반환하는 소드.
     *
     * @return Car클래스의 객체를 입력한 이름수만큼 생성하는 동적배열
     */
    public Car[] makeCar() {
        while (true) {
            String[] carList = parseCar.parseCarString();
            check = except.exceptCarInput(carList);

            /*파싱해서 얻은 차의 수만큼 동적배열생성*/
            car = new Car[carList.length];
            for (int i = 0; i < carList.length; i++) {
                car[i] = new Car(carList[i]);
            }
            if (check) {
                continue;
            }
            return car;
        }
    }
}
