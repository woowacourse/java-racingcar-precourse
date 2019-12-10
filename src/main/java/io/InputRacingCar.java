package io;

import java.util.Scanner;

public class InputRacingCar {
    private static Scanner sc = new Scanner(System.in);

    public static String inputCarsName() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return validateCarsName(sc.nextLine());
    }

    public static int inputRepeatTimes() {
        System.out.println("시도할 회수는 몇회인가요?");
        return sc.nextInt();
    }

    private static String validateCarsName(String carsName) {
        if (carsName.equals("")) {
            throw new IllegalStateException("이름을 입력해주세요.");
        }
        return carsName;
    }
}
