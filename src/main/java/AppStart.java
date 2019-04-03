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

        System.out.println();
        System.out.println("실행결과");
        for(int i = 0; i < tryNum; ++i){
            start(car, length);
            printResult(car, length, tryNum);
            System.out.println();
        }

        decideWinner(car, length);
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

    public static void decideWinner(Car[] car, int length){
        int max = 0;
        for (int i = 0; i < length; ++i){
            if (car[i].getPosition() > max){
                max = car[i].getPosition();
            }
        }
        printWinner(car, length, max);
    }

    public static void printWinner(Car[] car, int length, int max){
        for (int i = 0; i < length; ++i){
            if (car[i].getPosition() == max){
                System.out.print(car[i].getName() + ",");
            }
        }
        System.out.println("\b가 최종 우승했습니다.");
    }
}

