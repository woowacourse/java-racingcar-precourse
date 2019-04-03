package com.nekisse;

import java.util.Scanner;

public class InputView {

    public static String getInputCarName() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public static int getInputTryCount() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        Scanner scanner = new Scanner(System.in);
        checkValidNumber(scanner);
        return scanner.nextInt();
    }

    private static void checkValidNumber(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            scanner.next();
            System.out.print("숫자만 입력가능합니다> ");
        }
    }

}
