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
        int iterationNumber;
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

        iterationNumber = RacingManager.inputNumberOfLaps();

        for (int i = 0; i < iterationNumber; i++) {
            for (int j = 0; j < iterationNumber; j++) {
                cars[j].canYouGo();
                System.out.println(cars[j].getName()
                        + " : " + cars[j].getPosition());
            }
        }


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
