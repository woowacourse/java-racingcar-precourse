package domain;

import java.util.Scanner;

public class Naming {
    static String[] inputNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        Scanner sc = new Scanner(System.in);
        String[] names = sc.nextLine().split(",");
        return names;
    }
}
