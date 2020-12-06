package domain;

import java.util.Scanner;

public class InputCarName {

    public static String inputCarName(Scanner scanner) {
        while (true) {
            System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
            String strList = scanner.nextLine();
            if (InputCarNameCheck.checkInputCarName(strList)) {
                return strList;
            }
        }
    }
}
