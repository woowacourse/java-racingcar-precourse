/**
 * Main 클래스
 * <p>
 * 자동차 이름, 이동 횟수 입력 받을 예정
 * run() 함수도 호출할 예정
 * 이동 횟수만큼 반복 예정
 */
package domain;

import domain.Controller.RacingManager;

public class Main {

    public static void main(String[] args) {
        RacingManager racingmanager = new RacingManager();

        racingmanager.start();

//        for (Car car : cars) {
//            positionList.add(car.getPosition());
//        }
//
//        maxPosition = Collections.max(positionList);
//        racingmanager.whoIsWinner(numberOfCars, maxPosition, cars);
    }
}
