package service;

import domain.Car;
import domain.Config;

import java.util.Scanner;

public class Index {
    public static void main(String[] args) {
        Config config = new Config();
        Scanner scan = new Scanner(System.in);
        System.out.println("경주할 자동차의 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분");
        String carsName = config.inputCarsName();
        String[] carArrays = config.makeCarNameArray(carsName);
        Car[] garage = config.makeGarage(carArrays);
        System.out.println("게임을 몇 회 실시시키겠습니까?");
        int count = scan.nextInt();
        System.out.println("레이스 시작");
        for (int i = 0; i < count; i++) {
            garage = config.race(garage);
        }
        System.out.println("레이스 종료");
        String winner = config.printWinner(garage);
        System.out.println(winner + "님이 최종 우승하셨습니다!");
    }
}