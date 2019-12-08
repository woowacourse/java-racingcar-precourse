/*
 * class: WinsCar
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
 * 우승차를 가려내는 class.
 *
 * @author joseph415
 * @version 3.0 2019.12.08
 */
public class WinsCar {
    int temp = -1;
    StringBuilder winsCar = new StringBuilder();

    /**
     * 우승차를 가려내는 매소드.
     *
     * @param car Car 타입의 배열
     * @return position이 가장 높은 차를 winsCar에 계속 추가
     */
    public String wins(Car[] car) {

        /*최대값이 생기면 winsCar에 추가 하고 최대값을 바꿔줌*/
        for (Car value : car) {
            if (value.getPosition() > temp) {
                temp = value.getPosition();
                winsCar = new StringBuilder(value.getName());
                continue;
            }
            if (value.getPosition() == temp) {
                winsCar.append(",");
                winsCar.append(value.getName());
            }
        }
        return winsCar.toString();
    }
}
