/*
 * class: WinsCar
 *
 * version: 1.0
 *
 * date: 2019.12.07
 *
 * 이 프로그램의 저작권은 정은석에게 있습니다.
 * Copyright 2019.12.07
 */

package domain;

/**
 * 우승차를 가려내는 class.
 *
 * @author joseph415
 * @version 1.0 2019.12.07
 */
public class WinsCar {
    /**
     * 우승차를 가려내는 매소드.
     *
     * @param car Car 타입의 배열
     * @return position이 가장 높은 차를 winsCar에 계속 추가
     */
    public String wins(Car[] car) {
        StringBuilder winsCar = new StringBuilder();
        int temp = -1;

        /*최대값이 생기면 winsCar에 추가 하고 최대값을 바꿔줌*/
        for (int i = 0; i < car.length; i++) {
            if (car[i].getPosition() > temp) {
                temp = car[i].getPosition();
                winsCar = new StringBuilder(car[i].getName());
            } else if (car[i].getPosition() == temp) {
                winsCar.append(",");
                winsCar.append(car[i].getName());
            }
        }
        return winsCar.toString();
    }
}
