/**
 * CarManager.java 2019.12.07
 * <p>
 * version 1.0
 */
package domain.Controller;

import domain.Model.Car;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Car 객체를 배열로 관리하는 클래스
 * 기능은 다음과 같다.
 * 1. 특정 조건을 만족하면 Car의 position을 증가시킨다
 * 2. Car 객체들 중 position 값이 가장 큰 우승자를 선출한다
 * 3. 우승자를 출력한다.
 *
 * @author 황성찬
 * @version 1.0 2019-12-07
 */
public class CarManager {
    Car[] cars;
    ArrayList<Integer> positionList;

    int carsLength;
    int maxPosition;

    public CarManager(String[] carNames) {
        cars = new Car[carsLength];
        this.carsLength = carNames.length;

        for (int i = 0; i < carsLength; i++) {
            cars[i] = new Car(carNames[i]);
        }

        this.positionList = new ArrayList<>();
    }

    public int getCarsLength() {
        return this.carsLength;
    }

    private void setPositionList() {

        for (Car car : cars) {
            this.positionList.add(car.getPosition());
        }

    }

    private void setMaxPositions() {
        setPositionList();
        this.maxPosition = Collections.max(this.positionList);
    }

    public void printCarsNameAndPosition() {

        for (Car car : cars) {
            System.out.println(car.getName()
                    + ": " + car.getPosition());
        }

    }

    public void ifBiggerThanFourYouCanMove(
            int randomNumber, int carIndex) {

        if (randomNumber >= 4) {
            cars[carIndex].move();
        }

    }

    public void whoIsWinner() {
        setMaxPositions();
        System.out.print("<< ");

        for (Car car : cars) {

            if (car.getPosition() == this.maxPosition) {
                System.out.print(car.getName() + " ");
            }

        }

        System.out.println(">> 최종 우승!!");
    }

}
