/**
 * Main 클래스
 * <p>
 * 자동차 이름, 이동 횟수 입력 받을 예정
 * run() 함수도 호출할 예정
 * 이동 횟수만큼 반복 예정
 */
package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        ArrayList<Integer> positionList = new ArrayList<>();

        String carNames;
        String[] splitedCarNames;
        int numberOfLaps;
        int maxPosition;
        int numberOfCars;


        do {
            carNames = RacingManager.inputCarNames();
            splitedCarNames = RacingManager.splitCarNames(
                    carNames, ",");
        } while (RacingManager
                .namesLengthGraterThanFive(splitedCarNames));

        numberOfCars = splitedCarNames.length;
        Car[] cars = new Car[numberOfCars];

        for (int i = 0; i < numberOfCars; i++) {
            cars[i] = new Car(splitedCarNames[i]);
        }

        numberOfLaps = RacingManager.inputNumberOfLaps();
        RacingManager.runOrStop(numberOfLaps, numberOfCars, cars);


        for (Car car : cars) {
            positionList.add(car.getPosition());
        }

        maxPosition = Collections.max(positionList);

        for (int i = 0; i < numberOfCars; i++) {
            if (cars[i].getPosition() == maxPosition) {
                System.out.print(cars[i].getName() + " ");
            }
        }
        System.out.println("최종 우승!!");
    }
}
