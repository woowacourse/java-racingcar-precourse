package service;

import domain.Car;
import domain.Config;

import java.util.Scanner;

public class Index {
    public static void main(String[] args) {
        Config config = new Config();
        Scanner scan = new Scanner(System.in);

        String carsName = config.inputCarsName();
        String[] carArrays = config.divideCarNameArray(carsName);
        Car[] garage = config.makeGarage(carArrays);
        config.race(garage);
        config.printWinner(garage);

        System.out.println("레이스 종료");
    }
}