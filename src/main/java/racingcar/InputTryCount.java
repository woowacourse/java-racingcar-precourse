package racingcar;

import java.util.Scanner;

public class InputTryCount {

    public static int getTryCount(Scanner scanner) {
        System.out.println("시도할 회수는 몇회인가요?");
        int tryCount;

        try {
            tryCount = scanner.nextInt();
        } catch (Exception e) {
            System.out.println("[ERROR] 잘못된 입력값입니다. 숫자를 입력해주세요.");
            throw new IllegalArgumentException();
        }
        if (tryCount < 1) {
            System.out.println("[ERROR] 잘못된 입력값입니다. 1 이상의 숫자를 입력해주세요.");
            throw new IllegalArgumentException();
        }

        return tryCount;
    }
}
