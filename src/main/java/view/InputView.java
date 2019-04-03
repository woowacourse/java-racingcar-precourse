package view;

import java.util.Scanner;

public class InputView {
    private static String INPUT_CAR_NAME_MENT = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분";
    private static String INPUT_TIMES_MENT = "시도할 횟수는 몇회인가요?";
    private static Scanner scanner = new Scanner(System.in);

    public static String getCarName() {
        System.out.println(INPUT_CAR_NAME_MENT);
        return scanner.nextLine();
    }

    public static String getTime() {
        System.out.println(INPUT_TIMES_MENT);
        return scanner.nextLine();
    }
}
