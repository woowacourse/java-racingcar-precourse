package racingcar;

import java.util.Scanner;

public class inputAndOutput {
    static String inputString(Scanner scanner, String print) {
        System.out.println(print);
        return scanner.next();
    }

    static int inputInt(Scanner scanner, String print) {
        System.out.println(print);
        return scanner.nextInt();
    }

    static void outputOneStepStateBar(int nowPosition, String stateBar) {
        for (int i = 0; i < nowPosition; i++) {
            System.out.print(stateBar);
        }
    }

    static void outputOneStepName(String name) {
        System.out.print(name);
        System.out.print(" : ");
    }
}
