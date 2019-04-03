package xyz.zerobell;

import java.util.Scanner;

public class Main {

    static private Scanner staticSc;

    static private Scanner getScanner() {
        if (staticSc==null) {
            staticSc = new Scanner(System.in);
        }

        return staticSc;
    }

    static private String[] separateStrings(String str) {
        return str.split(",");
    }

    static private boolean isStringsValid(String[] strings) {
        for (String s : strings) {
            if (!Car.isNameValid((s))) {
                return false;
            }
        }
        return true;
    }

    static private String[] getStrings() {
        Scanner sc = getScanner();

        while (true) {
            System.out.println("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)");
            String[] strings = separateStrings(sc.next());

            if (isStringsValid(strings)) {
                return strings;
            }
            System.out.println("자동차의 이름은 5자 이하어야 합니다!!");
        }
    }

    static private Car[] makeCars(String[] strings) {
        Car[] cars = new Car[strings.length];
        for (int i = 0; i < strings.length; i++) {
            cars[i] = new Car(strings[i]);
        }

        return cars;
    }

    static private void race(Car[] cars) {
        for (Car car: cars) {
            car.boostOrStop();
            System.out.println(car.toString());
        }
    }

}
