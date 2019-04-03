package xyz.zerobell;

import java.util.Scanner;

public class Main {

    static private Scanner sc;

    static private Scanner getScanner() {
        if (sc==null) {
            sc = new Scanner(System.in);
        }

        return sc;
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

            for (String s : strings) {

            }
        }
    }

}
