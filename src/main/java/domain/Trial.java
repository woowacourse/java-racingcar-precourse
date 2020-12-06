package domain;

import java.util.Scanner;

public class Trial {

    public static int inputCountValidate(Scanner scanner) {
        while (true) {
            System.out.println("시도할 회수는 몇회인가요?");
            String number = scanner.nextLine();
            try {
                if (!inputCountLessThanOne(number)) {
                    return Integer.parseInt(number);
                }
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 시도 횟수는 문자일 수 없습니다. 숫자를 입력해주세요.");
                continue;
            }
        }
    }

    public static boolean inputCountLessThanOne(String number) {
        int inputCount = Integer.parseInt(number);
        if (inputCount < 1) {
            System.out.println("[ERROR] 시도 횟수는 1 이상이여야 합니다.");
            return true;
        }
        return false;
    }
}
