/**
 * Main 클래스
 * <p>
 * 자동차 이름, 이동 횟수 입력 받을 예정
 * run() 함수도 호출할 예정
 * 이동 횟수만큼 반복 예정
 */
package domain;

import domain.Controller.RacingManager;
import domain.Model.Car;

import java.util.ArrayList;
import java.util.Collections;

public class Main {

    public static void main(String[] args) {
        ArrayList<Integer> positionList = new ArrayList<>();

        RacingManager racingmanager = new RacingManager();

        racingmanager.start();


//        do {
//            carNames = racingmanager.inputCarNames();
//            splitedCarNames = racingmanager.splitCarNames(
//                    carNames, ",");
//        } while (racingmanager
//                .namesLengthGraterThanFive(splitedCarNames));
//
//        numberOfCars = splitedCarNames.length;
//        Car[] cars = new Car[numberOfCars];
//
//        for (int i = 0; i < numberOfCars; i++) {
//            cars[i] = new Car(splitedCarNames[i]);
//        }
//
//        numberOfLaps = racingmanager.inputNumberOfLaps();
//        racingmanager.runOrStop(numberOfLaps, numberOfCars, cars);
//
//
//        for (Car car : cars) {
//            positionList.add(car.getPosition());
//        }
//
//        maxPosition = Collections.max(positionList);
//        racingmanager.whoIsWinner(numberOfCars, maxPosition, cars);
    }
}
