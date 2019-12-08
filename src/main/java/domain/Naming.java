package domain;

import java.util.Scanner;

public class Naming {
    static String[] inputNames() {
        Scanner sc = new Scanner(System.in);
        String[] names = new String[]{};
        do {
            System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
            names = sc.nextLine().split(",");
        } while (checkNames(names));
        return names;
    }

    static boolean checkNames(String[] names) {
        boolean again = true;
        if (names.length < 1) {
            System.out.println("자동차 이름은 1개 이상이어야 합니다.");
            return again;
        }
        for (String name : names) {
            if (name.length() > 5) {
                System.out.println("자동차 이름은 5글자 이하여야 합니다.");
                return again;
            }
        }
        again = false;
        return again;
    }
}
