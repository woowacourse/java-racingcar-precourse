/*
 * 클래스 이름: RaceingGameController.java
 * 버전 정보: 1.0.0
 * 날짜: 2019/04/03
 * Copyright 2019 Inkwon Lee
 */
package domain;

import java.util.ArrayList;

/*
 * RacingGame 에 대한 컨트롤러 클래스
 * gameStart 를 통하여 순차적으로 진행
 * raceStart() 함수에서 자동차 위치가 움직이는지 확인
 */
public class RaceingGameController {

    public void gameStart() {
        System.out.println(Output.outputEnrollCarName);
        ArrayList<Car> carNameList = Input.getInstance().enrollCarName();

        System.out.println(Output.outputTryNumber);
        int tryNumber = Input.getInstance().tryNumber();

        System.out.println();
        gameResult(carNameList, tryNumber);

    }

    private void gameResult(ArrayList<Car> carNameList, int tryNumber) {
        System.out.println(Output.outputOngoing);
        for (int i = 0; i < tryNumber; i++) {
            racingStart(carNameList);
            System.out.println();
        }

        System.out.println(Output.getInstance().gameRusultMessage(carNameList).toString() + Output.outputResult);
    }

    private void racingStart(ArrayList<Car> carNameList) {
        for (Car car : carNameList) {
            car.movePosition();
            Output.getInstance().gameOngoingMessage(car);
        }
    }

}
