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


    }
}
