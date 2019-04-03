/*
 * AppStart.java
 * 20190403
 * ver 1.0.0
 * leejk118
 */

import domain.Car;
import java.util.Scanner;

public class AppStart {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = sc.nextLine();

        String name[] = input.split(",");
        int length = name.length;

        Car[] car = new Car[length];

        for (int i = 0; i < length; ++i){
            car[i] = new Car(name[i]);
        }

        System.out.println("시도할 회수는 몇회인가요?");
        int tryNum = sc.nextInt();

        for(int i = 0; i < tryNum; ++i){
            start(car, length);
            printResult(car, length, tryNum);
            System.out.println();
        }
    }

    public static void start(Car[] car, int length) {
        for(int i = 0; i < length; ++i){
            car[i].decideGoStop();
        }
    }
    public static void printResult(Car[] car, int length, int tryNum){
        for (int i = 0; i < length; ++i) {
            System.out.print(car[i].getName() + " : ");
            for (int j = 0; j < car[i].getPosition(); ++j){
                System.out.print("-");
            }
            System.out.println();
        }
    }
}

