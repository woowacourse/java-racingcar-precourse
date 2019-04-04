package service;

import domain.Car;
import domain.Config;

/**
 * Index : 실제 앱의 동작을 담은 클래스
 */
public class Index {
    public static void main(String[] args) {
        Config config = new Config();

        String carsName = config.inputCarsName();
        String[] carArrays = config.divideCarNameArray(carsName);
        Car[] garage = config.makeGarage(carArrays);
        config.race(garage);
        config.printWinner(garage);

        System.out.println("레이스 종료");
    }
}