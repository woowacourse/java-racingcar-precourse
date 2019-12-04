package io;

import java.util.Scanner;

public class InputRacingCar {
    private static Scanner sc = new Scanner(System.in);

    public static String inputCarsName() {
        // TODO: 2019-12-04 이름이 5글자 초과인 경우 예외처리 
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return sc.nextLine();
    }

    public static int inputRepeatTime() {
        System.out.println("시도할 회수는 몇회인가요?");
        return sc.nextInt();
    }
}
