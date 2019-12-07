package domain.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class inputUtils {
    private static final String PROMPTNAMES = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String PROMPTTRIES = "시도할 회수는 몇회인가요?";
    private static final String ERRORMESSAGE = "유효하지 않은 입력입니다.";
    private static final String SEPARATOR = ",";
    static Scanner scanner = new Scanner(System.in);

    public static Integer inputTries() {
        Integer inputValue;
        while (true) {
            System.out.println(PROMPTTRIES);
            if (scanner.hasNextInt() && (inputValue = scanner.nextInt()) > 0) {
                break;
            }
            System.out.println(ERRORMESSAGE);
            inputFlush();
        }
        inputFlush();
        return inputValue;
    }

    private static void inputFlush() {
        scanner.nextLine();
    }

    public static void inputClose() {
        scanner.close();
    }
}
